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
import edu.mizzou.incidentaccident.api.models.IncidentIncidentNatureModel;

@Repository("incidentIncidentNatureDao")
public class IncidentIncidentNatureDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(IncidentIncidentNatureDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addIncidentIncidentNature(IncidentIncidentNatureModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + INCIDENT_INCIDENT_NATURE + " (")
            .append(" incident_id " )
            .append(", incident_nature_id " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getIncidentId(), 
            bean.getIncidentNatureId()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateIncidentIncidentNature(IncidentIncidentNatureModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + INCIDENT_INCIDENT_NATURE)
        .append(" SET ")
        .append(" incident_id = ? " )
        .append(", incident_nature_id = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE incident_id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getIncidentId(), 
            bean.getIncidentNatureId()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public IncidentIncidentNatureModel getIncidentIncidentNature(Integer incident_id) {
    String sqlString = "select " +
        "incident_id" +
        ", incident_nature_id" +
        " from " + INCIDENT_INCIDENT_NATURE + " where incident_id = ?";
        Object[] args = {incident_id};
        List<IncidentIncidentNatureModel> matches = getTemplate().query(sqlString, args, new RowMapper<IncidentIncidentNatureModel>() {
            public IncidentIncidentNatureModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                IncidentIncidentNatureModel model = new IncidentIncidentNatureModel();
                    model.setIncidentId(rs.getInt("incident_id"));
                    model.setIncidentNatureId(rs.getInt("incident_nature_id"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<IncidentIncidentNatureModel> getIncidentIncidentNatureList() {
    String sqlString = "select " +
        "incident_id" +
        ", incident_nature_id" +
        " from " + INCIDENT_INCIDENT_NATURE;
        return getTemplate().query(sqlString, new RowMapper<IncidentIncidentNatureModel>() {
            public IncidentIncidentNatureModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                IncidentIncidentNatureModel model = new IncidentIncidentNatureModel();
                    model.setIncidentId(rs.getInt("incident_id"));
                    model.setIncidentNatureId(rs.getInt("incident_nature_id"));
                return model;
            }
        });
    }


    public int deleteIncidentIncidentNature(Integer incident_id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + INCIDENT_INCIDENT_NATURE);
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
