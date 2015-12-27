package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IncidentIncidentNatureModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(IncidentIncidentNatureModel.class);
    private Integer incidentId;
    private Integer incidentNatureId;

    public IncidentIncidentNatureModel() {
    	
    }
    
    public IncidentIncidentNatureModel(Integer incident, Integer incidentNature) {
    	setIncidentId(incident);
    	setIncidentNatureId(incidentNature);
    }
	
    public Integer getIncidentId() {
        return this.incidentId;
    }

    public void setIncidentId(Integer incidentId) {
        this.incidentId = incidentId;
    }


    public Integer getIncidentNatureId() {
        return this.incidentNatureId;
    }

    public void setIncidentNatureId(Integer incidentNatureId) {
        this.incidentNatureId = incidentNatureId;
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
