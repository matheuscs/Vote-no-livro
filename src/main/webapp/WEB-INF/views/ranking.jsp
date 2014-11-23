<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Seus votos</p>
	<table>
		<c:forEach items="${votos}" var="voto">
			<tr>
				<td>${voto.key}</td>
				<td>${voto.value}</td>
			</tr>
		</c:forEach>
	</table>
	<p>Votos totais</p>
	<table>
		<c:forEach items="${todosOsVotos}" var="voto">
			<tr>
				<td>${voto.key}</td>
				<td>${voto.value}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>