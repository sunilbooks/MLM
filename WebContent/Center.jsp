<%@page import="com.sunrays.javarefbook.mlm.model.CenterModel"%>
<html>
<body>
<p class="title"align="center">Center Detail</p>
	<%
		CenterModel centerModel = null;
		centerModel = (CenterModel) request.getAttribute("getRecord");
		if (centerModel == null) {
			centerModel = new CenterModel();
		}
	%>

	<form action="CenterCtl.do" method="post">
		<table align="center">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id"
					value="<%=centerModel.getId()%>"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type="text" name="name"
					value="<%=centerModel.getName()%>" /></td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><input type="text" name="address"
					value="<%=centerModel.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>PERMISION ID</td>
				<td><input type="text" name="permissionId"
					value="<%=centerModel.getPermissionId()%>" /></td>
			</tr>
			<tr>
				<td>PHONE NO</td>
				<td><input type="text" name="phoneNo"
					value="<%=centerModel.getPhoneNo()%>" /></td>
			</tr>

			<tr>
			<tr>
				<td>LOGIN</td>
				<td><input type="text" name="loginId"
					value="<%=centerModel.getLoginId()%>" />
			<tr>
				<td>PASSWORD</td>
				<td><input type="text" name="password"
					value="<%=centerModel.getPassword()%>" /></td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td><input type="submit" name="operation" value="Save" /></td>


				<td><input type="submit" name="operation" value="update" /></td>


		</table>

	</form>
</body>
</html>