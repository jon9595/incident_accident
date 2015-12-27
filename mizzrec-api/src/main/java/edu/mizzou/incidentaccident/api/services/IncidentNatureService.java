package edu.mizzou.incidentaccident.api.services;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.IncidentNatureDAO;
import edu.mizzou.incidentaccident.api.models.IncidentNatureModel;
 
 
@Service("incidentNatureService")
public class IncidentNatureService {
 
    private static Logger log = LoggerFactory.getLogger(IncidentNatureService.class);

	 
    @Autowired
    private IncidentNatureDAO incidentNatureDao;
	 

    public List<IncidentNatureModel> getIncidentNatureList() {
        return incidentNatureDao.getIncidentNatureList();
    }


    public IncidentNatureModel getIncidentNature(Integer id) {
        return incidentNatureDao.getIncidentNature(id);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateIncidentNature(IncidentNatureModel bean) {
        return incidentNatureDao.updateIncidentNature(bean);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteIncidentNature(Integer id) {
        return incidentNatureDao.deleteIncidentNature(id);
    }

	 
}
