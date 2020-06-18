<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aggiungi Digimon</title>
</head>
<body>
<form:form action="saveDigimon" method="post" modelAttribute="digimon">
<table border="0" cellpadding="5">
				<tr>
					<td>Nome: </td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td>Attacco: </td>
					<td><form:input path="atk" /></td>
				</tr>
				<tr>
					<td>Difesa: </td>
					<td><form:input path="def" /></td>
				</tr>
				<tr>
					<td>Resistenza: </td>
					<td><form:input path="res" /></td>
				</tr>
				<tr>
					<td>Evoluzione: </td>
					<td><form:input path="evoluzione" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Salva"></td>
				</tr>	
				</table>
				</form:form>
</body>
</html>