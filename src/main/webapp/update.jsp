
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Gerenciador de Exames - Atualizar exame</title>
	
		<style>
			.button-read {
				margin-bottom: 10px;
				background-color: #000000;
				color: white;
				margin-bottom: 10px;
			}
			.button-create {
				background-color: green;
				color: white;
			}
			.errorMessage {
				color: red;
			}
		</style>
	</head>
	<body>
		<h2>Atualizando Exame</h2>
		<a href="listar.action">
			<button class="button-read" type="button">Listar</button>
		</a>
		
		<s:form action="update.action" method="post">
					
			<s:textfield label="Data/Hora" name="exame.data" />
			<s:textfield label="E-mail" name="exame.email" />
			<s:textfield label="Nome" name="exame.nome" />
			<s:textfield label="Idade" name="exame.idade" />
			<s:textfield label="Telefone" name="exame.telefone" />
			<s:textfield label="CPF" name="exame.cpf" />	
			<s:textfield label="Descricao" name="exame.descricao" />
			
			<s:hidden label="Id" name="exame.id" />
	
	           
			<s:submit cssClass="button-create" value="Atualizar exame" />
		</s:form>
	</body>
</html>