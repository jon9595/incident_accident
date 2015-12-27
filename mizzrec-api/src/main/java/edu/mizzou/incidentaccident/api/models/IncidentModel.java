package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IncidentModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(IncidentModel.class);
    private Integer id;

    private Integer demographicsId;
    private Integer membershipStatusId;
    private Integer programActivityId;
    private Integer responderAcctId;
    private Integer memberAcctId;
    private Integer witnessAcctId;
    private Integer witnessInfoId;
    private Integer properNotificationsId;
    private Integer specificLocationId;
    
	private DemographicsModel demographics;
    private MembershipStatusModel membershipStatus;
    private ProgramActivityInvolvedModel programActivity;
    private AccountDescriptionModel responderAcct;
    private AccountDescriptionModel memberAcct;
    private AccountDescriptionModel witnessAcct;
    private WitnessInfoModel witnessInfo;
    private ProperNotificationsModel properNotifications;
    private SpecificLocationModel specificLocation;
    private String otherIncNatureDesc;

    private List<LocationsModel> incidentLocations;
    private List<IncidentNatureModel> incidentNatures;

    private String[] locations;
    private String[] incidentDetails;

    private String createdBy;
    private String modifiedBy;

    public IncidentModel() {
    	demographics = new DemographicsModel();
        membershipStatus = new MembershipStatusModel();
        programActivity = new ProgramActivityInvolvedModel();
        responderAcct = new AccountDescriptionModel();
        memberAcct = new AccountDescriptionModel();
        witnessAcct = new AccountDescriptionModel();
        witnessInfo = new WitnessInfoModel();
        properNotifications = new ProperNotificationsModel();
        specificLocation = new SpecificLocationModel();
    }
	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDemographicsId() {
		return demographicsId;
	}

	public void setDemographicsId(Integer demographicsId) {
		this.demographicsId = demographicsId;
	}

	public Integer getMembershipStatusId() {
		return membershipStatusId;
	}

	public void setMembershipStatusId(Integer membershipStatusId) {
		this.membershipStatusId = membershipStatusId;
	}

	public Integer getProgramActivityId() {
		return programActivityId;
	}

	public void setProgramActivityId(Integer programActivityId) {
		this.programActivityId = programActivityId;
	}

	public Integer getResponderAcctId() {
		return responderAcctId;
	}

	public void setResponderAcctId(Integer responderAcctId) {
		this.responderAcctId = responderAcctId;
	}

	public Integer getMemberAcctId() {
		return memberAcctId;
	}

	public void setMemberAcctId(Integer memberAcctId) {
		this.memberAcctId = memberAcctId;
	}

	public Integer getWitnessAcctId() {
		return witnessAcctId;
	}

	public void setWitnessAcctId(Integer witnessAcctId) {
		this.witnessAcctId = witnessAcctId;
	}

	public Integer getWitnessInfoId() {
		return witnessInfoId;
	}

	public void setWitnessInfoId(Integer witnessInfoId) {
		this.witnessInfoId = witnessInfoId;
	}

	public Integer getProperNotificationsId() {
		return properNotificationsId;
	}

	public void setProperNotificationsId(Integer properNotificationsId) {
		this.properNotificationsId = properNotificationsId;
	}

	public Integer getSpecificLocationId() {
		return specificLocationId;
	}

	public void setSpecificLocationId(Integer specificLocationId) {
		this.specificLocationId = specificLocationId;
	}

	public DemographicsModel getDemographics() {
		return demographics;
	}

	public void setDemographics(DemographicsModel demographics) {
		this.demographics = demographics;
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

	public AccountDescriptionModel getResponderAcct() {
		return responderAcct;
	}

	public void setResponderAcct(AccountDescriptionModel responderAcct) {
		this.responderAcct = responderAcct;
	}

	public AccountDescriptionModel getMemberAcct() {
		return memberAcct;
	}

	public void setMemberAcct(AccountDescriptionModel memberAcct) {
		this.memberAcct = memberAcct;
	}

	public AccountDescriptionModel getWitnessAcct() {
		return witnessAcct;
	}

	public void setWitnessAcct(AccountDescriptionModel witnessAcct) {
		this.witnessAcct = witnessAcct;
	}

	public WitnessInfoModel getWitnessInfo() {
		return witnessInfo;
	}

	public void setWitnessInfo(WitnessInfoModel witnessInfo) {
		this.witnessInfo = witnessInfo;
	}

	public ProperNotificationsModel getProperNotifications() {
		return properNotifications;
	}

	public void setProperNotifications(ProperNotificationsModel properNotifications) {
		this.properNotifications = properNotifications;
	}

	public SpecificLocationModel getSpecificLocation() {
		return specificLocation;
	}

	public void setSpecificLocation(SpecificLocationModel specificLocation) {
		this.specificLocation = specificLocation;
	}

	public String getOtherIncNatureDesc() {
        return this.otherIncNatureDesc;
    }

    public void setOtherIncNatureDesc(String otherIncNatureDesc) {
        this.otherIncNatureDesc = otherIncNatureDesc;
    }


    public List<LocationsModel> getIncidentLocations() {
		return incidentLocations;
	}

	public void setIncidentLocations(List<LocationsModel> incidentLocations) {
		this.incidentLocations = incidentLocations;
		String[] locations = new String[incidentLocations.size()];
		int loop = 0;
		for (LocationsModel alm : incidentLocations) {
			locations[loop++] = String.valueOf(alm.getId());
		}
		setLocations(locations);
	}

	public String[] getLocations() {
		return locations;
	}

	public void setLocations(String[] locations) {
		this.locations = locations;
	}
	
	public List<IncidentNatureModel> getIncidentNatures() {
		return incidentNatures;
	}

	public void setIncidentNatures(List<IncidentNatureModel> incidentNatures) {
		this.incidentNatures = incidentNatures;
		String[] inj = new String[incidentNatures.size()];
		int loop = 0;
		for (IncidentNatureModel addm : incidentNatures) {
			inj[loop++] = String.valueOf(addm.getId());
		}
		setIncidentDetails(inj);
	}

	public String[] getIncidentDetails() {
		return incidentDetails;
	}

	public String getIncidentDetailsDesc() {
		StringBuffer sb = new StringBuffer();
		List<IncidentNatureModel> in = getIncidentNatures();
		if (in != null) {
			for (IncidentNatureModel inm : in) {
				if (!sb.toString().isEmpty()) {
					sb.append("\n");
				}
				sb.append(inm.getDescription());
			}
		}
		return sb.toString();
	}

	public void setIncidentDetails(String[] incidentDetails) {
		this.incidentDetails = incidentDetails;
	}

	public String getIncidentLocationDesc() {
		StringBuffer sb = new StringBuffer();
		List<LocationsModel> al = getIncidentLocations();
		if (al != null) {
			for (LocationsModel alm : al) {
				if (!sb.toString().isEmpty()) {
					sb.append("\n");
				}
				sb.append(alm.getLocation()).append(" - ").append(alm.getSubLocation());
			}
		}
		if (this.specificLocation != null) {
			if (this.specificLocation.isSpecEquipPiece()) {
				if (!sb.toString().isEmpty()) {
					sb.append("\n");
				}
				sb.append("Specific Location: ").append(this.specificLocation.getSpecEquipPieceDesc());
			}
			if (this.specificLocation.isOther()) {
				if (!sb.toString().isEmpty()) {
					sb.append("\n");
				}
				sb.append("Other: ").append(this.specificLocation.getOtherDesc());
			}
		}
		return sb.toString();
	}
	

	public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
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
