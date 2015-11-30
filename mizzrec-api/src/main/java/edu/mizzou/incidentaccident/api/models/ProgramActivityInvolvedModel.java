package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Time;

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
    private boolean swimTeamPractice;
    private String swimTeamName;
    private boolean interAthletics;
    private boolean tigerxPt;
    private String tigerxPrgName;
    private String tigerxPtInstructor;
    private boolean specEvt;
    private String specEvtGroup;

	
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
