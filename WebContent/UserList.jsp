<%@page import="com.sunrays.javarefbook.mlm.model.UserModel"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<html>
<head>
		<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />

	</head>

<body>
	<h1 align="center">User List</h1>
	<form action="UserCtl.do">
		<%
			UserModel userModel = new UserModel();
		%>

		<table border="1">
			<tr>
				<!-- 1 -->
				<th>Member ID</th>
				<!-- 2 -->
				<th>Firstname</th>
				<!-- 3 -->
				<th>LastName</th>
				<!-- 4 -->
				<th>Date Of Birth</th>
				<!-- 5 -->
				<th>User Id</th>
				<!-- 6 -->
				<th>User Password</th>
				<!-- 7 -->
				<th>Address</th>
				<!-- 8 -->
				<th>Gender</th>
				<!-- 9 -->
				<th>Role Name</th>
				<!-- 10 -->
				<th>phone No</th>
				<!-- 11-->
				<th>Organization</th>
				<!-- 12 -->
				<th>Center Id</th>
				<!-- 13 -->
				<th>Center Name</th>
				<!-- 14 -->
				<th>Referred By Id</th>
				<!-- 15 -->
				<th>Referred By Name</th>
				<!-- 16 -->
				<th>Plan Id</th>
				<!-- 17 -->
				<th>Plan Name</th>

			</tr>
			<%
				List list = (List) request.getAttribute("List");
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					userModel = (UserModel) iterator.next();
			%>

			<tr>
				<!-- 1 -->
				<td><input type="checkbox" name="checkbox"
					value="<%=userModel.getId()%>" /></td>
				<!-- 2 -->
				<td><input type="text" value=<%=userModel.getFirstName()%> /></td>
				<!-- 3 -->
				<td><input type="text" value=<%=userModel.getLastName()%> /></td>
				<!-- 4 -->
				<td><input type="text" value=<%=userModel.getDateOfBirth()%> /></td>
				<!-- 5 -->
				<td><input type="text" value=<%=userModel.getUserid()%> /></td>
				<!-- 6 -->
				<td><input type="text" value=<%=userModel.getUserPassword()%> /></td>
				<!-- 7 -->
				<td><input type="text" value=<%=userModel.getAddress()%> /></td>
				<!-- 8 -->
				<td><input type="text" value=<%=userModel.getGender()%> /></td>
				<!-- 9 -->
				<td><input type="text" value=<%=userModel.getRoleName()%> /></td>
				<!-- 10 -->
				<td><input type="text" value=<%=userModel.getTelephonNo()%> /></td>
				<!-- 11 -->
				<td><input type="text" value=<%=userModel.getOrganization()%> /></td>
				<!-- 12 -->
				<td><input type="text" value=<%=userModel.getCenterId()%> /></td>
				<!-- 13-->
				<td><input type="text" value=<%=userModel.getCenterName()%> /></td>
				<!-- 14-->
				<td><input type="text" value=<%=userModel.getReferredById()%> /></td>
				<!-- 15 -->
				<td><input type="text" value=<%=userModel.getReferredByName()%> /></td>
				<!-- 16 -->
				<td><input type="text" value=<%=userModel.getPlanId()%> /></td>
				<!-- 17 -->
				<td><input type="text" value=<%=userModel.getPlanName()%> /></td>

				<td><a href="UserCtl.do?id=<%=userModel.getId()%>&operation=Get">Edit</a></td>


			</tr>
			<%
				}
			%>
		</table>
		<br />
		<table>
			<tr>
				<td><input type="submit" name="operation" value="Delete" /></td>

			</tr>

		</table>
	</form>
</body>
</html>