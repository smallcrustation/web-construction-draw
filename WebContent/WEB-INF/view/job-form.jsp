<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- add support for spring MVC form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Job Form</title>
	
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
			<h2>Add Job Form</h2>
		</div>
	</div>

	<div class="content">
		<div>
			<form:form action="saveJob" modelAttribute="job" method="POST"> 
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name"></form:input></td>
						<td><form:errors id="error" path="name" /></td>
					</tr>
					<tr>
						<td><label>Address:</label></td>
						<td><form:input path="address"></form:input></td>
						<td><form:errors id="error" path="address" /></td>
					</tr>
					<tr>
						<td><label>Owner:</label></td>
						<td><form:input path="owner"></form:input></td>
						<td><form:errors id="error" path="owner" /></td>
					</tr>
					<tr>
						<td><label>Contractor:</label></td>
						<td><form:input path="contractor"></form:input></td>
						<td><form:errors id="error" path="contractor" /></td>
					</tr>
					<tr>
						<td><label>Total Cost:</label></td>
						<td><form:input path="totalCost"></form:input></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" class="save" value="Save"></td>
					</tr>
				</tbody>
			</table>
			
			<p><a href="${pageContext.request.contextPath}/job/list">Back to List</a></p>
			
			</form:form>
		</div>
	</div>
	

</body>
</html>