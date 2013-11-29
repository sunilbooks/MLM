<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.sunrays.javarefbook.mlm.model.OrganizationModel"%>
<html>
</head>
<body>
	<h2>Organization List</h2>
	<%
		OrganizationModel organizationModel = new OrganizationModel();
	%>
	<form action="OrganizationCtl.do">

		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>

				<th>Address</th>
				<th>Phone No</th>
				<th>Fax No</th>
				<th>E_Mail</th>
				<th>URL</th>
				<th>logo</th>


			</tr>
			<%
				List list = (List) request.getAttribute("List");
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					organizationModel = (OrganizationModel) iterator.next();
			%>

			<tr>
				<td><input type="checkbox" name="checkbox"
					value=<%=organizationModel.getId()%> /></td>



				<td><input type="text" value=<%=organizationModel.getName()%> /></td>

				<td><input type="text"
					value=<%=organizationModel.getAddress()%> /></td>

				<td><input type="text"
					value=<%=organizationModel.getPhoneNo()%> /></td>
				<td><input type="text" value=<%=organizationModel.getFaxNo()%> /></td>
				<td><input type="text" value=<%=organizationModel.getEmail()%> /></td>
				<td><input type="text" value=<%=organizationModel.getUrl()%> /></td>

				<td><input type="text" value=<%=organizationModel.getLogo()%> /></td>
				<td><a href="OrganizationCtl?id=<%=organizationModel.getId()%>&operation=Get">Edit</a></td>


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