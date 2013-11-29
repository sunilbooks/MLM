<html>
<body>
	<h1 align="center">Account(s)</h1>
	<form action="AccountList">
		<table border="1">

			<tr>

				<th>Id</th>
				<th>User</th>

				<th>Date Of Opening</th>
				<th>Last Transaction Date</th>
				<th>Balance</th>

			</tr>

			<tr>

				<td><input type="checkbox" name="checkbox"></td>

				<td><input type="text" name="userName" /></td>

				<td><input type="text" name="dateOfOpening" /></td>
				<td><input type="lastTransactionDate" /></td>
				<td><input type="text" name="balance" /></td>

				<td><a href="Account.jsp">Edit</a></td>
			</tr>


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