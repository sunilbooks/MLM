<%@page import="com.sunrays.javarefbook.mlm.model.UserModel"%>
<script language="javascript" type="text/javascript"
	src="datetimepicker.js"></script>

<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />

</head>
<body>

	<p class="title">
		<font size="14">User Registration</font>
	</p>
	<%
		UserModel userModel = null;
		userModel = (UserModel) request.getAttribute("get");
		if (userModel == null) {
			userModel = new UserModel();

		}
	%>


	<form action="UserCtl.do" method="post">
		<table align="center">
			<tr>
				<td>MemberID</td>
				<td><input type="text" name="id" value="<%=userModel.getId()%>" /></td>
			</tr>





			<td>First Name</td>
			<td><input type="text" name="firstName"
				value="<%=userModel.getFirstName()%>" />
			<tr>
				<td>Last name</td>
				<td><input type="text" name="lastName"
					value="<%=userModel.getLastName()%>" />
			<tr>
				<td>userId</td>
				<td><input type="text" name="userId"
					value="<%=userModel.getUserid()%>" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="userPassword"
					value="<%=userModel.getUserPassword()%>"></td>
			</tr>




			<!-- <tr>
				<td>Date Of Birth</td>
				<td><input id="demo1" type="text" size="25"><a
					href="javascript:NewCal('demo1','ddmmyyyy')"><img
						src="images/cal.gif" width="16" height="16" border="0"
						alt="Pick a date"></a></td>
			</tr> -->
			<tr>
				<td>Address</td>
				<td><input type="textarea" name="address"
					value="<%=userModel.getAddress()%>"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male">Male<br>
					<input type="radio" name="gender" value="female">Female</td>
			</tr>
			<tr>
			<tr>
				<td>Role</td>
				<td><input type="text" name="roleName"
					value="<%=userModel.getRoleName()%>"></td>
			</tr>


			<tr>
				<td>Organization</td>
				<td><select name="organization"
					value="<%=userModel.getOrganization()%>">
						<option value="volvo">Volvo</option>
						<option value="saab">Saab</option>
						<option value="mercedes">Mercedes</option>
						<option value="audi">Audi</option></td>
			</tr>
			<tr>
				<td>Center ID</td>
				<td><select name="centerId"
					value="<%=userModel.getCenterId()%>">
						<option value="1245">121</option>
						<option value="876">12414</option>
						<option value="543">124124</option>
						<option value="1423">124214</option>
						</option>
				</select>
			<tr>
			<tr>
				<td>center Name</td>
				<td><input type="text" name="centerName"
					value="<%=userModel.getCenterName()%>"></td>
			</tr>

			<tr>
				<td>referredById</td>
				<td><input type="text" name="referredById"
					value="<%=userModel.getReferredById()%>"></td>
			</tr>
			<tr>
				<td>referredByName</td>
				<td><input type="text" name="referredByName"
					value="<%=userModel.getReferredByName()%>"></td>
			</tr>
			<tr>
				<td>Plan</td>
				<td><select name="planId">
						<option value="1325">34</option>
						<option value="890">426</option>
						<option value="789">56</option>
						<option value="579">789</option>
				</select></td>
			</tr>
			<tr>
				<td>plan Name</td>
				<td><input type="text" name="planName"
					value="<%=userModel.getPlanName()%>"></td>
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