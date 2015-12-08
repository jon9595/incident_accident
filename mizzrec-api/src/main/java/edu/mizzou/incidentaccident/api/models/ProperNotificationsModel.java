package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mizzou.incidentaccident.api.common.util.DateUtil;
import edu.mizzou.incidentaccident.api.constants.AppConstants;


public class ProperNotificationsModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(ProperNotificationsModel.class);
    private Integer id;
    private String mupdOfficerName;
    private Date mupdOfficerCalled;
    private Date mupdOfficerArrived;
    private String mupdOfficerCaseNbr;
    private String emsContacted;
    private String emsEntrance;
    private Date emsCalled;
    private Date emsArrived;
    private String profStaffContacted;
    private String profStaffName;
    private Date profStaffCalled;
    private Date profStaffArrived;
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


    public Date getMupdOfficerCalled() {
        return this.mupdOfficerCalled;
    }

    public void setMupdOfficerCalled(Date mupdOfficerCalled) {
        this.mupdOfficerCalled = mupdOfficerCalled;
    }


    public Date getMupdOfficerArrived() {
        return this.mupdOfficerArrived;
    }

    public void setMupdOfficerArrived(Date mupdOfficerArrived) {
        this.mupdOfficerArrived = mupdOfficerArrived;
    }

    public String getMupdOfficerCalledStr() {
        return DateUtil.format(this.mupdOfficerCalled, AppConstants.DATE_FORMAT_PATTERN_HM);
    }

    public void setMupdOfficerCalledStr(String mupdOfficerCalled) {
        this.mupdOfficerCalled = DateUtil.parse(mupdOfficerCalled, AppConstants.DATE_FORMAT_PATTERN_HM);
    }


    public String getMupdOfficerArrivedStr() {
        return DateUtil.format(this.mupdOfficerArrived, AppConstants.DATE_FORMAT_PATTERN_HM);
    }

    public void setMupdOfficerArrivedStr(String mupdOfficerArrived) {
        this.mupdOfficerArrived = DateUtil.parse(mupdOfficerArrived, AppConstants.DATE_FORMAT_PATTERN_HM);
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


    public Date getEmsCalled() {
        return this.emsCalled;
    }

    public void setEmsCalled(Date emsCalled) {
        this.emsCalled = emsCalled;
    }

    public String getEmsCalledStr() {
        return DateUtil.format(this.emsCalled, AppConstants.DATE_FORMAT_PATTERN_HM);
    }

    public void setEmsCalledStr(String emsCalled) {
        this.emsCalled = DateUtil.parse(emsCalled, AppConstants.DATE_FORMAT_PATTERN_HM);
    }

    public Date getEmsArrived() {
        return this.emsArrived;
    }

    public void setEmsArrived(Date emsArrived) {
        this.emsArrived = emsArrived;
    }

    public String getEmsArrivedStr() {
        return DateUtil.format(this.emsArrived, AppConstants.DATE_FORMAT_PATTERN_HM);
    }

    public void setEmsArrivedStr(String emsArrived) {
        this.emsArrived = DateUtil.parse(emsArrived, AppConstants.DATE_FORMAT_PATTERN_HM);
    }

    public String getProfStaffContacted() {
        return this.profStaffContacted;
    }

    public void setProfStaffContacted(String profStaffContacted) {
        this.profStaffContacted = profStaffContacted;
    }


    public String getProfStaffName() {
		return profStaffName;
	}

	public void setProfStaffName(String profStaffName) {
		this.profStaffName = profStaffName;
	}

	public Date getProfStaffCalled() {
        return this.profStaffCalled;
    }

    public void setProfStaffCalled(Date profStaffCalled) {
        this.profStaffCalled = profStaffCalled;
    }

	public String getProfStaffCalledStr() {
        return DateUtil.format(this.profStaffCalled, AppConstants.DATE_FORMAT_PATTERN_HM);
    }

    public void setProfStaffCalledStr(String profStaffCalled) {
        this.profStaffCalled = DateUtil.parse(profStaffCalled, AppConstants.DATE_FORMAT_PATTERN_HM);
    }

    public Date getProfStaffArrived() {
        return this.profStaffArrived;
    }

    public void setProfStaffArrived(Date profStaffArrived) {
        this.profStaffArrived = profStaffArrived;
    }

    public String getProfStaffArrivedStr() {
        return DateUtil.format(this.profStaffArrived, AppConstants.DATE_FORMAT_PATTERN_HM);
    }

    public void setProfStaffArrivedStr(String profStaffArrived) {
        this.profStaffArrived = DateUtil.parse(profStaffArrived, AppConstants.DATE_FORMAT_PATTERN_HM);
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

    public String getRptCmpltDateStr() {
        return DateUtil.format(this.rptCmpltDate, AppConstants.DATE_FORMAT_PATTERN_MDY);
    }

    public void setRptCmpltDateStr(String rptCmpltDate) {
        this.rptCmpltDate = DateUtil.parse(rptCmpltDate, AppConstants.DATE_FORMAT_PATTERN_MDY);
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

    public String getRptReviewerDateStr() {
        return DateUtil.format(this.rptReviewerDate, AppConstants.DATE_FORMAT_PATTERN_MDY);
    }

    public void setRptReviewerDateStr(String rptReviewerDate) {
        this.rptReviewerDate = DateUtil.parse(rptReviewerDate, AppConstants.DATE_FORMAT_PATTERN_MDY);
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

    public String getResLifeContDateSentStr() {
        return DateUtil.format(this.resLifeContDateSent, AppConstants.DATE_FORMAT_PATTERN_MDY);
    }

    public void setResLifeContDateSentStr(String resLifeContDateSent) {
        this.resLifeContDateSent = DateUtil.parse(resLifeContDateSent, AppConstants.DATE_FORMAT_PATTERN_MDY);
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
