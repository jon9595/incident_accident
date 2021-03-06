<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
function deleteReport() {
	if(confirm("Are you sure you want to delete this report?")) {
		location.href='${pageContext.request.contextPath}/incident/delete/${incident.id}';
	}	
}

</script>


<div class="page-header padding-top-md noprint">
  <h1>Incident Report - ${incident.demographics.name}</h1>
</div>
<div class="page-header margin-top-none margin-bottom-none padding-top-none padding-bottom-none noscreen">
  <h1>Incident Report - ${incident.demographics.name}</h1>
</div>
<div class="row">
    <div class="col-md-12 col-lg-12 noprint">
        <div class="display-container" style="padding-top:10px; padding-bottom:10px;">
        <c:if test="${(sessionScope.userProfile.admin || sessionScope.userProfile.manager) && !incident.approved}">
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/incident/edit/${incident.id}';">Edit Report</button>
		<button class="btn btn-primary" onclick="deleteReport();">Delete Report</button>
        </c:if>
        <c:if test="${(sessionScope.userProfile.admin || sessionScope.userProfile.manager) && !incident.approved}">
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/incident/approve/${incident.id}';">Approve Report</button>
        </c:if>
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/incident/list';">View Incident Reports</button>
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/accident/list';">View Accident Reports</button>
        </div>
    </div>
    <div class="col-md-12 col-lg-12">
        <div class="display-container">
        <fieldset><legend>General Information</legend>
              <div class="row margin-bottom-lg">
				<div class="col-md-12">
					<label>Date of Accident:</label> <fmt:formatDate value="${incident.demographics.date}" pattern="MM/dd/yyyy hh:mm a"/> 
				</div>
              </div>
              <div class="row margin-bottom-lg">
				<div class="col-md-12">
	                <div class="col-md-6 margin-bottom-sm">
	                	<address>
	                		<strong>${incident.demographics.name}</strong><br/>
	                		${incident.demographics.address}<br/>
	                		${incident.demographics.phone}<br/>
	                		${incident.demographics.email}
	                	</address>
					</div>
					<div class="col-md-6 margin-bottom-sm">
						<label class="margin-bottom-sm">Birth Date: </label>&nbsp;<fmt:formatDate value="${incident.demographics.birthDate}" pattern="MM/dd/yyyy"/><br/>
						<label class="margin-bottom-sm">Gender:</label>&nbsp;${"M"==incident.demographics.gender?"Male":("O"==incident.demographics.gender?"Other":"Female")}<br/>
						<label class="margin-bottom-sm">Res Life Student:</label>&nbsp;${"Y"==incident.demographics.resLifeStudent?"Yes":"No"}<br/>
					</div>
				</div>
              </div>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm">
					<label>Membership Status: </label>&nbsp;${incident.membershipStatus.membershipStatus}
				</div>
			  </div>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm">
					<div class="col-md-6">
						<label>Incident Details: </label>&nbsp;<pre>${incident.incidentDetailsDesc}</pre>
					</div>
					<div class="col-md-6">
						<label>Location: </label>&nbsp;<pre>${incident.incidentLocationDesc}</pre>
					</div>
				</div>
			  </div>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm">
					<div class="col-md-12">
						<label>Program or Activity Involved: </label>&nbsp;<pre>${incident.programActivity.programActivityDesc}</pre>
					</div>
				</div>
			  </div>
        </fieldset>
        <br/>
        <fieldset><legend>Responder Account</legend>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm account-description">
					<p>${incident.responderAcct.acctDesc}</p>
				</div>
			</div>
        </fieldset>
        <br/>
        <fieldset><legend>Member Account of Accident</legend>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm account-description">
					<p>${incident.memberAcct.acctDesc}</p>
				</div>
			</div>
        </fieldset>
        <fieldset><legend>Witness Account of Accident</legend>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm account-description">
					<p>${incident.witnessAcct.acctDesc}</p>
				</div>
			</div>
        </fieldset>
<c:if test="${incident.witnessInfo!=null && incident.witnessInfo.sigId != 0 && incident.witnessInfo.sigId != '' && incident.witnessInfo.sigId != null}">
	<fieldset>
	<legend>Witness Information</legend>
      <div class="row margin-bottom-lg">
		<div class="col-md-12 margin-bottom-sm account-description">
			<p>Witness Name: ${incident.witnessInfo.name}</p>
			<p>Phone: ${incident.witnessInfo.phone}</p>
			<img alt="Witness Signature" class="sigImg" src="${pageContext.request.contextPath}/regenSignature/${incident.witnessInfo.sigId}">
		</div>
	  </div>
	</fieldset>
</c:if>
        <fieldset><legend>MUPD</legend>
            <div class="row margin-bottom-lg">
				<div class="col-md-12">
					<div class="col-md-4">
					<label>Officer Responding: </label>&nbsp;${incident.properNotifications.mupdOfficerName}
					</div>
					<div class="col-md-8">
						<div class="col-md-4">
							<label>Time Called: </label>&nbsp;<fmt:formatDate value="${incident.properNotifications.mupdOfficerCalled}" pattern="hh:mm a"/>
						</div>
						<div class="col-md-4">
							<label>Time Arrived: </label>&nbsp;<fmt:formatDate value="${incident.properNotifications.mupdOfficerArrived}" pattern="hh:mm a"/> 
						</div>
						<div class="col-md-4">
							<label>Case Number: </label>&nbsp;${incident.properNotifications.mupdOfficerCaseNbr}
						</div>
					</div>
				</div>
			</div>
        </fieldset>
        <br/>
        <fieldset><legend>EMS</legend>
            <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-left-md">
					<label>EMS Contacted: </label>&nbsp;${"Y"==incident.properNotifications.emsContacted?"Yes":"No"}
				</div>
				<c:if test="${'Y'==incident.properNotifications.emsContacted}">
					<div class="col-md-12">
						<div class="col-md-6">
						<label>Entrance Used: </label>&nbsp;${incident.properNotifications.emsEntrance}
						</div>
						<div class="col-md-6">
							<div class="col-md-6">
								<label>Time Called: </label>&nbsp;<fmt:formatDate value="${incident.properNotifications.emsCalled}" pattern="hh:mm a"/>
							</div>
							<div class="col-md-6">
								<label>Time Arrived: </label>&nbsp;<fmt:formatDate value="${incident.properNotifications.emsArrived}" pattern="hh:mm a"/> 
							</div>
						</div>
					</div>
				</c:if>
			</div>
        </fieldset>
        <br/>
        <fieldset><legend>Professional Staff</legend>
            <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-left-md">
					<label>Professional Staff Contacted: </label>&nbsp;${"Y"==incident.properNotifications.profStaffContacted?"Yes":"No"}
				</div>
				<c:if test="${'Y'==incident.properNotifications.profStaffContacted}">
					<div class="col-md-12">
						<div class="col-md-6">
						<label>Professional Staff Member Called: </label>&nbsp;${incident.properNotifications.profStaffName}
						</div>
						<div class="col-md-6">
							<div class="col-md-6">
								<label>Time Called: </label>&nbsp;<fmt:formatDate value="${incident.properNotifications.profStaffCalled}" pattern="hh:mm a"/>
							</div>
							<div class="col-md-6">
								<label>Time Arrived: </label>&nbsp;<fmt:formatDate value="${incident.properNotifications.profStaffArrived}" pattern="hh:mm a"/> 
							</div>
						</div>
					</div>
				</c:if>
			</div>
        </fieldset>
        <br/>
        <fieldset><legend>Report Completion</legend>
            <div class="row margin-bottom-lg">
				<div class="col-md-12">
					<div class="col-md-5">
					<label>Report Completed By: </label>&nbsp;${incident.creator!=null?incident.creator.name:incident.createdBy}
					</div>
					<div class="col-md-5">
					<label>Position: </label>&nbsp;${incident.creator.position}
					</div>
					<div class="col-md-2">
					<label>Date: </label>&nbsp;<fmt:formatDate value="${incident.created}" pattern="MM/dd/yyyy"/> 
					</div>
				</div>
			</div>
            <div class="row margin-bottom-lg">
				<div class="col-md-12">
					<div class="col-md-5">
					<label>Report Reviewed By: </label>&nbsp;${incident.properNotifications.reviewer!=null?incident.properNotifications.reviewer.name:""}
					</div>
					<div class="col-md-5">
					<label>Position: </label>&nbsp;${incident.properNotifications.reviewer!=null?incident.properNotifications.reviewer.position:""}
					</div>
					<div class="col-md-2">
					<label>Date: </label>&nbsp;<fmt:formatDate value="${incident.properNotifications.rptReviewerDate}" pattern="MM/dd/yyyy"/> 
					</div>
				</div>
			</div>
        </fieldset>
		</div>
     </div>
     <c:if test="${sessionScope.userProfile.admin}">
    <div class="col-md-12 col-lg-12 noprint">
        <div class="display-container" style="padding-top:10px; padding-bottom:10px;">
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/incident/edit/${incident.id}';">Edit Report</button>
		<button class="btn btn-primary" onclick="deleteReport();">Delete Report</button>
        </div>
    </div>
     </c:if>
 </div>
