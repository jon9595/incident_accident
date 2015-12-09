package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AccidentInjuryLocationModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(AccidentInjuryLocationModel.class);
    private Integer accidentId;
    private Integer injuryLocationsId;
    
    public AccidentInjuryLocationModel() {
    	
    }
    

    public AccidentInjuryLocationModel(Integer accidentId, Integer locationId) {
    	setAccidentId(accidentId);
    	setInjuryLocationsId(locationId);
    }

    public Integer getAccidentId() {
        return this.accidentId;
    }

    public void setAccidentId(Integer accidentId) {
        this.accidentId = accidentId;
    }


    public Integer getInjuryLocationsId() {
        return this.injuryLocationsId;
    }

    public void setInjuryLocationsId(Integer injuryLocationsId) {
        this.injuryLocationsId = injuryLocationsId;
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
