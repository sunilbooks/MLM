package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

public class MajorCategoryModel {
	private Integer id = null;
	private String categoryCode = null;
	private String name = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO MAJORCATEGORY (ID,NAME,CATEGORY_CODE) VALUES (?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, categoryCode);
		preparedStatement.setString(3, name);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE MAJORCATEGORY SET NAME=?,CATEGORY_CODE=? WHERE ID=?");
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, categoryCode);
		preparedStatement.setInt(3, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM MAJORCATEGORY WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public MajorCategoryModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM MAJORCATEGORY WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		MajorCategoryModel majorCategoryModel = null;
		while (resultSet.next()) {
			majorCategoryModel = new MajorCategoryModel();
			majorCategoryModel.setId(resultSet.getInt(1));
			majorCategoryModel.setCategoryCode(resultSet.getString(2));
			majorCategoryModel.setName(resultSet.getString(3));
		}
		System.out.println(majorCategoryModel.getName());
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

		return majorCategoryModel;

	}

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM MAJORCATEGORY WHERE 1=1");

		if (categoryCode != null && categoryCode.length() > 0) {
			searchQuery.append(" AND CATEGORYCODE LIKE '" + categoryCode
					+ "%' ");
		}
		if (name != null && name.length() > 0) {
			searchQuery.append(" AND NAME '" + name + "%' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			MajorCategoryModel majorCategoryModel = new MajorCategoryModel();
			majorCategoryModel.setId(resultSet.getInt(1));
			majorCategoryModel.setCategoryCode(resultSet.getString(2));
			majorCategoryModel.setName(resultSet.getString(3));

			list.add(majorCategoryModel);
		}
		statement.close();
		DatabaseUtility.closeConnection(connection);

		return list;

	}

	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM MAJORCATEGORY ");
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
