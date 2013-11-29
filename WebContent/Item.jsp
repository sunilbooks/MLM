<%@page import="com.sunrays.javarefbook.mlm.model.MinorCategoryModel"%>
<%@page import="com.sunrays.javarefbook.mlm.model.MajorCategoryModel"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.sunrays.javarefbook.mlm.model.ItemModel"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />

</head>
<body>
	<%
		MajorCategoryModel majorCategoryModel = new MajorCategoryModel();
	%>
	<%
		MinorCategoryModel minorCategoryModel = new MinorCategoryModel();
	%>


	<font size="12">Item</font>
	<%
		ItemModel itemModel = (ItemModel) request.getAttribute("get");
		if (itemModel == null) {
			itemModel = new ItemModel();

		}
	%>
	<%
		List list = (List) request.getAttribute("majorList");
		Iterator iterator = list.iterator();
	%>

	<form action="ItemCtl.do" method="post">
		<table align="center">
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" value="<%=itemModel.getId()%>"></td>
			</tr>
			<tr>
				<td>Item Name</td>
				<td><input type="text" name="ItemName"
					value="<%=itemModel.getItemName()%>"></td>
			</tr>

			<tr>
				<td>Major Category</td>
				<td><select name="majorCategory">
						<option value="">--Select--</option>
						<%
							while (iterator.hasNext()) {
								majorCategoryModel = (MajorCategoryModel) iterator.next();
						%>
						<option value="<%=majorCategoryModel.getName()%>"><%=majorCategoryModel.getName()%></option>
						<%
							}
						%>

				</select></td>
			</tr>
			<tr>
				<td>Minor Category</td>
				<td><select name="minorCategory">
						<option value="">--Select--</option>
						<%
							list = (List) request.getAttribute("minorList");
							iterator = list.iterator();
							while (iterator.hasNext()) {
								minorCategoryModel = (MinorCategoryModel) iterator.next();
						%>
						<option value="<%=minorCategoryModel.getName()%>"><%=minorCategoryModel.getName()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td>Item Size</td>
				<td><input type="text" name="itemSize"
					value="<%=itemModel.getItemSize()%>"></td>
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