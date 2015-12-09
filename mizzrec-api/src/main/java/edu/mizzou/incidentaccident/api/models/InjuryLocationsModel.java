package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InjuryLocationsModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(InjuryLocationsModel.class);
    private Integer id;
    private String location;
    private String subLocation;
    private static HashMap<String, String> sublocations = new HashMap<String, String>();
    
    static {
    	sublocations.put("L", "Left");
    	sublocations.put("R", "Right");
    }

	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getSubLocation() {
        return this.subLocation;
    }

    public void setSubLocation(String subLocation) {
        this.subLocation = subLocation;
    }

    public String getInjuryDescription() {
    	StringBuffer sb = new StringBuffer();
    	sb.append(this.getLocation());
    	if (StringUtils.isNotBlank(getSubLocation())) {
			sb.append(" - ").append(sublocations.get(getSubLocation()));
		}
    	return sb.toString();
    }

	
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Method getter = this.getClass().getMethod("get"+StringUtils.capitalize(field.getName()), null);
                sb.append(field.getName()+": ");
                sb.append(getter.invoke(this, null)).append("");
            } catch (Exception e) {
                log.error("Exception outputting toString: " + e.getMessage(), e);
            }
        }
        return sb.toString();
    }

}
