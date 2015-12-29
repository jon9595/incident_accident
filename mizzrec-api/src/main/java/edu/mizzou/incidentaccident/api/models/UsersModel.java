package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UsersModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(UsersModel.class);
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private boolean activated;
    private String newPasswordKey;
    private Date newPasswordRequested;
    private String position;
    private Date lastLogin;
    private Date created;
    private Date modified;
    private TreeSet<String> userRoles;
    
    public static enum RoleList {
    	ADMIN("admin"), USER("user");

    	private String value;
    	
    	private RoleList(String value) {
    		this.value = value;
    	}
    	
    	public String getValue() {
    		return this.value;
    	}
    };
	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public boolean isActivated() {
        return this.activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }


    public String getNewPasswordKey() {
        return this.newPasswordKey;
    }

    public void setNewPasswordKey(String newPasswordKey) {
        this.newPasswordKey = newPasswordKey;
    }


    public Date getNewPasswordRequested() {
        return this.newPasswordRequested;
    }

    public void setNewPasswordRequested(Date newPasswordRequested) {
        this.newPasswordRequested = newPasswordRequested;
    }


    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public Date getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }


    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    public Date getModified() {
        return this.modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public boolean isAdmin() {
    	System.out.println("role list admin: " + RoleList.ADMIN.getValue());
    	System.out.println("contains admin: " + (this.userRoles!=null && !this.userRoles.isEmpty() && this.userRoles.contains(RoleList.ADMIN.getValue())));
    	return this.userRoles!=null && !this.userRoles.isEmpty() && this.userRoles.contains(RoleList.ADMIN.getValue());
    }
    
    public void setAdmin(boolean adminFlag) {
		if (this.userRoles == null ) {
			this.userRoles = new TreeSet<String>();
		}
    	if (adminFlag) {
			this.userRoles.add(RoleList.ADMIN.getValue());
		} else {
			this.userRoles.remove(RoleList.ADMIN.getValue());
		}
    }
	
    public TreeSet<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(TreeSet<String> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Method getter = this.getClass().getMethod("get"+StringUtils.capitalize(field.getName()), null);
                sb.append(field.getName()+": ");
                sb.append(getter.invoke(this, null)).append("");
            } catch (Exception e) {
                log.error("Exception outputting toString: " + e.getMessage(), e);
            }
        }
        return sb.toString();
    }

}
