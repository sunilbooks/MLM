<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.sunrays.javarefbook.mlm.model.CenterModel"%>
<html>
<body>


	<p class="title" align="center">Center Detail List</p>
	<form action="CenterListCtl.do" method="post">
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone No</th>
				<th>Login Id</th>
				<th>Password</th>
				<th>Permission Id</th>

			</tr>
			<%
				List list = (List) request.getAttribute("centerList");
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					CenterModel centerModel = (CenterModel) iterator.next();
			%>
			<tr>

				<td><input type="checkbox" name="ids"
					value=<%=centerModel.getId()%> /></td>
				<td><input type="text" value=<%=centerModel.getName()%> /></td>

				<td><input type="text" value=<%=centerModel.getAddress()%>></td>
				<td><input type="text" value=<%=centerModel.getPhoneNo()%>></td>
				<td><input type="text" value=<%=centerModel.getPermissionId()%>></td>

				<td><input type="text" value=<%=centerModel.getLoginId()%>></td>
				<td><input type="text" value=<%=centerModel.getPassword()%>></td>

				<td><a
					href="CenterCtl.do?id=<%=centerModel.getId()%>&operation=Get">Edit</a></td>
				<%
					}
				%>
			
		</table>
		

		<table>
			<tr>
				<td><input type="submit" name="operation" value="Delete" /></td>

			</tr>


		</table>
	</form>
</body>
</html>