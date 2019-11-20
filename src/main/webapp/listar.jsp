<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<title>Gerenciador de Exames - Listar exames</title>

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

	<div style="margin: 40px;">

		<h1 style="text-align: center;">Lista de Exames</h1>

		<a href="create.jsp"><button class="btn btn-secondary"
				type="button" style="margin-bottom: 10px;">
				<s:text name="novo" />
			</button></a>

		<table class="table table-bordered table-secondary">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nome</th>
					<th scope="col">Telefone</th>
					<th scope="col">E-mail</th>
					<th scope="col">CPF</th>
					<th scope="col">Idade</th>
					<th scope="col">Data/Hora</th>
					<th scope="col">Descrição</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<s:iterator value="exameList">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="nome" /></td>
					<td><s:property value="telefone" /></td>
					<td><s:property value="email" /></td>
					<td><s:property value="cpf" /></td>
					<td><s:property value="idade" /></td>
					<td><s:date name="data" format="dd/MM/yyyy hh:mm" /></td>
					<td><s:property value="descricao" /></td>

					<td><a href="exame.action?id=<s:property value="id"/>">
							<button class="btn btn-primary">Atualizar</button>
					</a> <a href="delete.action?id=<s:property value="id"/>">
							<button class="btn btn-danger">Remover</button>
					</a></td>

				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>