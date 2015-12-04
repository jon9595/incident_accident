package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AccidentModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(AccidentModel.class);
    private Integer id;

    private Integer demographicsId;
    private Integer membershipStatusId;
    private Integer programActivityId;
    private Integer responderAcctId;
    private Integer memberAcctId;
    private Integer refusalOfCareId;
    private Integer witnessOneId;
    private Integer witnessTwoId;
    private Integer properNotificationsId;
    private Integer specInjLocationId;
    private Integer specificLocationId;



	private DemographicsModel demographics;
    private MembershipStatusModel membershipStatus;
    private ProgramActivityInvolvedModel programActivity;
    private AccountDescriptionModel responderAcct;
    private AccountDescriptionModel memberAcct;
    private RefusalOfCareModel refusalOfCare;
    private WitnessInfoModel witnessOne;
    private WitnessInfoModel witnessTwo;
    private ProperNotificationsModel properNotifications;
    private SpecificInjuryModel specInjLocation;
    private SpecificLocationModel specificLocation;
    
    private String[] locations;
    private String[] injurylocations;
    private String[] accidentDetails;
    
    private int[] nonSubInj;
    private String otherInjDesc;
    private String createdBy;
    private String modifiedBy;

    public AccidentModel() {
    	demographics = new DemographicsModel();
        membershipStatus = new MembershipStatusModel();
        programActivity = new ProgramActivityInvolvedModel();
        responderAcct = new AccountDescriptionModel();
        memberAcct = new AccountDescriptionModel();
        refusalOfCare = new RefusalOfCareModel();
        witnessOne = new WitnessInfoModel();
        witnessTwo = new WitnessInfoModel();
        properNotifications = new ProperNotificationsModel();
        specInjLocation = new SpecificInjuryModel();
        specificLocation = new SpecificLocationModel();
    }
    
    public Integer getId() {
		return id;
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



	public Integer getRefusalOfCareId() {
		return refusalOfCareId;
	}



	public void setRefusalOfCareId(Integer refusalOfCareId) {
		this.refusalOfCareId = refusalOfCareId;
	}



	public Integer getWitnessOneId() {
		return witnessOneId;
	}



	public void setWitnessOneId(Integer witnessOneId) {
		this.witnessOneId = witnessOneId;
	}



	public Integer getWitnessTwoId() {
		return witnessTwoId;
	}



	public void setWitnessTwoId(Integer witnessTwoId) {
		this.witnessTwoId = witnessTwoId;
	}



	public Integer getProperNotificationsId() {
		return properNotificationsId;
	}



	public void setProperNotificationsId(Integer properNotificationsId) {
		this.properNotificationsId = properNotificationsId;
	}



	public Integer getSpecInjLocationId() {
		return specInjLocationId;
	}



	public void setSpecInjLocationId(Integer specInjLocationId) {
		this.specInjLocationId = specInjLocationId;
	}



	public Integer getSpecificLocationId() {
		return specificLocationId;
	}



	public void setSpecificLocationId(Integer specificLocationId) {
		this.specificLocationId = specificLocationId;
	}



	public void setId(Integer id) {
		this.id = id;
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



	public RefusalOfCareModel getRefusalOfCare() {
		return refusalOfCare;
	}



	public void setRefusalOfCare(RefusalOfCareModel refusalOfCare) {
		this.refusalOfCare = refusalOfCare;
	}



	public WitnessInfoModel getWitnessOne() {
		return witnessOne;
	}



	public void setWitnessOne(WitnessInfoModel witnessOne) {
		this.witnessOne = witnessOne;
	}



	public WitnessInfoModel getWitnessTwo() {
		return witnessTwo;
	}



	public void setWitnessTwo(WitnessInfoModel witnessTwo) {
		this.witnessTwo = witnessTwo;
	}



	public ProperNotificationsModel getProperNotifications() {
		return properNotifications;
	}



	public void setProperNotifications(ProperNotificationsModel properNotifications) {
		this.properNotifications = properNotifications;
	}



	public String[] getLocations() {
		return locations;
	}

	public void setLocations(String[] locations) {
		this.locations = locations;
	}

	public String[] getInjurylocations() {
		return injurylocations;
	}

	public void setInjurylocations(String[] injurylocations) {
		this.injurylocations = injurylocations;
	}

	public String[] getAccidentDetails() {
		return accidentDetails;
	}

	public void setAccidentDetails(String[] accidentDetails) {
		this.accidentDetails = accidentDetails;
	}

	public String getOtherInjDesc() {
		return otherInjDesc;
	}



	public int[] getNonSubInj() {
		return nonSubInj;
	}

	public void setNonSubInj(int[] nonSubInj) {
		this.nonSubInj = nonSubInj;
	}

	public void setOtherInjDesc(String otherInjDesc) {
		this.otherInjDesc = otherInjDesc;
	}



	public SpecificInjuryModel getSpecInjLocation() {
		return specInjLocation;
	}



	public void setSpecInjLocation(SpecificInjuryModel specInjLocation) {
		this.specInjLocation = specInjLocation;
	}



	public SpecificLocationModel getSpecificLocation() {
		return specificLocation;
	}



	public void setSpecificLocation(SpecificLocationModel specificLocation) {
		this.specificLocation = specificLocation;
	}

	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getModifiedBy() {
		return modifiedBy;
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
