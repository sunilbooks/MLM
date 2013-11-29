<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />

</head>
<body>

	<h2>System Setting</h2>


	<form action="SystemTesting">
		<table border="1">


			<input type="hidden" name="id">
			<tr>
				<td>No Of Record On The Page</td>
				<td><input type="text" name="noOfRecord"></td>
			</tr>
			<tr>
				<td>SMS Notification</td>
				<td><input type="checkbox" name="smsNotification"></td>
			</tr>
			<tr>
				<td>E-Mail Notification</td>
				<td><input type="checkbox" name="emailNotification"></td>
			</tr>

			<tr>
				<td><input type="submit" name="operation" value="Save">
				</td>
			</tr>


		</table>
	</form>
</body>
</html>