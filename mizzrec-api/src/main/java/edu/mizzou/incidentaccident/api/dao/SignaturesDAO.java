package edu.mizzou.incidentaccident.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mizzou.incidentaccident.api.constants.DBConstants;
import edu.mizzou.incidentaccident.api.models.SignaturesModel;

@Repository("signaturesDao")
public class SignaturesDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(SignaturesDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addSignatures(SignaturesModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + SIGNATURES + " (")
            .append(" data " )
            .append(", json_data " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getData(), 
            bean.getJsonData()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateSignatures(SignaturesModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + SIGNATURES)
        .append(" SET ")
        .append(" data = ? " )
        .append(", json_data = ? " );
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getData(), 
            bean.getJsonData(), 
            bean.getId()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public SignaturesModel getSignatures(Integer id) {
    String sqlString = "select " +
        "id" +
        ", data" +
        ", json_data" +
        ", created" +
        " from " + SIGNATURES + " where id = ?";
        Object[] args = {id};
        List<SignaturesModel> matches = getTemplate().query(sqlString, args, new RowMapper<SignaturesModel>() {
            public SignaturesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                SignaturesModel model = new SignaturesModel();
                    model.setId(rs.getInt("id"));
                    model.setData(rs.getBytes("data"));
                    model.setJsonData(rs.getString("json_data"));
                    model.setCreated(rs.getTimestamp("created")!=null?new java.util.Date(rs.getTimestamp("created").getTime()):null);
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<SignaturesModel> getSignaturesList() {
    String sqlString = "select " +
        "id" +
        ", data" +
        ", json_data" +
        ", created" +
        " from " + SIGNATURES;
        return getTemplate().query(sqlString, new RowMapper<SignaturesModel>() {
            public SignaturesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                SignaturesModel model = new SignaturesModel();
                    model.setId(rs.getInt("id"));
                    model.setData(rs.getBytes("data"));
                    model.setJsonData(rs.getString("json_data"));
                    model.setCreated(rs.getTimestamp("created")!=null?new java.util.Date(rs.getTimestamp("created").getTime()):null);
                return model;
            }
        });
    }


    public int deleteSignatures(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + SIGNATURES);
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sDeleteStmt.append(sWhereStmt);
        Object[] args = {id};
        int numRows = getTemplate().update(sDeleteStmt.toString(), args);
        return numRows;
    }


    public int getAutoIncrementKey() {
        String sqlString = "select last_insert_id()";
        return getTemplate().queryForInt(sqlString);
    }


}
