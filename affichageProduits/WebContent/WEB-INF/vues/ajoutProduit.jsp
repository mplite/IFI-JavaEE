<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html><head><title>formulaire Ajout</title> </head>  
  <body><h3>Formulaire Ajouter un produit </h3>
    <form:form commandName="commandAjout">
	<table>
		<tr>
			<td>Nouveau Produit</td>
			<td><form:input path="nouveauProduit" /></td>
			<%-- Show errors for name field --%>
			<td><form:errors path="nouveauProduit" /></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Envoyer" /></td>
		</tr>
	</table>
</form:form>
  </body></html>
