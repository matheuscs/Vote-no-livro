<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<P>The time on the server is ${serverTime}.</P>
	<form method=GET action="votacao">
		<p>
			<input type="submit" value="Pressione aqui para ir para outra pagina" />
		</p>
	</form>
</body>
</html>
