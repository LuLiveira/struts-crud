<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Exames</title>
<style>
table, td, th {border: 1px solid black;}
table {border-collapse: collapse;width: 60%;}
th {height: 30px;}
.button-update {background-color: #008CBA;color: white;}
.button-delete {background-color: red;color: white;}
</style>
</head>
<body>
	<h2>Lista de Exames</h2>
	<div style="margin-top: 40px;">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>Id</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>Idade</th>
						<th>Data</th>
						<th>Hora</th>
						<th>Descrição</th>
						<th>Action</th>
					</tr>
				</thead>
				<s:iterator value="exameList">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="nome" /></td>
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
</body>
</html>