
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Update</title>
</head>
<body>
	<h2>Atualizando Exame</h2>
	<a href="listar.action"><button class="button-read" type="button">Listar</button></a>
	<form action=update.action method="post">
		<pre>	
		
Nome:        <input type="text" name="exame.nome"
				value='<s:property value="exame.nome"/>'>
				
Telefone:    <input type="text" name="exame.telefone"
				value='<s:property value="exame.telefone"/>'>
				
E-mail:      <input type="text" name="exame.email"
				value='<s:property value="exame.email"/>'>
						
CPF:         <input type="text" name="exame.cpf"
				value='<s:property value="exame.cpf"/>'>
		
Idade:       <input type="text" name="exame.idade"
				value='<s:property value="exame.idade"/>'>
			
Data:        <input type="date" name="exame.data"
				value='<s:property value="exame.data"/>'>

Hora:        <input type="text" name="exame.hora"
				value='<s:property value="exame.hora"/>'>

Descrição:   <input type="text" name="exame.descricao"
				value='<s:property value="exame.descricao"/>'>
		
           <input hidden type="text" name="id"
				value='<s:property value="exame.id"/>'>
           
		<button name="submitType" value="update" type="submit">Atualizar</button>
		</pre>
	</form>
</body>
</html>