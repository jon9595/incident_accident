package edu.mizzou.incidentaccident.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mizzou.incidentaccident.api.constants.DBConstants;
import edu.mizzou.incidentaccident.api.models.AccidentDetailDescriptionModel;

@Repository("accidentDetailDescriptionDao")
public class AccidentDetailDescriptionDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(AccidentDetailDescriptionDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addAccidentDetailDescription(AccidentDetailDescriptionModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + ACCIDENT_DETAIL_DESCRIPTION + " (")
            .append(" id " )
            .append(", description " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getId(), 
            bean.getDescription()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateAccidentDetailDescription(AccidentDetailDescriptionModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + ACCIDENT_DETAIL_DESCRIPTION)
        .append(" SET ")
        .append(" description = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getDescription(),
            bean.getId()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public AccidentDetailDescriptionModel getAccidentDetailDescription(Integer id) {
    String sqlString = "select " +
        "id" +
        ", description" +
        " from " + ACCIDENT_DETAIL_DESCRIPTION + " where id = ?";
        Object[] args = {id};
        List<AccidentDetailDescriptionModel> matches = getTemplate().query(sqlString, args, new RowMapper<AccidentDetailDescriptionModel>() {
            public AccidentDetailDescriptionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentDetailDescriptionModel model = new AccidentDetailDescriptionModel();
                    model.setId(rs.getInt("id"));
                    model.setDescription(rs.getString("description"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<AccidentDetailDescriptionModel> getAccidentDetailDescriptionList() {
    String sqlString = "select " +
        "id" +
        ", description" +
        " from " + ACCIDENT_DETAIL_DESCRIPTION;
    	List<AccidentDetailDescriptionModel> list = getTemplate().query(sqlString, new RowMapper<AccidentDetailDescriptionModel>() {
            public AccidentDetailDescriptionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentDetailDescriptionModel model = new AccidentDetailDescriptionModel();
                    model.setId(rs.getInt("id"));
                    model.setDescription(rs.getString("description"));
                return model;
            }
        });
    	Collections.sort(list);
    	return list;
    }


    public List<AccidentDetailDescriptionModel> getAccidentDetailDescriptionListForAccident(Integer accidentId) {
    String sqlString = "select " +
        "id" +
        ", description" +
        " from " + ACCIDENT_DETAIL_DESCRIPTION +
        " where id in (select acc_det_desc_id from " + ACCIDENT_DETAILS + " where accident_id = ?)";
    	Object[] args = {accidentId};
    	return getTemplate().query(sqlString, args, new RowMapper<AccidentDetailDescriptionModel>() {
            public AccidentDetailDescriptionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccidentDetailDescriptionModel model = new AccidentDetailDescriptionModel();
                    model.setId(rs.getInt("id"));
                    model.setDescription(rs.getString("description"));
                return model;
            }
        });
    }

    public int deleteAccidentDetailDescription(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + ACCIDENT_DETAIL_DESCRIPTION);
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
