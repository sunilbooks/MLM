<html>
<head>
		<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />

	</head>
<body>
	<td><a href="Menu.jsp">Menu</a></td>

	<h1 align="center">Transaction List</h1>
	<form action="Transaction">
		<table border="1">
			<tr>

				<th>Id</th>
				<th>Amount</th>

				<th>Trndate</th>
				<th>Account Id</th>
				<th>User Id</th>
				<th>From User Id</th>
				<th>From User Name</th>
			</tr>

			<tr>

				<td><input type="checkbox" name="checkbox"
					value='<s:property value="id" />' /></td>
				<td><input type="text" name="id" /></td>
				<td><input type="text" value="referredById" /></td>


				<td><input type="text" value="" /></td>
				<td><input type="text" value="" /></td>
				<td><input type="text" value="" /></td>
				<td><input type="text" value="" /></td>



				<td><a href="Transaction.jsp">Edit</a></td>
		</table>
		<br />

		<table>
			<tr>
				<td><input type="submit" name="operation" value="Delete" /></td>

			</tr>


		</table>
	</form>
</body>
</html>