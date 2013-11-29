<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
            "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="com.sunrays.javarefbook.mlm.model.UserModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.sunrays.javarefbook.mlm.model.GroupModel"%>
<head>
<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />
</head>
<html>
<body>
<p class="title"align="center">Group Detail</p>
	<center>

		<h2>Group Detail</h2>
		<%
			UserModel userModel = new UserModel();
		%>
		<%
			GroupModel groupModel = null;
			groupModel = (GroupModel) request.getAttribute("get");
			if (groupModel == null) {
				groupModel = new GroupModel();
			}
		%>
		<%
			List list = (List) request.getAttribute("groupList");

			Iterator iterator = list.iterator();
		%>


		<form action="GroupCtl.do" method="post">
			<table border="1">
				<tr>
					<table align="center">
						<tr>
							<td>ID</td>
							<td><input type="text" name="id"
								value="<%=groupModel.getId()%>"></td>
						</tr>
						<tr>
							<td>Select Group</td>
							<td><select name="groupId">
									<option value="">--Select--</option>
									<%
										while (iterator.hasNext()) {
											groupModel = (GroupModel) iterator.next();
									%>
									<option value="<%=groupModel.getGroupId()%>"><%=groupModel.getGroupId()%></option>
									<%
										}
									%>
							</select></td>
						</tr>

						<tr>

							<td>UserId</td>
							<td><select name="userId">
									<option value="">--Select--</option>
									<%
										list = (List) request.getAttribute("userList");
										while (iterator.hasNext()) {
											groupModel = (GroupModel) iterator.next();
									%>
									<option value="<%=userModel.getId()%>"><%=userModel.getId()%></option>
									<%
										}
									%>
							</select></td>
						</tr>


						<tr>
							<td>No of Id</td>
							<td><input type="text" name="noOfId"
								value="<%=groupModel.getNoOfId()%>"></td>
						</tr>

					</table>
					<table align="center">
						<tr>
							<td><input type="submit" name="operation" value="Save"
								align="center"></td>


							<td><input type="submit" name="operation" value="update" /></td>




					</table>
				</tr>
			</table>
		</form>
	</center>