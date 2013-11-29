package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

public class CenterModel {
	private Integer id = null;
	private String name = null;
	private String address = null;
	private String permissionId = null;
	private String phoneNo = null;
	private String loginId = null;
	private String password = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void add() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		System.out.println("in add" + connection);
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO CENTER (ID,NAME,ADDRESS,PERMISSION_ID,PHONE_NO,LOGIN_ID,PASSWORD) VALUES (?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, address);
		preparedStatement.setString(4, permissionId);
		preparedStatement.setString(5, phoneNo);
		preparedStatement.setString(6, loginId);
		preparedStatement.setString(7, password);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE CENTER SET NAME=?,ADDRESS=?,PERMISSION_ID=?,PHONE_NO=?,LOGIN_ID=?,PASSWORD=? WHERE ID=?");
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, address);
		preparedStatement.setString(3, permissionId);
		preparedStatement.setString(4, phoneNo);
		preparedStatement.setString(5, loginId);
		preparedStatement.setString(6, password);
		preparedStatement.setInt(7, id);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM CENTER WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public CenterModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM CENTER WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		CenterModel centerModel = null;
		while (resultSet.next()) {
			centerModel = new CenterModel();
			centerModel.setId(resultSet.getInt(1));
			centerModel.setName(resultSet.getString(2));
			centerModel.setAddress(resultSet.getString(3));
			centerModel.setPermissionId(resultSet.getString(4));
			centerModel.setPhoneNo(resultSet.getString(5));
			centerModel.setLoginId(resultSet.getString(6));
			centerModel.setPassword(resultSet.getString(7));
		}
		System.out.println(centerModel.getName());
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

		return centerModel;

	}

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM CENTER WHERE 1=1");

		if (name != null && name.length() > 0) {
			searchQuery.append(" AND NAME LIKE '" + name + "%' ");
		}
		if (address != null && address.length() > 0) {
			searchQuery.append(" AND ADDRESS LIKE '" + address + "%' ");
		}
		if (permissionId != null && permissionId.length() > 0) {
			searchQuery.append(" AND  PERMISSIONID LIKE '" + permissionId
					+ "%' ");
		}
		if (phoneNo != null && phoneNo.length() > 0) {
			searchQuery.append(" AND PHONENO'" + phoneNo + "%' ");
		}
		if (loginId != null && loginId.length() > 0) {
			searchQuery.append(" AND LOGINID LIKE '" + loginId + "%' ");
		}
		if (password != null && password.length() > 0) {
			searchQuery.append(" AND PASSWORD LIKE '" + password + "%' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			CenterModel centerModel = new CenterModel();

			centerModel.setId(resultSet.getInt(1));
			centerModel.setName(resultSet.getString(2));
			centerModel.setAddress(resultSet.getString(3));
			centerModel.setPermissionId(resultSet.getString(4));
			centerModel.setPhoneNo(resultSet.getString(5));
			centerModel.setLoginId(resultSet.getString(6));
			centerModel.setPassword(resultSet.getString(7));
			list.add(centerModel);
		}
		statement.close();
		DatabaseUtility.closeConnection(connection);
		return list;

	}

	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM CENTER ");
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

	public List getlist() throws Exception {
		CenterModel centerModel = new CenterModel();
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from center ");
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			centerModel.setId(resultSet.getInt(1));
			centerModel.setName(resultSet.getString(2));
			centerModel.setAddress(resultSet.getString(3));
			centerModel.setPermissionId(resultSet.getString(4));
			centerModel.setPhoneNo(resultSet.getString(5));
			centerModel.setLoginId(resultSet.getString(6));
			centerModel.setPassword(resultSet.getString(7));

		}

		return null;

	}

	public CenterModel authenticate() throws Exception {
		System.out.println("in centralmodelauth");
		DatabaseUtility.openConnection();
		System.out.println("values " + loginId + " " + password);
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM CENTER WHERE LOGIN_ID=? AND PASSWORD=?");
		preparedStatement.setString(1, loginId);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		CenterModel centerModel = null;

		if (resultSet.next()) {
			System.out.println("in resultset");
			centerModel = new CenterModel();
			centerModel.setLoginId(loginId);
			centerModel.setPassword(password);
		}
		preparedStatement.close();
		connection.close();
		return centerModel;
	}
}
