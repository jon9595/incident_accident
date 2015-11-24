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
import edu.mizzou.incidentaccident.api.models.AccountDescriptionModel;

@Repository("accountDescriptionDao")
public class AccountDescriptionDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(AccountDescriptionDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addAccountDescription(AccountDescriptionModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + ACCOUNT_DESCRIPTION + " (")
            .append(" id " )
            .append(", acct_desc " )
            .append(") VALUES ( ")
            .append(", ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getId(), 
            bean.getAcctDesc()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateAccountDescription(AccountDescriptionModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + ACCOUNT_DESCRIPTION)
        .append(" SET ")
        .append(" id = ? " )
        .append(", acct_desc = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getId(), 
            bean.getAcctDesc()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public AccountDescriptionModel getAccountDescription(Integer id) {
    String sqlString = "select " +
        "id" +
        ", acct_desc" +
        " from " + ACCOUNT_DESCRIPTION + " where id = ?";
        Object[] args = {id};
        List<AccountDescriptionModel> matches = getTemplate().query(sqlString, args, new RowMapper<AccountDescriptionModel>() {
            public AccountDescriptionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccountDescriptionModel model = new AccountDescriptionModel();
                    model.setId(rs.getInt("id"));
                    model.setAcctDesc(rs.getString("acct_desc"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<AccountDescriptionModel> getAccountDescriptionList() {
    String sqlString = "select " +
        "id" +
        ", acct_desc" +
        " from " + ACCOUNT_DESCRIPTION;
        return getTemplate().query(sqlString, new RowMapper<AccountDescriptionModel>() {
            public AccountDescriptionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccountDescriptionModel model = new AccountDescriptionModel();
                    model.setId(rs.getInt("id"));
                    model.setAcctDesc(rs.getString("acct_desc"));
                return model;
            }
        });
    }


    public int deleteAccountDescription(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + ACCOUNT_DESCRIPTION);
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
