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
import edu.mizzou.incidentaccident.api.models.WitnessInfoModel;

@Repository("witnessInfoDao")
public class WitnessInfoDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(WitnessInfoDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addWitnessInfo(WitnessInfoModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + WITNESS_INFO + " (")
            .append(" id " )
            .append(", name " )
            .append(", phone " )
            .append(", signature " )
            .append(") VALUES ( ")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getId(), 
            bean.getName(), 
            bean.getPhone(), 
            bean.getSignature()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateWitnessInfo(WitnessInfoModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + WITNESS_INFO)
        .append(" SET ")
        .append(" id = ? " )
        .append(", name = ? " )
        .append(", phone = ? " )
        .append(", signature = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getId(), 
            bean.getName(), 
            bean.getPhone(), 
            bean.getSignature()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public WitnessInfoModel getWitnessInfo(Integer id) {
    String sqlString = "select " +
        "id" +
        ", name" +
        ", phone" +
        ", signature" +
        " from " + WITNESS_INFO + " where id = ?";
        Object[] args = {id};
        List<WitnessInfoModel> matches = getTemplate().query(sqlString, args, new RowMapper<WitnessInfoModel>() {
            public WitnessInfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                WitnessInfoModel model = new WitnessInfoModel();
                    model.setId(rs.getInt("id"));
                    model.setName(rs.getString("name"));
                    model.setPhone(rs.getString("phone"));
                    model.setSignature(rs.getBytes("signature"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<WitnessInfoModel> getWitnessInfoList() {
    String sqlString = "select " +
        "id" +
        ", name" +
        ", phone" +
        ", signature" +
        " from " + WITNESS_INFO;
        return getTemplate().query(sqlString, new RowMapper<WitnessInfoModel>() {
            public WitnessInfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                WitnessInfoModel model = new WitnessInfoModel();
                    model.setId(rs.getInt("id"));
                    model.setName(rs.getString("name"));
                    model.setPhone(rs.getString("phone"));
                    model.setSignature(rs.getBytes("signature"));
                return model;
            }
        });
    }


    public int deleteWitnessInfo(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + WITNESS_INFO);
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
