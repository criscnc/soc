<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Exames</title>
</head>

<body>
	<h2>Lista de Exames</h2>

	<fieldset>
		<table width="100%" border="1px">

			<tr>
				<th align="left">Paciente</th>
				<th align="left">Exame</th>
				<th align="left">Data</th>
				<th align="left">Observação / Resultado</th>
			</tr>

			<s:iterator value="listarExames">
				<tr>
					<td align="left" width="30%" height="20%"><s:property
							value="nomePaciente" /></td> 

					<td align="left" width="30%"><s:property value="nomeExame" /></td>

					<td align="center" width="10%"><s:property value="dtExame" /></td>

					<td align="left" width="30%"><s:property value="obs" /></td>
				</tr>
			</s:iterator>
		</table>
	</fieldset>

	<br />
	<br />

	<s:a href="Exame.jsp"> <<<<==== VOLTAR</s:a>
</body>
</html>