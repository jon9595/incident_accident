package edu.mizzou.incidentaccident.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mizzou.incidentaccident.api.constants.DBConstants;
import edu.mizzou.incidentaccident.api.models.UsersModel;

@Repository("usersDao")
public class UsersDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(UsersDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addUsers(UsersModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + USERS + " (")
            .append(" id " )
            .append(", username " )
            .append(", first_name " )
            .append(", last_name " )
            .append(", password " )
            .append(", email " )
            .append(", activated " )
            .append(", position " )
            .append(", created " )
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
            .append(")");
        Object[] args = {
            bean.getId(), 
            bean.getUsername(), 
            bean.getFirstName(), 
            bean.getLastName(), 
            bean.getPassword(), 
            bean.getEmail(), 
            bean.isActivated(), 
            bean.getPosition(), 
            bean.getCreated()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateUsers(UsersModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + USERS)
        .append(" SET ")
        .append(" username = ? " )
        .append(", first_name = ? " )
        .append(", last_name = ? " )
        .append(", password = ? " )
        .append(", email = ? " )
        .append(", activated = ? " )
        .append(", position = ? " )
        .append(", modified = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getUsername(), 
            bean.getFirstName(), 
            bean.getLastName(), 
            bean.getPassword(), 
            bean.getEmail(), 
            bean.isActivated(), 
            bean.getPosition(), 
            bean.getModified(),
            bean.getId()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public UsersModel getUsers(Integer id) {
    String sqlString = "select " +
        "id" +
        ", username" +
        ", first_name" +
        ", last_name" +
        ", password" +
        ", email" +
        ", activated" +
        ", position" +
        ", created" +
        ", modified" +
        " from " + USERS + " where id = ?";
        Object[] args = {id};
        List<UsersModel> matches = getTemplate().query(sqlString, args, new RowMapper<UsersModel>() {
            public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UsersModel model = new UsersModel();
                    model.setId(rs.getInt("id"));
                    model.setUsername(rs.getString("username"));
                    model.setFirstName(rs.getString("first_name"));
                    model.setLastName(rs.getString("last_name"));
                    model.setPassword(rs.getString("password"));
                    model.setEmail(rs.getString("email"));
                    model.setActivated(rs.getBoolean("activated"));
                    model.setPosition(rs.getString("position"));
                    model.setCreated(rs.getTimestamp("created")!=null?new java.util.Date(rs.getTimestamp("created").getTime()):null);
                    model.setModified(rs.getTimestamp("modified")!=null?new java.util.Date(rs.getTimestamp("modified").getTime()):null);
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }

    public UsersModel getUserByUsername(String username) {
    String sqlString = "select " +
        "id" +
        ", username" +
        ", first_name" +
        ", last_name" +
        ", password" +
        ", email" +
        ", activated" +
        ", position" +
        ", created" +
        ", modified" +
        " from " + USERS + " where username = ?";
        Object[] args = {username};
        List<UsersModel> matches = getTemplate().query(sqlString, args, new RowMapper<UsersModel>() {
            public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UsersModel model = new UsersModel();
                    model.setId(rs.getInt("id"));
                    model.setUsername(rs.getString("username"));
                    model.setFirstName(rs.getString("first_name"));
                    model.setLastName(rs.getString("last_name"));
                    model.setPassword(rs.getString("password"));
                    model.setEmail(rs.getString("email"));
                    model.setActivated(rs.getBoolean("activated"));
                    model.setPosition(rs.getString("position"));
                    model.setCreated(rs.getTimestamp("created")!=null?new java.util.Date(rs.getTimestamp("created").getTime()):null);
                    model.setModified(rs.getTimestamp("modified")!=null?new java.util.Date(rs.getTimestamp("modified").getTime()):null);
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }

    public List<UsersModel> getUsersList() {
    String sqlString = "select " +
        "id" +
        ", username" +
        ", first_name" +
        ", last_name" +
        ", password" +
        ", email" +
        ", activated" +
        ", position" +
        ", created" +
        ", modified" +
        " from " + USERS;
        return getTemplate().query(sqlString, new RowMapper<UsersModel>() {
            public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UsersModel model = new UsersModel();
                    model.setId(rs.getInt("id"));
                    model.setUsername(rs.getString("username"));
                    model.setFirstName(rs.getString("first_name"));
                    model.setLastName(rs.getString("last_name"));
                    model.setPassword(rs.getString("password"));
                    model.setEmail(rs.getString("email"));
                    model.setActivated(rs.getBoolean("activated"));
                    model.setPosition(rs.getString("position"));
                    model.setCreated(rs.getTimestamp("created")!=null?new java.util.Date(rs.getTimestamp("created").getTime()):null);
                    model.setModified(rs.getTimestamp("modified")!=null?new java.util.Date(rs.getTimestamp("modified").getTime()):null);
                return model;
            }
        });
    }


    public int deleteUsers(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + USERS);
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

    public int setLastLoggedIn(String username) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + USERS)
        .append(" SET ")
        .append(" last_login = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE username = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {new Date(), username};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }
}
