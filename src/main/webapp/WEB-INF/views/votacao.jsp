<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method=GET action="votacao">
		<p>Escolha seu livro preferido dentre as opções abaixo:</p>
		<table>
			<tr>
				<td>1) ${livro1}</td>
				<td>2) ${livro2}</td>
			</tr>
			<tr>
				<td>Qual livro prefere?</td>
				<td><input name="livroEscolhido" type="text" /></td>
			</tr>
		</table>
		<input type="submit" value="Escolhi" />
	</form>
</body>
</html>