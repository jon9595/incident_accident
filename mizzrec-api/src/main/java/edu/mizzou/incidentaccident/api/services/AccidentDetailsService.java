package edu.mizzou.incidentaccident.api.services;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.AccidentDetailsDAO;
import edu.mizzou.incidentaccident.api.models.AccidentDetailsModel;
 
 
@Service("accidentDetailsService")
public class AccidentDetailsService {
 
    private static Logger log = LoggerFactory.getLogger(AccidentDetailsService.class);

	 
    @Autowired
    private AccidentDetailsDAO accidentDetailsDao;
	 

    public List<AccidentDetailsModel> getAccidentDetailsList() {
        return accidentDetailsDao.getAccidentDetailsList();
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteAccidentDetails(Integer accident_id) {
        return accidentDetailsDao.deleteAccidentDetails(accident_id);
    }

	 
}
