package edu.mizzou.incidentaccident.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mizzou.incidentaccident.api.constants.DBConstants;
import edu.mizzou.incidentaccident.api.models.InjuryLocationsModel;
import edu.mizzou.incidentaccident.api.models.LocationsModel;

@Repository("injuryLocationsDao")
public class InjuryLocationsDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(InjuryLocationsDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addInjuryLocations(InjuryLocationsModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + INJURY_LOCATIONS + " (")
            .append(" location " )
            .append(", sub_location " )
            .append(") VALUES ( ")
            .append(" ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getLocation(), 
            bean.getSubLocation()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateInjuryLocations(InjuryLocationsModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + INJURY_LOCATIONS)
        .append(" SET ")
        .append(" location = ? " )
        .append(", sub_location = ? " ); 
        StringBuffer sWhereStmt = new StringBuffer(100);
        sWhereStmt.append(" WHERE id = ?");
        sUpdateStmt.append( sWhereStmt );
        Object[] args = {
            bean.getLocation(), 
            bean.getSubLocation(),
            bean.getId()};
        int numRows = getTemplate().update(sUpdateStmt.toString(), args);
        return numRows;
    }


    public InjuryLocationsModel getInjuryLocations(Integer id) {
    String sqlString = "select " +
        "id" +
        ", location" +
        ", sub_location" +
        " from " + INJURY_LOCATIONS + " where id = ?";
        Object[] args = {id};
        List<InjuryLocationsModel> matches = getTemplate().query(sqlString, args, new RowMapper<InjuryLocationsModel>() {
            public InjuryLocationsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                InjuryLocationsModel model = new InjuryLocationsModel();
                    model.setId(rs.getInt("id"));
                    model.setLocation(rs.getString("location"));
                    model.setSubLocation(rs.getString("sub_location"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<InjuryLocationsModel> getInjuryLocationsList() {
    String sqlString = "select " +
        "id" +
        ", location" +
        ", sub_location" +
        " from " + INJURY_LOCATIONS;
        return getTemplate().query(sqlString, new RowMapper<InjuryLocationsModel>() {
            public InjuryLocationsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                InjuryLocationsModel model = new InjuryLocationsModel();
                    model.setId(rs.getInt("id"));
                    model.setLocation(rs.getString("location"));
                    model.setSubLocation(rs.getString("sub_location"));
                return model;
            }
        });
    }

    public HashMap<String, List<InjuryLocationsModel>> getInjuryLocations() {
        String sqlString = "select " +
                "id" +
                ", location" +
                ", sub_location" +
                " from " + INJURY_LOCATIONS + " order by location, sub_location";
		List<InjuryLocationsModel> locations = getTemplate().query(sqlString, new RowMapper<InjuryLocationsModel>() {
		            public InjuryLocationsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	InjuryLocationsModel model = new InjuryLocationsModel();
		                    model.setId(rs.getInt("id"));
		                    model.setLocation(rs.getString("location"));
		                    model.setSubLocation(rs.getString("sub_location"));
		                return model;
		            }
		        });
		String locationHdr = "";
		HashMap<String, List<InjuryLocationsModel>> map = new HashMap<String, List<InjuryLocationsModel>>();
		List<InjuryLocationsModel> list = new ArrayList<InjuryLocationsModel>();
		for (InjuryLocationsModel location : locations) {
			if (StringUtils.isNotBlank(locationHdr) && !locationHdr.equals(location.getLocation())) {
				map.put(locationHdr, list);
				list = new ArrayList<InjuryLocationsModel>();
				locationHdr = location.getLocation();
			}
			if (StringUtils.isBlank(locationHdr)) {
				locationHdr = location.getLocation();
			}
			list.add(location);
		}
		map.put(locationHdr, list);
		return map;
    }

    public int deleteInjuryLocations(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + INJURY_LOCATIONS);
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
