<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Vote no Livro - Math</title>
<link href=http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css rel="stylesheet">
<link href="<c:url value="/resources/css/estilo.css" />" rel="stylesheet">
</head>
<body>
	<h1>Olá</h1>
	<P>Que tal participar da nossa votação e nos dizer quais são seus livros favoritos da lista?</P>
	<form method=GET action="votacao">
		<p>
			<input type="submit" value="Ir para votação" />
		</p>
	</form>
</body>
</html>
