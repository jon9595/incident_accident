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
import edu.mizzou.incidentaccident.api.models.SpecificInjuryModel;

@Repository("specificInjuryDao")
public class SpecificInjuryDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(SpecificInjuryDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addSpecificInjury(SpecificInjuryModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + SPECIFIC_INJURY + " (")
            .append(" id " )
            .append(", description " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getId(), 
            bean.getDescription()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateSpecificInjury(SpecificInjuryModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + SPECIFIC_INJURY)
        .append(" SET ")
        .append(" id = ? " )
        .append(", description = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getId(), 
            bean.getDescription()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public SpecificInjuryModel getSpecificInjury(Integer id) {
    String sqlString = "select " +
        "id" +
        ", description" +
        " from " + SPECIFIC_INJURY + " where id = ?";
        Object[] args = {id};
        List<SpecificInjuryModel> matches = getTemplate().query(sqlString, args, new RowMapper<SpecificInjuryModel>() {
            public SpecificInjuryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                SpecificInjuryModel model = new SpecificInjuryModel();
                    model.setId(rs.getInt("id"));
                    model.setDescription(rs.getString("description"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<SpecificInjuryModel> getSpecificInjuryList() {
    String sqlString = "select " +
        "id" +
        ", description" +
        " from " + SPECIFIC_INJURY;
        return getTemplate().query(sqlString, new RowMapper<SpecificInjuryModel>() {
            public SpecificInjuryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                SpecificInjuryModel model = new SpecificInjuryModel();
                    model.setId(rs.getInt("id"));
                    model.setDescription(rs.getString("description"));
                return model;
            }
        });
    }


    public int deleteSpecificInjury(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + SPECIFIC_INJURY);
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
