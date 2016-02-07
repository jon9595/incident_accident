package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncidentSearchModel implements Serializable {

	private Logger log = LoggerFactory.getLogger(IncidentSearchModel.class);
	
	private Integer id;
	private Date incidentDate;
	private String name;
	private String address;
	private String location;
	private String incidentDetails;
	
	private MembershipStatusModel membershipStatus;
	private ProgramActivityInvolvedModel programActivity;
	
	public IncidentSearchModel() {
		membershipStatus = new MembershipStatusModel();
		programActivity = new ProgramActivityInvolvedModel();		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getIncidentDate() {
		return incidentDate;
	}
	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = StringUtils.replace(location, ",", "\n");
	}
	public String getIncidentDetails() {
		return incidentDetails;
	}
	public void setIncidentDetails(String incidentDetails) {
		this.incidentDetails = StringUtils.replace(incidentDetails, ",", "\n");
	}
	public MembershipStatusModel getMembershipStatus() {
		return membershipStatus;
	}
	public void setMembershipStatus(MembershipStatusModel membershipStatus) {
		this.membershipStatus = membershipStatus;
	}
	public ProgramActivityInvolvedModel getProgramActivity() {
		return programActivity;
	}
	public void setProgramActivity(ProgramActivityInvolvedModel programActivity) {
		this.programActivity = programActivity;
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
