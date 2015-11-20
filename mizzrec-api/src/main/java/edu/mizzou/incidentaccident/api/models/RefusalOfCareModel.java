package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RefusalOfCareModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(RefusalOfCareModel.class);
    private Integer id;
    private byte[] memberSig;
    private byte[] staffSig;
    private Date date;

	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public byte[] getMemberSig() {
        return this.memberSig;
    }

    public void setMemberSig(byte[] memberSig) {
        this.memberSig = memberSig;
    }


    public byte[] getStaffSig() {
        return this.staffSig;
    }

    public void setStaffSig(byte[] staffSig) {
        this.staffSig = staffSig;
    }


    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
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
