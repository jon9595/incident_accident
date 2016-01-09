package edu.mizzou.incidentaccident.web.models;

import org.apache.commons.lang3.StringUtils;

public class IncidentSearchForm extends SearchForm {

	private String incidentNature;

	public String getIncidentNature() {
		return incidentNature;
	}

	public void setIncidentNature(String incidentNature) {
		this.incidentNature = incidentNature;
	}

	@Override
	public String generateWhereClause() {
		StringBuffer sb = new StringBuffer(super.getThisWhereClause());
		boolean isAnd = !" where ".equals(sb.toString());
		
		if (StringUtils.isNotBlank(this.incidentNature)) {
			if (isAnd) {
				sb.append(" and ");
			} else {
				isAnd = true;
			}
			sb.append("id in (SELECT incident_id FROM " + INCIDENT_INCIDENT_NATURE + " where incident_nature_id = " + this.incidentNature + ")");
		}
		if (" where ".equals(sb.toString())) {
			return "";
		} else {
			return sb.toString();
		}
	}
	
	
}
