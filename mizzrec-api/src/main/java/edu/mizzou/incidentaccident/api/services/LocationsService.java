package edu.mizzou.incidentaccident.api.services;
 
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.LocationsDAO;
import edu.mizzou.incidentaccident.api.models.LocationsModel;
 
 
@Service("locationsService")
public class LocationsService {
 
    private static Logger log = LoggerFactory.getLogger(LocationsService.class);

	 
    @Autowired
    private LocationsDAO locationsDao;
	 

    public List<LocationsModel> getLocationsList() {
        return locationsDao.getLocationsList();
    }

    public HashMap<String, List<LocationsModel>> getLocations() {
        return locationsDao.getLocations();
    }

    public LocationsModel getLocations(Integer id) {
        return locationsDao.getLocations(id);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateLocations(LocationsModel bean) {
        return locationsDao.updateLocations(bean);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteLocations(Integer id) {
        return locationsDao.deleteLocations(id);
    }

	 
}
