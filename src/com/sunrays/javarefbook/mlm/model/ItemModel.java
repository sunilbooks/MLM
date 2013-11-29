package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

public class ItemModel {
	private Integer id = null;
	private String itemName = null;
	private String majorCategory = null;
	private String minorCategory = null;
	private Integer itemSize = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getMajorCategory() {
		return majorCategory;
	}

	public void setMajorCategory(String majorCategory) {
		this.majorCategory = majorCategory;
	}

	public String getMinorCategory() {
		return minorCategory;
	}

	public void setMinorCategory(String minorCategory) {
		this.minorCategory = minorCategory;
	}

	public Integer getItemSize() {
		return itemSize;
	}

	public void setItemSize(Integer itemSize) {
		this.itemSize = itemSize;
	}

	public void add() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO ITEM (ID,ITEM_NAME,MAJOR_CATEGORY,MINOR_CATEGORY,ITEM_SIZE) VALUES (?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, itemName);
		preparedStatement.setString(3, majorCategory);
		preparedStatement.setString(4, minorCategory);
		preparedStatement.setInt(5, itemSize);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE ITEM SET ITEM_NAME=?,MAJOR_CATEGORY=?,MINOR_CATEGORY=?,ITEM_SIZE=? WHERE ID=?");
		preparedStatement.setString(1, itemName);
		preparedStatement.setString(2, majorCategory);
		preparedStatement.setString(3, minorCategory);
		preparedStatement.setInt(4, itemSize);
		preparedStatement.setInt(5, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM ITEM WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public ItemModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM ITEM WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		ItemModel itemModel = null;
		while (resultSet.next()) {
			itemModel = new ItemModel();
			itemModel.setId(resultSet.getInt(1));
			itemModel.setItemName(resultSet.getString(2));
			itemModel.setMajorCategory(resultSet.getString(3));
			itemModel.setMinorCategory(resultSet.getString(4));
			itemModel.setItemSize(resultSet.getInt(5));
		}
		System.out.println(itemModel.itemName);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

		return itemModel;

	}

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM ITEM WHERE 1=1");

		if (itemName != null && itemName.length() > 0) {
			searchQuery.append(" AND ITEMNAME LIKE '" + itemName + "%' ");
		}
		if (majorCategory != null && majorCategory.length() > 0) {
			searchQuery.append(" AND MAJORCATEGORY '" + majorCategory + "%' ");
		}
		if (minorCategory != null && minorCategory.length() > 0) {
			searchQuery.append(" AND  MINORCATEGORY LIKE '" + minorCategory
					+ "%' ");
		}
		if (itemSize != null && itemSize > 0) {
			searchQuery.append(" AND ITEMSIZE = '" + itemSize + "' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			ItemModel itemModel = new ItemModel();
			itemModel.setId(resultSet.getInt(1));
			itemModel.setItemName(resultSet.getString(2));
			itemModel.setMajorCategory(resultSet.getString(3));
			itemModel.setMinorCategory(resultSet.getString(4));
			itemModel.setItemSize(resultSet.getInt(5));
			list.add(itemModel);
		}
		statement.close();
		DatabaseUtility.closeConnection(connection);
		return list;

	}
	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM ITEM ");
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
