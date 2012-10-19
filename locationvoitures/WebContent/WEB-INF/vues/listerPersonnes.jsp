<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
  	<title>Liste des Personnes</title>
  </head>  
  <body>
  	<h3>Liste des personnes</h3>
    <hr>
    <form method="post">
      <table border="0">
        <tr>
          <td> Les Personnes </td>
          <td>
	      	<select name="listepersonnes" size="3">
	      	  <c:forEach items="${listenoms}" var="nom">
	      		<c:choose>
	      		   <c:when test="${selectionPersonne.nom==nom}">
	      			 <option selected>${nom}</option>
	      		   </c:when>
	      		   <c:otherwise>
	      			  <option>${nom}</option>
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
			   <td> Personne :</td>
			   <td>${selectionPersonne.nom}</td>
			   <td>${selectionPersonne.prenom}</td>
			 </tr>
			  <c:forEach items="${selectionPersonne.voitures}" var="voiture">
				<tr>
			   		<td> Reservation pour Voiture :</td>
			   		<td>${voiture.id}</td>
			   		<td>${voiture.modele}</td>
			   		<td>${voiture.couleur}</td>
			   	</tr>
	      	  </c:forEach>
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
