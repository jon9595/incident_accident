<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	            <div class="form-container padding-bottom-none">
	                <fieldset><legend>Basic Information</legend>
	                  <div class="col-md-12 col-sm-12 margin-bottom-lg">
	                  <span class="text-muted">Accidents resulting from or directly related to the Department of Recreation Services' programs and premises are to be reported on this 
	                  form.</span>
	                  </div>
	                <div class="form-group">
	                  <label for="date" class="col-sm-2 col-md-2 col-lg-2 control-label">Date of Accident:</label>
	                  <div class="col-sm-11 col-md-5 col-lg-3">
	                    <html:input id="date" type="text" class="form-control margin-bottom-md" path="demographics.date"/>
	                  </div>
	
	                  <label for="time" class="col-sm-2 col-md-2 col-lg-2 control-label">Time of Accident:</label>
	                  <div class="col-sm-11 col-md-5 col-lg-3">
	                    <html:input id="time" type="text" class="form-control margin-bottom-md" path="demographics.time"/>
	                  </div>
	
	                </div>
	                <div class="form-group">
	
	                  <label for="name" class="col-sm-1 col-md-1 control-label">Name:</label>
	                  <div class="col-sm-11 col-md-5">
	                    <html:input type="text" class="form-control margin-bottom-md" id="name" placeholder="Name" path="demographics.name"/>
	                  </div>
	
	                  <label for="address" class="col-sm-1 col-md-1 control-label">Address:</label>
	                  <div class="col-sm-11 col-md-5">
	                    <html:input type="text" class="form-control" id="address" placeholder="Address" path="demographics.address"/>
	                  </div>
	
	                </div>
	
	                <div class="form-group">
	
	                  <label for="email" class="col-sm-1 col-md-1 control-label">Email:</label>
	                  <div class="col-sm-11 col-md-5">
	                    <html:input type="email" class="form-control margin-bottom-md" id="email" placeholder="Email" path="demographics.email"/>
	                  </div>
	
	                  <label for="phone" class="col-sm-1 col-md-1 control-label">Phone:</label>
	                  <div class="col-sm-11 col-md-5">
	                    <html:input type="text" class="form-control" id="phone" placeholder="Phone" path="demographics.phone"/>
	                  </div>
	
	                </div>
	
	                <div class="form-group">
	                   <label class="col-sm-2 col-md-2 col-lg-1 control-label" for="gender">Gender</label> 
	                     <div class="col-sm-2 col-md-2 col-lg-2 columns"> 
	                     <label class="radio-inline" for="male">
	                     <html:radiobutton id="male" value="M" path="demographics.gender"/>
	                     Male
	                     </label> 
	                     <label class="radio-inline" for="female">
	                     <html:radiobutton id="female" value="F" path="demographics.gender"/>
	                     Female
	                     </label> 
	                   </div>
	
	                   <label class="col-sm-2 col-md-2 col-lg-1 control-label" for="res-life">Res Life Student</label> 
	                     <div class="col-sm-2 col-md-2 col-lg-2 columns"> 
	                     <label class="radio-inline" for="res-life-y">
	                     <html:radiobutton id="res-life-y" value="Y" path="demographics.resLifeStudent"/>
	                     Yes
	                     </label> 
	                     <label class="radio-inline" for="res-life-n">
	                     <html:radiobutton id="res-life-n" value="N" path="demographics.resLifeStudent"/>
	                     No
	                     </label> 
	                   </div>
	
	
	                  <label for="dob" class="col-sm-1 col-md-1 col-lg-1 control-label">Birth Date:</label>
	                  <div class="col-sm-11 col-md-5 col-lg-3">
	                    <html:input id="dob" type="text" class="form-control" path="demographics.birthDate"/>
	                  </div>
	
	                </div>
	                </fieldset>
	            </div>
