<%@page import="com.sunrays.javarefbook.mlm.model.PlanModel"%>
<html>
<body>


	<h2>Plan Detail</h2>
	<%
		PlanModel planModel = null;
		planModel = (PlanModel) request.getAttribute("get");
		if (planModel == null) {
			planModel = new PlanModel();

		}
	%>
	<form action="PlanCtl.do" method="post">
		<table border="1">
			<tr>
				<td>id</td>
				<td><input type="text" name="id" value=<%=planModel.getId()%>></td>
			</tr>

			<tr>
				<td>level1</td>
				<td><input type="text" name="level1"
					value=<%=planModel.getLevel1()%>></td>
			</tr>
			<tr>
				<td>level2</td>
				<td><input type="text" name="level2"
					value=<%=planModel.getLevel2()%>></td>
			</tr>
			<tr>
				<td>level3</td>
				<td><input type="text" name="level3"
					value=<%=planModel.getLevel3()%>></td>
			</tr>
			<tr>
				<td>level4</td>
				<td><input type="text" name="level4"
					value=<%=planModel.getLevel4()%>></td>
			</tr>
			<tr>
				<td>level5</td>
				<td><input type="text" name="level5"
					value=<%=planModel.getLevel5()%>></td>
			</tr>
			<tr>
				<td>level6</td>
				<td><input type="text" name="level6"
					value=<%=planModel.getLevel6()%>></td>
			</tr>
			<tr>
				<td>level7</td>
				<td><input type="text" name="level7"
					value=<%=planModel.getLevel7()%>></td>
			</tr>
			<tr>
				<td>level8</td>
				<td><input type="text" name="level8"
					value=<%=planModel.getLevel8()%>></td>
			</tr>
			<tr>
				<td>level9</td>
				<td><input type="text" name="level9"
					value=<%=planModel.getLevel9()%>></td>
			</tr>
			<tr>
				<td>level10</td>
				<td><input type="text" name="level10"
					value=<%=planModel.getLevel10()%>></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"
					value=<%=planModel.getName()%>></td>
			</tr>


		</table>
		<table>
			<tr>
				<input type="submit" name="operation" value="Save">

				<input type="submit" name="operation" value="Update">
			</tr>
		</table>
	</form>


</body>
</html>