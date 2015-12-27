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
import edu.mizzou.incidentaccident.api.models.AccidentDetailDescriptionModel;
import edu.mizzou.incidentaccident.api.models.IncidentNatureModel;

@Repository("incidentNatureDao")
public class IncidentNatureDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(IncidentNatureDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addIncidentNature(IncidentNatureModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + INCIDENT_NATURE + " (")
            .append(" id " )
            .append(", description " )
            .append(") VALUES ( ")
            .append(", ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getId(), 
            bean.getDescription()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateIncidentNature(IncidentNatureModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + INCIDENT_NATURE)
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


    public IncidentNatureModel getIncidentNature(Integer id) {
    String sqlString = "select " +
        "id" +
        ", description" +
        " from " + INCIDENT_NATURE + " where id = ?";
        Object[] args = {id};
        List<IncidentNatureModel> matches = getTemplate().query(sqlString, args, new RowMapper<IncidentNatureModel>() {
            public IncidentNatureModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                IncidentNatureModel model = new IncidentNatureModel();
                    model.setId(rs.getInt("id"));
                    model.setDescription(rs.getString("description"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }

    public List<IncidentNatureModel> getIncidentDetailDescriptionListForIncident(Integer incidentId) {
    String sqlString = "select " +
        "id" +
        ", description" +
        " from " + INCIDENT_NATURE +
        " where id in (select incident_nature_id from " + INCIDENT_INCIDENT_NATURE + " where incident_id = ?)";
    	Object[] args = {incidentId};
        return getTemplate().query(sqlString, args, new RowMapper<IncidentNatureModel>() {
            public IncidentNatureModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                IncidentNatureModel model = new IncidentNatureModel();
                    model.setId(rs.getInt("id"));
                    model.setDescription(rs.getString("description"));
                return model;
            }
        });
    }
    

    public List<IncidentNatureModel> getIncidentNatureList() {
    String sqlString = "select " +
        "id" +
        ", description" +
        " from " + INCIDENT_NATURE;
        return getTemplate().query(sqlString, new RowMapper<IncidentNatureModel>() {
            public IncidentNatureModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                IncidentNatureModel model = new IncidentNatureModel();
                    model.setId(rs.getInt("id"));
                    model.setDescription(rs.getString("description"));
                return model;
            }
        });
    }


    public int deleteIncidentNature(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + INCIDENT_NATURE);
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
