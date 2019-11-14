<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Create</title>
<style type="text/css">
.button-create {background-color: green;color: white;}
.button-read {background-color: #000000;color: white;margin-left: 30%;}
</style>
</head>
<body>
	<div>
		<h2>Create Exames</h2>
		<a href="listar.action"><button class="button-read" type="button">Read</button></a>
		<s:form action="create.action" method="post">
		
			<s:textfield label="Nome" name="nome" />
			<s:textfield label="Idade" name="idade" />
			<s:textfield label="CPF" name="cpf" />
			<s:textfield label="Data" name="data" />
			<s:textfield label="Hora" name="hora" />
			<s:textfield label="Descricao" name="descricao" />
			
			<s:submit cssClass="button-create" value="Create" />
		</s:form>
		<s:if test="rows>0">
			<span style="color: green;"><s:property value="response" /></span>
		</s:if>
		<s:else>
			<span style="color: red;"><s:property value="response" /></span>
		</s:else>
	</div>
</body>
</html>