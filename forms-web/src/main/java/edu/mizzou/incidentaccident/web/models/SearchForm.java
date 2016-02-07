package edu.mizzou.incidentaccident.web.models;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import edu.mizzou.incidentaccident.api.common.util.DateUtil;
import edu.mizzou.incidentaccident.api.constants.AppConstants;
import edu.mizzou.incidentaccident.api.constants.DBConstants;

public abstract class SearchForm implements Serializable, DBConstants {

	private String name;
	private String memberStatus;
	private Date startDate;
	private Date endDate;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
    public String getStartDateStr() {
        return DateUtil.format(this.startDate, AppConstants.DATE_FORMAT_PATTERN_MDY);
    }
    public void setStartDateStr(String startDate) {
        this.startDate = DateUtil.parse(startDate, AppConstants.DATE_FORMAT_PATTERN_MDY);
    }
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    public String getEndDateStr() {
        return DateUtil.format(this.endDate, AppConstants.DATE_FORMAT_PATTERN_MDY);
    }
    public void setEndDateStr(String endDate) {
        this.endDate = DateUtil.parse(endDate, AppConstants.DATE_FORMAT_PATTERN_MDY);
    }
	
	protected String getThisWhereClause() {
		StringBuffer sb = new StringBuffer(" where ");
		boolean isAnd = false;
		if (StringUtils.isNotBlank(this.name)) {
			sb.append("demographics in (SELECT id FROM " + DEMOGRAPHICS + " where lower(name) like '%"+StringUtils.lowerCase(this.name)+"%')");
			isAnd = true;
		}
		if (StringUtils.isNotBlank(this.memberStatus)) {
			if (isAnd) {
				sb.append(" and ");
			} else {
				isAnd = true;
			}
			sb.append("membership_status in (SELECT id FROM " + MEMBERSHIP_STATUS + " where " + this.memberStatus + " = 'Y')");
		}
		if (this.startDate != null || this.endDate != null) {
			if (isAnd) {
				sb.append(" and ");
			} else {
				isAnd = true;
			}
			if (this.startDate != null && this.endDate != null) {
				sb.append("dem.date between '" + DateUtil.format(this.startDate, AppConstants.DATE_FORMAT_PATTERN_SQL) + " 00:00:00' and '" + DateUtil.format(this.endDate, AppConstants.DATE_FORMAT_PATTERN_SQL) + " 23:59:59'");
			} else if (this.startDate != null) {
				sb.append("dem.date >= '" + DateUtil.format(this.startDate, AppConstants.DATE_FORMAT_PATTERN_SQL) +" 00:00:00'");
			} else {
				sb.append("dem.date <= '" + DateUtil.format(this.endDate, AppConstants.DATE_FORMAT_PATTERN_SQL) +" 23:59:59'");
			}
		}
		return sb.toString();
	}
	
	public abstract String generateWhereClause();
}
