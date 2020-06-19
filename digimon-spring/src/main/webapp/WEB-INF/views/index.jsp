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
<div align="center">
<a href="new">Aggiungi Allenatore</a> &nbsp;
<a href="newDigimon">Aggiungi Digimon</a> &nbsp;<br><br>
<a href="listaDigimon">Lista di tutti i Digimon</a> 
<br><br><br>
<table border="1">
		<tr>
		
			<th>ID Allenatore</th>
			<th>Nome</th>
			<th>Modifica Allenatore</th>
			<th>Lista Digimon allenatore</th>
			<th>Assegna</th>
			<th>Elimina</th>
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
	
	</div>
</body>
</html>