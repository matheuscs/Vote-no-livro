<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
	<form method=GET action="votacao" id="form">
		<p>Escolha seu livro preferido dentre as opções abaixo:</p>
		<table>
			<tr>
				<td>
					<c:url value="/resources/images/${livro1}.jpg" var="imagem1" />
					<img id='livro1' src='${imagem1}' name='${livro1}' style='cursor: pointer;' />
				</td>
				<td>
					<c:url value="/resources/images/${livro2}.jpg" var="imagem2" />
				    <img id='livro2' src='${imagem2}' name='${livro2}' style='cursor: pointer;' />
				</td>
			</tr>
		</table>
		<input type="hidden" name="livroEscolhido" />
	</form>
	<script>
	$(document).ready(function(){
		$("#livro1").click(function(){
			$('input[name=livroEscolhido]').val($('#livro1')[0].name);
		    $("#form").submit();
		});
		$("#livro2").click(function(){
			$('input[name=livroEscolhido]').val($('#livro2')[0].name);
		    $("#form").submit();
		});
	});
	</script>
</body>
</html>
