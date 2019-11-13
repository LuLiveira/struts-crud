<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Update</title>
</head>
<body>
	<h2>Struts 2 Create, Read, Update and Delete (CRUD) Example using JDBC</h2>
	<a href="read"><button class="button-read" type="button">Read</button></a>
	<form action=update method="post">
		<pre>
		
		<b>Name:         </b><input type="text" name="id" value='<s:property value="id"/>'>
		
<b>Name:         </b><input type="text" name="nome" value='<s:property value="nome"/>'>
		
		
<b>Email:        </b><input type="text"  name="cpf" value='<s:property value="cpf"/>'>
		
<b>Password:     </b><input type="text" name="idade" value='<s:property value="idade"/>'>
		
		
<b>Designation:  </b><input type="text" name="data" value='<s:property value="data"/>'>

<b>Designation:  </b><input type="text" name="hora" value='<s:property value="hora"/>'>

<b>Designation:  </b><input type="text" name="descricao" value='<s:property value="descricao"/>'>
		
		<button name="submitType" value="update" type="submit">Update</button>
		</pre>
	</form>
	<s:if test="rows>0">
		<span style="color: red;"><s:property value="response" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="response" /></span>
	</s:else>
</body>
</html>