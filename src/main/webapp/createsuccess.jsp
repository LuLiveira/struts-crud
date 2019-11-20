<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<style type="text/css">
.button-read {
	background-color: #000000;
	color: white;
	margin-top: 10px
}
</style>
<meta charset="UTF-8">
<title>Gerenciador de Exames - Criar exame</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="background: #c8c8c8;">

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/struts/create.jsp">Exames</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Alterna navegação">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link active" href="listar.action">Listar</a>
				<a class="nav-item nav-link disabled" href="/struts/login.jsp">Logout</a>
			</div>
		</div>
	</nav>

	<div style="margin: 15px;">
		<h3>
			<s:text name="criado" />
		</h3>

		<h2>
			Verifique as informações presentes no seu exame: <br />
		</h2>
		<s:text name="label.nome" />
		<br />

		<s:text name="label.idade" />
		<br />

		<s:text name="label.email" />
		<br />

		<s:text name="label.cpf" />
		<br /> 

		<s:text name="label.telefone" />
		<br /> 

		<s:text name="label.data">
			<s:param name="value" value="exame.data" />
		</s:text>
		<br />

		<s:text name="label.descricao" />


		<br /> <br /> <span style="color: red"> Importante... </span>
		<p style="display: inline; text-decoration: underline">caso exista
			alguma informação incorreta não se preocupe! Você podera alterar.</p>
	</div>
</body>
</html>