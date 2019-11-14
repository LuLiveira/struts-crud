<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Struts 2 - Login Screen</title>
</head>
<body>

	<h1>Login</h1>
	
	<s:actionerror/>
	
	<s:form action="create.jsp" method="POST">
	
		<s:textfield label="Usuario" name="username" key="label.username" size="20" />
		<s:password label="Senha" name="password" key="label.password" size="20" />
		
		<s:submit method="authenticate" key="label.login" align="center" value="Logar"/>
		
	</s:form>

</body>
</html>