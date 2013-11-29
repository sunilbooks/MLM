<%@page import="com.sunrays.javarefbook.mlm.model.OrganizationModel"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />

</head>

<body>
	<h2 align="center">Organization</h2>
	<%
		OrganizationModel organizationModel = null;
		organizationModel = (OrganizationModel) request.getAttribute("get");
		if (organizationModel == null) {
			organizationModel = new OrganizationModel();

		}
	%>

	<form action="OrganizationCtl.do" method="post">
		<table border="1" align="center">
			<tr>
				<td>id</td>
				<td><input type="text" name="id"
					value=<%=organizationModel.getId()%>></td>
			</tr>

			<tr>
				<td>Name</td>
				<td><input type="text" name="name"
					value=<%=organizationModel.getName()%>></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"
					value=<%=organizationModel.getAddress()%>></td>
			</tr>
			<tr>
				<td>phone no</td>
				<td><input type="text" name="phoneNo"
					value=<%=organizationModel.getPhoneNo()%>></td>
			</tr>
			<tr>
				<td>Fax No</td>
				<td><input type="text" name="faxNo"
					value=<%=organizationModel.getFaxNo()%>></td>
			</tr>
			<tr>
				<td>E Mail</td>
				<td><input type="text" name="email"
					value=<%=organizationModel.getEmail()%>></td>
			</tr>

			<tr>
				<td>URL</td>
				<td><input type="text" name="url"
					value=<%=organizationModel.getUrl()%>></td>
			</tr>
			<tr>
				<td>Logo</td>
				<td><input type="text" name="logo"
					value=<%=organizationModel.getLogo()%>></td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td><input type="submit" name="operation" value="Save">
				</td>
				<td><input type="submit" name="operation" value="Update">

				</td>
			</tr>
		</table>

	</form>
</body>
</html>