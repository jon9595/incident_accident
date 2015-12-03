package edu.mizzou.incidentaccident.api.services;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.AccidentInjuryLocationDAO;
import edu.mizzou.incidentaccident.api.models.AccidentInjuryLocationModel;
 
 
@Service("accidentInjuryLocationService")
public class AccidentInjuryLocationService {
 
    private static Logger log = LoggerFactory.getLogger(AccidentInjuryLocationService.class);

	 
    @Autowired
    private AccidentInjuryLocationDAO accidentInjuryLocationDao;
	 

    public List<AccidentInjuryLocationModel> getAccidentInjuryLocationList() {
        return accidentInjuryLocationDao.getAccidentInjuryLocationList();
    }


    public AccidentInjuryLocationModel getAccidentInjuryLocation(Integer accident_id) {
        return accidentInjuryLocationDao.getAccidentInjuryLocation(accident_id);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateAccidentInjuryLocation(AccidentInjuryLocationModel bean) {
        return accidentInjuryLocationDao.updateAccidentInjuryLocation(bean);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteAccidentInjuryLocation(Integer accident_id) {
        return accidentInjuryLocationDao.deleteAccidentInjuryLocation(accident_id);
    }

	 
}
