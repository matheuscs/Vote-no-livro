<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Olá</h1>
	<P>Que tal participar da nossa votação para saber qual é o livro preferido dentre a lista?</P>
	<form method=GET action="votacao">
		<p>
			<input type="submit" value="Ir para votação" />
		</p>
	</form>
</body>
</html>
