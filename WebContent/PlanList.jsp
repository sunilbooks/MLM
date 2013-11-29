<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.sunrays.javarefbook.mlm.model.PlanModel"%>
<html>
</head>
<body>
	<h1 align="center">User List</h1>
	<%
		PlanModel planModel = new PlanModel();
	%>
	<form action="PlanCtl.do">

		<table border="1">
			<tr>
				<th>ID</th>

				<th>level1</th>
				<th>level2</th>
				<th>level3</th>
				<th>level4</th>
				<th>level5</th>
				<th>level6</th>
				<th>level7</th>
				<th>level8</th>
				<th>level9</th>
				<th>level10</th>
				<th>Plan Name</th>
			</tr>
			<%
				List list = (List) request.getAttribute("List");
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					planModel = (PlanModel) iterator.next();
			%>
			<tr>
				<td><input type="checkbox" name="checkbox"
					value=<%=planModel.getId()%> /></td>

				<td><input type="text" value=<%=planModel.getLevel1()%> /></td>
				<td><input type="text" value=<%=planModel.getLevel2()%> /></td>
				<td><input type="text" value=<%=planModel.getLevel3()%> /></td>
				<td><input type="text" value=<%=planModel.getLevel4()%> /></td>
				<td><input type="text" value=<%=planModel.getLevel5()%> /></td>
				<td><input type="text" value=<%=planModel.getLevel6()%> /></td>
				<td><input type="text" value=<%=planModel.getLevel7()%> /></td>
				<td><input type="text" value=<%=planModel.getLevel8()%> /></td>
				<td><input type="text" value=<%=planModel.getLevel9()%> /></td>
				<td><input type="text" value=<%=planModel.getLevel10()%> /></td>
				<td><input type="text" value=<%=planModel.getName()%> /></td>

				<td><a href="PlanCtl.do?id=<%=planModel.getId()%>&operation=Get">Edit</a></td>


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