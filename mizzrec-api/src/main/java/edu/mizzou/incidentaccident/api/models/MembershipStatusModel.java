package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MembershipStatusModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(MembershipStatusModel.class);
    private Integer id;
    private boolean student;
    private String studentId;
    private boolean facultyStaff;
    private boolean alumni;
    private boolean guest;
    private boolean tigerXpress;
    private boolean stopOutStudent;
    private boolean houseHoldAdult;
    private boolean other;
    private String otherExplain;
    private String[] membership;

	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public boolean isStudent() {
		return student;
	}

	public void setStudent(boolean student) {
		this.student = student;
	}

	public boolean isFacultyStaff() {
		return facultyStaff;
	}

	public void setFacultyStaff(boolean facultyStaff) {
		this.facultyStaff = facultyStaff;
	}

	public boolean isAlumni() {
		return alumni;
	}

	public void setAlumni(boolean alumni) {
		this.alumni = alumni;
	}

	public boolean isGuest() {
		return guest;
	}

	public void setGuest(boolean guest) {
		this.guest = guest;
	}

	public boolean isTigerXpress() {
		return tigerXpress;
	}

	public void setTigerXpress(boolean tigerXpress) {
		this.tigerXpress = tigerXpress;
	}

	public boolean isStopOutStudent() {
		return stopOutStudent;
	}

	public void setStopOutStudent(boolean stopOutStudent) {
		this.stopOutStudent = stopOutStudent;
	}

	public boolean isHouseHoldAdult() {
		return houseHoldAdult;
	}

	public void setHouseHoldAdult(boolean houseHoldAdult) {
		this.houseHoldAdult = houseHoldAdult;
	}

	public boolean isOther() {
		return other;
	}

	public void setOther(boolean other) {
		this.other = other;
	}

	public String getOtherExplain() {
        return this.otherExplain;
    }

    public void setOtherExplain(String otherExplain) {
        this.otherExplain = otherExplain;
    }


    private void resetBooleans() {
        student = false;
        facultyStaff = false;
        alumni = false;
        guest = false;
        tigerXpress = false;
        stopOutStudent = false;
        houseHoldAdult = false;
        other = false;
    }
	
    public String[] getMembership() {
    	ArrayList<String> list = new ArrayList<String>();
    	if (student) {
			list.add("student");
		}
    	if (facultyStaff) {
			list.add("facultyStaff");
		}
    	if (alumni) {
			list.add("alumni");
		}
    	if (guest) {
			list.add("guest");
		}
    	if (tigerXpress) {
			list.add("tigerXpress");
		}
    	if (stopOutStudent) {
			list.add("stopOutStudent");
		}
    	if (houseHoldAdult) {
			list.add("houseHoldAdult");
		}
    	if (other) {
			list.add("other");
		}
    	membership = list.toArray(new String[list.size()]);
		return membership;
	}

	public void setMembership(String[] membership) {
		this.membership = membership;
		this.resetBooleans();
		for (String member : membership) {
			switch (member) {
			case "student":
				this.student = true;
				break;
			case "facultyStaff":
				this.facultyStaff = true;
				break;
			case "alumni":
				this.alumni = true;
				break;
			case "guest":
				this.guest = true;
				break;
			case "tigerXpress":
				this.tigerXpress = true;
				break;
			case "stopOutStudent":
				this.stopOutStudent = true;
				break;
			case "houseHoldAdult":
				this.houseHoldAdult = true;
				break;
			case "other":
				this.other = true;
				break;

			default:
				break;
			}
		}
		this.membership = membership;
	}

	public String getMembershipStatus() {
		StringBuffer sb = new StringBuffer();
    	if (this.student) {
			sb.append("Student");
		}
    	if (this.facultyStaff) {
    		if (!sb.toString().isEmpty()) {
				sb.append(" ");
			}
			sb.append("Faculty/Staff");
		}
    	if (this.alumni) {
    		if (!sb.toString().isEmpty()) {
				sb.append(" ");
			}
			sb.append("Alumni");
		}
    	if (this.guest) {
    		if (!sb.toString().isEmpty()) {
				sb.append(" ");
			}
			sb.append("Guest");
		}
    	if (this.tigerXpress) {
    		if (!sb.toString().isEmpty()) {
				sb.append(" ");
			}
			sb.append("Tiger Express");
		}
    	if (this.stopOutStudent) {
    		if (!sb.toString().isEmpty()) {
				sb.append(" ");
			}
			sb.append("Stop-Out Student");
		}
    	if (this.houseHoldAdult) {
    		if (!sb.toString().isEmpty()) {
				sb.append(" ");
			}
			sb.append("Household Adult");
		}
    	if (this.other) {
    		if (!sb.toString().isEmpty()) {
				sb.append(" ");
			}
			sb.append("Other: " + this.otherExplain);
		}		
		return sb.toString();
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
