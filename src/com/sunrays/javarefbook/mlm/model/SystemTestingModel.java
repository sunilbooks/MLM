package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

public class SystemTestingModel {
	private Integer id = null;
	private String emailNotification = null;
	private Integer noOfRecord = null;
	private String smsNotification = null;
	private String theme = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailNotification() {
		return emailNotification;
	}

	public void setEmailNotification(String emailNotification) {
		this.emailNotification = emailNotification;
	}

	public Integer getNoOfRecord() {
		return noOfRecord;
	}

	public void setNoOfRecord(Integer noOfRecord) {
		this.noOfRecord = noOfRecord;
	}

	public String getSmsNotification() {
		return smsNotification;
	}

	public void setSmsNotification(String smsNotification) {
		this.smsNotification = smsNotification;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void add() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO SYSTEMTESTING (ID,E_MAIL_NOTIFICATION,NO_OF_RECORD,SMS_NOTIFICATION,THEME) VALUES (?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, emailNotification);
		preparedStatement.setInt(3, noOfRecord);
		preparedStatement.setString(4, smsNotification);
		preparedStatement.setString(5, theme);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE SYSTEMTESTING SET E_MAIL_NOTIFICATION=?,"
						+ "NO_OF_RECORD=?,SMS_NOTIFICATION=?,THEME=? WHERE ID=?");
		preparedStatement.setString(1, emailNotification);
		preparedStatement.setInt(2, noOfRecord);
		preparedStatement.setString(3, smsNotification);
		preparedStatement.setString(4, theme);
		preparedStatement.setInt(5, id);
		preparedStatement.setInt(5, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM SYSTEMTESTING WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public SystemTestingModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM SYSTEMTESTING WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		SystemTestingModel systemTestingModel = null;
		while (resultSet.next()) {
			systemTestingModel = new SystemTestingModel();
			systemTestingModel.setId(resultSet.getInt(1));
			systemTestingModel.setEmailNotification(resultSet.getString(2));
			systemTestingModel.setNoOfRecord(resultSet.getInt(3));
			systemTestingModel.setSmsNotification(resultSet.getString(4));
			systemTestingModel.setTheme(resultSet.getString(5));
		}
		System.out.println(systemTestingModel.getNoOfRecord());
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);
		return systemTestingModel;

	}

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM CENTER WHERE 1=1");

		if (emailNotification != null && emailNotification.length() > 0) {
			searchQuery.append(" AND ITEMNAME EMAILNOTIFICATION '"
					+ emailNotification + "%' ");
		}
		if (noOfRecord != null && noOfRecord > 0) {
			searchQuery.append(" AND NOOFRECORD = '" + noOfRecord + "' ");
		}
		if (smsNotification != null && smsNotification.length() > 0) {
			searchQuery.append(" AND SMSNOTIFICATION '" + smsNotification
					+ "%' ");
		}
		if (theme != null && theme.length() > 0) {
			searchQuery.append(" AND  THEME LIKE '" + theme + "%' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			SystemTestingModel systemTestingModel = new SystemTestingModel();
			systemTestingModel.setId(resultSet.getInt(1));
			systemTestingModel.setEmailNotification(resultSet.getString(2));
			systemTestingModel.setNoOfRecord(resultSet.getInt(3));
			systemTestingModel.setTheme(resultSet.getString(4));
			list.add(systemTestingModel);
		}
		statement.close();
		DatabaseUtility.closeConnection(connection);
		return list;

	}
	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM SYSTEMTESTING ");
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
