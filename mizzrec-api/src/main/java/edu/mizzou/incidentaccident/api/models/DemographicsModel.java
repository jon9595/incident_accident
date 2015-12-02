package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mizzou.incidentaccident.api.common.util.DateUtil;
import edu.mizzou.incidentaccident.api.constants.AppConstants;


public class DemographicsModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(DemographicsModel.class);
    private Integer id;
    private Date date;
    private Date time;
    private String name;
    private String gender;
    private Date birthDate;
    private String email;
    private String phone;
    private String address;
    private String resLifeStudent;

	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDateStr() {
    	return DateUtil.format(this.date, AppConstants.DATE_FORMAT_PATTERN_MDY);
    }

    public void setDateStr(String date) {
        this.date = DateUtil.parse(date, AppConstants.DATE_FORMAT_PATTERN_MDY);
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimeStr() {
		return DateUtil.format(this.time, AppConstants.DATE_FORMAT_PATTERN_HM);
	}

	public void setTimeStr(String time) {
		this.time = DateUtil.parse(time, AppConstants.DATE_FORMAT_PATTERN_HM);
	}

    public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDateStr() {
        return DateUtil.format(this.birthDate, AppConstants.DATE_FORMAT_PATTERN_MDY);
    }

    public void setBirthDateStr(String birthDate) {
        this.birthDate = DateUtil.parse(birthDate, AppConstants.DATE_FORMAT_PATTERN_MDY);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getResLifeStudent() {
        return this.resLifeStudent;
    }

    public void setResLifeStudent(String resLifeStudent) {
        this.resLifeStudent = resLifeStudent;
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
