package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProperNotificationsModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(ProperNotificationsModel.class);
    private Integer id;
    private String mupdOfficerName;
    private Time mupdOfficerCalled;
    private Time mupdOfficerArrived;
    private String mupdOfficerCaseNbr;
    private String emsContacted;
    private String emsEntrance;
    private Time emsCalled;
    private Time emsArrived;
    private String profStaffContacted;
    private Time profStaffCalled;
    private Time profStaffArrived;
    private String reportCompletedBy;
    private String rptCmpltPosition;
    private Date rptCmpltDate;
    private String rptReviewedBy;
    private String rptReviewerPosition;
    private Date rptReviewerDate;
    private String resLifeContEmailSent;
    private Date resLifeContDateSent;

	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getMupdOfficerName() {
        return this.mupdOfficerName;
    }

    public void setMupdOfficerName(String mupdOfficerName) {
        this.mupdOfficerName = mupdOfficerName;
    }


    public Time getMupdOfficerCalled() {
        return this.mupdOfficerCalled;
    }

    public void setMupdOfficerCalled(Time mupdOfficerCalled) {
        this.mupdOfficerCalled = mupdOfficerCalled;
    }


    public Time getMupdOfficerArrived() {
        return this.mupdOfficerArrived;
    }

    public void setMupdOfficerArrived(Time mupdOfficerArrived) {
        this.mupdOfficerArrived = mupdOfficerArrived;
    }


    public String getMupdOfficerCaseNbr() {
        return this.mupdOfficerCaseNbr;
    }

    public void setMupdOfficerCaseNbr(String mupdOfficerCaseNbr) {
        this.mupdOfficerCaseNbr = mupdOfficerCaseNbr;
    }


    public String getEmsContacted() {
        return this.emsContacted;
    }

    public void setEmsContacted(String emsContacted) {
        this.emsContacted = emsContacted;
    }


    public String getEmsEntrance() {
        return this.emsEntrance;
    }

    public void setEmsEntrance(String emsEntrance) {
        this.emsEntrance = emsEntrance;
    }


    public Time getEmsCalled() {
        return this.emsCalled;
    }

    public void setEmsCalled(Time emsCalled) {
        this.emsCalled = emsCalled;
    }


    public Time getEmsArrived() {
        return this.emsArrived;
    }

    public void setEmsArrived(Time emsArrived) {
        this.emsArrived = emsArrived;
    }


    public String getProfStaffContacted() {
        return this.profStaffContacted;
    }

    public void setProfStaffContacted(String profStaffContacted) {
        this.profStaffContacted = profStaffContacted;
    }


    public Time getProfStaffCalled() {
        return this.profStaffCalled;
    }

    public void setProfStaffCalled(Time profStaffCalled) {
        this.profStaffCalled = profStaffCalled;
    }


    public Time getProfStaffArrived() {
        return this.profStaffArrived;
    }

    public void setProfStaffArrived(Time profStaffArrived) {
        this.profStaffArrived = profStaffArrived;
    }


    public String getReportCompletedBy() {
        return this.reportCompletedBy;
    }

    public void setReportCompletedBy(String reportCompletedBy) {
        this.reportCompletedBy = reportCompletedBy;
    }


    public String getRptCmpltPosition() {
        return this.rptCmpltPosition;
    }

    public void setRptCmpltPosition(String rptCmpltPosition) {
        this.rptCmpltPosition = rptCmpltPosition;
    }


    public Date getRptCmpltDate() {
        return this.rptCmpltDate;
    }

    public void setRptCmpltDate(Date rptCmpltDate) {
        this.rptCmpltDate = rptCmpltDate;
    }


    public String getRptReviewedBy() {
        return this.rptReviewedBy;
    }

    public void setRptReviewedBy(String rptReviewedBy) {
        this.rptReviewedBy = rptReviewedBy;
    }


    public String getRptReviewerPosition() {
        return this.rptReviewerPosition;
    }

    public void setRptReviewerPosition(String rptReviewerPosition) {
        this.rptReviewerPosition = rptReviewerPosition;
    }


    public Date getRptReviewerDate() {
        return this.rptReviewerDate;
    }

    public void setRptReviewerDate(Date rptReviewerDate) {
        this.rptReviewerDate = rptReviewerDate;
    }


    public String getResLifeContEmailSent() {
        return this.resLifeContEmailSent;
    }

    public void setResLifeContEmailSent(String resLifeContEmailSent) {
        this.resLifeContEmailSent = resLifeContEmailSent;
    }


    public Date getResLifeContDateSent() {
        return this.resLifeContDateSent;
    }

    public void setResLifeContDateSent(Date resLifeContDateSent) {
        this.resLifeContDateSent = resLifeContDateSent;
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
