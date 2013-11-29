package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

public class OrganizationModel {
	private Integer id = null;
	private String name = null;
	private String address = null;
	private String phoneNo = null;
	private String faxNo = null;
	private String email = null;
	private String url = null;
	private String logo = null;

	

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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void add() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO ORGANIZATION (ID,NAME,ADDRESS,PHONE_NO,FAX_NO,E_MAIL,URL,LOGO) VALUES (?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, address);
		preparedStatement.setString(4, phoneNo);
		preparedStatement.setString(5, faxNo);
		preparedStatement.setString(6, email);
		preparedStatement.setString(7, url);
		preparedStatement.setString(8, logo);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE ORGANIZATION SET NAME=?,ADDRESS=?,PHONE_NO=?,FAX_NO=?,URL=?,LOGO=? WHERE ID=?");
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, address);
		preparedStatement.setString(3, phoneNo);
		preparedStatement.setString(4, faxNo);
		preparedStatement.setString(5, email);
		preparedStatement.setString(6, url);
		preparedStatement.setString(6, logo);
		preparedStatement.setInt(7, id);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM ORGANIZATION WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public OrganizationModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM ORGANIZATION WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		OrganizationModel organizationModel = null;
		while (resultSet.next()) {
			organizationModel = new OrganizationModel();
			organizationModel.setId(resultSet.getInt(1));
			organizationModel.setName(resultSet.getString(2));
			organizationModel.setAddress(resultSet.getString(3));
			organizationModel.setPhoneNo(resultSet.getString(4));
			organizationModel.setFaxNo(resultSet.getString(5));
			organizationModel.setEmail(resultSet.getString(6));
			organizationModel.setUrl(resultSet.getString(7));
			organizationModel.setLogo(resultSet.getString(8));
		}
		System.out.println(organizationModel.getName());
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);
		return organizationModel;

	}

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM ORGANIZATION WHERE 1=1");

		if (name != null && name.length() > 0) {
			searchQuery.append(" AND NAME LIKE '" + name + "%' ");
		}
		if (address != null && address.length() > 0) {
			searchQuery.append(" AND ADDRESS LIKE '" + address + "%' ");
		}
		if (phoneNo != null && phoneNo.length() > 0) {
			searchQuery.append(" AND  PHONENO LIKE '" + phoneNo + "%' ");
		}
		if (faxNo != null && faxNo.length() > 0) {
			searchQuery.append(" AND FAXNO'" + faxNo + "%' ");
		}
		if (email != null && email.length() > 0) {
			searchQuery.append(" AND EMAIL LIKE '" + email + "%' ");
		}
		if (url != null && url.length() > 0) {
			searchQuery.append(" AND URL LIKE '" + url + "%' ");
		}
		if (logo != null && logo.length() > 0) {
			searchQuery.append(" AND LOGO LIKE '" + logo + "%' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			OrganizationModel organizationModel = new OrganizationModel();

			organizationModel.setId(resultSet.getInt(1));
			organizationModel.setName(resultSet.getString(2));
			organizationModel.setAddress(resultSet.getString(3));
			organizationModel.setPhoneNo(resultSet.getString(4));
			organizationModel.setFaxNo(resultSet.getString(5));
			organizationModel.setEmail(resultSet.getString(6));
			organizationModel.setUrl(resultSet.getString(7));
			organizationModel.setLogo(resultSet.getString(8));
			list.add(organizationModel);
		}
		statement.close();
		DatabaseUtility.closeConnection(connection);
		return list;

	}
	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM ORGANIZATION ");
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
