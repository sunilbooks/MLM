package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

public class UserProfileModel {
	private Integer id = null;
	private String firstName = null;
	private String lastName = null;
	private String userId = null;
	private String password = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void add() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO USERPROFILE (ID,FIRST_NAME,LAST_NAME,USER_ID,"
						+ "PASSWORD) VALUES (?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, firstName);
		preparedStatement.setString(3, lastName);
		preparedStatement.setString(4, userId);
		preparedStatement.setString(5, password);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE USERPROFILE SET FIRST_NAME=?,LAST_NAME=?,USER_ID=?,"
						+ "PASSWORD=? WHERE ID=?");
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		preparedStatement.setString(3, userId);
		preparedStatement.setString(4, password);
		preparedStatement.setInt(5, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM USERPROFILE WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public UserProfileModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM USERPROFILE WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		UserProfileModel userProfileModel = null;
		while (resultSet.next()) {
			userProfileModel = new UserProfileModel();
			userProfileModel.setId(resultSet.getInt(1));
			userProfileModel.setFirstName(resultSet.getString(2));
			userProfileModel.setLastName(resultSet.getString(3));
			userProfileModel.setUserId(resultSet.getString(4));
			userProfileModel.setPassword(resultSet.getString(5));

		}
		System.out.println(userProfileModel.firstName);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);
		return userProfileModel;

	}

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM CENTER WHERE 1=1");

		if (firstName != null && firstName.length() > 0) {
			searchQuery.append(" AND FIRSTNAME '" + firstName + "%' ");
		}
		if (lastName != null && lastName.length() > 0) {
			searchQuery.append(" AND  LASTNAME LIKE '" + lastName + "%' ");
		}

		if (userId != null && userId.length() > 0) {
			searchQuery.append(" AND  USERID LIKE '" + userId + "%' ");
		}
		if (password != null && password.length() > 0) {
			searchQuery.append(" AND  PASSWORD LIKE '" + password + "%' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			UserProfileModel userProfileModel = new UserProfileModel();
			userProfileModel.setId(resultSet.getInt(1));
			userProfileModel.setFirstName(resultSet.getString(2));
			userProfileModel.setLastName(resultSet.getString(3));
			userProfileModel.setUserId(resultSet.getString(4));
			userProfileModel.setPassword(resultSet.getString(5));

			list.add(userProfileModel);
		}
		statement.close();
		DatabaseUtility.closeConnection(connection);
		return list;

	}
	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM USERPROFILE ");
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
