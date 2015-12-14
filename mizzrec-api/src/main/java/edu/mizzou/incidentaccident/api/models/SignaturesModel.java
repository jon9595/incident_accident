package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SignaturesModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(SignaturesModel.class);
    private Integer id;
    private byte[] data;
    private String jsonData;
    private Date created;

	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }


    public String getJsonData() {
        return this.jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }


    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
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
