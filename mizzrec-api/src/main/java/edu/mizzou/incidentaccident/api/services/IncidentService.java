package edu.mizzou.incidentaccident.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mizzou.incidentaccident.api.dao.AccountDescriptionDAO;
import edu.mizzou.incidentaccident.api.dao.DemographicsDAO;
import edu.mizzou.incidentaccident.api.dao.LocationsDAO;
import edu.mizzou.incidentaccident.api.dao.MembershipStatusDAO;
import edu.mizzou.incidentaccident.api.dao.ProgramActivityInvolvedDAO;
import edu.mizzou.incidentaccident.api.dao.ProperNotificationsDAO;
import edu.mizzou.incidentaccident.api.dao.RefusalOfCareDAO;
import edu.mizzou.incidentaccident.api.dao.SignaturesDAO;
import edu.mizzou.incidentaccident.api.dao.WitnessInfoDAO;

@Service("incidentService")
public class IncidentService {

    private static Logger log = LoggerFactory.getLogger(AccidentService.class);

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
	private SignaturesDAO signaturesDao;

}
