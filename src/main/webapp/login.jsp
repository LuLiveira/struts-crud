<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gerenciador de Exames - Login</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>

.errorMessage {
	color: red;
}

body {
	height: 100vh;
	background: #c8c8c8;
}
</style>

<body>

	<div style="display: flex; flex-direction: column; align-items: center; justify-content: center; height: 60%">

		<h1>Login</h1>

		<s:actionerror/>


		<s:form cssClass="login-form" action="login.action" method="POST">

			<s:textfield cssClass="form-control" label="Usuario" name="usuario" />
			<s:password cssClass="form-control" label="Senha" name="senha" />

			<s:submit cssClass="btn btn-success" method="authenticate" value="Entrar" />

		</s:form>

	</div>
</body>
</html>