package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AccidentDetailsModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(AccidentDetailsModel.class);
    private Integer accidentId;
    private Integer accDetDescId;

    public AccidentDetailsModel () {
    	
    }

    public AccidentDetailsModel (Integer accidentId, Integer descId) {
    	setAccidentId(accidentId);
    	setAccDetDescId(descId);
    }
	
    public Integer getAccidentId() {
        return this.accidentId;
    }

    public void setAccidentId(Integer accidentId) {
        this.accidentId = accidentId;
    }


    public Integer getAccDetDescId() {
        return this.accDetDescId;
    }

    public void setAccDetDescId(Integer accDetDescId) {
        this.accDetDescId = accDetDescId;
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
