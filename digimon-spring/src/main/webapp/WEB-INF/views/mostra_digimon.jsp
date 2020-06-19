<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>

			<th>Nome</th>
			<th>Attacco</th>
			<th>Difesa</th>
			<th>Resistenza</th>
			<th>Evoluzione</th>
			<th>Modifica</th>
			<th>Elimina</th>
		</tr>
		<c:forEach items="${lista}" var="dig">
			<tr>

				<td>${dig.nome}</td>
				<td>${dig.atk}</td>
				<td>${dig.def}</td>
				<td>${dig.res}</td>
				<td>${dig.evoluzione}</td>
				<td><a href="editDigimon?id=${dig.id}">Modifica</a></td>
				<td><a href="deleteDigimon?id=${dig.id}">Elimina</a></td>
			</tr>
		</c:forEach>
	</table>

	ordina per:
	<form action="sortDigimon">
		<input type="radio" name="ordinamento" value="0"> <label
			for="attacco">Attacco</label><br> <input type="radio"
			name="ordinamento" value="1"> <label for="difesa">Difesa</label><br>
		<input type="radio" name="ordinamento" value="2"> <label
			for="resistenza">Resistenza</label><br> <input type="submit"
			value="ordina"><br>
		<br>
	</form>
	<form action="indietro" method="post">
		<input type="submit" value="Torna Indietro">
	</form>
</body>
</html>