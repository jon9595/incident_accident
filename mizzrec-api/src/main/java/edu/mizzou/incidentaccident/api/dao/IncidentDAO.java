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
import edu.mizzou.incidentaccident.api.models.AccidentSearchModel;
import edu.mizzou.incidentaccident.api.models.IncidentModel;
import edu.mizzou.incidentaccident.api.models.IncidentSearchModel;
import edu.mizzou.incidentaccident.api.models.MembershipStatusModel;
import edu.mizzou.incidentaccident.api.models.ProgramActivityInvolvedModel;

@Repository("incidentDao")
public class IncidentDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(IncidentDAO.class);
    
    private String incidentSqlString = "select inc.id, dem.date, dem.name, dem.address, ms.*,"
    		+ " (select group_concat(concat(location,if(sub_location != '',\" - \",\"\"), sub_location)) from  " + LOCATIONS
    		+ " where id in (select location_id from " + INCIDENT_LOCATION + " where incident_id = inc.id)) as location, pai.*,"
    		+ "(select group_concat(description) from " +  INCIDENT_NATURE  + " where id in "
    		+ "(select incident_nature_id from  " + INCIDENT_INCIDENT_NATURE  + "  where incident_id = inc.id)) as incident_nature "
    		+ "from " + INCIDENT  + " inc join demographics dem on (dem.id = inc.demographics) join " + MEMBERSHIP_STATUS  + " ms on (ms.id = inc.membership_status) "
    		+ "join " + PROGRAM_ACTIVITY_INVOLVED  + "  pai on (pai.id = inc.program_activity)";

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
        ", created" +
        ", created_by" +
        ", modified" +
        ", modified_by" +
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
                    model.setCreated(rs.getTimestamp("created")!=null?new java.util.Date(rs.getTimestamp("created").getTime()):null);
                    model.setCreatedBy(rs.getString("created_by"));
                    model.setModified(rs.getTimestamp("modified")!=null?new java.util.Date(rs.getTimestamp("modified").getTime()):null);
                    model.setModifiedBy(rs.getString("modified_by"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<IncidentSearchModel> getIncidentList() {
    String sqlString = incidentSqlString;
        return getTemplate().query(sqlString, new RowMapper<IncidentSearchModel>() {
            public IncidentSearchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            	return populateSearchModel(rs);
            }
        });
    }

    public List<IncidentSearchModel> getIncidentListFromPastMonth() {
    String sqlString = incidentSqlString + 
    	" where dem.date > (NOW() - INTERVAL 1 MONTH)";
        return getTemplate().query(sqlString, new RowMapper<IncidentSearchModel>() {
            public IncidentSearchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            	return populateSearchModel(rs);
            }
        });
    }
    
    public List<IncidentSearchModel> getIncidentListFromSearch(String whereClause) {
        String sqlString = incidentSqlString + whereClause;
        return getTemplate().query(sqlString, new RowMapper<IncidentSearchModel>() {
            public IncidentSearchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            	return populateSearchModel(rs);
            }
        });
    }

    public List<IncidentSearchModel> getIncidentsNeedingApproval() {
        String sqlString = incidentSqlString + " where proper_notifications in (" +
        " SELECT pa.id FROM " + PROPER_NOTIFICATIONS + 
        " pa where rpt_reviewed_by is null or rpt_reviewed_by  = '')";
        return getTemplate().query(sqlString, new RowMapper<IncidentSearchModel>() {
            public IncidentSearchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            	return populateSearchModel(rs);
            }
        });
    }

    private IncidentSearchModel populateSearchModel(ResultSet rs) throws SQLException{
    	IncidentSearchModel model = new IncidentSearchModel();
        model.setId(rs.getInt("id"));
        model.setIncidentDate(rs.getTimestamp("date")!=null?new java.util.Date(rs.getTimestamp("date").getTime()):null);
        model.setName(rs.getString("dem.name"));
        model.setAddress(rs.getString("dem.address"));
        model.setLocation(rs.getString("location"));
        model.setIncidentDetails(rs.getString("incident_nature"));
        MembershipStatusModel msModel = model.getMembershipStatus();
        msModel.setId(rs.getInt("ms.id"));
        msModel.setStudent("Y".equals(rs.getString("ms.student"))?true:false);
        msModel.setStudentId(rs.getString("ms.student_id"));
        msModel.setFacultyStaff("Y".equals(rs.getString("ms.faculty_staff"))?true:false);
        msModel.setAlumni("Y".equals(rs.getString("ms.alumni"))?true:false);
        msModel.setGuest("Y".equals(rs.getString("ms.guest"))?true:false);
        msModel.setTigerXpress("Y".equals(rs.getString("ms.tiger_xpress"))?true:false);
        msModel.setStopOutStudent("Y".equals(rs.getString("ms.stop_out_student"))?true:false);
        msModel.setHouseHoldAdult("Y".equals(rs.getString("ms.house_hold_adult"))?true:false);
        msModel.setOther("Y".equals(rs.getString("ms.other"))?true:false);
        msModel.setOtherExplain(rs.getString("ms.other_explain"));
    	ProgramActivityInvolvedModel paiModel = model.getProgramActivity();
    	paiModel.setId(rs.getInt("pai.id"));
    	paiModel.setTime(rs.getTime("pai.time"));
        paiModel.setInformalActivity("Y".equals(rs.getString("pai.informal_activity"))?true:false);
        paiModel.setInfActDesc(rs.getString("pai.inf_act_desc"));
        paiModel.setClubRecSports("Y".equals(rs.getString("pai.club_rec_sports"))?true:false);
        paiModel.setClubRecTeamName(rs.getString("pai.club_rec_team_name"));
        paiModel.setRecSports("Y".equals(rs.getString("pai.rec_sports"))?true:false);
        paiModel.setRecTeamName(rs.getString("pai.rec_team_name"));
        paiModel.setSwimTeamPractice("Y".equals(rs.getString("pai.swim_team_practice"))?true:false);
        paiModel.setSwimTeamName(rs.getString("pai.swim_team_name"));
        paiModel.setInterAthletics("Y".equals(rs.getString("pai.inter_athletics"))?true:false);
        paiModel.setTigerxPt("Y".equals(rs.getString("pai.tigerx_pt"))?true:false);
        paiModel.setTigerxPrgName(rs.getString("pai.tigerx_prg_name"));
        paiModel.setTigerxPtInstructor(rs.getString("pai.tigerx_pt_instructor"));
        paiModel.setSpecEvt("Y".equals(rs.getString("pai.spec_evt"))?true:false);
        paiModel.setSpecEvtGroup(rs.getString("pai.spec_evt_group"));
        return model;
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
