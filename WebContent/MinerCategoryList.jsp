<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.sunrays.javarefbook.mlm.model.MinorCategoryModel"%>
<html>
</head>
<body>
	<h1 align="center">MinorCategory List</h1>
	<%
		MinorCategoryModel minorCategoryModel = new MinorCategoryModel();
	%>
	<form action="MinorCategoryCtl.do" method="post">

		<table border="1">
			<tr>
				<th>Id</th>
				<th>Major Category Id</th>
				<th>Category Code</th>

				<th>Name</th>


			</tr>
			<%
				List list = (List) request.getAttribute("List");
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					minorCategoryModel = (MinorCategoryModel) iterator.next();
			%>

			<tr>
				<td><input type="checkbox" name="checkbox"
					value=<%=minorCategoryModel.getId()%>></td>
				<td><input type="text"
					value=<%=minorCategoryModel.getMajorCategoryId()%>></td>
				<td><input type="text"
					value=<%=minorCategoryModel.getCategoryCode()%>></td>

				<td><input type="text" value=<%=minorCategoryModel.getName()%>></td>

				<td><a href="MinerCategoryCtl.do?id=<%=minorCategoryModel.getId()%>&operation=Get">Edit</a></td>


			</tr>
			<%
				}
			%>
		</table>

		<table align="center">
			<tr>
				<td><input type="submit" name="operation" value="Delete" /></td>

			</tr>

		</table>
	</form>
</body>
</html>