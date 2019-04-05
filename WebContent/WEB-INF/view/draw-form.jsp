
<!-- add support for spring MVC form tags -->
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Draw Form</title>
	
	<!-- References the style sheet, {...} get base file name -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-job-style.css"/>
</head>
<body>
	<!-- HTML Table -->
	<div id="wrapper">
		<div id="header">
			<h2>Add Draw Form</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<form action="saveDraw" method="POST"> 
			<input type="hidden" name="jobId" value="${job.id}"/> <!-- Not sure if this works -->
			
			<table>
				<tbody>
					<tr>
						<td><label>Draw #:</label></td>
						<td><input name="applicationNumber"></input></td>
					</tr>
					<tr>
						<td><label>Ending Period:</label></td>
						<td><input name="endingPeriod"></input></td>
					</tr>
				
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save"></td>
					</tr>
				</tbody>
			</table>
			
			<p><a href="${pageContext.request.contextPath}/job/list">Back to Job</a></p>
			
			</form>
		</div>
	</div>
	

</body>
</html>