package edu.mizzou.incidentaccident.api.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.common.util.AppUtil;
import edu.mizzou.incidentaccident.api.dao.AccountDescriptionDAO;
import edu.mizzou.incidentaccident.api.dao.DemographicsDAO;
import edu.mizzou.incidentaccident.api.dao.IncidentDAO;
import edu.mizzou.incidentaccident.api.dao.IncidentIncidentNatureDAO;
import edu.mizzou.incidentaccident.api.dao.IncidentLocationDAO;
import edu.mizzou.incidentaccident.api.dao.IncidentNatureDAO;
import edu.mizzou.incidentaccident.api.dao.LocationsDAO;
import edu.mizzou.incidentaccident.api.dao.MembershipStatusDAO;
import edu.mizzou.incidentaccident.api.dao.ProgramActivityInvolvedDAO;
import edu.mizzou.incidentaccident.api.dao.ProperNotificationsDAO;
import edu.mizzou.incidentaccident.api.dao.SignaturesDAO;
import edu.mizzou.incidentaccident.api.dao.SpecificLocationDAO;
import edu.mizzou.incidentaccident.api.dao.WitnessInfoDAO;
import edu.mizzou.incidentaccident.api.models.IncidentIncidentNatureModel;
import edu.mizzou.incidentaccident.api.models.IncidentLocationModel;
import edu.mizzou.incidentaccident.api.models.IncidentModel;
import edu.mizzou.incidentaccident.api.models.SignaturesModel;

@Service("incidentService")
public class IncidentService {

    private static Logger log = LoggerFactory.getLogger(AccidentService.class);

    @Autowired
    private IncidentDAO incidentDao;
    @Autowired
    private DemographicsDAO demographicsDao;
    @Autowired
    private MembershipStatusDAO membershipStatusDao;
    @Autowired
    private ProgramActivityInvolvedDAO programActivityInvolvedDao;
    @Autowired
    private AccountDescriptionDAO accountDescriptionDao;
    @Autowired
    private WitnessInfoDAO witnessInfoDao;
    @Autowired
    private ProperNotificationsDAO properNotificationsDao;
    @Autowired
    private LocationsDAO locationsDao;
    @Autowired
    private SpecificLocationDAO specificLocationDao;
    @Autowired
	private SignaturesDAO signaturesDao;
    @Autowired
    private IncidentLocationDAO incidentLocationDao;
    @Autowired
    private IncidentIncidentNatureDAO incidentIncidentNatureDao;
    @Autowired
    private IncidentNatureDAO incidentNatureDao;
    
    public List<IncidentModel> getIncidentList() {
    	List<IncidentModel> incidents = incidentDao.getIncidentList();
    	for (IncidentModel incident : incidents) {
			incident.setDemographics(demographicsDao.getDemographics(incident.getDemographicsId()));
			incident.setMembershipStatus(membershipStatusDao.getMembershipStatus(incident.getMembershipStatusId()));
			incident.setProgramActivity(programActivityInvolvedDao.getProgramActivityInvolved(incident.getProgramActivityId()));
			incident.setResponderAcct(accountDescriptionDao.getAccountDescription(incident.getResponderAcctId()));
			incident.setMemberAcct(accountDescriptionDao.getAccountDescription(incident.getMemberAcctId()));
			incident.setWitnessAcct(accountDescriptionDao.getAccountDescription(incident.getWitnessAcctId()));
			incident.setWitnessInfo(witnessInfoDao.getWitnessInfo(incident.getWitnessInfoId()));
			incident.setProperNotifications(properNotificationsDao.getProperNotifications(incident.getProperNotificationsId()));
			incident.setSpecificLocation(specificLocationDao.getSpecificLocation(incident.getSpecificLocationId()));
			incident.setIncidentLocations(locationsDao.getLocationsListForIncident(incident.getId()));
			incident.setIncidentNatures(incidentNatureDao.getIncidentDetailDescriptionListForIncident(incident.getId()));
		}
        return incidents;
    }

    public IncidentModel getIncident(Integer id) {
    	IncidentModel incident = incidentDao.getIncident(id);
		incident.setDemographics(demographicsDao.getDemographics(incident.getDemographicsId()));
		incident.setMembershipStatus(membershipStatusDao.getMembershipStatus(incident.getMembershipStatusId()));
		incident.setProgramActivity(programActivityInvolvedDao.getProgramActivityInvolved(incident.getProgramActivityId()));
		incident.setResponderAcct(accountDescriptionDao.getAccountDescription(incident.getResponderAcctId()));
		incident.setMemberAcct(accountDescriptionDao.getAccountDescription(incident.getMemberAcctId()));
		incident.setWitnessAcct(accountDescriptionDao.getAccountDescription(incident.getWitnessAcctId()));
		incident.setWitnessInfo(witnessInfoDao.getWitnessInfo(incident.getWitnessInfoId()));
		incident.setProperNotifications(properNotificationsDao.getProperNotifications(incident.getProperNotificationsId()));
		incident.setSpecificLocation(specificLocationDao.getSpecificLocation(incident.getSpecificLocationId()));
		incident.setIncidentLocations(locationsDao.getLocationsListForIncident(incident.getId()));
		incident.setIncidentNatures(incidentNatureDao.getIncidentDetailDescriptionListForIncident(incident.getId()));
    	return incident;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public int addIncident(IncidentModel incident) {
    	if (incident.getDemographics()!=null) {
        	incident.setDemographicsId(demographicsDao.addDemographics(incident.getDemographics()));
		}
    	if (incident.getMembershipStatus() != null) {
    		incident.setMembershipStatusId(membershipStatusDao.addMembershipStatus(incident.getMembershipStatus()));
		}
    	if (incident.getProgramActivity() != null) {
    		incident.setProgramActivityId(programActivityInvolvedDao.addProgramActivityInvolved(incident.getProgramActivity()));
		}
    	if (incident.getResponderAcct() != null) {
    		incident.setResponderAcctId(accountDescriptionDao.addAccountDescription(incident.getResponderAcct()));
		}
    	if (incident.getMemberAcct() != null) {
    		incident.setMemberAcctId(accountDescriptionDao.addAccountDescription(incident.getMemberAcct()));
		}
    	if (incident.getWitnessAcct() != null) {
    		incident.setWitnessAcctId(accountDescriptionDao.addAccountDescription(incident.getWitnessAcct()));
		}
    	if (incident.getWitnessInfo() != null && StringUtils.isNotBlank(incident.getWitnessInfo().getSignature())) {
    		SignaturesModel witOneSig = new SignaturesModel();
    		witOneSig.setJsonData(incident.getWitnessInfo().getSignature());
    		witOneSig.setData(AppUtil.generateSignatureImage(witOneSig.getJsonData()));
    		incident.getWitnessInfo().setSigId(signaturesDao.addSignatures(witOneSig));
    		incident.setWitnessInfoId(witnessInfoDao.addWitnessInfo(incident.getWitnessInfo()));
		}
    	if (incident.getProperNotifications() != null) {
    		incident.setProperNotificationsId(properNotificationsDao.addProperNotifications(incident.getProperNotifications()));
		}
    	if (incident.getSpecificLocation() != null && (incident.getSpecificLocation().isSpecEquipPiece() || incident.getSpecificLocation().isOther())) {
    		incident.setSpecificLocationId(specificLocationDao.addSpecificLocation(incident.getSpecificLocation()));
		}
    	int id = incidentDao.addIncident(incident);
    	if (incident.getLocations() != null && incident.getLocations().length > 0) {
			for (String location  : incident.getLocations()) {
				incidentLocationDao.addIncidentLocation(new IncidentLocationModel(id, new Integer(location)));
			}
		}
    	if (incident.getIncidentDetails()!=null && incident.getIncidentDetails().length > 0) {
			for (String det : incident.getIncidentDetails()) {
				incidentIncidentNatureDao.addIncidentIncidentNature(new IncidentIncidentNatureModel(id, new Integer(det)));
			}
		}
        return id;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public int updateIncident(IncidentModel incident) {
    	if (incident.getDemographics()!=null) {
    		incident.getDemographics().setId(incident.getDemographicsId());
        	demographicsDao.updateDemographics(incident.getDemographics());
		}
    	if (incident.getMembershipStatus() != null) {
    		incident.getMembershipStatus().setId(incident.getMembershipStatusId());
    		membershipStatusDao.updateMembershipStatus(incident.getMembershipStatus());
		}
    	if (incident.getProgramActivity() != null) {
    		incident.getProgramActivity().setId(incident.getProgramActivityId());
    		programActivityInvolvedDao.updateProgramActivityInvolved(incident.getProgramActivity());
		}
    	if (incident.getResponderAcct() != null) {
    		if (incident.getResponderAcctId() == 0) {
    			incident.setResponderAcctId(accountDescriptionDao.addAccountDescription(incident.getResponderAcct()));
			} else {
	    		incident.getResponderAcct().setId(incident.getResponderAcctId());
	    		accountDescriptionDao.updateAccountDescription(incident.getResponderAcct());
			}
		}
    	if (incident.getMemberAcct() != null) {
    		if (incident.getMemberAcctId() == 0) {
    			incident.setMemberAcctId(accountDescriptionDao.addAccountDescription(incident.getMemberAcct()));
			} else {
	    		incident.getMemberAcct().setId(incident.getMemberAcctId());
	    		accountDescriptionDao.updateAccountDescription(incident.getMemberAcct());
			}
		}
    	if (incident.getWitnessAcct() != null) {
    		if (incident.getWitnessAcctId() == 0) {
    			incident.setWitnessAcctId(accountDescriptionDao.addAccountDescription(incident.getWitnessAcct()));
			} else {
	    		incident.getWitnessAcct().setId(incident.getWitnessAcctId());
	    		accountDescriptionDao.updateAccountDescription(incident.getWitnessAcct());
			}
		}
    	if (incident.getWitnessInfo() != null) {
    		if (incident.getWitnessInfoId() == 0 || incident.getWitnessInfoId() == null) {
    			if (StringUtils.isNotBlank(incident.getWitnessInfo().getSignature())) {
    				SignaturesModel witOneSig = new SignaturesModel();
    	    		witOneSig.setJsonData(incident.getWitnessInfo().getSignature());
    	    		witOneSig.setData(AppUtil.generateSignatureImage(witOneSig.getJsonData()));
    	    		incident.getWitnessInfo().setSigId(signaturesDao.addSignatures(witOneSig));
				}
				incident.setWitnessInfoId(witnessInfoDao.addWitnessInfo(incident.getWitnessInfo()));
			} else {
				if (incident.getWitnessInfo().getSigId() == 0 && StringUtils.isNotBlank(incident.getWitnessInfo().getSignature())) {
    				SignaturesModel witOneSig = new SignaturesModel();
    	    		witOneSig.setJsonData(incident.getWitnessInfo().getSignature());
    	    		witOneSig.setData(AppUtil.generateSignatureImage(witOneSig.getJsonData()));
    	    		incident.getWitnessInfo().setSigId(signaturesDao.addSignatures(witOneSig));
    				incident.getWitnessInfo().setId(incident.getWitnessInfoId());
    	    		witnessInfoDao.updateWitnessInfo(incident.getWitnessInfo());
				}
			}
    		
    		// Updating witness information means there wasn't a record to begin with. 
    		// So the id is zero or null.  
		}
    	if (incident.getProperNotifications() != null) {
    		if (incident.getProperNotificationsId() == 0) {
    			incident.setProperNotificationsId(properNotificationsDao.addProperNotifications(incident.getProperNotifications()));
			} else {
				incident.getProperNotifications().setId(incident.getProperNotificationsId());
	    		properNotificationsDao.updateProperNotifications(incident.getProperNotifications());
			}
		}
    	if (incident.getSpecificLocation() != null) {
    		if (incident.getSpecificLocationId() == 0) {
    			incident.setSpecificLocationId(specificLocationDao.addSpecificLocation(incident.getSpecificLocation()));
			} else {
				incident.getSpecificLocation().setId(incident.getSpecificLocationId());
	    		specificLocationDao.updateSpecificLocation(incident.getSpecificLocation());
			}
		}
    	incidentLocationDao.deleteIncidentLocation(incident.getId());
    	if (incident.getLocations() != null && incident.getLocations().length > 0) {
			for (String location  : incident.getLocations()) {
				incidentLocationDao.addIncidentLocation(new IncidentLocationModel(incident.getId(), new Integer(location)));
			}
		}
    	incidentIncidentNatureDao.deleteIncidentIncidentNature(incident.getId());
    	if (incident.getIncidentDetails()!=null && incident.getIncidentDetails().length > 0) {
			for (String det : incident.getIncidentDetails()) {
				incidentIncidentNatureDao.addIncidentIncidentNature(new IncidentIncidentNatureModel(incident.getId(), new Integer(det)));
			}
		}
    	int numrows = incidentDao.updateIncident(incident);
        return numrows;
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteAccident(Integer id) {
    	IncidentModel incident = incidentDao.getIncident(id);
    	if (incident != null) {
        	if (incident.getDemographics()!=null) {
            	demographicsDao.deleteDemographics(incident.getDemographicsId());
    		}
        	if (incident.getMembershipStatus() != null) {
        		membershipStatusDao.deleteMembershipStatus(incident.getMembershipStatusId());
    		}
        	if (incident.getProgramActivity() != null) {
        		programActivityInvolvedDao.deleteProgramActivityInvolved(incident.getProgramActivityId());
    		}
        	if (incident.getResponderAcct() != null) {
        		accountDescriptionDao.deleteAccountDescription(incident.getResponderAcctId());
    		}
        	if (incident.getMemberAcct() != null) {
        		accountDescriptionDao.deleteAccountDescription(incident.getMemberAcctId());
    		}
        	if (incident.getWitnessInfo() != null) {
        		if (incident.getWitnessInfo().getSigId() != 0) {
					signaturesDao.deleteSignatures(incident.getWitnessInfo().getSigId());
				}
        		witnessInfoDao.deleteWitnessInfo(incident.getWitnessInfoId());
    		}
        	if (incident.getProperNotifications() != null) {
        		properNotificationsDao.deleteProperNotifications(incident.getProperNotificationsId());
    		}
        	if (incident.getSpecificLocation() != null) {
        		specificLocationDao.deleteSpecificLocation(incident.getSpecificLocationId());
    		}
        	incidentLocationDao.deleteIncidentLocation(incident.getId());
		}
    	int numrows = incidentDao.deleteIncident(id);
        return numrows;
    }
    
}
