<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>modifica digimon</title>
</head>
<body>
	<div align="center">
		<h2>Modifica digimon</h2>
		<form:form action="saveDigimon" method="post" modelAttribute="digimon">
			<table>
				<tr>
					<td>ID:</td>
					<td>${digimon.id}<form:hidden path="id" />
					</td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td>Attacco:</td>
					<td><form:input path="atk" /></td>
				</tr>
				<tr>
					<td>Difesa:</td>
					<td><form:input path="def" /></td>
				</tr>
				<tr>
					<td>Resistenza:</td>
					<td><form:input path="res" /></td>
				</tr>
				<tr>
					<td>Evoluzione:</td>
					<td><form:input path="evoluzione" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Modifica"></td>
				</tr>
			</table>
		</form:form>
		<br>
		<br>

		<form action="indietro" method="post">
			<input type="submit" value="Torna Indietro">
		</form>
	</div>

</body>
</html>