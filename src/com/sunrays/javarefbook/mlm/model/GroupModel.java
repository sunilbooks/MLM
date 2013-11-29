package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

public class GroupModel {
	private Integer id = null;
	private Integer groupId = null;
	private Integer userId = null;
	private Integer noOfId = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getNoOfId() {
		return noOfId;
	}

	public void setNoOfId(Integer noOfId) {
		this.noOfId = noOfId;
	}

	public void add() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO GROUPTABLE (ID,GROUP_ID,USER_ID,NO_OF_ID) VALUES(?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setInt(2, groupId);
		preparedStatement.setInt(3, userId);
		preparedStatement.setInt(4, noOfId);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE GROUPTABLE SET GROUP_ID=?,USER_ID=?,NO_OF_ID=? WHERE ID=?");
		preparedStatement.setInt(1, groupId);
		preparedStatement.setInt(2, userId);
		preparedStatement.setInt(3, noOfId);
		preparedStatement.setInt(4, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM GROUPTABLE WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public GroupModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM GROUPTABLE WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		GroupModel groupModel = null;
		while (resultSet.next()) {
			groupModel = new GroupModel();
			groupModel.setId(resultSet.getInt(1));
			groupModel.setGroupId(resultSet.getInt(2));
			groupModel.setUserId(resultSet.getInt(3));
			groupModel.setNoOfId(resultSet.getInt(4));

		}
		System.out.println(groupModel.getGroupId());
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);
		return groupModel;

	}

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM GROUPTABLE WHERE 1=1");

		if (groupId != null && groupId > 0) {
			searchQuery.append(" AND GROUPID = '" + groupId + "' ");
		}
		if (userId != null && userId > 0) {
			searchQuery.append(" AND userId = '" + userId + "' ");
		}

		if (noOfId != null && noOfId > 0) {
			searchQuery.append(" AND NOOFID  = '" + groupId + "' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			GroupModel groupModel = new GroupModel();
			groupModel.setId(resultSet.getInt(1));
			groupModel.setGroupId(resultSet.getInt(2));
			groupModel.setUserId(resultSet.getInt(3));
			groupModel.setNoOfId(resultSet.getInt(4));
			list.add(groupModel);
		}
		statement.close();
		DatabaseUtility.closeConnection(connection);

		return list;

	}
	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM GROUPTABLE ");
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
