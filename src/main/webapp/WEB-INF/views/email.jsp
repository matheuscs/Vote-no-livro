<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote no Livro - Math</title>
<link
	href="<c:url value="/resources/js/bootstrap.3.1.1.min.js" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.3.0.2.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/estilo.css" />" rel="stylesheet">

<script src="<c:url value="/resources/js/jquery.1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.3.1.1.min.js" />"></script>
</head>
<body>
	<form id="emailForm" method=GET action=ranking>

		<div class="container">
			<p>Obrigado por votar! Para verificar o ranking dos livros mais
				votados e o seu resultado, preencha nome e email abaixo e clique em
				Enviar.</p>
			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" placeholder="Digite seu email">
			</div>
			<div class="form-group">
				<label for="name">Nome</label> <input type="text"
					class="form-control" id="name" placeholder="Digite seu nome">
			</div>
			<input type="submit" value="Enviar"/>
		</div>
	</form>
</body>
<script>
$(document).ready(function() {
	alert('sdf');
    $('.registerForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The username is required and cannot be empty'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'The username can only consist of alphabetical, number and underscore'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email is required and cannot be empty'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            }
        }
    });
});
</script>
</html>