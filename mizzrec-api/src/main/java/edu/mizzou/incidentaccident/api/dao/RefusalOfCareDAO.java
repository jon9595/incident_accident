package edu.mizzou.incidentaccident.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("refusalOfCareDao")
public class RefusalOfCareDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(RefusalOfCareDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addRefusalOfCare(RefusalOfCareModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + REFUSAL_OF_CARE + " (")
            .append(" id " )
            .append(", member_sig " )
            .append(", staff_sig " )
            .append(", date " )
            .append(") VALUES ( ")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getId(), 
            bean.getMemberSig(), 
            bean.getStaffSig(), 
            bean.getDate()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateRefusalOfCare(RefusalOfCareModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + REFUSAL_OF_CARE)
        .append(" SET ")
        .append(" id = ? " )
        .append(", member_sig = ? " )
        .append(", staff_sig = ? " )
        .append(", date = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getId(), 
            bean.getMemberSig(), 
            bean.getStaffSig(), 
            bean.getDate()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public RefusalOfCareModel getRefusalOfCare(Integer id) {
    String sqlString = "select " +
        "id" +
        ", member_sig" +
        ", staff_sig" +
        ", date" +
        " from " + REFUSAL_OF_CARE + " where id = ?";
        Object[] args = {id};
        List<RefusalOfCareModel> matches = getTemplate().query(sqlString, args, new RowMapper<RefusalOfCareModel>() {
            public RefusalOfCareModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                RefusalOfCareModel model = new RefusalOfCareModel();
                    model.setId(rs.getInt("id"));
                    model.setMemberSig(rs.getBytes("member_sig"));
                    model.setStaffSig(rs.getBytes("staff_sig"));
                    model.setDate(rs.getDate("date")!=null?new java.util.Date(rs.getDate("date").getTime()):null);
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<RefusalOfCareModel> getRefusalOfCareList() {
    String sqlString = "select " +
        "id" +
        ", member_sig" +
        ", staff_sig" +
        ", date" +
        " from " + REFUSAL_OF_CARE;
        return getTemplate().query(sqlString, new RowMapper<RefusalOfCareModel>() {
            public RefusalOfCareModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                RefusalOfCareModel model = new RefusalOfCareModel();
                    model.setId(rs.getInt("id"));
                    model.setMemberSig(rs.getBytes("member_sig"));
                    model.setStaffSig(rs.getBytes("staff_sig"));
                    model.setDate(rs.getDate("date")!=null?new java.util.Date(rs.getDate("date").getTime()):null);
                return model;
            }
        });
    }


    public int deleteRefusalOfCare(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + REFUSAL_OF_CARE);
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
