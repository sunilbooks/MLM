package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

public class PlanModel {
	private Integer id;
	private String name;
	private Integer level1;
	private Integer level2;
	private Integer level3;
	private Integer level4;
	private Integer level5;
	private Integer level6;
	private Integer level7;
	private Integer level8;
	private Integer level9;
	private Integer level10;

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

	public Integer getLevel1() {
		return level1;
	}

	public void setLevel1(Integer level1) {
		this.level1 = level1;
	}

	public Integer getLevel2() {
		return level2;
	}

	public void setLevel2(Integer level2) {
		this.level2 = level2;
	}

	public Integer getLevel3() {
		return level3;
	}

	public void setLevel3(Integer level3) {
		this.level3 = level3;
	}

	public Integer getLevel4() {
		return level4;
	}

	public void setLevel4(Integer level4) {
		this.level4 = level4;
	}

	public Integer getLevel5() {
		return level5;
	}

	public void setLevel5(Integer level5) {
		this.level5 = level5;
	}

	public Integer getLevel6() {
		return level6;
	}

	public void setLevel6(Integer level6) {
		this.level6 = level6;
	}

	public Integer getLevel7() {
		return level7;
	}

	public void setLevel7(Integer level7) {
		this.level7 = level7;
	}

	public Integer getLevel8() {
		return level8;
	}

	public void setLevel8(Integer level8) {
		this.level8 = level8;
	}

	public Integer getLevel9() {
		return level9;
	}

	public void setLevel9(Integer level9) {
		this.level9 = level9;
	}

	public Integer getLevel10() {
		return level10;
	}

	public void setLevel10(Integer level10) {
		this.level10 = level10;
	}

	public void add() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO PLAN (ID,LEVEL_1,LEVEL_2,LEVEL_3,LEVEL_4,LEVEL_5,LEVEL_6,"
						+ "LEVEL_7,LEVEL_8,LEVEL_9,LEVEL_10,NAME) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setInt(2, level1);
		preparedStatement.setInt(3, level2);
		preparedStatement.setInt(4, level3);
		preparedStatement.setInt(5, level4);
		preparedStatement.setInt(6, level5);
		preparedStatement.setInt(7, level6);
		preparedStatement.setInt(8, level7);
		preparedStatement.setInt(9, level8);
		preparedStatement.setInt(10, level9);
		preparedStatement.setInt(11, level10);
		preparedStatement.setString(12, name);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE PLAN SET LEVEL_1=?,LEVEL_2=?,LEVEL_3=?,LEVEL_4=?,LEVEL_5=?,LEVEL_6=?,"
						+ "LEVEL_7=?,LEVEL_8=?,LEVEL_9=?,LEVEL_10=?,NAME=? WHERE ID=?");
		preparedStatement.setInt(1, level1);
		preparedStatement.setInt(2, level2);
		preparedStatement.setInt(3, level3);
		preparedStatement.setInt(4, level4);
		preparedStatement.setInt(5, level5);
		preparedStatement.setInt(6, level6);
		preparedStatement.setInt(7, level7);
		preparedStatement.setInt(8, level8);
		preparedStatement.setInt(9, level9);
		preparedStatement.setInt(10, level10);
		preparedStatement.setString(11, name);
		preparedStatement.setInt(12, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM PLAN WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public PlanModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM PLAN WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		PlanModel planModel = new PlanModel();
		while (resultSet.next()) {
			planModel = new PlanModel();
			planModel.setId(resultSet.getInt(1));
			planModel.setLevel1(resultSet.getInt(2));
			planModel.setLevel2(resultSet.getInt(3));
			planModel.setLevel3(resultSet.getInt(4));
			planModel.setLevel4(resultSet.getInt(5));
			planModel.setLevel5(resultSet.getInt(6));
			planModel.setLevel6(resultSet.getInt(7));
			planModel.setLevel7(resultSet.getInt(8));
			planModel.setLevel8(resultSet.getInt(9));
			planModel.setLevel9(resultSet.getInt(10));
			planModel.setLevel10(resultSet.getInt(11));
			planModel.setName(resultSet.getString(12));

		}
		System.out.println(planModel.getName());
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);
		return planModel;

	}

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM PLAN WHERE 1=1");

		if (name != null && name.length() > 0) {
			searchQuery.append(" AND NAME LIKE '" + name + "%' ");
		}

		if (level1 != null && level1 > 0) {
			searchQuery.append(" AND LEVEL1 = '" + level1 + "' ");
		}
		if (level2 != null && level2 > 0) {
			searchQuery.append(" AND LEVEL2 = '" + level2 + "' ");
		}
		if (level3 != null && level3 > 0) {
			searchQuery.append(" AND LEVEL3 = '" + level3 + "' ");
		}
		if (level4 != null && level4 > 0) {
			searchQuery.append(" AND LEVEL4 = '" + level4 + "' ");
		}
		if (level5 != null && level5 > 0) {
			searchQuery.append(" AND LEVEL5 = '" + level5 + "' ");
		}
		if (level6 != null && level6 > 0) {
			searchQuery.append(" AND LEVEL6 = '" + level6 + "' ");
		}
		if (level7 != null && level7 > 0) {
			searchQuery.append(" AND LEVEL7 = '" + level7 + "' ");
		}
		if (level8 != null && level8 > 0) {
			searchQuery.append(" AND LEVEL8 = '" + level8 + "' ");
		}
		if (level9 != null && level9 > 0) {
			searchQuery.append(" AND LEVEL9 = '" + level9 + "' ");
		}
		if (level10 != null && level10 > 0) {
			searchQuery.append(" AND LEVEL10 = '" + level10 + "' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			PlanModel planModel = new PlanModel();
			planModel.setId(resultSet.getInt(1));
			planModel.setLevel1(resultSet.getInt(2));
			planModel.setLevel2(resultSet.getInt(3));
			planModel.setLevel3(resultSet.getInt(4));
			planModel.setLevel4(resultSet.getInt(5));
			planModel.setLevel5(resultSet.getInt(6));
			planModel.setLevel6(resultSet.getInt(7));
			planModel.setLevel7(resultSet.getInt(8));
			planModel.setLevel8(resultSet.getInt(9));
			planModel.setLevel9(resultSet.getInt(11));
			planModel.setLevel10(resultSet.getInt(11));
			planModel.setName(resultSet.getString(12));

			list.add(planModel);
		}
		statement.close();
		DatabaseUtility.closeConnection(connection);
		return list;

	}
	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM PLAN ");
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
