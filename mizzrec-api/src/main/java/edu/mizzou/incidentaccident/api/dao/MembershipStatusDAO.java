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
import edu.mizzou.incidentaccident.api.models.MembershipStatusModel;

@Repository("membershipStatusDao")
public class MembershipStatusDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(MembershipStatusDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addMembershipStatus(MembershipStatusModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + MEMBERSHIP_STATUS + " (")
            .append(" id " )
            .append(", student " )
            .append(", student_id " )
            .append(", faculty_staff " )
            .append(", alumni " )
            .append(", guest " )
            .append(", tiger_xpress " )
            .append(", stop_out_student " )
            .append(", house_hold_adult " )
            .append(", other " )
            .append(", other_explain " )
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
            .append(")");
        Object[] args = {
            bean.getId(), 
            bean.isStudent()?"Y":"N", 
            bean.getStudentId(), 
            bean.isFacultyStaff()?"Y":"N", 
            bean.isAlumni()?"Y":"N", 
            bean.isGuest()?"Y":"N", 
            bean.isTigerXpress()?"Y":"N", 
            bean.isStopOutStudent()?"Y":"N", 
            bean.isHouseHoldAdult()?"Y":"N", 
            bean.isOther()?"Y":"N", 
            bean.getOtherExplain()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateMembershipStatus(MembershipStatusModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + MEMBERSHIP_STATUS)
        .append(" SET ")
        .append(" id = ? " )
        .append(", student = ? " )
        .append(", student_id = ? " )
        .append(", faculty_staff = ? " )
        .append(", alumni = ? " )
        .append(", guest = ? " )
        .append(", tiger_xpress = ? " )
        .append(", stop_out_student = ? " )
        .append(", house_hold_adult = ? " )
        .append(", other = ? " )
        .append(", other_explain = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getId(), 
            bean.isStudent()?"Y":"N", 
            bean.getStudentId(), 
            bean.isFacultyStaff()?"Y":"N", 
            bean.isAlumni()?"Y":"N", 
            bean.isGuest()?"Y":"N", 
            bean.isTigerXpress()?"Y":"N", 
            bean.isStopOutStudent()?"Y":"N", 
            bean.isHouseHoldAdult()?"Y":"N", 
            bean.isOther()?"Y":"N", 
            bean.getOtherExplain()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public MembershipStatusModel getMembershipStatus(Integer id) {
    String sqlString = "select " +
        "id" +
        ", student" +
        ", student_id" +
        ", faculty_staff" +
        ", alumni" +
        ", guest" +
        ", tiger_xpress" +
        ", stop_out_student" +
        ", house_hold_adult" +
        ", other" +
        ", other_explain" +
        " from " + MEMBERSHIP_STATUS + " where id = ?";
        Object[] args = {id};
        List<MembershipStatusModel> matches = getTemplate().query(sqlString, args, new RowMapper<MembershipStatusModel>() {
            public MembershipStatusModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                MembershipStatusModel model = new MembershipStatusModel();
                    model.setId(rs.getInt("id"));
                    model.setStudent("Y".equals(rs.getString("student"))?true:false);
                    model.setStudentId(rs.getString("student_id"));
                    model.setFacultyStaff("Y".equals(rs.getString("faculty_staff"))?true:false);
                    model.setAlumni("Y".equals(rs.getString("alumni"))?true:false);
                    model.setGuest("Y".equals(rs.getString("guest"))?true:false);
                    model.setTigerXpress("Y".equals(rs.getString("tiger_xpress"))?true:false);
                    model.setStopOutStudent("Y".equals(rs.getString("stop_out_student"))?true:false);
                    model.setHouseHoldAdult("Y".equals(rs.getString("house_hold_adult"))?true:false);
                    model.setOther("Y".equals(rs.getString("other"))?true:false);
                    model.setOtherExplain(rs.getString("other_explain"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<MembershipStatusModel> getMembershipStatusList() {
    String sqlString = "select " +
        "id" +
        ", student" +
        ", student_id" +
        ", faculty_staff" +
        ", alumni" +
        ", guest" +
        ", tiger_xpress" +
        ", stop_out_student" +
        ", house_hold_adult" +
        ", other" +
        ", other_explain" +
        " from " + MEMBERSHIP_STATUS;
        return getTemplate().query(sqlString, new RowMapper<MembershipStatusModel>() {
            public MembershipStatusModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                MembershipStatusModel model = new MembershipStatusModel();
                    model.setId(rs.getInt("id"));
                    model.setStudent("Y".equals(rs.getString("student"))?true:false);
                    model.setStudentId(rs.getString("student_id"));
                    model.setFacultyStaff("Y".equals(rs.getString("faculty_staff"))?true:false);
                    model.setAlumni("Y".equals(rs.getString("alumni"))?true:false);
                    model.setGuest("Y".equals(rs.getString("guest"))?true:false);
                    model.setTigerXpress("Y".equals(rs.getString("tiger_xpress"))?true:false);
                    model.setStopOutStudent("Y".equals(rs.getString("stop_out_student"))?true:false);
                    model.setHouseHoldAdult("Y".equals(rs.getString("house_hold_adult"))?true:false);
                    model.setOther("Y".equals(rs.getString("other"))?true:false);
                    model.setOtherExplain(rs.getString("other_explain"));
                return model;
            }
        });
    }


    public int deleteMembershipStatus(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + MEMBERSHIP_STATUS);
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
