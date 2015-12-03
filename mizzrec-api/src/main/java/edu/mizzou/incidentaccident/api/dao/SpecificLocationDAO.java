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
import edu.mizzou.incidentaccident.api.models.SpecificLocationModel;

@Repository("specificLocationDao")
public class SpecificLocationDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(SpecificLocationDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addSpecificLocation(SpecificLocationModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + SPECIFIC_LOCATION + " (")
            .append(" spec_equip_piece " )
            .append(", spec_equip_piece_desc " )
            .append(", other " )
            .append(", other_desc " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.isSpecEquipPiece()?"Y":"N", 
            bean.getSpecEquipPieceDesc(), 
            bean.isOther()?"Y":"N", 
            bean.getOtherDesc()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateSpecificLocation(SpecificLocationModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + SPECIFIC_LOCATION)
        .append(" SET ")
        .append(" spec_equip_piece = ? " )
        .append(", spec_equip_piece_desc = ? " )
        .append(", other = ? " )
        .append(", other_desc = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.isSpecEquipPiece()?"Y":"N", 
            bean.getSpecEquipPieceDesc(), 
            bean.isOther()?"Y":"N", 
            bean.getOtherDesc(),
            bean.getId()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public SpecificLocationModel getSpecificLocation(Integer id) {
    String sqlString = "select " +
        "id" +
        ", spec_equip_piece" +
        ", spec_equip_piece_desc" +
        ", other" +
        ", other_desc" +
        " from " + SPECIFIC_LOCATION + " where id = ?";
        Object[] args = {id};
        List<SpecificLocationModel> matches = getTemplate().query(sqlString, args, new RowMapper<SpecificLocationModel>() {
            public SpecificLocationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                SpecificLocationModel model = new SpecificLocationModel();
                    model.setId(rs.getInt("id"));
                    model.setSpecEquipPiece("Y".equals(rs.getString("spec_equip_piece"))?true:false);
                    model.setSpecEquipPieceDesc(rs.getString("spec_equip_piece_desc"));
                    model.setOther("Y".equals(rs.getString("other"))?true:false);
                    model.setOtherDesc(rs.getString("other_desc"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<SpecificLocationModel> getSpecificLocationList() {
    String sqlString = "select " +
        "id" +
        ", spec_equip_piece" +
        ", spec_equip_piece_desc" +
        ", other" +
        ", other_desc" +
        " from " + SPECIFIC_LOCATION;
        return getTemplate().query(sqlString, new RowMapper<SpecificLocationModel>() {
            public SpecificLocationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                SpecificLocationModel model = new SpecificLocationModel();
                    model.setId(rs.getInt("id"));
                    model.setSpecEquipPiece("Y".equals(rs.getString("spec_equip_piece"))?true:false);
                    model.setSpecEquipPieceDesc(rs.getString("spec_equip_piece_desc"));
                    model.setOther("Y".equals(rs.getString("other"))?true:false);
                    model.setOtherDesc(rs.getString("other_desc"));
                return model;
            }
        });
    }


    public int deleteSpecificLocation(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + SPECIFIC_LOCATION);
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
