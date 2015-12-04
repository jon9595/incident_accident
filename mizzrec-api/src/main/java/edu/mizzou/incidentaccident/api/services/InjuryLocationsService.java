package edu.mizzou.incidentaccident.api.services;
 
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.InjuryLocationsDAO;
import edu.mizzou.incidentaccident.api.models.InjuryLocationsModel;
 
 
@Service("injuryLocationsService")
public class InjuryLocationsService {
 
    private static Logger log = LoggerFactory.getLogger(InjuryLocationsService.class);

	 
    @Autowired
    private InjuryLocationsDAO injuryLocationsDao;
	 

    public List<InjuryLocationsModel> getInjuryLocationsList() {
        return injuryLocationsDao.getInjuryLocationsList();
    }

    public Map<String, List<InjuryLocationsModel>> getInjuryLocations() {
        return injuryLocationsDao.getInjuryLocations();
    }
    
    public List<InjuryLocationsModel> getInjuryLocationsWithoutSub() {
    	return injuryLocationsDao.getInjuryLocationsWithoutSub();
    }

    public InjuryLocationsModel getInjuryLocations(Integer id) {
        return injuryLocationsDao.getInjuryLocations(id);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateInjuryLocations(InjuryLocationsModel bean) {
        return injuryLocationsDao.updateInjuryLocations(bean);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteInjuryLocations(Integer id) {
        return injuryLocationsDao.deleteInjuryLocations(id);
    }

	 
}
