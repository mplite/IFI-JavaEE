<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
  	<title>Reservations</title>
  </head>  
  <body>
  	<h3>Reservations</h3>
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
            <input type="submit" name="voirPersonne" value="Voir Details">
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
      <table border="1">
			 <tr>
			   <td> Personne :</td>
			   <td>${choixPersonne.nom}</td>
			   <td>${choixPersonne.prenom}</td>
			 </tr>
	        </table>     
	  <input type="submit" name="choixPersonne" value="choisir">
	  
	  
	  <c:out value="${errorMessage}" />
	  <hr>
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
            <input type="submit" name="voirVoiture" value="Voir Details">
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
      
	  <input type="submit" name="choixVoiture" value="Choisir">
	  <table border="1">
			 <tr>
			   <td> Voiture sélectionnée :</td>
			   <td>${choixVoiture.id}</td>
			   <td>${choixVoiture.modele}</td>
			   <td>${choixVoiture.couleur}</td>
			 </tr>
	        </table>  
	  <c:out value="${errorMessage}" />
	  <hr>
	  
	  <input type="submit" name="annuler" value="Annuler">
	  <input type="submit" name="confirmer" value="Confirmer">
    </form>
    <hr>
    <a href="<c:url value="/index.jsp"/>">Menu</a>
    <a href="<c:url value="/listeVoitures.html"/>">Gestion des voitures</a>
    <a href="<c:url value="/reservation.html"/>">Gestions des Reservations</a>
  </body>
</html>
