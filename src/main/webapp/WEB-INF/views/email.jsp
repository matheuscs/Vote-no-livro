<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote no Livro - Math</title>
<link href="<c:url value="/resources/css/estilo.css" />" rel="stylesheet">
</head>
<body>
	<form method=GET action=ranking>
		<p>Obrigado por votar! Para verificar o ranking dos
			livros mais votados e o seu resultado, preencha nome e email abaixo
			e clique em Enviar.</p>
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="Enviar" /></th>
			</tr>
		</table>
	</form>
</body>
</html>