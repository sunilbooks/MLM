package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

/**
 * Account Model contains account data and its database operations
 * 
 * @author Sunil Sahu
 * 
 */
public class AccountModel {

	/**
	 * Account ID
	 */
	private Integer id = null;

	/**
	 * Account Balance
	 */

	private Integer balance = null;

	/**
	 * Opening date of Account
	 */
	private Date dateOfOpening = null;

	/**
	 * Last transaction date of Account
	 */
	private Date lastTransactionDate = null;

	/**
	 * Account Holder Name
	 */
	private String userName = null;

	/**
	 * Account Holder ID
	 */
	private Long userId = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Date getDateOfOpening() {
		return dateOfOpening;
	}

	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}

	public Date getLastTransactionDate() {
		return lastTransactionDate;
	}

	public void setLastTransactionDate(Date lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Add an Account 
	 * 
	 * @throws Exception
	 */
	public void add() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO ACCOUNT(ID,BALANCE,DATE_OF_OPENING,LAST_TRANSACTION_DATE,USER_NAME,USER_ID) VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setInt(2, balance);
		preparedStatement
				.setDate(3, new java.sql.Date(dateOfOpening.getTime()));
		preparedStatement.setDate(4,
				new java.sql.Date(lastTransactionDate.getTime()));
		preparedStatement.setString(5, userName);
		preparedStatement.setLong(6, userId);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}
	
	/**
	 * Update an Account
	 * 
	 * @throws Exception
	 */

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE ACCOUNT SET BALANCE=?,DATE_OF_OPENING=?,LAST_TRANSACTION_DATE=?,USER_NAME=?,USER_ID=? WHERE ID=?");
		preparedStatement.setInt(1, balance);
		preparedStatement
				.setDate(2, new java.sql.Date(dateOfOpening.getTime()));
		preparedStatement.setDate(3,
				new java.sql.Date(lastTransactionDate.getTime()));
		preparedStatement.setString(4, userName);
		preparedStatement.setLong(5, userId);
		preparedStatement.setInt(6, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	/**
	 * Delete an Account
	 *  
	 * @throws Exception
	 */
	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM ACCOUNT WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	/**
	 * Find an Account by Account ID 
	 * @param id  Primary Key
	 * @return
	 * @throws Exception
	 */
	public AccountModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM ACCOUNT WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		AccountModel accountModel = null;
		while (resultSet.next()) {
			accountModel = new AccountModel();
			accountModel.setId(resultSet.getInt(1));
			accountModel.setBalance(resultSet.getInt(2));
			accountModel.setDateOfOpening(resultSet.getDate(3));
			accountModel.setLastTransactionDate(resultSet.getDate(4));
			accountModel.setUserName(resultSet.getString(5));
			accountModel.setUserId(resultSet.getLong(6));
		}
		System.out.println(accountModel);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

		return accountModel;

	}
	
	/**
	 * Search Account and return list of accounts satisfy search criteria 
	 * 
	 * @return
	 * @throws Exception
	 */

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM ACCOUNT WHERE 1=1");

		if (balance != null && balance > 0) {
			searchQuery.append(" AND BALANCE = '" + balance + "' ");
		}
		if (dateOfOpening != null) {
			searchQuery.append(" AND DATE_OF_OPENING LIKE '" + dateOfOpening
					+ "%' ");
		}
		if (lastTransactionDate != null) {
			searchQuery.append(" AND LAST_TRANSACTION_DATE LIKE '"
					+ lastTransactionDate + "%' ");
		}
		if (userName != null && userName.length() > 0) {
			searchQuery.append(" AND USER_NAME LIKE '" + userName + "%' ");
		}
		if (userId != null && userId > 0) {
			searchQuery.append(" AND USERID = '" + userId + "' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			AccountModel accountModel = new AccountModel();
			accountModel.setId(resultSet.getInt(1));
			accountModel.setBalance(resultSet.getInt(2));
			accountModel.setDateOfOpening(resultSet.getDate(3));
			accountModel.setLastTransactionDate(resultSet.getDate(4));
			accountModel.setUserName(resultSet.getString(5));
			accountModel.setUserId(resultSet.getLong(6));
			list.add(accountModel);
		}

		statement.close();
		DatabaseUtility.closeConnection(connection);
		return list;

	}

	/**
	 * Get next available primary key to create a new account 
	 * @return
	 * @throws Exception
	 */
	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM ACCOUNT");
		ResultSet resultSet = preparedStatement.executeQuery();
		id = 1;
		if (resultSet.next()) {
			id += resultSet.getInt(1);

		}
		System.out.println(id);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);
		return id;

	}
}
