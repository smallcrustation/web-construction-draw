<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Job Page</title>
	
	<!-- References the style sheet, {...} get base file name -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<!-- HTML Table -->
	<div id="wrapper">
		<div id="header">
			<h2>"${job.name}"</h2>
		</div>
	</div>
	
	<!-- Job Details -->
	
	<div id="container">
		<div id="content">
			<table>
				<tbody>
					<tr><td>Job Name: ${job.name}</td></tr>
					<tr><td>Address: ${job.address}</td></tr>
					<tr><td>Owner: ${job.owner}</td></tr>
					<tr><td>Contractor: ${job.contractor}</td></tr>
					<tr><td>Total Cost: 
						<format:formatNumber value="${job.totalCost}" type="currency" currencySymbol="$"/>
					</td></tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- *********** EVERYTHING DRAWS BELOW *************** -->
	
	<div id="container">
		<div id="content">
		
			<!-- ////no button to add a new Draw -->
			<c:url var="addDrawLink" value="/job/showFormForAddDraw">
				<c:param name="jobId" value="${job.id}"/>
			</c:url>
			
			<a href="${addDrawLink}">Add Draw</a>				  	
		
			<table>
				<tr>
					<th>Draw #</th>
					<th>Period Ending</th>
					<th>Total Completed</th>
					<th>Actions</th>
				</tr>
				
			<!-- Loop over and print Draws -->
			<c:forEach var="tempDraw" items="${job.drawList}">
				    
				<!-- create link to draw -->
				<c:url var="selectLink" value="/job/drawSelected">
					<c:param name="drawId" value="${tempDraw.id}"/>
				</c:url>
			
				<!-- create link to delete job -->
				<c:url var="deleteLink" value="/job/deleteDraw">
					<c:param name="drawId" value="${tempDraw.id}"/>
				</c:url>
			
				<tr>
					<td>${tempDraw.applicationNumber}</td>
					<td>${tempDraw.endingPeriod}</td>
					<td>$ Place Holder</td>
					<%-- <td><format:formatNumber value="${tempDraw.totalCompleted}" type="currency" currencySymbol="$"/></td> --%>
					<td>
						<a href="${selectLink}">Select</a>
						<a href="${deleteLink}"
						   onclick="if(!(confirm('Are you sure you want to delete this Draw?'))) return false">
						   Delete
						</a>
					</td>
				</tr>
			</c:forEach>
			</table>
			
			<!-- return to job list -->
			<a href="${pageContext.request.contextPath}/job/list">Back to List</a>
		</div>
	</div>
	

</body>
</html>