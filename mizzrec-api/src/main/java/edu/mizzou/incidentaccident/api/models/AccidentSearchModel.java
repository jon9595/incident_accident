package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

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
	private String emsContacted;

	private MembershipStatusModel membershipStatus;
	private ProgramActivityInvolvedModel programActivity;
	
	public AccidentSearchModel() {
		membershipStatus = new MembershipStatusModel();
		programActivity = new ProgramActivityInvolvedModel();
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

	public String getRevName() {
		StringTokenizer st = new StringTokenizer(this.name);
		String str = "";
		if (st.countTokens() >= 2) {
			List<String> list1 = new LinkedList<String>();
			while (st.hasMoreElements()) {
				String word = (String) st.nextElement();
				list1.add(word);
			}
			Collections.reverse(list1);
			for (String word : list1) {
				str += word + " ";
			}
		} else {
			str = this.name;
		}
		return str;
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

	public String getInjuryLocation() {
		return injuryLocation;
	}

	public void setInjuryLocation(String injuryLocation) {
		this.injuryLocation = StringUtils.replace(injuryLocation, ",", "\n");
	}

	public String getEmsContacted() {
		return emsContacted;
	}

	public void setEmsContacted(String emsContacted) {
		this.emsContacted = emsContacted;
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

	public void setProgramActivity(
			ProgramActivityInvolvedModel programActivityInvolved) {
		this.programActivity = programActivityInvolved;
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
