<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote no Livro - Math</title>
<link href="<c:url value="/resources/css/bootstrap.3.0.2.min.css" />"
	rel="stylesheet">
</head>
<body>
	<br />
	<div class="container">
		<div class="row">
			<div class="form-group col-xs-5 col-lg-5">
				<form method="post" action="votacao" id="form">
					<p>Escolha seu livro preferido dentre as duas opções abaixo:</p>
					<table cellpadding="10">
						<tr>
							<td><c:url value="/resources/images/${livro1}.jpg"
									var="imagem1" /> <img id='livro1' src='${imagem1}'
								name='${livro1}' style='cursor: pointer;'
								onclick='enviaLivro1()' /></td>
							<td><c:url value="/resources/images/${livro2}.jpg"
									var="imagem2" /> <img id='livro2' src='${imagem2}'
								name='${livro2}' style='cursor: pointer;'
								onclick='enviaLivro2()' /></td>
						</tr>
					</table>
					<input type="hidden" id="livroEscolhido" name="livroEscolhido" />
				</form>
			</div>
		</div>
	</div>
	<script>
		function enviaLivro1() {
			document.getElementById('livroEscolhido').value = document
					.getElementById('livro1').name;
			document.getElementById('form').submit();
		}
		function enviaLivro2() {
			document.getElementById('livroEscolhido').value = document
					.getElementById('livro2').name;
			document.getElementById('form').submit();
		}
	</script>
</body>
</html>
