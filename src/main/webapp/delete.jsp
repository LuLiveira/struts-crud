<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Gerenciador de Exames - Remover exame</title>
		<style>
			.return {
				background-color: #000000;color: white;
				margin-bottom: 10px;
			}
		</style>
	</head>
	<body>
		<h2><s:text name="header" /></h2>
		<span>
			<s:text name="deletado" />
		</span>
		<br><br>
		<a href="listar.action">
			<button class="return" type="button"><s:text name="listar" /></button>
		</a>
	</body>
</html>