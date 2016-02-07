package edu.mizzou.incidentaccident.web.models;

import org.apache.commons.lang3.StringUtils;

public class AccidentSearchForm extends SearchForm {
	
	private String accidentDetail;
	private String emsContacted;
	
	public String getAccidentDetail() {
		return accidentDetail;
	}
	public void setAccidentDetail(String accidentDetail) {
		this.accidentDetail = accidentDetail;
	}
	public String getEmsContacted() {
		return emsContacted;
	}
	public void setEmsContacted(String emsContacted) {
		this.emsContacted = emsContacted;
	}
	@Override
	public String generateWhereClause() {
		StringBuffer sb = new StringBuffer(super.getThisWhereClause());
		boolean isAnd = !" where ".equals(sb.toString());
		
		if (StringUtils.isNotBlank(this.accidentDetail)) {
			if (isAnd) {
				sb.append(" and ");
			} else {
				isAnd = true;
			}
			sb.append("acc.id in (SELECT accident_id FROM " + ACCIDENT_DETAILS + " where acc_det_desc_id = " + this.accidentDetail + ")");
		}
		if (StringUtils.isNotBlank(this.emsContacted)) {
			if (isAnd) {
				sb.append(" and ");
			} else {
				isAnd = true;
			}
			sb.append("proper_notifications in (SELECT id FROM " + PROPER_NOTIFICATIONS + " where ems_contacted = '" + this.emsContacted + "')");			
		}
		if (" where ".equals(sb.toString())) {
			return "";
		} else {
			return sb.toString();
		}
	}
	
	
}
