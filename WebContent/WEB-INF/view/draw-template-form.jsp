<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- add support for spring MVC form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Draw Template</title>
	
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
			<h2>Draw Template</h2>
			<p>Setup draw line items and scheduled value</p>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
	
		</div>
	</div>
	
	<!-- for the DrawTemplate class, will save all line items, ScheduledValues, Item#'s, DescriptionOfWork, jobId and pass to every draw -->
	
	
</body>
</html>