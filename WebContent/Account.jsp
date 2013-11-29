<html>
<body>
	<h2>Account Detail</h2>
	<form action="AccountCTL">
		<TABLE>
			<input type="hidden" name="id" />
			<TR>
				<TD><b>Balance</b></TD>
				<TD><input type="text" name="balance" /></TD>
			</TR>
			<TR>
				<TD><b>Date Of Opening (MM/DD/YYYY)</b></TD>
				<TD><input type="text" name="dateOfOpening" /></TD>
			</TR>
			<TR>
				<TD><b>Date Of Last Transaction (MM/DD/YYYY)</b></TD>
				<TD><input type="text" name="lastTransactionDate" /></TD>
			</TR>
			<TR>

				<TD><b>Member</b></TD>
				<TD><input type="text" name="userName" /></TD>
			</TR>
			<TR>
				<TD><b>UserName</b></TD>
				<TD><input type="text" name="lastTransactionDate" /></TD>
			</TR>

			<TR>
				<TD><b>User Id</b></TD>
				<TD><input type="text" name="userId" /></TD>
			</TR>
		</TABLE>
		<h2>Transaction Detail</h2>

		<table border="1">

			<tr>

				<th>Id</th>
				<th>User</th>

				<th>Transaction Date</th>
				<th>Balance</th>

			</tr>


			<tr>

				<td><input type="checkbox" name="checkbox" value="id" /></td>


				<td><input type="text" name="fromUserName" /></td>

				<td><input type="text" name="trndate" /></td>
				<td><input type="text" name="amount" /></td>

			</tr>


		</table>
	</form>

</body>
</html>