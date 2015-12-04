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
import edu.mizzou.incidentaccident.api.models.AccidentDetailsModel;

@Repository("accidentDetailsDao")
public class AccidentDetailsDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(AccidentDetailsDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addAccidentDetails(AccidentDetailsModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + ACCIDENT_DETAILS + " (")
            .append(" accident_id " )
            .append(", acc_det_desc_id " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getAccidentId(), 
            bean.getAccDetDescId()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public List<AccidentDetailsModel> getAccidentDetailsList() {
    String sqlString = "select " +
        "accident_id" +
        ", acc_det_desc_id" +
        " from " + ACCIDENT_DETAILS;
        return getTemplate().query(sqlString, new RowMapper<AccidentDetailsModel>() {
            public AccidentDetailsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentDetailsModel model = new AccidentDetailsModel();
                    model.setAccidentId(rs.getInt("accident_id"));
                    model.setAccDetDescId(rs.getInt("acc_det_desc_id"));
                return model;
            }
        });
    }


    public int deleteAccidentDetails(Integer accident_id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + ACCIDENT_DETAILS);
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE accident_id = ?");
        sDeleteStmt.append(sWhereStmt);
        Object[] args = {accident_id};
        int numRows = getTemplate().update(sDeleteStmt.toString(), args);
        return numRows;
    }


    public int getAutoIncrementKey() {
        String sqlString = "select last_insert_id()";
        return getTemplate().queryForInt(sqlString);
    }


}
