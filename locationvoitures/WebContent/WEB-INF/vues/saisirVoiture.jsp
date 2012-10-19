<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html><head><title>formulaire Ajout voiture</title> </head>  
  <body><h3>Formulaire Ajouter une voiture </h3>
   <form:form commandName="voiture">
   		<table>
   			<tr>
   				<form:input path="id"/><form:errors path="id" />
   			</tr>
   			<tr>
   				<form:input path="modele" /><form:errors path="modele" />
   			</tr>
   			<tr>
   				<form:input path="couleur" /><form:errors path="couleur" />
   			</tr>
   			<tr>
   				<input type="submit" value="Envoyer" />
   			</tr>
   		</table>
   </form:form>
  </body></html>
