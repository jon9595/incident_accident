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
import edu.mizzou.incidentaccident.api.models.AccidentModel;

@Repository("accidentDao")
public class AccidentDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(AccidentDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addAccident(AccidentModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + ACCIDENT + " (")
            .append(" demographics " )
            .append(", membership_status " )
            .append(", program_activity " )
            .append(", responder_acct " )
            .append(", member_acct " )
            .append(", refusal_of_care " )
            .append(", witness_one " )
            .append(", witness_two " )
            .append(", proper_notifications " )
            .append(", other_inj_desc " )
            .append(", spec_inj_location " )
            .append(", specific_location " )
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
            .append(", ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getDemographicsId(), 
            bean.getMembershipStatusId(), 
            bean.getProgramActivityId(), 
            bean.getResponderAcctId(), 
            bean.getMemberAcctId(), 
            bean.getRefusalOfCareId(), 
            bean.getWitnessOneId(), 
            bean.getWitnessTwoId(), 
            bean.getProperNotificationsId(), 
            bean.getOtherInjDesc(), 
            bean.getSpecInjLocationId(), 
            bean.getSpecificLocationId(),
            bean.getCreatedBy()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateAccident(AccidentModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + ACCIDENT)
        .append(" SET ")
        .append(" demographics = ? " )
        .append(", membership_status = ? " )
        .append(", program_activity = ? " )
        .append(", responder_acct = ? " )
        .append(", member_acct = ? " )
        .append(", refusal_of_care = ? " )
        .append(", witness_one = ? " )
        .append(", witness_two = ? " )
        .append(", proper_notifications = ? " )
        .append(", other_inj_desc = ? " )
        .append(", spec_inj_location = ? " )
        .append(", specific_location = ? " )
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
            bean.getRefusalOfCareId(), 
            bean.getWitnessOneId(), 
            bean.getWitnessTwoId(), 
            bean.getProperNotificationsId(), 
            bean.getOtherInjDesc(), 
            bean.getSpecInjLocationId(), 
            bean.getSpecificLocationId(),
            bean.getModifiedBy(),
            bean.getId()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public AccidentModel getAccident(Integer id) {
    String sqlString = "select " +
        "id" +
        ", demographics" +
        ", membership_status" +
        ", program_activity" +
        ", responder_acct" +
        ", member_acct" +
        ", refusal_of_care" +
        ", witness_one" +
        ", witness_two" +
        ", proper_notifications" +
        ", other_inj_desc" +
        ", spec_inj_location" +
        ", specific_location" +
        ", created" +
        ", created_by" +
        ", modified" +
        ", modified_by" +
        " from " + ACCIDENT + " where id = ?";
        Object[] args = {id};
        List<AccidentModel> matches = getTemplate().query(sqlString, args, new RowMapper<AccidentModel>() {
            public AccidentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentModel model = new AccidentModel();
                    model.setId(rs.getInt("id"));
                    model.setDemographicsId(rs.getInt("demographics"));
                    model.setMembershipStatusId(rs.getInt("membership_status"));
                    model.setProgramActivityId(rs.getInt("program_activity"));
                    model.setResponderAcctId(rs.getInt("responder_acct"));
                    model.setMemberAcctId(rs.getInt("member_acct"));
                    model.setRefusalOfCareId(rs.getInt("refusal_of_care"));
                    model.setWitnessOneId(rs.getInt("witness_one"));
                    model.setWitnessTwoId(rs.getInt("witness_two"));
                    model.setProperNotificationsId(rs.getInt("proper_notifications"));
                    model.setOtherInjDesc(rs.getString("other_inj_desc"));
                    model.setSpecInjLocationId(rs.getInt("spec_inj_location"));
                    model.setSpecificLocationId(rs.getInt("specific_location"));
                    model.setCreated(rs.getTimestamp("created")!=null?new java.util.Date(rs.getTimestamp("created").getTime()):null);
                    model.setCreatedBy(rs.getString("created_by"));
                    model.setModified(rs.getTimestamp("modified")!=null?new java.util.Date(rs.getTimestamp("modified").getTime()):null);
                    model.setModifiedBy(rs.getString("modified_by"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<AccidentModel> getAccidentList() {
    String sqlString = "select " +
        "id" +
        ", demographics" +
        ", membership_status" +
        ", program_activity" +
        ", responder_acct" +
        ", member_acct" +
        ", refusal_of_care" +
        ", witness_one" +
        ", witness_two" +
        ", proper_notifications" +
        ", other_inj_desc" +
        ", spec_inj_location" +
        ", specific_location" +
        ", created" +
        ", created_by" +
        ", modified" +
        ", modified_by" +
        " from " + ACCIDENT;
        return getTemplate().query(sqlString, new RowMapper<AccidentModel>() {
            public AccidentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentModel model = new AccidentModel();
                    model.setId(rs.getInt("id"));
                    model.setDemographicsId(rs.getInt("demographics"));
                    model.setMembershipStatusId(rs.getInt("membership_status"));
                    model.setProgramActivityId(rs.getInt("program_activity"));
                    model.setResponderAcctId(rs.getInt("responder_acct"));
                    model.setMemberAcctId(rs.getInt("member_acct"));
                    model.setRefusalOfCareId(rs.getInt("refusal_of_care"));
                    model.setWitnessOneId(rs.getInt("witness_one"));
                    model.setWitnessTwoId(rs.getInt("witness_two"));
                    model.setProperNotificationsId(rs.getInt("proper_notifications"));
                    model.setOtherInjDesc(rs.getString("other_inj_desc"));
                    model.setSpecInjLocationId(rs.getInt("spec_inj_location"));
                    model.setSpecificLocationId(rs.getInt("specific_location"));
                    model.setCreated(rs.getTimestamp("created")!=null?new java.util.Date(rs.getTimestamp("created").getTime()):null);
                    model.setCreatedBy(rs.getString("created_by"));
                    model.setModified(rs.getTimestamp("modified")!=null?new java.util.Date(rs.getTimestamp("modified").getTime()):null);
                    model.setModifiedBy(rs.getString("modified_by"));
                return model;
            }
        });
    }

    public List<AccidentModel> getAccidentListFromPastMonth() {
    String sqlString = "select " +
        "id" +
        ", demographics" +
        ", membership_status" +
        ", program_activity" +
        ", responder_acct" +
        ", member_acct" +
        ", refusal_of_care" +
        ", witness_one" +
        ", witness_two" +
        ", proper_notifications" +
        ", other_inj_desc" +
        ", spec_inj_location" +
        ", specific_location" +
        ", created" +
        ", created_by" +
        ", modified" +
        ", modified_by" +
        " from " + ACCIDENT +
        " where created > (NOW() - INTERVAL 1 MONTH)";
        return getTemplate().query(sqlString, new RowMapper<AccidentModel>() {
            public AccidentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentModel model = new AccidentModel();
                    model.setId(rs.getInt("id"));
                    model.setDemographicsId(rs.getInt("demographics"));
                    model.setMembershipStatusId(rs.getInt("membership_status"));
                    model.setProgramActivityId(rs.getInt("program_activity"));
                    model.setResponderAcctId(rs.getInt("responder_acct"));
                    model.setMemberAcctId(rs.getInt("member_acct"));
                    model.setRefusalOfCareId(rs.getInt("refusal_of_care"));
                    model.setWitnessOneId(rs.getInt("witness_one"));
                    model.setWitnessTwoId(rs.getInt("witness_two"));
                    model.setProperNotificationsId(rs.getInt("proper_notifications"));
                    model.setOtherInjDesc(rs.getString("other_inj_desc"));
                    model.setSpecInjLocationId(rs.getInt("spec_inj_location"));
                    model.setSpecificLocationId(rs.getInt("specific_location"));
                    model.setCreated(rs.getTimestamp("created")!=null?new java.util.Date(rs.getTimestamp("created").getTime()):null);
                    model.setCreatedBy(rs.getString("created_by"));
                    model.setModified(rs.getTimestamp("modified")!=null?new java.util.Date(rs.getTimestamp("modified").getTime()):null);
                    model.setModifiedBy(rs.getString("modified_by"));
                return model;
            }
        });
    }
        
    public List<AccidentModel> getAccidentListFromSearch(String whereClause) {
    String sqlString = "select " +
        "id" +
        ", demographics" +
        ", membership_status" +
        ", program_activity" +
        ", responder_acct" +
        ", member_acct" +
        ", refusal_of_care" +
        ", witness_one" +
        ", witness_two" +
        ", proper_notifications" +
        ", other_inj_desc" +
        ", spec_inj_location" +
        ", specific_location" +
        ", created" +
        ", created_by" +
        ", modified" +
        ", modified_by" +
        " from " + ACCIDENT + whereClause;
        return getTemplate().query(sqlString, new RowMapper<AccidentModel>() {
            public AccidentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentModel model = new AccidentModel();
                    model.setId(rs.getInt("id"));
                    model.setDemographicsId(rs.getInt("demographics"));
                    model.setMembershipStatusId(rs.getInt("membership_status"));
                    model.setProgramActivityId(rs.getInt("program_activity"));
                    model.setResponderAcctId(rs.getInt("responder_acct"));
                    model.setMemberAcctId(rs.getInt("member_acct"));
                    model.setRefusalOfCareId(rs.getInt("refusal_of_care"));
                    model.setWitnessOneId(rs.getInt("witness_one"));
                    model.setWitnessTwoId(rs.getInt("witness_two"));
                    model.setProperNotificationsId(rs.getInt("proper_notifications"));
                    model.setOtherInjDesc(rs.getString("other_inj_desc"));
                    model.setSpecInjLocationId(rs.getInt("spec_inj_location"));
                    model.setSpecificLocationId(rs.getInt("specific_location"));
                    model.setCreated(rs.getTimestamp("created")!=null?new java.util.Date(rs.getTimestamp("created").getTime()):null);
                    model.setCreatedBy(rs.getString("created_by"));
                    model.setModified(rs.getTimestamp("modified")!=null?new java.util.Date(rs.getTimestamp("modified").getTime()):null);
                    model.setModifiedBy(rs.getString("modified_by"));
                return model;
            }
        });
    }
        
    public List<AccidentModel> getAccidentsNeedingApproval() {
        String sqlString = "select " +
        "id" +
        ", demographics" +
        ", membership_status" +
        ", program_activity" +
        ", responder_acct" +
        ", member_acct" +
        ", refusal_of_care" +
        ", witness_one" +
        ", witness_two" +
        ", proper_notifications" +
        ", other_inj_desc" +
        ", spec_inj_location" +
        ", specific_location" +
        ", created" +
        ", created_by" +
        ", modified" +
        ", modified_by" +
        " from " + ACCIDENT + 
        " where proper_notifications in (" +
        " SELECT pa.id FROM " + PROPER_NOTIFICATIONS + 
        " pa where rpt_reviewed_by is null or rpt_reviewed_by  = '')";
        return getTemplate().query(sqlString, new RowMapper<AccidentModel>() {
            public AccidentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentModel model = new AccidentModel();
                    model.setId(rs.getInt("id"));
                    model.setDemographicsId(rs.getInt("demographics"));
                    model.setMembershipStatusId(rs.getInt("membership_status"));
                    model.setProgramActivityId(rs.getInt("program_activity"));
                    model.setResponderAcctId(rs.getInt("responder_acct"));
                    model.setMemberAcctId(rs.getInt("member_acct"));
                    model.setRefusalOfCareId(rs.getInt("refusal_of_care"));
                    model.setWitnessOneId(rs.getInt("witness_one"));
                    model.setWitnessTwoId(rs.getInt("witness_two"));
                    model.setProperNotificationsId(rs.getInt("proper_notifications"));
                    model.setOtherInjDesc(rs.getString("other_inj_desc"));
                    model.setSpecInjLocationId(rs.getInt("spec_inj_location"));
                    model.setSpecificLocationId(rs.getInt("specific_location"));
                    model.setCreated(rs.getTimestamp("created")!=null?new java.util.Date(rs.getTimestamp("created").getTime()):null);
                    model.setCreatedBy(rs.getString("created_by"));
                    model.setModified(rs.getTimestamp("modified")!=null?new java.util.Date(rs.getTimestamp("modified").getTime()):null);
                    model.setModifiedBy(rs.getString("modified_by"));
                return model;
            }
        });
    }

    public int deleteAccident(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + ACCIDENT);
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
