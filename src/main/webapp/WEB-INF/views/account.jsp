<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.adopteunrdv.model.Appointment" %>
<%@ page import="com.adopteunrdv.model.AppUser" %>

<!DOCTYPE html>
<html>
<head>
    <title>Mon compte</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="content">
    <h2>Mon compte</h2>
    <%
        AppUser user = (AppUser) request.getAttribute("user");
    %>
    <p><%= user.getUsername() %></p>
    <p><%= user.getEmail() %></p>
    <!-- Ajouter d'autres détails du compte si nécessaire -->
</div>
</body>
</html>
