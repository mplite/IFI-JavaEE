<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html;charset=ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import= "java.util.Iterator" %>

<jsp:useBean id="groupe" scope="request" class="java.util.ArrayList" />
<html>
	<head>
		<title>Affichage</title>
	</head>
	<body>
		<h2>Groupe</h2>
		<table border="1">
			<tr>
				<th colspan="3" align="center">Produits du groupe</th>
			</tr>
			<tr>
			<%
				for( Iterator i = groupe.iterator(); i.hasNext();) {
           			
					out.print("<td>" + i.next()+ "</td>");
				}%>
				
			</tr>
		</table>
		<a href="ajouter.html">Ajout</a>
	</body>
</html>
