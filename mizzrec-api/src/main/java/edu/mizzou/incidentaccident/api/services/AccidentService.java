package edu.mizzou.incidentaccident.api.services;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.AccidentDAO;
import edu.mizzou.incidentaccident.api.dao.AccidentDetailDescriptionDAO;
import edu.mizzou.incidentaccident.api.dao.AccidentDetailsDAO;
import edu.mizzou.incidentaccident.api.dao.AccidentInjuryLocationDAO;
import edu.mizzou.incidentaccident.api.dao.AccidentLocationDAO;
import edu.mizzou.incidentaccident.api.dao.AccountDescriptionDAO;
import edu.mizzou.incidentaccident.api.dao.DemographicsDAO;
import edu.mizzou.incidentaccident.api.dao.InjuryLocationsDAO;
import edu.mizzou.incidentaccident.api.dao.LocationsDAO;
import edu.mizzou.incidentaccident.api.dao.MembershipStatusDAO;
import edu.mizzou.incidentaccident.api.dao.ProgramActivityInvolvedDAO;
import edu.mizzou.incidentaccident.api.dao.ProperNotificationsDAO;
import edu.mizzou.incidentaccident.api.dao.RefusalOfCareDAO;
import edu.mizzou.incidentaccident.api.dao.SpecificInjuryDAO;
import edu.mizzou.incidentaccident.api.dao.SpecificLocationDAO;
import edu.mizzou.incidentaccident.api.dao.WitnessInfoDAO;
import edu.mizzou.incidentaccident.api.models.AccidentDetailDescriptionModel;
import edu.mizzou.incidentaccident.api.models.AccidentDetailsModel;
import edu.mizzou.incidentaccident.api.models.AccidentInjuryLocationModel;
import edu.mizzou.incidentaccident.api.models.AccidentLocationModel;
import edu.mizzou.incidentaccident.api.models.AccidentModel;
 
 
@Service("accidentService")
public class AccidentService {
 
    private static Logger log = LoggerFactory.getLogger(AccidentService.class);

	 
    @Autowired
    private AccidentDAO accidentDao;
    @Autowired
    private AccidentLocationDAO accidentLocationDao;
    @Autowired
    private DemographicsDAO demographicsDao;
    @Autowired
    private MembershipStatusDAO membershipStatusDao;
    @Autowired
    private ProgramActivityInvolvedDAO programActivityInvolvedDao;
    @Autowired
    private AccountDescriptionDAO accountDescriptionDao;
    @Autowired
    private RefusalOfCareDAO refusalOfCareDao;
    @Autowired
    private WitnessInfoDAO witnessInfoDao;
    @Autowired
    private ProperNotificationsDAO properNotificationsDao;
    @Autowired
    private SpecificInjuryDAO specificInjuryDao;
    @Autowired
    private SpecificLocationDAO specificLocationDao;
    @Autowired
    private InjuryLocationsDAO injuryLocationsDao;
    @Autowired
    private AccidentInjuryLocationDAO accidentInjuryLocationDao;
    @Autowired
    private AccidentDetailDescriptionDAO accidentDetailDescriptionDao;
    @Autowired
    private LocationsDAO locationsDao;
    @Autowired
    private AccidentDetailsDAO accidentDetailsDao;
	 

    public List<AccidentModel> getAccidentList() {
    	List<AccidentModel> accidents = accidentDao.getAccidentList();
    	for (AccidentModel accident : accidents) {
			accident.setDemographics(demographicsDao.getDemographics(accident.getDemographicsId()));
			accident.setMembershipStatus(membershipStatusDao.getMembershipStatus(accident.getMembershipStatusId()));
			accident.setProgramActivity(programActivityInvolvedDao.getProgramActivityInvolved(accident.getProgramActivityId()));
			accident.setResponderAcct(accountDescriptionDao.getAccountDescription(accident.getResponderAcctId()));
			accident.setMemberAcct(accountDescriptionDao.getAccountDescription(accident.getMemberAcctId()));
			accident.setRefusalOfCare(refusalOfCareDao.getRefusalOfCare(accident.getRefusalOfCareId()));
			accident.setWitnessOne(witnessInfoDao.getWitnessInfo(accident.getWitnessOneId()));
			accident.setWitnessTwo(witnessInfoDao.getWitnessInfo(accident.getWitnessTwoId()));
			accident.setProperNotifications(properNotificationsDao.getProperNotifications(accident.getProperNotificationsId()));
			accident.setSpecInjLocation(specificInjuryDao.getSpecificInjury(accident.getSpecInjLocationId()));
			accident.setSpecificLocation(specificLocationDao.getSpecificLocation(accident.getSpecificLocationId()));
			accident.setAccidentLocations(locationsDao.getLocationsListForAccident(accident.getId()));
			accident.setInjuryAccidentLocations(injuryLocationsDao.getInjuryLocationsForAccident(accident.getId()));
			accident.setAccidentDetailDescriptions(accidentDetailDescriptionDao.getAccidentDetailDescriptionListForAccident(accident.getId()));
		}
        return accidents;
    }


    public AccidentModel getAccident(Integer id) {
    	AccidentModel accident = accidentDao.getAccident(id);
		accident.setDemographics(demographicsDao.getDemographics(accident.getDemographicsId()));
		accident.setMembershipStatus(membershipStatusDao.getMembershipStatus(accident.getMembershipStatusId()));
		accident.setProgramActivity(programActivityInvolvedDao.getProgramActivityInvolved(accident.getProgramActivityId()));
		accident.setResponderAcct(accountDescriptionDao.getAccountDescription(accident.getResponderAcctId()));
		accident.setMemberAcct(accountDescriptionDao.getAccountDescription(accident.getMemberAcctId()));
		accident.setRefusalOfCare(refusalOfCareDao.getRefusalOfCare(accident.getRefusalOfCareId()));
		accident.setWitnessOne(witnessInfoDao.getWitnessInfo(accident.getWitnessOneId()));
		accident.setWitnessTwo(witnessInfoDao.getWitnessInfo(accident.getWitnessTwoId()));
		accident.setProperNotifications(properNotificationsDao.getProperNotifications(accident.getProperNotificationsId()));
		accident.setSpecInjLocation(specificInjuryDao.getSpecificInjury(accident.getSpecInjLocationId()));
		accident.setSpecificLocation(specificLocationDao.getSpecificLocation(accident.getSpecificLocationId()));
		accident.setAccidentLocations(locationsDao.getLocationsListForAccident(accident.getId()));
		accident.setInjuryAccidentLocations(injuryLocationsDao.getInjuryLocationsForAccident(accident.getId()));
		accident.setAccidentDetailDescriptions(accidentDetailDescriptionDao.getAccidentDetailDescriptionListForAccident(accident.getId()));
    	return accident;
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public int addAccident(AccidentModel accident) {
    	if (accident.getDemographics()!=null) {
        	accident.setDemographicsId(demographicsDao.addDemographics(accident.getDemographics()));
		}
    	if (accident.getMembershipStatus() != null) {
    		accident.setMembershipStatusId(membershipStatusDao.addMembershipStatus(accident.getMembershipStatus()));
		}
    	if (accident.getProgramActivity() != null) {
    		accident.setProgramActivityId(programActivityInvolvedDao.addProgramActivityInvolved(accident.getProgramActivity()));
		}
    	if (accident.getResponderAcct() != null) {
    		accident.setResponderAcctId(accountDescriptionDao.addAccountDescription(accident.getResponderAcct()));
		}
    	if (accident.getMemberAcct() != null) {
    		accident.setMemberAcctId(accountDescriptionDao.addAccountDescription(accident.getMemberAcct()));
		}
    	if (accident.getRefusalOfCare() != null) {
    		accident.setRefusalOfCareId(refusalOfCareDao.addRefusalOfCare(accident.getRefusalOfCare()));
		}
    	if (accident.getWitnessOne() != null) {
    		accident.setWitnessOneId(witnessInfoDao.addWitnessInfo(accident.getWitnessOne()));
		}
    	if (accident.getWitnessTwo() != null) {
    		accident.setWitnessTwoId(witnessInfoDao.addWitnessInfo(accident.getWitnessTwo()));
		}
    	if (accident.getProperNotifications() != null) {
    		accident.setProperNotificationsId(properNotificationsDao.addProperNotifications(accident.getProperNotifications()));
		}
    	if (accident.getSpecInjLocation() != null) {
    		accident.setSpecInjLocationId(specificInjuryDao.addSpecificInjury(accident.getSpecInjLocation()));
		}
    	if (accident.getSpecificLocation() != null && (accident.getSpecificLocation().isSpecEquipPiece() || accident.getSpecificLocation().isOther())) {
    		accident.setSpecificLocationId(specificLocationDao.addSpecificLocation(accident.getSpecificLocation()));
		}
    	if (accident.getWitnessOne()!=null) {
			accident.setWitnessOneId(witnessInfoDao.addWitnessInfo(accident.getWitnessOne()));
		}
    	if (accident.getWitnessTwo()!=null) {
			accident.setWitnessTwoId(witnessInfoDao.addWitnessInfo(accident.getWitnessTwo()));
		}
    	int id = accidentDao.addAccident(accident);
    	if (accident.getLocations() != null && accident.getLocations().length > 0) {
			for (String location  : accident.getLocations()) {
				accidentLocationDao.addAccidentLocation(new AccidentLocationModel(id, new Integer(location)));
			}
		}
    	if (accident.getAccidentDetails()!=null && accident.getAccidentDetails().length > 0) {
			for (String accLoc : accident.getAccidentDetails()) {
				accidentDetailsDao.addAccidentDetails(new AccidentDetailsModel(id, new Integer(accLoc)));
			}
		}
    	if (accident.getInjurylocations()!=null && accident.getInjurylocations().length > 0) {
    		for (String injLoc : accident.getInjurylocations()) {
        		accidentInjuryLocationDao.addAccidentInjuryLocation(new AccidentInjuryLocationModel(id, new Integer(injLoc)));
			}
		}
        return id;
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateAccident(AccidentModel accident) {
    	if (accident.getDemographics()!=null) {
    		accident.getDemographics().setId(accident.getDemographicsId());
        	demographicsDao.updateDemographics(accident.getDemographics());
		}
    	if (accident.getMembershipStatus() != null) {
    		accident.getMembershipStatus().setId(accident.getMembershipStatusId());
    		membershipStatusDao.updateMembershipStatus(accident.getMembershipStatus());
		}
    	if (accident.getProgramActivity() != null) {
    		accident.getProgramActivity().setId(accident.getProgramActivityId());
    		programActivityInvolvedDao.updateProgramActivityInvolved(accident.getProgramActivity());
		}
    	if (accident.getResponderAcct() != null) {
    		if (accident.getResponderAcctId() == 0) {
    			accident.setResponderAcctId(accountDescriptionDao.addAccountDescription(accident.getResponderAcct()));
			} else {
	    		accident.getResponderAcct().setId(accident.getResponderAcctId());
	    		accountDescriptionDao.updateAccountDescription(accident.getResponderAcct());
			}
		}
    	if (accident.getMemberAcct() != null) {
    		if (accident.getMemberAcctId() == 0) {
    			accident.setMemberAcctId(accountDescriptionDao.addAccountDescription(accident.getMemberAcct()));
			} else {
	    		accident.getMemberAcct().setId(accident.getMemberAcctId());
	    		accountDescriptionDao.updateAccountDescription(accident.getMemberAcct());
			}
		}
    	if (accident.getRefusalOfCare() != null) {
    		if (accident.getRefusalOfCareId() == 0) {
    			accident.setRefusalOfCareId(refusalOfCareDao.addRefusalOfCare(accident.getRefusalOfCare()));
			} else {
				accident.getRefusalOfCare().setId(accident.getRefusalOfCareId());
	    		refusalOfCareDao.updateRefusalOfCare(accident.getRefusalOfCare());
			}
		}
    	if (accident.getWitnessOne() != null) {
    		if (accident.getWitnessOneId() == 0) {
				accident.setWitnessOneId(witnessInfoDao.addWitnessInfo(accident.getWitnessOne()));
			} else {
				accident.getWitnessOne().setId(accident.getWitnessOneId());
	    		witnessInfoDao.updateWitnessInfo(accident.getWitnessOne());
			}
		}
    	if (accident.getWitnessTwo() != null) {
    		if (accident.getWitnessTwoId() == 0) {
				accident.setWitnessTwoId(witnessInfoDao.addWitnessInfo(accident.getWitnessTwo()));
			} else {
				accident.getWitnessTwo().setId(accident.getWitnessTwoId());
	    		witnessInfoDao.updateWitnessInfo(accident.getWitnessTwo());
			}
		}
    	if (accident.getProperNotifications() != null) {
    		if (accident.getProperNotificationsId() == 0) {
    			accident.setProperNotificationsId(properNotificationsDao.addProperNotifications(accident.getProperNotifications()));
			} else {
				accident.getProperNotifications().setId(accident.getProperNotificationsId());
	    		properNotificationsDao.updateProperNotifications(accident.getProperNotifications());
			}
		}
    	if (accident.getSpecInjLocation() != null) {
    		if (accident.getSpecInjLocationId() == 0) {
    			accident.setSpecInjLocationId(specificInjuryDao.addSpecificInjury(accident.getSpecInjLocation()));
			} else {
				accident.getSpecInjLocation().setId(accident.getSpecInjLocationId());
	    		specificInjuryDao.updateSpecificInjury(accident.getSpecInjLocation());
			}
		}
    	if (accident.getSpecificLocation() != null) {
    		if (accident.getSpecificLocationId() == 0) {
    			accident.setSpecificLocationId(specificLocationDao.addSpecificLocation(accident.getSpecificLocation()));
			} else {
				accident.getSpecificLocation().setId(accident.getSpecificLocationId());
	    		specificLocationDao.updateSpecificLocation(accident.getSpecificLocation());
			}
		}
    	accidentLocationDao.deleteAccidentLocation(accident.getId());
    	if (accident.getLocations() != null && accident.getLocations().length > 0) {
			for (String location  : accident.getLocations()) {
				accidentLocationDao.addAccidentLocation(new AccidentLocationModel(accident.getId(), new Integer(location)));
			}
		}
    	accidentDetailsDao.deleteAccidentDetails(accident.getId());
    	if (accident.getAccidentDetails()!=null && accident.getAccidentDetails().length > 0) {
			for (String accLoc : accident.getAccidentDetails()) {
				accidentDetailsDao.addAccidentDetails(new AccidentDetailsModel(accident.getId(), new Integer(accLoc)));
			}
		}
    	accidentInjuryLocationDao.deleteAccidentInjuryLocation(accident.getId());
    	if (accident.getInjurylocations()!=null && accident.getInjurylocations().length > 0) {
    		for (String injLoc : accident.getInjurylocations()) {
        		accidentInjuryLocationDao.addAccidentInjuryLocation(new AccidentInjuryLocationModel(accident.getId(), new Integer(injLoc)));
			}
		}
    	int numrows = accidentDao.updateAccident(accident);
        return numrows;
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteAccident(Integer id) {
    	AccidentModel accident = accidentDao.getAccident(id);
    	if (accident != null) {
        	if (accident.getDemographics()!=null) {
            	demographicsDao.deleteDemographics(accident.getDemographicsId());
    		}
        	if (accident.getMembershipStatus() != null) {
        		membershipStatusDao.deleteMembershipStatus(accident.getMembershipStatusId());
    		}
        	if (accident.getProgramActivity() != null) {
        		programActivityInvolvedDao.deleteProgramActivityInvolved(accident.getProgramActivityId());
    		}
        	if (accident.getResponderAcct() != null) {
        		accountDescriptionDao.deleteAccountDescription(accident.getResponderAcctId());
    		}
        	if (accident.getMemberAcct() != null) {
        		accountDescriptionDao.deleteAccountDescription(accident.getMemberAcctId());
    		}
        	if (accident.getRefusalOfCare() != null) {
        		refusalOfCareDao.deleteRefusalOfCare(accident.getRefusalOfCareId());
    		}
        	if (accident.getWitnessOne() != null) {
        		witnessInfoDao.deleteWitnessInfo(accident.getWitnessOneId());
    		}
        	if (accident.getWitnessTwo() != null) {
        		witnessInfoDao.deleteWitnessInfo(accident.getWitnessTwoId());
    		}
        	if (accident.getProperNotifications() != null) {
        		properNotificationsDao.deleteProperNotifications(accident.getProperNotificationsId());
    		}
        	if (accident.getSpecInjLocation() != null) {
        		specificInjuryDao.deleteSpecificInjury(accident.getSpecInjLocationId());
    		}
        	if (accident.getSpecificLocation() != null) {
        		specificLocationDao.deleteSpecificLocation(accident.getSpecificLocationId());
    		}
        	accidentLocationDao.deleteAccidentLocation(accident.getId());
        	accidentDetailsDao.deleteAccidentDetails(accident.getId());
        	accidentInjuryLocationDao.deleteAccidentInjuryLocation(accident.getId());
		}
    	int numrows = accidentDao.deleteAccident(id);
        return numrows;
    }

	 
}
