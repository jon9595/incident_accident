<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	            <div class="form-container padding-bottom-none">
	                <fieldset><legend>Basic Information</legend>
						<div class="row">
						<div class="col-md-12 col-sm-12 margin-bottom-lg">
							<div class="col-md-4">
						        <div class="form-group">
						          <label for="date" class="col-md-4 control-label">Date:</label>
						          <div class="col-md-8">
						            <span style="color: red;"><html:errors path="demographics.date" cssClass="err" /></span>
						            <html:input id="date" type="text" class="form-control margin-bottom-md date" path="demographics.dateStr"/>
						          </div>
						        </div>
							</div>
							<div class="col-md-4">
						        <div class="form-group">
						          <label for="time" class="col-md-4  control-label">Time:</label>
						          <div class="col-md-8">
						            <span style="color: red;"><html:errors path="demographics.time" cssClass="err" /></span>
						            <html:input id="time" type="text" class="form-control margin-bottom-md time" path="demographics.timeStr"/>
						          </div>
						        </div>
							</div>
							<div class="col-md-4">
						     <div class="form-group col-md-12">
								<button onclick="javascript:setcurrenttime('date', 'time');return false;" class="btn btn-large">Set current date</button>
						     </div>
							</div>
						</div>
						</div>
						
						<div class="row">
							<div class="col-md-12">
						        <div class="form-group">
							       <label for="name" class="col-sm-1 col-md-1 control-label">Name:</label>
						          <div class="col-sm-11 col-md-5">
							         <html:input type="text" class="form-control margin-bottom-md" id="name" placeholder="Name" path="demographics.name"/>
							         <span style="color: red;"><html:errors path="demographics.name" cssClass="err" /></span>
								  </div>
							       <label for="address" class="col-sm-1 col-md-1 control-label">Address:</label>
						          <div class="col-sm-11 col-md-5">
							         <html:input type="text" class="form-control" id="address" placeholder="Address" path="demographics.address"/>
							         <span style="color: red;"><html:errors path="demographics.address" cssClass="err" /></span>
								  </div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-12">
						
						        <div class="form-group">
						
						          <label for="email" class="col-sm-1 col-md-1 control-label">Email:</label>
						          <div class="col-sm-11 col-md-5">
						            <span style="color: red;"><html:errors path="demographics.email" cssClass="err" /></span>
						            <html:input type="email" class="form-control margin-bottom-md" id="email" placeholder="Email" path="demographics.email"/>
						          </div>
						
						          <label for="phone" class="col-sm-1 col-md-1 control-label">Phone:</label>
						          <div class="col-sm-11 col-md-5">
						            <span style="color: red;"><html:errors path="demographics.phone" cssClass="err" /></span>
						            <html:input type="text" class="form-control phone" id="phone" placeholder="Phone" path="demographics.phone"/>
						          </div>
						
						        </div>
						
							</div>
						</div>
						
						<div class="row">
						<div class="col-md-12 col-sm-12 margin-bottom-lg margin-left-none">
							<div class="col-md-4 col-sm-12">
						            <label class="col-md-4 col-sm-3 control-label" for="gender">Gender</label> 
						              <div class="col-sm-2 col-md-2 col-lg-2 columns"> 
						              <label class="radio-inline" for="male">
						              <html:radiobutton id="male" value="M" path="demographics.gender"/>
						              Male
						              </label> 
						              <label class="radio-inline" for="female">
						              <html:radiobutton id="female" value="F" path="demographics.gender"/>
						               Female
						               </label> 
									  <span style="color: red;"><html:errors path="demographics.gender" cssClass="err" /></span>
						            </div>
							</div>
							<div class="col-md-4 col-sm-12">
							       <label class="col-md-4 col-sm-3 control-label" for="res-life">Res Life Student</label> 
							         <div class="col-sm-2 col-md-2 col-lg-2 columns"> 
							         <label class="radio-inline" for="res-life-y">
							         <html:radiobutton id="res-life-y" value="Y" path="demographics.resLifeStudent"/>
							         Yes
							         </label> 
							         <label class="radio-inline" for="res-life-n">
							         <html:radiobutton id="res-life-n" value="N" path="demographics.resLifeStudent"/>
							               No
							               </label> 
									 <span style="color: red;"><html:errors path="demographics.resLifeStudent" cssClass="err" /></span>
							       </div>
							</div>
							<div class="col-md-4 col-sm-12">
								<label for="dob" class="control-label">Birth Date:</label>
							    <div class="">
							      <span style="color: red;"><html:errors path="demographics.birthDate" cssClass="err" /></span>
							      <html:input id="dob" type="text" class="form-control date" path="demographics.birthDateStr"/>
							    </div>
							</div>
						</div>
						</div>
	                </fieldset>
	            </div>
