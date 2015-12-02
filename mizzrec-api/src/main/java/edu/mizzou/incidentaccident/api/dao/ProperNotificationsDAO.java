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
import edu.mizzou.incidentaccident.api.models.ProperNotificationsModel;

@Repository("properNotificationsDao")
public class ProperNotificationsDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(ProperNotificationsDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addProperNotifications(ProperNotificationsModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + PROPER_NOTIFICATIONS + " (")
            .append(" mupd_officer_name " )
            .append(", mupd_officer_called " )
            .append(", mupd_officer_arrived " )
            .append(", mupd_officer_case_nbr " )
            .append(", ems_contacted " )
            .append(", ems_entrance " )
            .append(", ems_called " )
            .append(", ems_arrived " )
            .append(", prof_staff_contacted " )
            .append(", prof_staff_called " )
            .append(", prof_staff_arrived " )
            .append(", report_completed_by " )
            .append(", rpt_cmplt_position " )
            .append(", rpt_cmplt_date " )
            .append(", rpt_reviewed_by " )
            .append(", rpt_reviewer_position " )
            .append(", rpt_reviewer_date " )
            .append(", res_life_cont_email_sent " )
            .append(", res_life_cont_date_sent " )
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
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getMupdOfficerName(), 
            bean.getMupdOfficerCalled(), 
            bean.getMupdOfficerArrived(), 
            bean.getMupdOfficerCaseNbr(), 
            bean.getEmsContacted(), 
            bean.getEmsEntrance(), 
            bean.getEmsCalled(), 
            bean.getEmsArrived(), 
            bean.getProfStaffContacted(), 
            bean.getProfStaffCalled(), 
            bean.getProfStaffArrived(), 
            bean.getReportCompletedBy(), 
            bean.getRptCmpltPosition(), 
            bean.getRptCmpltDate(), 
            bean.getRptReviewedBy(), 
            bean.getRptReviewerPosition(), 
            bean.getRptReviewerDate(), 
            bean.getResLifeContEmailSent(), 
            bean.getResLifeContDateSent()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateProperNotifications(ProperNotificationsModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + PROPER_NOTIFICATIONS)
        .append(" SET ")
        .append(" mupd_officer_name = ? " )
        .append(", mupd_officer_called = ? " )
        .append(", mupd_officer_arrived = ? " )
        .append(", mupd_officer_case_nbr = ? " )
        .append(", ems_contacted = ? " )
        .append(", ems_entrance = ? " )
        .append(", ems_called = ? " )
        .append(", ems_arrived = ? " )
        .append(", prof_staff_contacted = ? " )
        .append(", prof_staff_called = ? " )
        .append(", prof_staff_arrived = ? " )
        .append(", report_completed_by = ? " )
        .append(", rpt_cmplt_position = ? " )
        .append(", rpt_cmplt_date = ? " )
        .append(", rpt_reviewed_by = ? " )
        .append(", rpt_reviewer_position = ? " )
        .append(", rpt_reviewer_date = ? " )
        .append(", res_life_cont_email_sent = ? " )
        .append(", res_life_cont_date_sent = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getMupdOfficerName(), 
            bean.getMupdOfficerCalled(), 
            bean.getMupdOfficerArrived(), 
            bean.getMupdOfficerCaseNbr(), 
            bean.getEmsContacted(), 
            bean.getEmsEntrance(), 
            bean.getEmsCalled(), 
            bean.getEmsArrived(), 
            bean.getProfStaffContacted(), 
            bean.getProfStaffCalled(), 
            bean.getProfStaffArrived(), 
            bean.getReportCompletedBy(), 
            bean.getRptCmpltPosition(), 
            bean.getRptCmpltDate(), 
            bean.getRptReviewedBy(), 
            bean.getRptReviewerPosition(), 
            bean.getRptReviewerDate(), 
            bean.getResLifeContEmailSent(), 
            bean.getResLifeContDateSent(),
            bean.getId()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public ProperNotificationsModel getProperNotifications(Integer id) {
    String sqlString = "select " +
        "id" +
        ", mupd_officer_name" +
        ", mupd_officer_called" +
        ", mupd_officer_arrived" +
        ", mupd_officer_case_nbr" +
        ", ems_contacted" +
        ", ems_entrance" +
        ", ems_called" +
        ", ems_arrived" +
        ", prof_staff_contacted" +
        ", prof_staff_called" +
        ", prof_staff_arrived" +
        ", report_completed_by" +
        ", rpt_cmplt_position" +
        ", rpt_cmplt_date" +
        ", rpt_reviewed_by" +
        ", rpt_reviewer_position" +
        ", rpt_reviewer_date" +
        ", res_life_cont_email_sent" +
        ", res_life_cont_date_sent" +
        " from " + PROPER_NOTIFICATIONS + " where id = ?";
        Object[] args = {id};
        List<ProperNotificationsModel> matches = getTemplate().query(sqlString, args, new RowMapper<ProperNotificationsModel>() {
            public ProperNotificationsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProperNotificationsModel model = new ProperNotificationsModel();
                    model.setId(rs.getInt("id"));
                    model.setMupdOfficerName(rs.getString("mupd_officer_name"));
                    model.setMupdOfficerCalled(rs.getTime("mupd_officer_called"));
                    model.setMupdOfficerArrived(rs.getTime("mupd_officer_arrived"));
                    model.setMupdOfficerCaseNbr(rs.getString("mupd_officer_case_nbr"));
                    model.setEmsContacted(rs.getString("ems_contacted"));
                    model.setEmsEntrance(rs.getString("ems_entrance"));
                    model.setEmsCalled(rs.getTime("ems_called"));
                    model.setEmsArrived(rs.getTime("ems_arrived"));
                    model.setProfStaffContacted(rs.getString("prof_staff_contacted"));
                    model.setProfStaffCalled(rs.getTime("prof_staff_called"));
                    model.setProfStaffArrived(rs.getTime("prof_staff_arrived"));
                    model.setReportCompletedBy(rs.getString("report_completed_by"));
                    model.setRptCmpltPosition(rs.getString("rpt_cmplt_position"));
                    model.setRptCmpltDate(rs.getDate("rpt_cmplt_date")!=null?new java.util.Date(rs.getDate("rpt_cmplt_date").getTime()):null);
                    model.setRptReviewedBy(rs.getString("rpt_reviewed_by"));
                    model.setRptReviewerPosition(rs.getString("rpt_reviewer_position"));
                    model.setRptReviewerDate(rs.getDate("rpt_reviewer_date")!=null?new java.util.Date(rs.getDate("rpt_reviewer_date").getTime()):null);
                    model.setResLifeContEmailSent(rs.getString("res_life_cont_email_sent"));
                    model.setResLifeContDateSent(rs.getDate("res_life_cont_date_sent")!=null?new java.util.Date(rs.getDate("res_life_cont_date_sent").getTime()):null);
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<ProperNotificationsModel> getProperNotificationsList() {
    String sqlString = "select " +
        "id" +
        ", mupd_officer_name" +
        ", mupd_officer_called" +
        ", mupd_officer_arrived" +
        ", mupd_officer_case_nbr" +
        ", ems_contacted" +
        ", ems_entrance" +
        ", ems_called" +
        ", ems_arrived" +
        ", prof_staff_contacted" +
        ", prof_staff_called" +
        ", prof_staff_arrived" +
        ", report_completed_by" +
        ", rpt_cmplt_position" +
        ", rpt_cmplt_date" +
        ", rpt_reviewed_by" +
        ", rpt_reviewer_position" +
        ", rpt_reviewer_date" +
        ", res_life_cont_email_sent" +
        ", res_life_cont_date_sent" +
        " from " + PROPER_NOTIFICATIONS;
        return getTemplate().query(sqlString, new RowMapper<ProperNotificationsModel>() {
            public ProperNotificationsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProperNotificationsModel model = new ProperNotificationsModel();
                    model.setId(rs.getInt("id"));
                    model.setMupdOfficerName(rs.getString("mupd_officer_name"));
                    model.setMupdOfficerCalled(rs.getTime("mupd_officer_called"));
                    model.setMupdOfficerArrived(rs.getTime("mupd_officer_arrived"));
                    model.setMupdOfficerCaseNbr(rs.getString("mupd_officer_case_nbr"));
                    model.setEmsContacted(rs.getString("ems_contacted"));
                    model.setEmsEntrance(rs.getString("ems_entrance"));
                    model.setEmsCalled(rs.getTime("ems_called"));
                    model.setEmsArrived(rs.getTime("ems_arrived"));
                    model.setProfStaffContacted(rs.getString("prof_staff_contacted"));
                    model.setProfStaffCalled(rs.getTime("prof_staff_called"));
                    model.setProfStaffArrived(rs.getTime("prof_staff_arrived"));
                    model.setReportCompletedBy(rs.getString("report_completed_by"));
                    model.setRptCmpltPosition(rs.getString("rpt_cmplt_position"));
                    model.setRptCmpltDate(rs.getDate("rpt_cmplt_date")!=null?new java.util.Date(rs.getDate("rpt_cmplt_date").getTime()):null);
                    model.setRptReviewedBy(rs.getString("rpt_reviewed_by"));
                    model.setRptReviewerPosition(rs.getString("rpt_reviewer_position"));
                    model.setRptReviewerDate(rs.getDate("rpt_reviewer_date")!=null?new java.util.Date(rs.getDate("rpt_reviewer_date").getTime()):null);
                    model.setResLifeContEmailSent(rs.getString("res_life_cont_email_sent"));
                    model.setResLifeContDateSent(rs.getDate("res_life_cont_date_sent")!=null?new java.util.Date(rs.getDate("res_life_cont_date_sent").getTime()):null);
                return model;
            }
        });
    }


    public int deleteProperNotifications(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + PROPER_NOTIFICATIONS);
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
