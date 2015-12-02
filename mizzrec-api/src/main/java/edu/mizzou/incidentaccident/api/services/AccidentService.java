package edu.mizzou.incidentaccident.api.services;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.AccidentDAO;
import edu.mizzou.incidentaccident.api.dao.AccountDescriptionDAO;
import edu.mizzou.incidentaccident.api.dao.DemographicsDAO;
import edu.mizzou.incidentaccident.api.dao.MembershipStatusDAO;
import edu.mizzou.incidentaccident.api.dao.ProgramActivityInvolvedDAO;
import edu.mizzou.incidentaccident.api.dao.ProperNotificationsDAO;
import edu.mizzou.incidentaccident.api.dao.RefusalOfCareDAO;
import edu.mizzou.incidentaccident.api.dao.SpecificInjuryDAO;
import edu.mizzou.incidentaccident.api.dao.SpecificLocationDAO;
import edu.mizzou.incidentaccident.api.dao.WitnessInfoDAO;
import edu.mizzou.incidentaccident.api.models.AccidentModel;
 
 
@Service("accidentService")
public class AccidentService {
 
    private static Logger log = LoggerFactory.getLogger(AccidentService.class);

	 
    @Autowired
    private AccidentDAO accidentDao;
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
//    	if (accident.getResponderAcct() != null) {
//    		accident.setResponderAcctId(accountDescriptionDao.addAccountDescription(accident.getResponderAcct()));
//		}
//    	if (accident.getMemberAcct() != null) {
//    		accident.setMemberAcctId(accountDescriptionDao.addAccountDescription(accident.getMemberAcct()));
//		}
//    	if (accident.getRefusalOfCare() != null) {
//    		accident.setRefusalOfCareId(refusalOfCareDao.addRefusalOfCare(accident.getRefusalOfCare()));
//		}
//    	if (accident.getWitnessOne() != null) {
//    		accident.setWitnessOneId(witnessInfoDao.addWitnessInfo(accident.getWitnessOne()));
//		}
//    	if (accident.getWitnessTwo() != null) {
//    		accident.setWitnessTwoId(witnessInfoDao.addWitnessInfo(accident.getWitnessTwo()));
//		}
//    	if (accident.getProperNotifications() != null) {
//    		accident.setProperNotificationsId(properNotificationsDao.addProperNotifications(accident.getProperNotifications()));
//		}
//    	if (accident.getSpecInjLocation() != null) {
//    		accident.setSpecInjLocationId(specificInjuryDao.addSpecificInjury(accident.getSpecInjLocation()));
//		}
//    	if (accident.getSpecificLocation() != null) {
//    		accident.setSpecificLocationId(specificLocationDao.addSpecificLocation(accident.getSpecificLocation()));
//		}
    	int id = accidentDao.addAccident(accident);
        return id;
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateAccident(AccidentModel accident) {
    	int numrows = accidentDao.updateAccident(accident);
    	if (accident.getDemographics()!=null) {
        	demographicsDao.updateDemographics(accident.getDemographics());
		}
    	if (accident.getMembershipStatus() != null) {
    		membershipStatusDao.updateMembershipStatus(accident.getMembershipStatus());
		}
    	if (accident.getProgramActivity() != null) {
    		programActivityInvolvedDao.updateProgramActivityInvolved(accident.getProgramActivity());
		}
    	if (accident.getResponderAcct() != null) {
    		accountDescriptionDao.updateAccountDescription(accident.getResponderAcct());
		}
    	if (accident.getMemberAcct() != null) {
    		accountDescriptionDao.updateAccountDescription(accident.getMemberAcct());
		}
    	if (accident.getRefusalOfCare() != null) {
    		refusalOfCareDao.updateRefusalOfCare(accident.getRefusalOfCare());
		}
    	if (accident.getWitnessOne() != null) {
    		witnessInfoDao.updateWitnessInfo(accident.getWitnessOne());
		}
    	if (accident.getWitnessTwo() != null) {
    		witnessInfoDao.updateWitnessInfo(accident.getWitnessTwo());
		}
    	if (accident.getProperNotifications() != null) {
    		properNotificationsDao.updateProperNotifications(accident.getProperNotifications());
		}
    	if (accident.getSpecInjLocation() != null) {
    		specificInjuryDao.updateSpecificInjury(accident.getSpecInjLocation());
		}
    	if (accident.getSpecificLocation() != null) {
    		specificLocationDao.updateSpecificLocation(accident.getSpecificLocation());
		}
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
		}
    	int numrows = accidentDao.deleteAccident(id);
        return numrows;
    }

	 
}
