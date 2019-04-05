<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Job List</title>
	
	<!-- References the style sheet, {...} get base file name -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<!-- HTML Table -->
	<div id="wrapper">
		<div id="header">
			<h2>Job List</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
		
			<!-- button to add a new job -->
			<input type="button" value="Add Job"
				   onclick="window.location.href='showFormForAddJob'; return false"
				   class="add-button"/>		
		
			<table>
				<tr>
					<th>Job Name</th>
					<th>Address</th>
					<th>Owner</th>
					<th>Contractor</th>
					<th>Total Cost</th>
					<th>Actions</th>
				</tr>
		
			<!-- Loop over and print jobs -->
			<c:forEach var="tempJob" items="${jobs}">
			
				<!-- create link to job details -->
				<c:url var="selectLink" value="/job/jobSelected">
					<c:param name="jobId" value="${tempJob.id}"/>
				</c:url>
			
				<!-- create link to delete job -->
				<c:url var="deleteLink" value="/job/deleteJob">
					<c:param name="jobId" value="${tempJob.id}"/>
				</c:url>
			
				<tr>
					<td>${tempJob.name}</td>
					<td>${tempJob.address}</td>
					<td>${tempJob.owner}</td>
					<td>${tempJob.contractor}</td>
					<td><format:formatNumber value="${tempJob.totalCost}" type="currency" currencySymbol="$"/></td>
					<td>
						<a href="${selectLink}">Select</a>
						<a href="${deleteLink}"
						   onclick="if(!(confirm('Are you sure you want to delete this job?'))) return false">
						   Delete
						</a>
					</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	

</body>
</html>