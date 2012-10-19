<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
  	<title>Liste des Voitures</title>
  </head>  
  <body>
  	<h3>Liste des voitures</h3>
    <hr>
    <form method="post">
      <table border="0">
        <tr>
          <td> Les Voitures </td>
          <td>
	      	<select name="listevoitures" size="3">
	      	  <c:forEach items="${listevoitures}" var="id">
	      		<c:choose>
	      		   <c:when test="${selectionVoiture.id==id}">
	      			 <option selected>${id}</option>
	      		   </c:when>
	      		   <c:otherwise>
	      			  <option>${id}</option>
	      		   </c:otherwise>
	      		</c:choose>
	      	  </c:forEach>
	      	</select>
          </td>
          <td>
            <input type="submit" name="voir" value="Voir Details">
          </td>
          <td>
			<table border="1">
			 <tr>
			   <td> Voiture :</td>
			   <td>${selectionVoiture.id}</td>
			   <td>${selectionVoiture.modele}</td>
			   <td>${selectionVoiture.couleur}</td>
			 </tr>
	        </table>          
          </td>
         </tr>
      </table>
      <hr>
	  <input type="text" name="nouveau" value="${nouveau}">
	  <input type="submit" name="ajout" value="Ajouter">
	  <c:out value="${errorMessage}" />
    </form>
    <hr>
    <a href="<c:url value="/index.jsp"/>">Menu</a>
    <a href="<c:url value="/listeVoitures.html"/>">Gestion des voitures</a>
    <a href="<c:url value="/reservation.html"/>">Gestions des Reservations</a>
  </body>
</html>
