<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gerenciador de Exames - Login</title>
	</head>
	<body>
	
		<h1>Login</h1>
		
		<s:actionerror/>
		
		<s:form action="login.action" method="POST">
		
			<s:textfield label="Usuario" name="usuario"  />
			<s:password label="Senha" name="senha"  />
			
			<s:submit method="authenticate" align="center" value="Logar"/>
			
		</s:form>
	
	</body>
</html>