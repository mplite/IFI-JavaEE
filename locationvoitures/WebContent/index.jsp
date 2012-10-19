<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
session.invalidate();
%>
<html>
<body>
 <h3>
 Locations de voitures...
<br>
 Choisissez:
<br>
<a href="<c:url value="listePersonnes.html"/>">Gestion des Personnes</a>
<br>
<a href="<c:url value="listeVoitures.html"/>">Gestion des Voitures</a>
<br>
<a href="<c:url value="reservation.html"/>">Gestion des Reservations</a>
<br>
</h3>

</body>
</html>