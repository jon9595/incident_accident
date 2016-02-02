package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccidentSearchModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(AccidentSearchModel.class);

	private Integer id;
	private Date accidentDate;
	private String name;
	private String address;
	private String location;
	private String injuryLocation;

	private MembershipStatusModel membershipStatus;
	private ProgramActivityInvolvedModel programActivityInvolved;
	
	public AccidentSearchModel() {
		membershipStatus = new MembershipStatusModel();
		programActivityInvolved = new ProgramActivityInvolvedModel();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
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
		this.location = location;
	}

	public String getInjuryLocation() {
		return injuryLocation;
	}

	public void setInjuryLocation(String injuryLocation) {
		this.injuryLocation = injuryLocation;
	}

	public MembershipStatusModel getMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(MembershipStatusModel membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	public ProgramActivityInvolvedModel getProgramActivityInvolved() {
		return programActivityInvolved;
	}

	public void setProgramActivityInvolved(
			ProgramActivityInvolvedModel programActivityInvolved) {
		this.programActivityInvolved = programActivityInvolved;
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
