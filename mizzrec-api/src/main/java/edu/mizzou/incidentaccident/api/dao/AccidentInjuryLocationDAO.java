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
import edu.mizzou.incidentaccident.api.models.AccidentInjuryLocationModel;

@Repository("accidentInjuryLocationDao")
public class AccidentInjuryLocationDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(AccidentInjuryLocationDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addAccidentInjuryLocation(AccidentInjuryLocationModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + ACCIDENT_INJURY_LOCATION + " (")
            .append(" accident_id " )
            .append(", injury_locations_id " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getAccidentId(), 
            bean.getInjuryLocationsId()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateAccidentInjuryLocation(AccidentInjuryLocationModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + ACCIDENT_INJURY_LOCATION)
        .append(" SET ")
        .append(" accident_id = ? " )
        .append(", injury_locations_id = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE accident_id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getAccidentId(), 
            bean.getInjuryLocationsId(),
            bean.getAccidentId()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public AccidentInjuryLocationModel getAccidentInjuryLocation(Integer accident_id) {
    String sqlString = "select " +
        "accident_id" +
        ", injury_locations_id" +
        " from " + ACCIDENT_INJURY_LOCATION + " where accident_id = ?";
        Object[] args = {accident_id};
        List<AccidentInjuryLocationModel> matches = getTemplate().query(sqlString, args, new RowMapper<AccidentInjuryLocationModel>() {
            public AccidentInjuryLocationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentInjuryLocationModel model = new AccidentInjuryLocationModel();
                    model.setAccidentId(rs.getInt("accident_id"));
                    model.setInjuryLocationsId(rs.getInt("injury_locations_id"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<AccidentInjuryLocationModel> getAccidentInjuryLocationList() {
    String sqlString = "select " +
        "accident_id" +
        ", injury_locations_id" +
        " from " + ACCIDENT_INJURY_LOCATION;
        return getTemplate().query(sqlString, new RowMapper<AccidentInjuryLocationModel>() {
            public AccidentInjuryLocationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentInjuryLocationModel model = new AccidentInjuryLocationModel();
                    model.setAccidentId(rs.getInt("accident_id"));
                    model.setInjuryLocationsId(rs.getInt("injury_locations_id"));
                return model;
            }
        });
    }


    public int deleteAccidentInjuryLocation(Integer accident_id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + ACCIDENT_INJURY_LOCATION);
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
