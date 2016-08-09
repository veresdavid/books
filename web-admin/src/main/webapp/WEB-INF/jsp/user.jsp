<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<h2>Create user</h2>

	<form:form method="POST" commandName="user" action="create">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<div>${message}</div>
		<table>
			<tr>
				<td>Full name :</td>
				<td><form:input path="fullName" /></td>
				<td><form:errors path="fullName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Login name :</td>
				<td><form:input path="loginName" /></td>
				<td><form:errors path="loginName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="password" type="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>