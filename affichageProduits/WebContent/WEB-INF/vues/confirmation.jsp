<%@ page language="java" pageEncoding="ISO-8859-1" 
    contentType="text/html;charset=ISO-8859-1"%>
    
<jsp:useBean id="commandAjout" scope="request" class="web.CommandAjout" />
<html>
	<head>
		<title>Confirmation Ajout</title>
	</head>
	<body>
		<h3>Confirmation de l'ajout</h3>
		<table border="1">
			<tr>
				<td>Nouveau produit </td>
				<td><%= commandAjout.getNouveauProduit() %></td>
			</tr>
		</table>
		<a href="afficher.html">Retour</a>
	</body>
</html>
