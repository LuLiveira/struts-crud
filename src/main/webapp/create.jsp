<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Gerenciador de Exames - Novo exame</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<style>
	.form-cadastro {
		width: 600px;
	}
	.errorMessage {
		color: red;
	}
</style>
<body style="background: #c8c8c8">

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

	<div style="margin-top: 10px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<h2>Cadastro de Exames</h2>

		<s:form cssClass="form-cadastro" action="create.action" method="post">

			<s:textfield cssClass="form-group form-control" label="Nome completo" name="exame.nome" />
			<s:textfield cssClass="form-group form-control" label="CPF" name="exame.cpf" />
			<s:textfield cssClass="form-group form-control" label="E-mail" name="exame.email" />
			<s:textfield cssClass="form-group form-control" label="Idade" name="exame.idade" />
			<s:textfield cssClass="form-group form-control" label="Telefone" name="exame.telefone" />
			<s:textfield cssClass="form-group form-control" label="Data" name="exame.data" />
			<s:textarea cssClass="form-group form-control" label="Descricao" name="exame.descricao" />

			<s:submit cssClass="btn btn-success" value="Cadastrar" />
		</s:form>
	</div>
</body>
</html>