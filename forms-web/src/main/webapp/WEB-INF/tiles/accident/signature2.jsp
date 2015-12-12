<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <link href="${pageContext.request.contextPath}/js/signature-pad/jquery.signaturepad.css" rel="stylesheet">
 <!--[if lt IE 9]><script src="${pageContext.request.contextPath}/js/signature-pad/flashcanvas.js"></script><![endif]-->
 <script src="${pageContext.request.contextPath}/js/signature-pad/jquery.signaturepad.min.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/signature-pad/json2.min.js" type="text/javascript"></script>
<style>
    body { font: normal 100.01%/1.375 "Helvetica Neue",Helvetica,Arial,sans-serif; }
</style>
<script>
    $(document).ready(function() {
      $('.sigPad').signaturePad({drawOnly:true});
    });
  </script>  
<h1>Signature Capture</h1>

<div class="display-container padding-bottom-none">
	<fieldset><legend>Location</legend>
		  <html:form method="post" modelAttribute="signatureForm"  action="${pageContext.request.contextPath}/accident/signature" cssClass="sigPad">
		    <label for="name">Print your name</label>
		    <html:input type="text" path="name" id="name" cssClass="name"/>
		    <p class="drawItDesc">Draw your signature</p>
		    <ul class="sigNav">
		      <li class="drawIt"><a href="#draw-it" >Draw It</a></li>
		      <li class="clearButton"><a href="#clear">Clear</a></li>
		    </ul>
		    <div class="sig sigWrapper">
		      <div class="typed"></div>
		      <canvas class="pad" width="500" height="300"></canvas>
		      <html:hidden path="output" cssClass="output"/>
		    </div>
		    <button type="submit">I accept the terms of this agreement.</button>
		  </html:form>
	</fieldset>
</div>
