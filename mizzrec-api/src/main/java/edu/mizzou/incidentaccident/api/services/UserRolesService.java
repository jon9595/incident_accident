package edu.mizzou.incidentaccident.api.services;
 
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.UserRolesDAO;
 
 
@Service("userRolesService")
public class UserRolesService {
 
    private static Logger log = LoggerFactory.getLogger(UserRolesService.class);

	 
    @Autowired
    private UserRolesDAO userRolesDao;
	 

    public TreeSet<String> getUserRoles(String username) {
        return userRolesDao.getUserRoles(username);
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteUserRoles(String username) {
        return userRolesDao.deleteUserRoles(username);
    }

	 
}
