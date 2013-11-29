package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

public class MinorCategoryModel {
	private Integer id = null;
	private String majorCategoryId = null;
	private String categoryCode = null;
	private String name = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMajorCategoryId() {
		return majorCategoryId;
	}

	public void setMajorCategoryId(String majorCategoryId) {
		this.majorCategoryId = majorCategoryId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add() throws Exception {
		System.out.println("in add");
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO MINORCATEGORY (ID,MAJOR_CATEGORY_ID,CATEGORY_CODE,NAME) VALUES (?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, majorCategoryId);
		preparedStatement.setString(3, categoryCode);
		preparedStatement.setString(4, name);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE MINORCATEGORY SET MAJOR_CATEGORY_ID=?,CATEGORY_CODE=?,NAME=? WHERE ID=?");
		preparedStatement.setString(1, majorCategoryId);
		preparedStatement.setString(2, categoryCode);
		preparedStatement.setString(3, name);
		preparedStatement.setInt(4, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM MINORCATEGORY WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public MinorCategoryModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM MINORCATEGORY WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		MinorCategoryModel minorCategoryModel = null;
		while (resultSet.next()) {
			minorCategoryModel = new MinorCategoryModel();
			minorCategoryModel.setId(resultSet.getInt(1));
			minorCategoryModel.setMajorCategoryId(resultSet.getString(2));
			minorCategoryModel.setCategoryCode(resultSet.getString(3));
			minorCategoryModel.setName(resultSet.getString(4));
		}
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

		return minorCategoryModel;

	}

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM MINORCATEGORY WHERE 1=1");

		if (majorCategoryId != null && majorCategoryId.length() > 0) {
			searchQuery.append(" AND MAJORCATEGORYID LIKE '" + majorCategoryId
					+ "%' ");
		}
		if (categoryCode != null && categoryCode.length() > 0) {
			searchQuery.append(" AND CATEGORYCODE LIKE '" + categoryCode
					+ "%' ");
		}
		if (name != null && name.length() > 0) {
			searchQuery.append(" AND NAME LIKE '" + name + "%' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			MinorCategoryModel minorCategoryModel = new MinorCategoryModel();
			minorCategoryModel.setId(resultSet.getInt(1));
			minorCategoryModel.setMajorCategoryId(resultSet.getString(2));
			minorCategoryModel.setCategoryCode(resultSet.getString(3));
			minorCategoryModel.setName(resultSet.getString(4));
			list.add(minorCategoryModel);
		}
		statement.close();
		DatabaseUtility.closeConnection(connection);

		return list;

	}

	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM MINERCATEGORY ");
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
