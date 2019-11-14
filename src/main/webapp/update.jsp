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
		
Nome:      <input type="text" name="nome"
				value='<s:property value="nome"/>'>
						
CPF:       <input type="text" name="cpf"
				value='<s:property value="cpf"/>'>
		
Idade:     <input type="text" name="idade"
				value='<s:property value="idade"/>'>
			
Data:      <input type="text" name="data"
				value='<s:property value="data"/>'>

Hora:      <input type="text" name="hora"
				value='<s:property value="hora"/>'>

Descrição: <input type="text" name="descricao"
				value='<s:property value="descricao"/>'>
		
           <input hidden type="text" name="id"
				value='<s:property value="id"/>'>
           
		<button name="submitType" value="update" type="submit">Atualizar</button>
		</pre>
	</form>
	<s:if test="rows>=0">
		<span style="color: red;"><s:property value="response" /></span>
	</s:if>
</body>
</html>