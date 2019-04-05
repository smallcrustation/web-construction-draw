<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Item Form</title>
		
		<link type="text/css" 
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css"	/>
		
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/add-line-item-style.css" />
	</head>
	
	<div id="wrapper">
		<div id="header">
			<h2>Add Line Item</h2>
			<h3>Draw ${draw.applicationNumber}</h3>
		</div>
	</div>
	
	<div id="container">
		<div id="contents">
			<!-- Form to save a new line item -->
			<form:form action="saveLineItem" modelAttribute="lineItem" method="POST">
			<input type="hidden" name="drawId" value="${draw.id}">
			
				<table>
					<tBody>
						<tr>
							<td><label>Item Number:</label></td>
							<td><form:input path="itemNumber"></form:input></td>
						</tr>
						<tr>
							<td><label>Description of Work:</label></td>
							<td><form:input path="descriptionOfWork"></form:input></td>
						</tr>
						<tr>
							<td><label>Scheduled Value:</label></td>
							<td><form:input path="scheduledValue"></form:input></td>
						</tr>
						<tr>
							<td><label>Previous Applications:</label></td>
							<td><form:input path="previousApplications"></form:input></td>
						</tr>
						<tr>
							<td><label>This Period:</label></td>
							<td><form:input path="thisPeriod"></form:input></td>
						</tr>
						<tr>
							<td><label>Materials Stored On Site:</label></td>
							<td><form:input path="materialsStoredOnSite"></form:input></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" class="save" value="Save"/></td>
						</tr>
						
					</tBody>
				</table>
			
			</form:form>
			
			<p><a href="${pageContext.request.contextPath}/job/drawSelected?drawId=${draw.id}">Back to Draw</a></p>
			
		</div>
	</div>

</html>