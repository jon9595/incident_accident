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
import edu.mizzou.incidentaccident.api.models.LocationsModel;

@Repository("locationsDao")
public class LocationsDAO implements DBConstants {
	
    private static Logger log = LoggerFactory.getLogger(LocationsDAO.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public JdbcTemplate getTemplate() {
        return this.jdbcTemplate;
    }
	
    public int addLocations(LocationsModel bean) {
        StringBuffer sInsertStmt = new StringBuffer(200);
        sInsertStmt.append( "INSERT INTO " + LOCATIONS + " (")
            .append(" location " )
            .append(", sub_location " )
            .append(") VALUES ( ")
            .append(", ?")
            .append(", ?")
            .append(", ?")
            .append(")");
        Object[] args = {
            bean.getLocation(), 
            bean.getSubLocation()};
        int numRows = getTemplate().update(sInsertStmt.toString(), args);
        return getAutoIncrementKey();
    }


    public int updateLocations(LocationsModel bean) {
        StringBuffer sUpdateStmt = new StringBuffer(200);
        sUpdateStmt.append("UPDATE " + LOCATIONS)
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


    public LocationsModel getLocations(Integer id) {
    String sqlString = "select " +
        "id" +
        ", location" +
        ", sub_location" +
        " from " + LOCATIONS + " where id = ?";
        Object[] args = {id};
        List<LocationsModel> matches = getTemplate().query(sqlString, args, new RowMapper<LocationsModel>() {
            public LocationsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                LocationsModel model = new LocationsModel();
                    model.setId(rs.getInt("id"));
                    model.setLocation(rs.getString("location"));
                    model.setSubLocation(rs.getString("sub_location"));
                return model;
            }
        });
        return matches!=null&&matches.size()>0?matches.get(0):null;
    }


    public List<LocationsModel> getLocationsList() {
    String sqlString = "select " +
        "id" +
        ", location" +
        ", sub_location" +
        " from " + LOCATIONS;
        return getTemplate().query(sqlString, new RowMapper<LocationsModel>() {
            public LocationsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                LocationsModel model = new LocationsModel();
                    model.setId(rs.getInt("id"));
                    model.setLocation(rs.getString("location"));
                    model.setSubLocation(rs.getString("sub_location"));
                return model;
            }
        });
    }
    
    public HashMap<String, List<LocationsModel>> getLocations() {
		String sqlString = "select " +
		        "id" +
		        ", location" +
		        ", sub_location" +
		        " from " + LOCATIONS + " order by location, sub_location";

		List<LocationsModel> locations = getTemplate().query(sqlString, new RowMapper<LocationsModel>() {
		            public LocationsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		                LocationsModel model = new LocationsModel();
		                    model.setId(rs.getInt("id"));
		                    model.setLocation(rs.getString("location"));
		                    model.setSubLocation(rs.getString("sub_location"));
		                return model;
		            }
		        });
		String locationHdr = "";
		HashMap<String, List<LocationsModel>> map = new HashMap<String, List<LocationsModel>>();
		List<LocationsModel> list = new ArrayList<LocationsModel>();
		for (LocationsModel location : locations) {
			if (StringUtils.isNotBlank(locationHdr) && !locationHdr.equals(location.getLocation())) {
				map.put(locationHdr, list);
				list = new ArrayList<LocationsModel>();
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


    public int deleteLocations(Integer id) {
        StringBuffer sDeleteStmt = new StringBuffer(200);
        sDeleteStmt.append("DELETE FROM " + LOCATIONS);
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
