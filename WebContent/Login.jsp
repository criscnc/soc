<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Login</title>
</head>

<body>
	<h2>Login</h2>
	<s:actionerror />
	<s:form action="login.action" method="post">
		<s:textfield name="usuario" key="label.usuario" size="20" />
		<s:password name="senha" key="label.senha" size="20" />
		<s:submit method="execute" key="label.login" align="center" />
	</s:form>
</body>
</html>