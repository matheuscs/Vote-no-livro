<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Vote no Livro - Math</title>
<link href="<c:url value="/resources/css/estilo.css" />" rel="stylesheet">
</head>
<body>
	<h1>Ol�</h1>
	<P>Que tal participar da nossa vota��o e nos dizer quais s�o seus livros favoritos da lista?</P>
	<form method=GET action="votacao">
		<p>
			<input type="submit" value="Ir para vota��o" />
		</p>
	</form>
</body>
</html>
