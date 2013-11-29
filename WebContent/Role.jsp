
<%@page import="com.sunrays.javarefbook.mlm.model.RoleModel"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />

</head>
<body>
<p class="title"align="center">Role</p>
	<%
		RoleModel roleModel = null;
		roleModel = (RoleModel) request.getAttribute("get");
		if (roleModel == null) {
			roleModel = new RoleModel();

		}
	%>

	<form action="RoleCtl.do" method="post">
		<table border="1" align=center>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value=<%=roleModel.getId()%>></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"
					value=<%=roleModel.getName()%>></td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td><input type="submit" name="operation" value="Save" /></td>
				<td><input type="submit" name="operation" value="Update" /></td>
			</tr>
		</table>
	</form>
</body>
</html>