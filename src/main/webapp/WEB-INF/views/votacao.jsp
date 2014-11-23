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
	<form method=GET action="votacao" id="form">
		<p>Escolha seu livro preferido dentre as opções abaixo:</p>
		<table>
			<tr>
				<td><a href="javascript:clickLivro('${livro1}');"> <c:url
							value="/resources/images/${livro1}.jpg" var="imagem1" /> <img
						src="${imagem1}" />
				</a></td>
				<td><a href="javascript:clickLivro('${livro2}');"> <c:url
							value="/resources/images/${livro2}.jpg" var="imagem2" /> <img
						src="${imagem2}" />
				</a></td>
			</tr>
		</table>
		<input type="hidden" name="livroEscolhido"/>
	</form>
	<script>
		function clickLivro(livro) {
			form.livroEscolhido.value = (livro);
			form.submit();
		}
	</script>
</body>
</html>
