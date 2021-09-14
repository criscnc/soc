<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>Cadastro de Exames</title>
</head>

<body>
	<h2>Cadastrar Exame</h2>
	<s:actionerror />
	<s:form action="exame.action" method="post">

		<div>
			<s:textfield name="nomePaciente" key="label.nomePaciente" size="100" required="true" />
		</div>

		<div>
			<s:textfield name="nomeExame" key="label.nomeExame" size="100" required="true" />
		</div>

		<div>		
			<s:textfield name="dtExame" key="label.dtExame" size="100" required="true" />
		</div>

		<div>
			<s:textfield name="obs" key="label.obs" size="100" />
		</div>

		<div>
			<s:submit method="buscarExame" key="label.buscar.exame" />
			<s:submit method="adicionarExame" key="label.adiciona.exame" />
			<s:submit method="alterarExame" key="label.alterar.exame" />
			<s:submit method="excluirExame" key="label.excluir.exame" />
			<s:submit method="limparExame" key="label.limpar.exame" />
			<s:submit method="listarExames" key="label.listar.exame" />
		</div>
	</s:form>

</body>
</html>

