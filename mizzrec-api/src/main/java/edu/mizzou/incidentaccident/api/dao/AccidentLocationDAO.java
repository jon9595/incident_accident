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
import edu.mizzou.incidentaccident.api.models.AccidentLocationModel;

@Repository("accidentLocationDao")
public class AccidentLocationDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(AccidentLocationDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addAccidentLocation(AccidentLocationModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + ACCIDENT_LOCATION + " (")
            .append(" accident_id " )
            .append(", location_id " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getAccidentId(), 
            bean.getLocationId()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }

    public List<AccidentLocationModel> getAccidentLocationList(Integer accidentId) {
    String sqlString = "select " +
        "accident_id" +
        ", location_id" +
        " from " + ACCIDENT_LOCATION + " where accident_id = ?";
    	Object[] args = {accidentId};
        return getTemplate().query(sqlString, args, new RowMapper<AccidentLocationModel>() {
            public AccidentLocationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentLocationModel model = new AccidentLocationModel(rs.getInt("accident_id"), rs.getInt("location_id"));
                return model;
            }
        });
    }


    public int deleteAccidentLocation(Integer accident_id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + ACCIDENT_LOCATION);
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
