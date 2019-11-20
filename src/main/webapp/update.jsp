
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<title>Gerenciador de Exames - Atualizar exame</title>

<style>
.errorMessage {
	color: red;
}
.form-update {
	width: 600px;
}
</style>
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

	<div style="margin: 15px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<h2>Atualizando Exame</h2>

		<s:form cssClass="form-update" action="update.action" method="post">

			<s:textfield cssClass="form-group form-control" label="Nome"
				name="exame.nome" />

			<s:textfield cssClass="form-group form-control" label="CPF"
				name="exame.cpf" />

			<s:textfield cssClass="form-group form-control" label="E-mail"
				name="exame.email" />

			<s:textfield cssClass="form-group form-control" label="Idade"
				name="exame.idade" />

			<s:textfield cssClass="form-group form-control" label="Telefone"
				name="exame.telefone" />

			<s:textfield cssClass="form-group form-control" label="Data/Hora"
				name="exame.data" value="%{getText('format.date',{exame.data})}" />

			<s:textarea cssClass="form-group form-control" label="Descricao"
				name="exame.descricao" />

			<s:hidden label="Id" name="exame.id" />


			<s:submit cssClass="btn btn-secondary" value="Atualizar exame" />
		</s:form>
	</div>
</body>
</html>