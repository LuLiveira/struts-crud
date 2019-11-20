<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Gerenciador de Exames - Remover exame</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
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
		<h2>
			<s:text name="header" />
		</h2>
		<span> <s:text name="deletado" />
		</span>
	</div>
</body>
</html>