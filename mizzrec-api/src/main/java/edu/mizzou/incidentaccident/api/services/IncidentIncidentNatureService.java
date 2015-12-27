package edu.mizzou.incidentaccident.api.services;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.IncidentIncidentNatureDAO;
import edu.mizzou.incidentaccident.api.models.IncidentIncidentNatureModel;
 
 
@Service("incidentIncidentNatureService")
public class IncidentIncidentNatureService {
 
    private static Logger log = LoggerFactory.getLogger(IncidentIncidentNatureService.class);

	 
    @Autowired
    private IncidentIncidentNatureDAO incidentIncidentNatureDao;
	 

    public List<IncidentIncidentNatureModel> getIncidentIncidentNatureList() {
        return incidentIncidentNatureDao.getIncidentIncidentNatureList();
    }


    public IncidentIncidentNatureModel getIncidentIncidentNature(Integer incident_id) {
        return incidentIncidentNatureDao.getIncidentIncidentNature(incident_id);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateIncidentIncidentNature(IncidentIncidentNatureModel bean) {
        return incidentIncidentNatureDao.updateIncidentIncidentNature(bean);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteIncidentIncidentNature(Integer incident_id) {
        return incidentIncidentNatureDao.deleteIncidentIncidentNature(incident_id);
    }

	 
}
