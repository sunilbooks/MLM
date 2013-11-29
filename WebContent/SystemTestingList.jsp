<html>
<head>
		<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />

	</head>
<body>
	<h1 align="center">System Setting List</h1>
	<s:form action="SystemTestingList">

		<table border="1">
			<tr>
				<th>ID</th>

				<th>No Of Record</th>
				<th>SMS Notification</th>
				<th>Email Notification</th>

			</tr>


			<tr>
				<td><input type="checkbox" name="checkbox" value="id" /></td>
				<td><input type="text" value="noOfRecord" /></td>
				<td><input type="text" value="smsNotification" /></td>
				<td><input type="text" value="emailNotification" /></td>

				<td><a href="SystemTesting.jsp">Edit</a></td>


			</tr>

		</table>

		<table align="center">
			<tr>
				<td><input type="submit" name="operation" value="Delete" /></td>

			</tr>

		</table>
	</s:form>

</body>
</html>