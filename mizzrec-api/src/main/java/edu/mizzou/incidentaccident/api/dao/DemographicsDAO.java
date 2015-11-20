package edu.mizzou.incidentaccident.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("demographicsDao")
public class DemographicsDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(DemographicsDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addDemographics(DemographicsModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + DEMOGRAPHICS + " (")
            .append(" id " )
            .append(", date " )
            .append(", name " )
            .append(", gender " )
            .append(", birth_date " )
            .append(", email " )
            .append(", phone " )
            .append(", address " )
            .append(", res_life_student " )
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
            .append(")");
        Object[] args = {
            bean.getId(), 
            bean.getDate(), 
            bean.getName(), 
            bean.getGender(), 
            bean.getBirthDate(), 
            bean.getEmail(), 
            bean.getPhone(), 
            bean.getAddress(), 
            bean.getResLifeStudent()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateDemographics(DemographicsModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + DEMOGRAPHICS)
        .append(" SET ")
        .append(" id = ? " )
        .append(", date = ? " )
        .append(", name = ? " )
        .append(", gender = ? " )
        .append(", birth_date = ? " )
        .append(", email = ? " )
        .append(", phone = ? " )
        .append(", address = ? " )
        .append(", res_life_student = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getId(), 
            bean.getDate(), 
            bean.getName(), 
            bean.getGender(), 
            bean.getBirthDate(), 
            bean.getEmail(), 
            bean.getPhone(), 
            bean.getAddress(), 
            bean.getResLifeStudent()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public DemographicsModel getDemographics(Integer id) {
    String sqlString = "select " +
        "id" +
        ", date" +
        ", name" +
        ", gender" +
        ", birth_date" +
        ", email" +
        ", phone" +
        ", address" +
        ", res_life_student" +
        " from " + DEMOGRAPHICS + " where id = ?";
        Object[] args = {id};
        List<DemographicsModel> matches = getTemplate().query(sqlString, args, new RowMapper<DemographicsModel>() {
            public DemographicsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                DemographicsModel model = new DemographicsModel();
                    model.setId(rs.getInt("id"));
                    model.setDate(rs.getTimestamp("date")!=null?new java.util.Date(rs.getTimestamp("date").getTime()):null);
                    model.setName(rs.getString("name"));
                    model.setGender(rs.getString("gender"));
                    model.setBirthDate(rs.getDate("birth_date")!=null?new java.util.Date(rs.getDate("birth_date").getTime()):null);
                    model.setEmail(rs.getString("email"));
                    model.setPhone(rs.getString("phone"));
                    model.setAddress(rs.getString("address"));
                    model.setResLifeStudent(rs.getString("res_life_student"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<DemographicsModel> getDemographicsList() {
    String sqlString = "select " +
        "id" +
        ", date" +
        ", name" +
        ", gender" +
        ", birth_date" +
        ", email" +
        ", phone" +
        ", address" +
        ", res_life_student" +
        " from " + DEMOGRAPHICS;
        return getTemplate().query(sqlString, new RowMapper<DemographicsModel>() {
            public DemographicsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                DemographicsModel model = new DemographicsModel();
                    model.setId(rs.getInt("id"));
                    model.setDate(rs.getTimestamp("date")!=null?new java.util.Date(rs.getTimestamp("date").getTime()):null);
                    model.setName(rs.getString("name"));
                    model.setGender(rs.getString("gender"));
                    model.setBirthDate(rs.getDate("birth_date")!=null?new java.util.Date(rs.getDate("birth_date").getTime()):null);
                    model.setEmail(rs.getString("email"));
                    model.setPhone(rs.getString("phone"));
                    model.setAddress(rs.getString("address"));
                    model.setResLifeStudent(rs.getString("res_life_student"));
                return model;
            }
        });
    }


    public int deleteDemographics(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + DEMOGRAPHICS);
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
