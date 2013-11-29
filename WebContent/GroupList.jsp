<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.sunrays.javarefbook.mlm.model.GroupModel"%>
<html>
</head>
<body>
	<h1 align="center">Group List</h1>
	<%
		GroupModel groupModel = new GroupModel();
	%>
	<form action="GroupListCtl.do" method="post">
		<table border="1">

			<tr>

				<th>Id</th>
				<th>Group Id</th>
				<th>User Id</th>
				<th>No Of Id</th>

			</tr>
			<%
				List list = (List) request.getAttribute("List");
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					groupModel = (GroupModel) iterator.next();
			%>

			<tr>

				<td><input type="checkbox" name="checkbox"
					value=<%=groupModel.getId()%> /></td>


				<td><input type="text" value=<%=groupModel.getGroupId()%> /></td>

				<td><input type="text" value=<%=groupModel.getUserId()%> /></td>
				<td><input type="text" value=<%=groupModel.getNoOfId()%> /></td>

				<td><a href="GroupCtl.do?id=<%=groupModel.getId()%>&operation=Get">Edit</a></td>
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