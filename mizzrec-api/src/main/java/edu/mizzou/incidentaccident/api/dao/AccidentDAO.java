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
import edu.mizzou.incidentaccident.api.models.AccidentSearchModel;
import edu.mizzou.incidentaccident.api.models.MembershipStatusModel;
import edu.mizzou.incidentaccident.api.models.ProgramActivityInvolvedModel;

@Repository("accidentDao")
public class AccidentDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(AccidentDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	private String accidentListSqlStr = "select acc.id, dem.date, dem.name, dem.address, ms.*, "
			+ "(select group_concat(concat(location,if(sub_location != '',\" - \",\"\"), sub_location)) from  " + LOCATIONS
			+ " where id in (select location_id from " + ACCIDENT_LOCATION + " where accident_id = acc.id)) as location"
			+ ",pai.*, (select group_concat(concat(location, if(sub_location is not null,\" - \", \"\"), "
			+ "if(sub_location is not null and sub_location = 'R',\"Right\","
			+ "(if (sub_location is not null and sub_location = 'L',\"Left\",\"\"))))) "
			+ " from "+ INJURY_LOCATIONS +" where id in (select injury_locations_id from " + ACCIDENT_INJURY_LOCATION + " where accident_id = acc.id)) as injury_location "
			+ ",(select group_concat(description) from " + ACCIDENT_DETAIL_DESCRIPTION + " where id in (select acc_det_desc_id from " + ACCIDENT_DETAILS + " where accident_id = acc.id)) as accident_description"
			+ ", pn.ems_contacted "
			+ "from  " + ACCIDENT + " acc "
			+ "join " + DEMOGRAPHICS + " dem on (dem.id = acc.demographics) "
			+ "join " + MEMBERSHIP_STATUS + " ms on (ms.id = acc.membership_status) "
			+ "join " + PROGRAM_ACTIVITY_INVOLVED + " pai on (pai.id = acc.program_activity) "
			+ "join " + PROPER_NOTIFICATIONS + " pn on (pn.id = acc.proper_notifications)";

	
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


    public List<AccidentSearchModel> getAccidentList() {
    	String sqlString = accidentListSqlStr + " order by dem.date desc";
        return getTemplate().query(sqlString, new RowMapper<AccidentSearchModel>() {
            public AccidentSearchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            	return populateSearchModel(rs);
            }
        });
    }

    public List<AccidentSearchModel> getAccidentListFromPastMonth() {
    String sqlString = accidentListSqlStr +
        " where dem.date > (NOW() - INTERVAL 1 MONTH)"
        + " order by dem.date desc";
        return getTemplate().query(sqlString, new RowMapper<AccidentSearchModel>() {
            public AccidentSearchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            	return populateSearchModel(rs);
            }
        });
    }
        
    public List<AccidentSearchModel> getAccidentListFromSearch(String whereClause) {
    String sqlString = accidentListSqlStr + whereClause + " order by dem.date desc";
        return getTemplate().query(sqlString, new RowMapper<AccidentSearchModel>() {
            public AccidentSearchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            	return populateSearchModel(rs);
            }
        });
    }
        
    public List<AccidentSearchModel> getAccidentsNeedingApproval() {
        String sqlString = accidentListSqlStr +
        " where proper_notifications in (" +
        " SELECT pa.id FROM " + PROPER_NOTIFICATIONS + 
        " pa where rpt_reviewed_by is null or rpt_reviewed_by  = '')"
         + " order by dem.date desc";
        return getTemplate().query(sqlString, new RowMapper<AccidentSearchModel>() {
            public AccidentSearchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            	return populateSearchModel(rs);
            }
        });
    }

    private AccidentSearchModel populateSearchModel(ResultSet rs) throws SQLException{
    	AccidentSearchModel model = new AccidentSearchModel();
        model.setId(rs.getInt("id"));
        model.setAccidentDate(rs.getTimestamp("date")!=null?new java.util.Date(rs.getTimestamp("date").getTime()):null);
        model.setName(rs.getString("dem.name"));
        model.setAddress(rs.getString("dem.address"));
        model.setLocation(rs.getString("location"));
        model.setInjuryLocation(rs.getString("injury_location"));
        model.setAccidentDescription(rs.getString("accident_description"));
        model.setEmsContacted(rs.getString("ems_contacted"));
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
