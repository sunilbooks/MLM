<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.sunrays.javarefbook.mlm.model.MajorCategoryModel"%>
<html>

<body>
	<center>
		<p class="title">MajorCategory List</p>
		<%
			MajorCategoryModel majorCategoryModel = new MajorCategoryModel();
		%>
		<form action="MajorCategoryCtl.do">

			<table border="1" align="center">
				<tr>
					<th><input type="checkbox"></th>
					<th>Id</th>
					<th>Name</th>
					<th>Category Code</th>
					<th>Edit</th>
				</tr>
				<%
					List list = (List) request.getAttribute("majorCategoryList");
					Iterator iterator = list.iterator();
					while (iterator.hasNext()) {
						majorCategoryModel = (MajorCategoryModel) iterator.next();
				%>
				<tr>
					<td><input type="checkbox" name="check"
						value=<%=majorCategoryModel.getId()%>></td>

					<td><input type="text" value=<%=majorCategoryModel.getId()%> /></td>
					<td><input type="text" value=<%=majorCategoryModel.getName()%> /></td>

					<td><input type="text"
						value=<%=majorCategoryModel.getCategoryCode()%> /></td>


					<td><a
						href="MajorCategoryCtl.do?id=<%=majorCategoryModel.getId()%>&operation=Get">Edit</a></td>
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
	</center>
</body>
</html>