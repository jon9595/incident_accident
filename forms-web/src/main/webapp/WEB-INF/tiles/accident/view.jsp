<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<div class="page-header padding-top-md noprint">
  <h1>Accident Report - ${accident.demographics.name}</h1>
</div>
<div class="page-header margin-top-none margin-bottom-none padding-top-none padding-bottom-none noscreen">
  <h1>Accident Report - ${accident.demographics.name}</h1>
</div>
<div class="row">
    <div class="col-md-12 col-lg-12 noprint">
        <div class="display-container" style="padding-top:10px; padding-bottom:10px;">
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/accident/edit/${accident.id}';">Edit Report</button>
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/accident/list';">View Accident Reports</button>
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/incident/list';">View Incident Reports</button>
        </div>
    </div>
    <div class="col-md-12 col-lg-12">
        <div class="display-container">
        <fieldset><legend>General Information</legend>
              <div class="row margin-bottom-lg">
				<div class="col-md-12">
					<label>Date of Accident:</label> <fmt:formatDate value="${accident.demographics.date}" pattern="MM/dd/yyyy hh:mm a"/> 
				</div>
              </div>
              <div class="row margin-bottom-lg">
				<div class="col-md-12">
	                <div class="col-md-6 margin-bottom-sm">
	                	<address>
	                		<strong>${accident.demographics.name}</strong><br/>
	                		${accident.demographics.address}<br/>
	                		${accident.demographics.phone}<br/>
	                		${accident.demographics.email}
	                	</address>
					</div>
					<div class="col-md-6 margin-bottom-sm">
						<label class="margin-bottom-sm">Birth Date: </label>&nbsp;<fmt:formatDate value="${accident.demographics.birthDate}" pattern="MM/dd/yyyy"/><br/>
						<label class="margin-bottom-sm">Gender:</label>&nbsp;${"M"==accident.demographics.gender?"Male":"Female"}<br/>
						<label class="margin-bottom-sm">Res Life Student:</label>&nbsp;${"Y"==accident.demographics.resLifeStudent?"Yes":"No"}<br/>
					</div>
				</div>
              </div>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm">
					<label>Membership Status: </label>&nbsp;${accident.membershipStatus.membershipStatus}
				</div>
			  </div>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm">
					<div class="col-md-6">
						<label>Accident Details: </label>&nbsp;<pre>${accident.accidentDetailsDesc}</pre>
					</div>
					<div class="col-md-6">
						<label>Location: </label>&nbsp;<pre>${accident.accidentLocationDesc}</pre>
					</div>
				</div>
			  </div>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm">
					<div class="col-md-6">
						<label>Injury Location: </label>&nbsp;<pre>${accident.injuryLocationsDesc}</pre>
					</div>
					<div class="col-md-6">
						<label>Program or Activity Involved: </label>&nbsp;<pre>${accident.programActivity.programActivityDesc}</pre>
					</div>
				</div>
			  </div>
        </fieldset>
        <br/>
        <fieldset><legend>Responder Account</legend>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm account-description">
					<p>${accident.responderAcct.acctDesc}</p>
				</div>
			</div>
        </fieldset>
        <br/>
        <fieldset><legend>Member Account of Accident</legend>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm account-description">
					<p>${accident.memberAcct.acctDesc}</p>
				</div>
			</div>
        </fieldset>
<c:if test="${accidentForm.refusalOfCare!=null && accidentForm.refusalOfCare.memberSig != 0 && accidentForm.refusalOfCare.memberSig != null && accidentForm.refusalOfCare.memberSig != ''}">
        <fieldset><legend>Refusal of Care</legend>
              <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-bottom-sm account-description">
					<p>Date: ${accident.refusalOfCare.dateStr}</p>
					<img src="${pageContext.request.contextPath}/regenSignature/${accident.refusalOfCare.memberSig}" class="sigImg"/>
					<p>Member Signature</p>
					<img src="${pageContext.request.contextPath}/regenSignature/${accident.refusalOfCare.staffSig}" class="sigImg"/>
					<p>Staff Signature</p>
				</div>
			</div>
        </fieldset>
</c:if>
<c:if test="${(accident.witnessOne!=null || accident.witnessTwo!=null) && (accident.witnessOne.sigId != 0 || accident.witnessTwo.sigId != 0)}">
	<fieldset>
	<legend>Witness Information</legend>
<c:if test="${accident.witnessOne.sigId != 0 && accident.witnessOne.sigId != '' && accident.witnessOne.sigId != null}">
      <div class="row margin-bottom-lg">
		<div class="col-md-12 margin-bottom-sm account-description">
			<p>Witness Name: ${accident.witnessOne.name}</p>
			<p>Phone: ${accident.witnessOne.phone}</p>
			<img alt="Witness Signature" class="sigImg" src="${pageContext.request.contextPath}/regenSignature/${accident.witnessOne.sigId}">
		</div>
	  </div>
</c:if>
<c:if test="${accident.witnessTwo.sigId != 0 && accident.witnessTwo.sigId != '' && accident.witnessTwo.sigId != null}">
      <div class="row margin-bottom-lg">
		<div class="col-md-12 margin-bottom-sm account-description">
			<p>Witness Name: ${accident.witnessTwo.name}</p>
			<p>Phone: ${accident.witnessTwo.phone}</p>
			<img alt="Witness Signature" class="sigImg" src="${pageContext.request.contextPath}/regenSignature/${accident.witnessTwo.sigId}">
		</div>
	  </div>
</c:if>
	</fieldset>
</c:if>
        <fieldset><legend>MUPD</legend>
            <div class="row margin-bottom-lg">
				<div class="col-md-12">
					<div class="col-md-4">
					<label>Officer Responding: </label>&nbsp;${accident.properNotifications.mupdOfficerName}
					</div>
					<div class="col-md-8">
						<div class="col-md-4">
							<label>Time Called: </label>&nbsp;<fmt:formatDate value="${accident.properNotifications.mupdOfficerCalled}" pattern="hh:mm a"/>
						</div>
						<div class="col-md-4">
							<label>Time Arrived: </label>&nbsp;<fmt:formatDate value="${accident.properNotifications.mupdOfficerArrived}" pattern="hh:mm a"/> 
						</div>
						<div class="col-md-4">
							<label>Case Number: </label>&nbsp;${accident.properNotifications.mupdOfficerCaseNbr}
						</div>
					</div>
				</div>
			</div>
        </fieldset>
        <br/>
        <fieldset><legend>EMS</legend>
            <div class="row margin-bottom-lg">
				<div class="col-md-12 margin-left-md">
					<label>EMS Contacted: </label>&nbsp;${"Y"==accident.properNotifications.emsContacted?"Yes":"No"}
				</div>
				<c:if test="${'Y'==accident.properNotifications.emsContacted}">
					<div class="col-md-12">
						<div class="col-md-6">
						<label>Entrance Used: </label>&nbsp;${accident.properNotifications.emsEntrance}
						</div>
						<div class="col-md-6">
							<div class="col-md-6">
								<label>Time Called: </label>&nbsp;<fmt:formatDate value="${accident.properNotifications.emsCalled}" pattern="hh:mm a"/>
							</div>
							<div class="col-md-6">
								<label>Time Arrived: </label>&nbsp;<fmt:formatDate value="${accident.properNotifications.emsArrived}" pattern="hh:mm a"/> 
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
					<label>Professional Staff Contacted: </label>&nbsp;${"Y"==accident.properNotifications.profStaffContacted?"Yes":"No"}
				</div>
				<c:if test="${'Y'==accident.properNotifications.profStaffContacted}">
					<div class="col-md-12">
						<div class="col-md-6">
						<label>Professional Staff Member Called: </label>&nbsp;${accident.properNotifications.profStaffName}
						</div>
						<div class="col-md-6">
							<div class="col-md-6">
								<label>Time Called: </label>&nbsp;<fmt:formatDate value="${accident.properNotifications.profStaffCalled}" pattern="hh:mm a"/>
							</div>
							<div class="col-md-6">
								<label>Time Arrived: </label>&nbsp;<fmt:formatDate value="${accident.properNotifications.profStaffArrived}" pattern="hh:mm a"/> 
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
					<label>Report Completed By: </label>&nbsp;${accident.properNotifications.reportCompletedBy}
					</div>
					<div class="col-md-5">
					<label>Position: </label>&nbsp;${accident.properNotifications.rptCmpltPosition}
					</div>
					<div class="col-md-2">
					<label>Date: </label>&nbsp;<fmt:formatDate value="${accident.properNotifications.rptCmpltDate}" pattern="MM/dd/yyyy"/> 
					</div>
				</div>
			</div>
            <div class="row margin-bottom-lg">
				<div class="col-md-12">
					<div class="col-md-5">
					<label>Report Reviewed By: </label>&nbsp;${accident.properNotifications.rptReviewedBy}
					</div>
					<div class="col-md-5">
					<label>Position: </label>&nbsp;${accident.properNotifications.rptReviewerPosition}
					</div>
					<div class="col-md-2">
					<label>Date: </label>&nbsp;<fmt:formatDate value="${accident.properNotifications.rptReviewerDate}" pattern="MM/dd/yyyy"/> 
					</div>
				</div>
			</div>
            <div class="row margin-bottom-lg">
				<div class="col-md-12">
					<div class="col-md-5">
					<label>Residential Life Email Sent: </label>&nbsp;${"Y"==accident.properNotifications.resLifeContEmailSent?"Yes":"No"}
					</div>
					<div class="col-md-7">
					<label>Date Email Sent: </label>&nbsp;<fmt:formatDate value="${accident.properNotifications.resLifeContDateSent}" pattern="MM/dd/yyyy"/> 
					</div>
				</div>
			</div>
        </fieldset>
		</div>
     </div>
    <div class="col-md-12 col-lg-12 noprint">
        <div class="display-container" style="padding-top:10px; padding-bottom:10px;">
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/accident/edit/${accident.id}';">Edit Report</button>
        </div>
    </div>
 </div>
