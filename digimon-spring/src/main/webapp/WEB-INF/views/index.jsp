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

<a href="new">Aggiungi Allenatore</a>
<a href="newDigimon">Aggiungi Digimon</a> <br> <br>
<a href="listaDigimon">Vedi Digimon</a>
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
			<td><a href="edit?id=${ale.id}">Modifica Allenatore</a></td>
			<td><a href="listaDigimonAll?id=${ale.id}">Lista Digimon</a></td> 
			<td><a href="assegna?id=${ale.id}">Assegna Digimon</a></td>
			<td><a href="delete?id=${ale.id}">Elimina Allenatore</a></td>
		</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>