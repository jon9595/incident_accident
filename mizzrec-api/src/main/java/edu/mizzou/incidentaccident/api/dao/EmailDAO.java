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
import edu.mizzou.incidentaccident.api.models.EmailModel;

@Repository("emailDAO")
public class EmailDAO implements DBConstants {

	private static Logger log = LoggerFactory.getLogger(EmailDAO.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
    
    public int addEmail(EmailModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + EMAIL_LIST + " (")
            .append(" user_id " )
            .append(", area " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(")");
        Object[] args = {
        		bean.getUserId(),
        		bean.getArea()
            };
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }
    
    public int updateEmail(EmailModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + DEMOGRAPHICS)
        	.append(" SET ")
            .append(" user_id = ?" )
            .append(", area = ?" );
            StringBuffer sWhereStmt = new StringBuffer(100);
            sWhereStmt.append(" WHERE id = ?");
            sUpdateStmt.append( sWhereStmt );
        Object[] args = {
        		bean.getUserId(),
        		bean.getArea()
            };
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return getAutoIncrementKey();
    }
    
    public List<EmailModel> getEmails(String area) {
    	String sqlString = "select " +
    			"id" +
    			", user_id" +
    			", area" +
    			" from " + EMAIL_LIST + " where area = ?";
    	Object[] args = {area};
    	return getTemplate().query(sqlString, args, new RowMapper<EmailModel>() {
    		public EmailModel mapRow(ResultSet rs, int numRow) throws SQLException {
    			EmailModel model = new EmailModel();
    				model.setId(rs.getInt("id"));
    				model.setUserId(rs.getInt("user_id"));
    				model.setArea(rs.getString("area"));
				return model;
    		}
    	});    	
    }
    
    public List<EmailModel> getEmailsList() {
    	String sqlString = "select " +
    		"id" +
    		", user_id" +
    		", area" +
    		" from " + EMAIL_LIST;
    	return getTemplate().query(sqlString, new RowMapper<EmailModel>() {
    		public EmailModel mapRow(ResultSet rs, int numRow) throws SQLException {
    			EmailModel model = new EmailModel();
    				model.setId(rs.getInt("id"));
    				model.setUserId(rs.getInt("user_id"));
    				model.setArea(rs.getString("area"));
				return model;
    		}
    	});
    }
    
    public int deleteEmail(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + EMAIL_LIST);
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
