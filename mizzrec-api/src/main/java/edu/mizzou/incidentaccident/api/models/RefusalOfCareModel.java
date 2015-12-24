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


public class RefusalOfCareModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(RefusalOfCareModel.class);
    private Integer id;
    private Integer memberSig;
    private Integer staffSig;
    private Date date;
    private String memberSignature;
    private String staffSignature;
    private String output;
    private String output2;
	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberSig() {
		return memberSig;
	}

	public void setMemberSig(Integer memberSig) {
		this.memberSig = memberSig;
	}

	public Integer getStaffSig() {
		return staffSig;
	}

	public void setStaffSig(Integer staffSig) {
		this.staffSig = staffSig;
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

    public String getMemberSignature() {
		return memberSignature;
	}

	public void setMemberSignature(String memberSignature) {
		this.memberSignature = memberSignature;
	}

	public String getStaffSignature() {
		return staffSignature;
	}

	public void setStaffSignature(String staffSignature) {
		this.staffSignature = staffSignature;
	}

	public boolean isEmpty() {
		return this.date == null && StringUtils.isBlank(this.memberSignature) && StringUtils.isBlank(this.staffSignature) && this.memberSig == null && this.staffSig == null;
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
