package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

public class TransactionModel {
	private Integer id = null;
	private Integer amount = null;
	private Long accountId = null;
	private Long fromUserId = null;
	private Long userId = null;
	private String fromUserName = null;
	private Date trndate = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getTrndate() {
		return trndate;
	}

	public void setTrndate(Date trndate) {
		this.trndate = trndate;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public void add() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO TRANSACTION (ID,AMOUNT,ACCOUNTID,FROMUSERID,FROMUSERNAME,TRNDATE,USERID) VALUES (?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setInt(2, amount);
		preparedStatement.setLong(3, accountId);
		preparedStatement.setLong(4, fromUserId);
		preparedStatement.setString(5, fromUserName);
		preparedStatement.setDate(6, new java.sql.Date(trndate.getTime()));
		preparedStatement.setLong(7, userId);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE TRANSACTION SET AMOUNT=?,ACCOUNTID=?,FROMUSERID=?,"
						+ "FROMUSERNAME=?,TRNDATE=?,USERID=? WHERE ID=?");

		preparedStatement.setInt(1, amount);
		preparedStatement.setLong(2, accountId);
		preparedStatement.setLong(3, fromUserId);
		preparedStatement.setString(4, fromUserName);
		preparedStatement.setDate(5, new java.sql.Date(trndate.getTime()));
		preparedStatement.setLong(6, userId);
		preparedStatement.setInt(7, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM TRANSACTION WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public TransactionModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM TRANSACTION WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		TransactionModel transactionModel = null;
		while (resultSet.next()) {
			transactionModel = new TransactionModel();
			transactionModel.setId(resultSet.getInt(1));
			transactionModel.setAmount(resultSet.getInt(2));
			transactionModel.setAccountId(resultSet.getLong(3));
			transactionModel.setFromUserId(resultSet.getLong(4));
			transactionModel.setUserId(resultSet.getLong(5));
			transactionModel.setTrndate(resultSet.getDate(6));
		}
		System.out.println(transactionModel);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);
		return transactionModel;

	}

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM CENTER WHERE 1=1");

		if (amount != null && amount > 0) {
			searchQuery.append(" AND AMOUNT = '" + amount + "' ");
		}
		if (accountId != null && accountId > 0) {
			searchQuery.append(" AND ACCOUNTID = '" + accountId + "' ");
		}
		if (userId != null && userId > 0) {
			searchQuery.append(" AND USERID = '" + userId + "' ");
		}
		if (fromUserName != null && fromUserName.length() > 0) {
			searchQuery.append(" AND FROMUSERNAME '" + fromUserName + "%' ");
		}
		if (trndate != null) {
			searchQuery.append(" AND  TRNDATE LIKE '" + trndate + "%' ");
		}
		if (fromUserId != null && fromUserId > 0) {
			searchQuery.append(" AND FROMUSERID = '" + fromUserId + "' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			TransactionModel transactionModel = new TransactionModel();
			transactionModel.setId(resultSet.getInt(1));
			transactionModel.setAmount(resultSet.getInt(2));
			transactionModel.setAccountId(resultSet.getLong(3));
			transactionModel.setFromUserId(resultSet.getLong(4));
			transactionModel.setUserId(resultSet.getLong(5));
			transactionModel.setFromUserName(resultSet.getString(6));
			transactionModel.setTrndate(resultSet.getDate(7));

			list.add(transactionModel);
		}
		statement.close();
		DatabaseUtility.closeConnection(connection);
		return list;

	}
	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM TRANSACTION ");
		ResultSet resultSet = preparedStatement.executeQuery();
		id =1;
		if (resultSet.next()) {
			id += resultSet.getInt(1);

		}
		System.out.println(id);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);
		return id;

	}
}
