package edu.mizzou.incidentaccident.api.services;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.SignaturesDAO;
import edu.mizzou.incidentaccident.api.models.SignaturesModel;
 
 
@Service("signaturesService")
public class SignaturesService {
 
    private static Logger log = LoggerFactory.getLogger(SignaturesService.class);

	 
    @Autowired
    private SignaturesDAO signaturesDao;
	 

    public List<SignaturesModel> getSignaturesList() {
        return signaturesDao.getSignaturesList();
    }


    public SignaturesModel getSignatures(Integer id) {
        return signaturesDao.getSignatures(id);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int addSignatures(SignaturesModel bean) {
        return signaturesDao.addSignatures(bean);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateSignatures(SignaturesModel bean) {
        return signaturesDao.updateSignatures(bean);
    }


    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteSignatures(Integer id) {
        return signaturesDao.deleteSignatures(id);
    }

	 
}
