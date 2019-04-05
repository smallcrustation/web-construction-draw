<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Draw Details</title>
	
	<!-- References the style sheet, {...} get base file name -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<!-- HTML Table -->
	<div id="wrapper">
		<div id="header">
			<h2>Draw ${draw.applicationNumber}</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
		
			<!-- Add Line Item -->
			<c:url var="addLineItemLink" value="/job/showLineItemForm/">
				<c:param name="drawId" value="${draw.id}"/>
			</c:url>
			
			<a href="${addLineItemLink}">Add Line Item</a>
		
			<!-- add a button to edit? -->
			<%-- <input type="button" value="Add Job"
				   onclick="window.location.href='showFormForAddJob'; return false"
				   class="add-button"/>	--%>	
		
			<table>
				<tr>
					<th>Item #</th>
					<th>Description of Work</th>
					<th>Scheduled Value</th>
					<th>Previous Applications</th>
					<th>This Period</th>
					<th>Materials Stored on Site</th>
					<th>Total Completed and Stored</th>
					<th>General Completion</th>
					<th>Balance to Finish</th>
				</tr>
		
			<!-- Loop over and print jobs -->
			<c:forEach var="tempItem" items="${draw.lineItemList}">
			
				<%--
				<!-- create link to LineItem details -->
				<c:url var="selectLink" value="/job/jobSelected">
					<c:param name="jobId" value="${tempLineItem.id}"/>
				</c:url>
			
				<!-- create link to delete LineItem -->
				<c:url var="deleteLink" value="/">
					<c:param name="jobId" value="${tempLineItem.id}"/>
				</c:url> --%>
			
				<tr>
					<td>${tempItem.itemNumber}</td>
					<td>${tempItem.descriptionOfWork}</td>
					<td><format:formatNumber value="${tempItem.scheduledValue}" type="currency" currencySymbol="$"/></td>
					<td><format:formatNumber value="${tempItem.previousApplications}" type="currency" currencySymbol="$"/></td>
					<td><format:formatNumber value="${tempItem.thisPeriod}" type="currency" currencySymbol="$"/></td>
					<td><format:formatNumber value="${tempItem.materialsStoredOnSite}" type="currency" currencySymbol="$"/></td>
					<td><format:formatNumber value="${tempItem.totalCompletedAndStored}" type="currency" currencySymbol="$"/></td>
					<td>${tempItem.generalCompletion}</td>
					<td><format:formatNumber value="${tempItem.balanceToFinish}" type="currency" currencySymbol="$"/></td>
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
			
			<p><a href="${pageContext.request.contextPath}/job/jobSelected?jobId=${draw.job.id}">Back to Job</a></p>
			
		</div>
	</div>
	

</body>
</html>