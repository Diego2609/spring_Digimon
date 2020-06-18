<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="newAle">Agggiungi Allenatore</a>
<a href="new">Aggiungi Digimon</a>
<table border="1">
		<tr>
		
			<th>ID Allenatore</th>
			<th>Nome</th>
			<th>Vedi Digimons</th>
			<th>Azione</th>
		</tr>
		<c:forEach items="${listAllenatore}" var="ale">
		<tr>
			<td>${ale.id}</td>
			<td>${ale.nome}</td>
			<td><a href="new">Assegna Digimon</a></td>
			<td><a href="lol">Lista Digimon</a></td>
			<td><a href="deleteAle">Elimina Allenatore</a></td>
		</tr>
		</c:forEach>
	</table>
	
		<h3><a href="new">Nuovo Prodotto</a></h3>
	





</body>
</html>