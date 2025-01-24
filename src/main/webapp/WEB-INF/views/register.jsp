<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.adopteunrdv.model.Appointment" %>

<!DOCTYPE html>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>S'inscrire</h1>
<form action="${pageContext.request.contextPath}/register" method="post">
    <div>
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <label for="email">Email :</label>
        <input type="email" id="email" name="email" required>
    </div>
    <button type="submit">S'inscrire</button>
</form>
</body>
</html>
