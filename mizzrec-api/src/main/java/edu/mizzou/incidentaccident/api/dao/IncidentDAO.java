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
import edu.mizzou.incidentaccident.api.models.IncidentModel;

@Repository("incidentDao")
public class IncidentDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(IncidentDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addIncident(IncidentModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + INCIDENT + " (")
            .append(" demographics " )
            .append(", membership_status " )
            .append(", program_activity " )
            .append(", responder_acct " )
            .append(", member_acct " )
            .append(", witness_acct " )
            .append(", witness_info " )
            .append(", proper_notifications " )
            .append(", specific_location " )
            .append(", other_inc_nature_desc " )
            .append(", created_by " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getDemographicsId(), 
            bean.getMembershipStatusId(), 
            bean.getProgramActivityId(), 
            bean.getResponderAcctId(), 
            bean.getMemberAcctId(), 
            bean.getWitnessAcctId(), 
            bean.getWitnessInfoId(), 
            bean.getProperNotificationsId(), 
            bean.getSpecificLocationId(), 
            bean.getOtherIncNatureDesc(), 
            bean.getCreatedBy()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateIncident(IncidentModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + INCIDENT)
        .append(" SET ")
        .append(" demographics = ? " )
        .append(", membership_status = ? " )
        .append(", program_activity = ? " )
        .append(", responder_acct = ? " )
        .append(", member_acct = ? " )
        .append(", witness_acct = ? " )
        .append(", witness_info = ? " )
        .append(", proper_notifications = ? " )
        .append(", specific_location = ? " )
        .append(", other_inc_nature_desc = ? " )
        .append(", modified_by = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getDemographicsId(), 
            bean.getMembershipStatusId(), 
            bean.getProgramActivityId(), 
            bean.getResponderAcctId(), 
            bean.getMemberAcctId(), 
            bean.getWitnessAcctId(), 
            bean.getWitnessInfoId(), 
            bean.getProperNotificationsId(), 
            bean.getSpecificLocationId(), 
            bean.getOtherIncNatureDesc(), 
            bean.getModifiedBy(),
            bean.getId()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public IncidentModel getIncident(Integer id) {
    String sqlString = "select " +
        "id" +
        ", demographics" +
        ", membership_status" +
        ", program_activity" +
        ", responder_acct" +
        ", member_acct" +
        ", witness_acct" +
        ", witness_info" +
        ", proper_notifications" +
        ", specific_location" +
        ", other_inc_nature_desc" +
        " from " + INCIDENT + " where id = ?";
        Object[] args = {id};
        List<IncidentModel> matches = getTemplate().query(sqlString, args, new RowMapper<IncidentModel>() {
            public IncidentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                IncidentModel model = new IncidentModel();
                    model.setId(rs.getInt("id"));
                    model.setDemographicsId(rs.getInt("demographics"));
                    model.setMembershipStatusId(rs.getInt("membership_status"));
                    model.setProgramActivityId(rs.getInt("program_activity"));
                    model.setResponderAcctId(rs.getInt("responder_acct"));
                    model.setMemberAcctId(rs.getInt("member_acct"));
                    model.setWitnessAcctId(rs.getInt("witness_acct"));
                    model.setWitnessInfoId(rs.getInt("witness_info"));
                    model.setProperNotificationsId(rs.getInt("proper_notifications"));
                    model.setSpecificLocationId(rs.getInt("specific_location"));
                    model.setOtherIncNatureDesc(rs.getString("other_inc_nature_desc"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<IncidentModel> getIncidentList() {
    String sqlString = "select " +
        "id" +
        ", demographics" +
        ", membership_status" +
        ", program_activity" +
        ", responder_acct" +
        ", member_acct" +
        ", witness_acct" +
        ", witness_info" +
        ", proper_notifications" +
        ", specific_location" +
        ", other_inc_nature_desc" +
        " from " + INCIDENT;
        return getTemplate().query(sqlString, new RowMapper<IncidentModel>() {
            public IncidentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                IncidentModel model = new IncidentModel();
                    model.setId(rs.getInt("id"));
                    model.setDemographicsId(rs.getInt("demographics"));
                    model.setMembershipStatusId(rs.getInt("membership_status"));
                    model.setProgramActivityId(rs.getInt("program_activity"));
                    model.setResponderAcctId(rs.getInt("responder_acct"));
                    model.setMemberAcctId(rs.getInt("member_acct"));
                    model.setWitnessAcctId(rs.getInt("witness_acct"));
                    model.setWitnessInfoId(rs.getInt("witness_info"));
                    model.setProperNotificationsId(rs.getInt("proper_notifications"));
                    model.setSpecificLocationId(rs.getInt("specific_location"));
                    model.setOtherIncNatureDesc(rs.getString("other_inc_nature_desc"));
                return model;
            }
        });
    }

    public List<IncidentModel> getIncidentListFromPastMonth() {
    String sqlString = "select " +
        "id" +
        ", demographics" +
        ", membership_status" +
        ", program_activity" +
        ", responder_acct" +
        ", member_acct" +
        ", witness_acct" +
        ", witness_info" +
        ", proper_notifications" +
        ", specific_location" +
        ", other_inc_nature_desc" +
        " from " + INCIDENT +
    	" where created > (NOW() - INTERVAL 1 MONTH)";
        return getTemplate().query(sqlString, new RowMapper<IncidentModel>() {
            public IncidentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                IncidentModel model = new IncidentModel();
                    model.setId(rs.getInt("id"));
                    model.setDemographicsId(rs.getInt("demographics"));
                    model.setMembershipStatusId(rs.getInt("membership_status"));
                    model.setProgramActivityId(rs.getInt("program_activity"));
                    model.setResponderAcctId(rs.getInt("responder_acct"));
                    model.setMemberAcctId(rs.getInt("member_acct"));
                    model.setWitnessAcctId(rs.getInt("witness_acct"));
                    model.setWitnessInfoId(rs.getInt("witness_info"));
                    model.setProperNotificationsId(rs.getInt("proper_notifications"));
                    model.setSpecificLocationId(rs.getInt("specific_location"));
                    model.setOtherIncNatureDesc(rs.getString("other_inc_nature_desc"));
                return model;
            }
        });
    }

    public int deleteIncident(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + INCIDENT);
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
