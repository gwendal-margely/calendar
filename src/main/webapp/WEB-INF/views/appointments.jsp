<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.adopteunrdv.model.Appointment" %>

<!DOCTYPE html>
<html>
<head>
    <title>Rendez-vous</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>Rendez-vous</h1>
<table>
    <thead>
    <tr>
        <th>Date</th>
        <th>Heure de début</th>
        <th>Heure de fin</th>
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
        <td><%= appointment.getDate() %></td>
        <td><%= appointment.getStartTime() %></td>
        <td><%= appointment.getEndTime() %></td>
        <td><%= appointment.getStatus() %></td>
        <td>
            <form action="${pageContext.request.contextPath}/appointments/delete" method="post">
                <input type="hidden" name="id" value="<%= appointment.getId() %>">
                <button type="submit">Annuler</button>
            </form>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
