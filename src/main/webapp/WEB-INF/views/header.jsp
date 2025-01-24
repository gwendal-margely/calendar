<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.adopteunrdv.model.Appointment" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/data/${siteName.toLowerCase()}/${cssFile}">
</head>
<body>
<header>
    <div class="header-container">
        <img src="${pageContext.request.contextPath}/data/${siteName.toLowerCase()}/${logoFile}" alt="Logo" class="logo">
        <h1>${siteName}</h1>
        <nav>
            <% if (request.getAttribute("user") != null) { %>
            <a href="${pageContext.request.contextPath}/">Accueil</a>
            <a href="${pageContext.request.contextPath}/calendar">Mon calendrier</a>
            <a href="${pageContext.request.contextPath}/account">Mon compte</a>
            <a href="${pageContext.request.contextPath}/logout">Se déconnecter</a>
            <% } %>
        </nav>
        <div class="language-selector">
            <a href="${pageContext.request.contextPath}/changeLanguage?lang=en">English</a>
            <a href="${pageContext.request.contextPath}/changeLanguage?lang=fr">Français</a>
        </div>
    </div>
</header>
</body>
</html>
