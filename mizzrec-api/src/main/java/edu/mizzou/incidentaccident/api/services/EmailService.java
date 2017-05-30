package edu.mizzou.incidentaccident.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.EmailDAO;
import edu.mizzou.incidentaccident.api.models.EmailModel;

@Service("emailService")
public class EmailService {

	private static Logger log = LoggerFactory.getLogger(EmailService.class);

	 
    @Autowired
    private EmailDAO emailDao;
    
    public List<EmailModel> getEmailList() {
    	List<EmailModel> emails = emailDao.getEmailsList();
    	
    	return emails;
    }
    
    public List<EmailModel> getEmailList(String area) {
    	List<EmailModel> emails = emailDao.getEmails(area);
    	
    	return emails;
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public int addEmail(EmailModel bean) {
    	int numRows = emailDao.addEmail(bean);
    	
    	return numRows;
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateEmail(EmailModel bean) {
    	int numRows = emailDao.updateEmail(bean);
    	
    	return numRows;
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteEmail(Integer id) {
    	return emailDao.deleteEmail(id);
    }
}
