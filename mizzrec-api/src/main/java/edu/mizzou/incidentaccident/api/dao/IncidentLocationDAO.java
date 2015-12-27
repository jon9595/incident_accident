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
import edu.mizzou.incidentaccident.api.models.IncidentLocationModel;

@Repository("incidentLocationDao")
public class IncidentLocationDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(IncidentLocationDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addIncidentLocation(IncidentLocationModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + INCIDENT_LOCATION + " (")
            .append(" incident_id " )
            .append(", location_id " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getIncidentId(), 
            bean.getLocationId()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }



    public IncidentLocationModel getIncidentLocation(Integer incident_id) {
    String sqlString = "select " +
        "incident_id" +
        ", location_id" +
        " from " + INCIDENT_LOCATION + " where incident_id = ?";
        Object[] args = {incident_id};
        List<IncidentLocationModel> matches = getTemplate().query(sqlString, args, new RowMapper<IncidentLocationModel>() {
            public IncidentLocationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                IncidentLocationModel model = new IncidentLocationModel();
                    model.setIncidentId(rs.getInt("incident_id"));
                    model.setLocationId(rs.getInt("location_id"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<IncidentLocationModel> getIncidentLocationList() {
    String sqlString = "select " +
        "incident_id" +
        ", location_id" +
        " from " + INCIDENT_LOCATION;
        return getTemplate().query(sqlString, new RowMapper<IncidentLocationModel>() {
            public IncidentLocationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                IncidentLocationModel model = new IncidentLocationModel();
                    model.setIncidentId(rs.getInt("incident_id"));
                    model.setLocationId(rs.getInt("location_id"));
                return model;
            }
        });
    }


    public int deleteIncidentLocation(Integer incident_id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + INCIDENT_LOCATION);
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE incident_id = ?");
        sDeleteStmt.append(sWhereStmt);
        Object[] args = {incident_id};
        int numRows = getTemplate().update(sDeleteStmt.toString(), args);
        return numRows;
    }


    public int getAutoIncrementKey() {
        String sqlString = "select last_insert_id()";
        return getTemplate().queryForInt(sqlString);
    }


}
