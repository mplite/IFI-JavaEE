<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html><head><title>formulaire Ajout personne</title> </head>  
  <body><h3>Formulaire Ajouter une personne </h3>
   <form:form commandName="personne">
   		<table>
   			<tr>
   				<form:input path="nom"/><form:errors path="nom" />
   			</tr>
   			<tr>
   				<form:input path="prenom" /><form:errors path="prenom" />
   			</tr>
   			<tr>
   				<input type="submit" value="Envoyer" />
   			</tr>
   		</table>
   </form:form>
  </body></html>


  