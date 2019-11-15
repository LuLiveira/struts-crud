<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>Exames</title>
	<link rel="stylesheet" type="text/css" href="./styles/styles.css">
	<style>
	</style>
</head>
<body>
	<div class="container">
		<h3>Lista de Exames</h3>
		
		<a href="create.jsp"><button class="button-read" type="button"><s:text name="novo" /></button></a>
		
		
		<div style="margin-top: 40px;">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>#</th>
						<th>Nome</th>
						<th>Telefone</th>
						<th>E-mail</th>
						<th>CPF</th>
						<th>Idade</th>
						<th>Data</th>
						<th>Hora</th>
						<th>Descri��o</th>
						<th>Action</th>
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
						<td><s:property value="data" /></td>
						<td><s:property value="hora" /></td>
						<td><s:property value="descricao" /></td>
						
						<td>
							<a href="exame.action?id=<s:property value="id"/>">
								<button class="button-update">Update</button>
							</a>
							<a href="delete.action?id=<s:property value="id"/>">
								<button class="button-delete">Delete</button>
							</a>
						</td>

					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</body>
</html>