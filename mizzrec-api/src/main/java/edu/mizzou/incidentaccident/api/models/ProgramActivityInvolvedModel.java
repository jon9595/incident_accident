package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProgramActivityInvolvedModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(ProgramActivityInvolvedModel.class);
    private Integer id;
    private Time time;
    private boolean informalActivity;
    private String infActDesc;
    private boolean clubRecSports;
    private String clubRecTeamName;
    private boolean recSports;
    private String recTeamName;
    private boolean swimTeamPractice;
    private String swimTeamName;
    private boolean interAthletics;
    private boolean tigerxPt;
    private String tigerxPrgName;
    private String tigerxPtInstructor;
    private boolean specEvt;
    private String specEvtGroup;
    private String[] programActivity;

	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }


    public boolean isInformalActivity() {
        return this.informalActivity;
    }

    public void setInformalActivity(boolean informalActivity) {
        this.informalActivity = informalActivity;
    }


    public String getInfActDesc() {
        return this.infActDesc;
    }

    public void setInfActDesc(String infActDesc) {
        this.infActDesc = infActDesc;
    }


    public boolean isClubRecSports() {
        return this.clubRecSports;
    }

    public void setClubRecSports(boolean clubRecSports) {
        this.clubRecSports = clubRecSports;
    }


    public String getClubRecTeamName() {
        return this.clubRecTeamName;
    }

    public void setClubRecTeamName(String clubRecTeamName) {
        this.clubRecTeamName = clubRecTeamName;
    }


    public boolean isRecSports() {
		return recSports;
	}

	public void setRecSports(boolean recSports) {
		this.recSports = recSports;
	}

	public String getRecTeamName() {
		return recTeamName;
	}

	public void setRecTeamName(String recTeamName) {
		this.recTeamName = recTeamName;
	}

	public boolean isSwimTeamPractice() {
        return this.swimTeamPractice;
    }

    public void setSwimTeamPractice(boolean swimTeamPractice) {
        this.swimTeamPractice = swimTeamPractice;
    }


    public String getSwimTeamName() {
        return this.swimTeamName;
    }

    public void setSwimTeamName(String swimTeamName) {
        this.swimTeamName = swimTeamName;
    }


    public boolean isInterAthletics() {
        return this.interAthletics;
    }

    public void setInterAthletics(boolean interAthletics) {
        this.interAthletics = interAthletics;
    }


    public boolean isTigerxPt() {
        return this.tigerxPt;
    }

    public void setTigerxPt(boolean tigerxPt) {
        this.tigerxPt = tigerxPt;
    }


    public String getTigerxPrgName() {
        return this.tigerxPrgName;
    }

    public void setTigerxPrgName(String tigerxPrgName) {
        this.tigerxPrgName = tigerxPrgName;
    }


    public String getTigerxPtInstructor() {
        return this.tigerxPtInstructor;
    }

    public void setTigerxPtInstructor(String tigerxPtInstructor) {
        this.tigerxPtInstructor = tigerxPtInstructor;
    }


    public boolean isSpecEvt() {
        return this.specEvt;
    }

    public void setSpecEvt(boolean specEvt) {
        this.specEvt = specEvt;
    }


    public String getSpecEvtGroup() {
        return this.specEvtGroup;
    }

    public void setSpecEvtGroup(String specEvtGroup) {
        this.specEvtGroup = specEvtGroup;
    }


    private void resetBooleans() {
        informalActivity = false;
        clubRecSports = false;
        recSports = false;
        swimTeamPractice = false;
        interAthletics = false;
        tigerxPt = false;
        specEvt = false;
    }

	
    public String[] getProgramActivity() {
    	ArrayList<String> list = new ArrayList<String>();
    	if (informalActivity) {
			list.add("informalActivity");
		}
    	if (clubRecSports) {
			list.add("clubRecSports");
		}
    	if (recSports) {
			list.add("recSports");
		}
    	if (swimTeamPractice) {
			list.add("swimTeamPractice");
		}
    	if (interAthletics) {
			list.add("interAthletics");
		}
    	if (tigerxPt) {
			list.add("tigerxPt");
		}
    	if (specEvt) {
			list.add("specEvt");
		}
    	programActivity = list.toArray(new String[list.size()]);
		return programActivity;
	}

	public void setProgramActivity(String[] programActivity) {
		this.programActivity = programActivity;
		this.resetBooleans();
		for (String ap : programActivity) {
			switch (ap) {
			case "informalActivity":
				this.informalActivity = true;
				break;

			case "clubRecSports":
				this.clubRecSports = true;
				break;

			case "recSports":
				this.recSports = true;
				break;

			case "swimTeamPractice":
				this.swimTeamPractice = true;
				break;

			case "interAthletics":
				this.interAthletics = true;
				break;

			case "tigerxPt":
				this.tigerxPt = true;
				break;

			case "specEvt":
				this.specEvt = true;
				break;

			default:
				break;
			}
		}
	}
	
	public String getProgramActivityDesc() {
		StringBuffer sb = new StringBuffer();
    	if (informalActivity) {
			sb.append("Informal Activity").append(" - ").append(getInfActDesc());
		}
    	if (clubRecSports) {
    		if (!sb.toString().isEmpty()) {
				sb.append("\n");
			}
			sb.append("Club Sports").append(" - ").append(getClubRecTeamName());
		}
    	if (recSports) {
    		if (!sb.toString().isEmpty()) {
				sb.append("\n");
			}
			sb.append("Rec Sports").append(" - ").append(getRecTeamName());
		}
    	if (swimTeamPractice) {
    		if (!sb.toString().isEmpty()) {
				sb.append("\n");
			}
			sb.append("Swim Team Practice").append(" - ").append(getSwimTeamName());
		}
    	if (interAthletics) {
    		if (!sb.toString().isEmpty()) {
				sb.append("\n");
			}
			sb.append("Intercollegiate Athletics");
		}
    	if (tigerxPt) {
    		if (!sb.toString().isEmpty()) {
				sb.append("\n");
			}
			sb.append("Tiger X").append(" - ").append(getTigerxPrgName()).append("; ").append(getTigerxPtInstructor());
		}
    	if (specEvt) {
    		if (!sb.toString().isEmpty()) {
				sb.append("\n");
			}
			sb.append("Special Event").append(" - ").append(getSpecEvtGroup());
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
