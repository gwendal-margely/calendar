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
    <% if (isEditable) { %>
    <form action="${pageContext.request.contextPath}/uploadImage" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="hidden" name="type" value="homeImage">
        <button type="submit">Upload Home Image</button>
    </form>
    <% } else { %>
    <img src="${pageContext.request.contextPath}/data/${siteName.toLowerCase()}/${homeImage}" alt="Home Image">
    <% } %>
    <p><spring:message code="home.text" /></p>
</div>
</body>
</html>
