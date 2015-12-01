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
import edu.mizzou.incidentaccident.api.models.ProgramActivityInvolvedModel;

@Repository("programActivityInvolvedDao")
public class ProgramActivityInvolvedDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(ProgramActivityInvolvedDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addProgramActivityInvolved(ProgramActivityInvolvedModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + PROGRAM_ACTIVITY_INVOLVED + " (")
            .append(" id " )
            .append(", time " )
            .append(", informal_activity " )
            .append(", inf_act_desc " )
            .append(", club_rec_sports " )
            .append(", club_rec_team_name " )
            .append(", swim_team_practice " )
            .append(", swim_team_name " )
            .append(", inter_athletics " )
            .append(", tigerx_pt " )
            .append(", tigerx_prg_name " )
            .append(", tigerx_pt_instructor " )
            .append(", spec_evt " )
            .append(", spec_evt_group " )
            .append(") VALUES ( ")
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
            .append(", ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getId(), 
            bean.getTime(), 
            bean.isInformalActivity(), 
            bean.getInfActDesc(), 
            bean.isClubRecSports(), 
            bean.getClubRecTeamName(), 
            bean.isSwimTeamPractice(), 
            bean.getSwimTeamName(), 
            bean.isInterAthletics(), 
            bean.isTigerxPt(), 
            bean.getTigerxPrgName(), 
            bean.getTigerxPtInstructor(), 
            bean.isSpecEvt(), 
            bean.getSpecEvtGroup()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateProgramActivityInvolved(ProgramActivityInvolvedModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + PROGRAM_ACTIVITY_INVOLVED)
        .append(" SET ")
        .append(" id = ? " )
        .append(", time = ? " )
        .append(", informal_activity = ? " )
        .append(", inf_act_desc = ? " )
        .append(", club_rec_sports = ? " )
        .append(", club_rec_team_name = ? " )
        .append(", swim_team_practice = ? " )
        .append(", swim_team_name = ? " )
        .append(", inter_athletics = ? " )
        .append(", tigerx_pt = ? " )
        .append(", tigerx_prg_name = ? " )
        .append(", tigerx_pt_instructor = ? " )
        .append(", spec_evt = ? " )
        .append(", spec_evt_group = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getId(), 
            bean.getTime(), 
            bean.isInformalActivity(), 
            bean.getInfActDesc(), 
            bean.isClubRecSports(), 
            bean.getClubRecTeamName(), 
            bean.isSwimTeamPractice(), 
            bean.getSwimTeamName(), 
            bean.isInterAthletics(), 
            bean.isTigerxPt(), 
            bean.getTigerxPrgName(), 
            bean.getTigerxPtInstructor(), 
            bean.isSpecEvt(), 
            bean.getSpecEvtGroup()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public ProgramActivityInvolvedModel getProgramActivityInvolved(Integer id) {
    String sqlString = "select " +
        "id" +
        ", time" +
        ", informal_activity" +
        ", inf_act_desc" +
        ", club_rec_sports" +
        ", club_rec_team_name" +
        ", swim_team_practice" +
        ", swim_team_name" +
        ", inter_athletics" +
        ", tigerx_pt" +
        ", tigerx_prg_name" +
        ", tigerx_pt_instructor" +
        ", spec_evt" +
        ", spec_evt_group" +
        " from " + PROGRAM_ACTIVITY_INVOLVED + " where id = ?";
        Object[] args = {id};
        List<ProgramActivityInvolvedModel> matches = getTemplate().query(sqlString, args, new RowMapper<ProgramActivityInvolvedModel>() {
            public ProgramActivityInvolvedModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProgramActivityInvolvedModel model = new ProgramActivityInvolvedModel();
                    model.setId(rs.getInt("id"));
                    model.setTime(rs.getTime("time"));
                    model.setInformalActivity("Y".equals(rs.getString("informal_activity"))?true:false);
                    model.setInfActDesc(rs.getString("inf_act_desc"));
                    model.setClubRecSports("Y".equals(rs.getString("club_rec_sports"))?true:false);
                    model.setClubRecTeamName(rs.getString("club_rec_team_name"));
                    model.setSwimTeamPractice("Y".equals(rs.getString("swim_team_practice"))?true:false);
                    model.setSwimTeamName(rs.getString("swim_team_name"));
                    model.setInterAthletics("Y".equals(rs.getString("inter_athletics"))?true:false);
                    model.setTigerxPt("Y".equals(rs.getString("tigerx_pt"))?true:false);
                    model.setTigerxPrgName(rs.getString("tigerx_prg_name"));
                    model.setTigerxPtInstructor(rs.getString("tigerx_pt_instructor"));
                    model.setSpecEvt("Y".equals(rs.getString("spec_evt"))?true:false);
                    model.setSpecEvtGroup(rs.getString("spec_evt_group"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<ProgramActivityInvolvedModel> getProgramActivityInvolvedList() {
    String sqlString = "select " +
        "id" +
        ", time" +
        ", informal_activity" +
        ", inf_act_desc" +
        ", club_rec_sports" +
        ", club_rec_team_name" +
        ", swim_team_practice" +
        ", swim_team_name" +
        ", inter_athletics" +
        ", tigerx_pt" +
        ", tigerx_prg_name" +
        ", tigerx_pt_instructor" +
        ", spec_evt" +
        ", spec_evt_group" +
        " from " + PROGRAM_ACTIVITY_INVOLVED;
        return getTemplate().query(sqlString, new RowMapper<ProgramActivityInvolvedModel>() {
            public ProgramActivityInvolvedModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProgramActivityInvolvedModel model = new ProgramActivityInvolvedModel();
                    model.setId(rs.getInt("id"));
                    model.setTime(rs.getTime("time"));
                    model.setInformalActivity("Y".equals(rs.getString("informal_activity"))?true:false);
                    model.setInfActDesc(rs.getString("inf_act_desc"));
                    model.setClubRecSports("Y".equals(rs.getString("club_rec_sports"))?true:false);
                    model.setClubRecTeamName(rs.getString("club_rec_team_name"));
                    model.setSwimTeamPractice("Y".equals(rs.getString("swim_team_practice"))?true:false);
                    model.setSwimTeamName(rs.getString("swim_team_name"));
                    model.setInterAthletics("Y".equals(rs.getString("inter_athletics"))?true:false);
                    model.setTigerxPt("Y".equals(rs.getString("tigerx_pt"))?true:false);
                    model.setTigerxPrgName(rs.getString("tigerx_prg_name"));
                    model.setTigerxPtInstructor(rs.getString("tigerx_pt_instructor"));
                    model.setSpecEvt("Y".equals(rs.getString("spec_evt"))?true:false);
                    model.setSpecEvtGroup(rs.getString("spec_evt_group"));
                return model;
            }
        });
    }


    public int deleteProgramActivityInvolved(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + PROGRAM_ACTIVITY_INVOLVED);
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
