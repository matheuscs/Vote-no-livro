<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Vote no Livro - Math</title>
<link href="<c:url value="/resources/css/bootstrap.3.0.2.min.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="form-group col-xs-5 col-lg-5">
				<h1>Olá</h1>
				<P>Que tal participar da nossa votação e nos dizer quais são
					seus livros favoritos da lista?</P>
				<form method="post" action="votacao">
					<p>
						<input type="submit" value="Ir para votação" />
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
