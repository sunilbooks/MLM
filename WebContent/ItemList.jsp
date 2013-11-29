<%@page import="com.sunrays.javarefbook.mlm.model.ItemModel"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />

</head>
<body>
	<%
		ItemModel itemModel = new ItemModel();
	%>
	<h1 align="center">Item List</h1>
	<form action="/ItemCtl.do" method="post" >

		<table border="1">
			<tr>
				<th>Id</th>
				<th>Item Name</th>
				<th>Major Category</th>
				<th>Minor Category</th>
				<th>Size</th>


			</tr>
			<%
				List list = (List) request.getAttribute("List");
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					itemModel = (ItemModel) iterator.next();
			%>

			<tr>
				<td><input type="checkbox" name="checkbox"
					value=<%=itemModel.getId()%> /></td>



				<td><input type="text" value=<%=itemModel.getItemName()%> /></td>

				<td><input type="text" value=<%=itemModel.getMajorCategory()%> /></td>
				<td><input type="text" value=<%=itemModel.getMinorCategory()%> /></td>
				<td><input type="text" value=<%=itemModel.getItemSize()%> /></td>


				<td><a href="ItemCtl.do?id=<%=itemModel.getId()%>&operation=Get">Edit</a></td>


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