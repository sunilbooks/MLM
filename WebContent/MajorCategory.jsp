<%@page import="com.sunrays.javarefbook.mlm.model.MajorCategoryModel"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />

</head>
<body>
	<center>

		<p class="title" align="center">MajorCategory</p>

		<%
			MajorCategoryModel majorCategoryModel = null;
			majorCategoryModel = (MajorCategoryModel) request
					.getAttribute("get");
			if (majorCategoryModel == null) {
				majorCategoryModel = new MajorCategoryModel();
			}
		%>

		<form action="MajorCategoryCtl.do" method="post">

			<table align="center">
				<tr>
					<td>id</td>
					<td><input type="text" name="id"
						value="<%=majorCategoryModel.getId()%>"></td>
				</tr>
				<tr>
					<td>Name</td>

					<td><input type="text" name="name"
						value="<%=majorCategoryModel.getName()%>"></td>
				</tr>
				<tr>
					<td>categoryCode</td>
					<td><input type="text" name="categoryCode"
						value="<%=majorCategoryModel.getCategoryCode()%>"></td>
				</tr>
			</table>
			<table>
				<br>
				<tr>
					<td><input type="submit" name="operation" value="Save"></td>

					<td><input type="submit" name="operation" value="Update"></td>

					<td><input type="submit" name="operation" value="Get"></td>
				</tr>
			</table>
		</form>
	</center>

</body>
</html>