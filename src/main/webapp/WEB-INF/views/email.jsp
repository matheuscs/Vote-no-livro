<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote no Livro - Math</title>
<link href="<c:url value="/resources/js/bootstrap.3.1.1.min.js" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.3.0.2.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.3.1.1.min.js" />"></script>
</head>

<body>
	<br />
	<div class="container">
		<form method="post" action="ranking" role="form" id="email-form">
			<div class="row">
				<div class="form-group col-xs-5 col-lg-5">
					<p>Obrigado por votar! Para verificar o ranking dos livros mais
						votados e o seu resultado, preencha nome e email abaixo e clique
						em Enviar.</p>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-xs-5 col-lg-3">
					<label class="control-label" for="email">Email</label> <input
						type="email" id="email" placeholder="Digite seu email"
						class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-xs-5 col-lg-3">
					<label class="control-label" for="name">Nome</label> <input
						type="text" id="name" placeholder="Digite seu nome"
						class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-xs-5 col-lg-1">
					<input type="submit" value="Enviar" />
				</div>
			</div>
		</form>
	</div>
</body>
<script>
	$(document).ready(
			function() {
				$('#email-form').validate(
						{
							rules : {
								name : {
									minlength : 2,
									required : true
								},
								email : {
									required : true,
									email : true
								},
								message : {
									minlength : 2,
									required : true
								}
							},
							highlight : function(element) {
								$(element).closest('.control-group')
										.removeClass('success').addClass(
												'error');
							},
							success : function(element) {
								element.text('OK!').addClass('valid').closest(
										'.control-group').removeClass('error')
										.addClass('success');
							}
						});

			});
</script>
</html>