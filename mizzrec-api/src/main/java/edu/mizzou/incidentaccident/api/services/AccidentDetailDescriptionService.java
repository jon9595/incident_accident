package edu.mizzou.incidentaccident.api.services;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.AccidentDetailDescriptionDAO;
import edu.mizzou.incidentaccident.api.models.AccidentDetailDescriptionModel;
 
 
@Service("accidentDetailDescriptionService")
public class AccidentDetailDescriptionService {
 
    private static Logger log = LoggerFactory.getLogger(AccidentDetailDescriptionService.class);

	 
    @Autowired
    private AccidentDetailDescriptionDAO accidentDetailDescriptionDao;
	 

    public List<AccidentDetailDescriptionModel> getAccidentDetailDescriptionList() {
        return accidentDetailDescriptionDao.getAccidentDetailDescriptionList();
    }


    public AccidentDetailDescriptionModel getAccidentDetailDescription(Integer id) {
        return accidentDetailDescriptionDao.getAccidentDetailDescription(id);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateAccidentDetailDescription(AccidentDetailDescriptionModel bean) {
        return accidentDetailDescriptionDao.updateAccidentDetailDescription(bean);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteAccidentDetailDescription(Integer id) {
        return accidentDetailDescriptionDao.deleteAccidentDetailDescription(id);
    }

	 
}
