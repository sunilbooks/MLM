<%@page import="com.sunrays.javarefbook.mlm.model.MinorCategoryModel"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />

</head>
<body>
	<%
		MinorCategoryModel minorCategoryModel = null;
		minorCategoryModel = (MinorCategoryModel) request
				.getAttribute("get");
		if (minorCategoryModel == null) {
			minorCategoryModel = new MinorCategoryModel();
		}
	%>

	<h1 align="center">MinorCategoryForm</h1>
	<form action="MinerCategoryCtl.do" method="post">
		<table>
			<tr>
				<td>id</td>
				<td><input type="text" name="id"
					value=<%=minorCategoryModel.getId()%>></td>
			</tr>
			<tr>
				<td>majorCategoryId</td>

				<td><input type="text" name="majorCategoryId"
					value=<%=minorCategoryModel.getMajorCategoryId()%>></td>
			<tr>
				<td>categoryCode</td>
				<td><input type="text" name="categoryCode"
					value=<%=minorCategoryModel.getCategoryCode()%> /></td>
			</tr>



			<!-- <td><select name="majorCategoryId"><option
							value="volvo">Volvo</option>
						<option value="saab">Saab</option>
						<option value="mercedes">Mercedes</option>
						<option value="audi">Audi</option></select></td> -->
			</tr>

			<tr>
				<td>Name</td>
				<td><input type="text" name="name"
					value=<%=minorCategoryModel.getName()%>></td>
			</tr>

		</table>
		<table>
			<input type="submit" name="operation" value="Save">
			<input type="submit" name="operation" value="Update">
		</table>
	</form>

</body>