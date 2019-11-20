<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Gerenciador de Exames - Inserir exame</title>
	<style type="text/css">
		.button-create {
			background-color: green;
			color: white;
		}
		.button-read {
			background-color: #000000;color: white;
			margin-bottom: 10px;
		}
		.errorMessage {
			color: red;
		}
	</style>
</head>
<body>
	<div>
		<h2>Novo exame</h2>
		
		<a href="listar.action">
			<button class="button-read" type="button">Listar</button>
		</a>
		
		<s:form action="create.action" method="post">
		
			<s:textfield label="Data" name="exame.data" />
			<s:textfield label="E-mail" name="exame.email" />
			<s:textfield label="Nome completo" name="exame.nome" />
			<s:textfield label="Idade" name="exame.idade" />
			<s:textfield label="Telefone" name="exame.telefone" />
			<s:textfield label="CPF" name="exame.cpf" />	
			<s:textfield label="Descricao" name="exame.descricao" />
			
			<s:submit cssClass="button-create" value="Create" />
		</s:form>
	</div>
</body>
</html>