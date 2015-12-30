package edu.mizzou.incidentaccident.api.services;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mizzou.incidentaccident.api.dao.UserRolesDAO;
import edu.mizzou.incidentaccident.api.dao.UsersDAO;
import edu.mizzou.incidentaccident.api.models.UsersModel;
 
 
@Service("usersService")
public class UsersService {
 
    private static Logger log = LoggerFactory.getLogger(UsersService.class);

	 
    @Autowired
    private UsersDAO usersDao;
	@Autowired
	private UserRolesDAO userRolesDao;

    public List<UsersModel> getUsersList() {
    	List<UsersModel> users = usersDao.getUsersList(); 
    	for (UsersModel user : users) {
			user.setUserRoles(userRolesDao.getUserRoles(user.getUsername()));
		}
        return users;
    }


    public UsersModel getUsers(Integer id) {
    	UsersModel user = usersDao.getUsers(id);
    	if (user != null) {
			user.setUserRoles(userRolesDao.getUserRoles(user.getUsername()));
		}
        return user;
    }

    public UsersModel getUserByUsername(String username) {
    	UsersModel user = usersDao.getUserByUsername(username);
    	if (user != null) {
			user.setUserRoles(userRolesDao.getUserRoles(user.getUsername()));
		}
    	return user;
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public int adduser(UsersModel bean) {
    	int numRows = usersDao.addUsers(bean);
    	userRolesDao.addUserRoles(bean.getUsername(), UsersModel.RoleList.STAFF.getValue());
    	if (bean.isAdmin()) {
        	userRolesDao.addUserRoles(bean.getUsername(), UsersModel.RoleList.ADMIN.getValue());
		}
    	return numRows;
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateUsers(UsersModel bean) {
    	int numRows = usersDao.updateUsers(bean);
    	userRolesDao.deleteUserRoles(bean.getUsername());
    	userRolesDao.addUserRoles(bean.getUsername(), UsersModel.RoleList.STAFF.getValue());
    	if (bean.isAdmin()) {
        	userRolesDao.addUserRoles(bean.getUsername(), UsersModel.RoleList.ADMIN.getValue());
		}
    	if (bean.isManager()) {
        	userRolesDao.addUserRoles(bean.getUsername(), UsersModel.RoleList.MANAGER.getValue());
		}
        return numRows;
    }

	 
    @Transactional(propagation=Propagation.REQUIRED)
    public int deleteUsers(Integer id) {
    	userRolesDao.deleteUserRoles(usersDao.getUsers(id).getUsername());
        return usersDao.deleteUsers(id);
    }

    @Transactional(propagation=Propagation.REQUIRED)
	public int setLastLoggedIn(String username) {
    	return usersDao.setLastLoggedIn(username);
	}
}
