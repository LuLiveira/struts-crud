<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<style type="text/css">
			.button-read {
				background-color: #000000;
				color: white; 
				margin-top: 10px
			}
		</style>
		<meta charset="UTF-8">
		<title>Gerenciador de Exames - Criar exame</title>
	</head>
	<body>
		<h3><s:text name="criado" /></h3>
		
		<h2>Verifique as informações presentes no seu exame: <pre> <s:property value="exame" /> </pre> </h2>
		
		<span style="color: red"> Importante...  </span> <p style="display: inline; text-decoration: underline"> caso exista alguma informação incorreta não se preocupe! Você pode alterar na próxima tela. </p>
		
		<br/>
		<a href="listar.action"><button class="button-read" type="button"><s:text name="listar" /></button></a>	
	</body>
</html>