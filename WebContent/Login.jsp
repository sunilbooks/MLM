<html>

<body>



	<form action="LoginCtl">
		<%
			String message = (String) request.getAttribute("message");
			String msg = (String) session.getAttribute("msg");
			if (message != null) {
		%>
		<b> <%=message%>
		</b>
		<%
			}
		%>
		<table align="center">
			<tr>
				<td>UserName</td>

				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>Password</td>

				<td><input type="password" name="userPassword"></td>
			</tr>

			<tr>
				<td><input type="submit" name="operation" value="Login">
				<td>
		</table>
	</form>
</body>
</html>