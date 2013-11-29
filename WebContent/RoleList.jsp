<%@page import="com.sunrays.javarefbook.mlm.model.RoleModel"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<html>
<body>

	<h1 align="center">Role List</h1>
	<%
		RoleModel roleModel = new RoleModel();
	%>
	<form action="RoleCTL.do">
		<table border="3" align="center">


			<tr>

				<th>ID</th>
				<th>Name</th>

			</tr>
			<%
				List list = (List) request.getAttribute("List");
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					roleModel = (RoleModel) iterator.next();
			%>


			<tr>
				<td><input type="checkbox" name="checkbox"
					value=<%=roleModel.getId()%>></td>



				<td><input type="text" value=<%=roleModel.getName()%> /></td>

				<td><a href="RoleCtl.do?id=<%=roleModel.getId()%>&operation=Get">Edit</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<br />

		<table align="center">
			<tr>
				<td><input type="submit" name="operation" value="Delete" /></td>
			</tr>


		</table>
	</form>
</body>
</html>