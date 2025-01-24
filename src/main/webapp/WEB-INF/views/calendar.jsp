<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.adopteunrdv.model.Appointment" %>

<!DOCTYPE html>
<html>
<head>
    <title>Calendrier</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container mt-5">
    <h1 class="text-center">Calendrier</h1>
    <h2 class="text-center"><%= request.getAttribute("date") %></h2>
    <table class="table table-bordered mt-4">
        <thead>
        <tr>
            <th>Heure</th>
            <th>Statut</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Appointment> appointmentsList = (List<Appointment>) request.getAttribute("appointments");
            for (Appointment appointment : appointmentsList) {
        %>
        <tr>
            <td><%= appointment.getStartTime() %></td>
            <td><%= appointment.getStatus() %></td>
            <td>
                <form action="${pageContext.request.contextPath}/appointments/delete" method="post">
                    <input type="hidden" name="id" value="<%= appointment.getId() %>">
                    <button type="submit" class="btn btn-danger">Annuler</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <h2 class="mt-4">Ajouter un rendez-vous</h2>
    <form action="${pageContext.request.contextPath}/book" method="post" class="mt-4">
        <div class="form-group">
            <label for="date">Date :</label>
            <input type="date" id="date" name="date" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="startTime">Heure de début :</label>
            <input type="time" id="startTime" name="startTime" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="endTime">Heure de fin :</label>
            <input type="time" id="endTime" name="endTime" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="status">Statut :</label>
            <input type="text" id="status" name="status" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Réserver</button>
    </form>
</div>
</body>
</html>
