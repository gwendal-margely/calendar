<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.adopteunrdv.model.Appointment" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="content">
    <img src="${pageContext.request.contextPath}/${homeImage}" alt="Home Image" class="home-image">
    <p><spring:message code="home.text" /></p>
</div>
</body>
</html>
