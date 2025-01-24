<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.adopteunrdv.model.Appointment" %>

<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>Se connecter</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div>
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" required>
    </div>
    <button type="submit">Se connecter</button>
</form>
</body>
</html>
