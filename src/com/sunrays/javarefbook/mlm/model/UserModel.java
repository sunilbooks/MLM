package com.sunrays.javarefbook.mlm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunrays.javarefbook.utility.DatabaseUtility;

public class UserModel {
	private Integer id = null;
	private String firstName = null;
	private String lastName = null;
	private Date dateOfBirth = null;
	private String userid = null;
	private String userPassword = null;
	private String roleName = null;
	private String address = null;
	private String gender = null;
	private String telephonNo = null;
	private String organization = null;
	private Long centerId = null;
	private String centerName = null;
	private Long planId = null;
	private String planName = null;
	private Long referredById = null;
	private String referredByName = null;
	private RoleModel roleModel = null;

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTelephonNo() {
		return telephonNo;
	}

	public void setTelephonNo(String telephonNo) {
		this.telephonNo = telephonNo;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Long getCenterId() {
		return centerId;
	}

	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Long getReferredById() {
		return referredById;
	}

	public void setReferredById(Long referredById) {
		this.referredById = referredById;
	}

	public String getReferredByName() {
		return referredByName;
	}

	public void setReferredByName(String referredByName) {
		this.referredByName = referredByName;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

	public void add() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO USER (ID,FIRST_NAME,LAST_NAME, DATE_OF_BIRTH,USER_ID,"
						+ "USER_PASSWORD,ADDRESS,GENDER,ROLE_NAME,TELEPHONE_NO,ORGANIZATION,CENTERID,CENTER_NAME,"
						+ "REFEREDBYID,REFFREDBYNAME,PLANID,PLANNAME) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, firstName);
		preparedStatement.setString(3, lastName);
		preparedStatement.setDate(4, new java.sql.Date(dateOfBirth.getTime()));
		preparedStatement.setString(5, userid);
		preparedStatement.setString(6, userPassword);
		preparedStatement.setString(7, address);
		preparedStatement.setString(8, gender);

		preparedStatement.setString(9, roleName);
		preparedStatement.setString(10, telephonNo);

		preparedStatement.setString(11, organization);
		preparedStatement.setLong(12, centerId);
		preparedStatement.setString(13, centerName);
		preparedStatement.setLong(14, referredById);
		preparedStatement.setString(15, referredByName);
		preparedStatement.setLong(16, planId);
		preparedStatement.setString(17, planName);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void update() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE USER SET FIRST_NAME=?,LAST_NAME=?, DATE_OF_BIRTH=?,USER_ID=?,"
						+ "USER_PASSWORD=?,ADDRESS=?,GENDER=?,ROLE_NAME=?,TELEPHONE_NO=?,ORGANIZATION=?,CENTERID=?,CENTER_NAME=?,"
						+ "REFEREDBYID=?,REFFREDBYNAME=?,PLANID=?,PLANNAME=? WHERE ID=?");
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		preparedStatement.setDate(3, new java.sql.Date(dateOfBirth.getTime()));
		preparedStatement.setString(4, userid);
		preparedStatement.setString(5, userPassword);
		preparedStatement.setString(6, address);
		preparedStatement.setString(7, gender);

		preparedStatement.setString(8, roleName);
		preparedStatement.setString(9, telephonNo);

		preparedStatement.setString(10, organization);
		preparedStatement.setLong(11, centerId);
		preparedStatement.setString(12, centerName);
		preparedStatement.setLong(13, referredById);
		preparedStatement.setString(14, referredByName);
		preparedStatement.setLong(15, planId);
		preparedStatement.setString(16, planName);
		preparedStatement.setInt(17, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public void delete() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM USER WHERE ID=?");
		preparedStatement.setInt(1, id);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);

	}

	public UserModel findByPK(Integer id) throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM USER WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		UserModel userModel = null;
		while (resultSet.next()) {
			userModel = new UserModel();
			userModel.setId(resultSet.getInt(1));
			userModel.setFirstName(resultSet.getString(2));
			userModel.setLastName(resultSet.getString(3));
			userModel.setDateOfBirth(resultSet.getDate(4));
			userModel.setUserid(resultSet.getString(5));
			userModel.setUserPassword(resultSet.getString(6));
			userModel.setAddress(resultSet.getString(7));
			userModel.setGender(resultSet.getString(8));
			userModel.setRoleName(resultSet.getString(9));

			userModel.setTelephonNo(resultSet.getString(10));
			userModel.setOrganization(resultSet.getString(11));
			userModel.setCenterId(resultSet.getLong(12));
			userModel.setCenterName(resultSet.getString(13));

			userModel.setReferredById(resultSet.getLong(14));
			userModel.setReferredByName(resultSet.getString(15));
			userModel.setPlanId(resultSet.getLong(16));
			userModel.setPlanName(resultSet.getString(17));

		}
		System.out.println(userModel.firstName);
		preparedStatement.close();
		DatabaseUtility.closeConnection(connection);
		return userModel;

	}

	public List search() throws Exception {
		Connection connection = DatabaseUtility.openConnection();
		StringBuffer searchQuery = new StringBuffer(
				"SELECT * FROM USER WHERE 1=1");

		if (firstName != null && firstName.length() > 0) {
			searchQuery.append(" AND FIRSTNAME '" + firstName + "%' ");
		}
		if (lastName != null && lastName.length() > 0) {
			searchQuery.append(" AND  LASTNAME LIKE '" + lastName + "%' ");
		}
		if (dateOfBirth != null) {
			searchQuery.append(" AND DATEOFBIRTH = '" + dateOfBirth + "' ");
		}
		if (userid != null && userid.length() > 0) {
			searchQuery.append(" AND  USERID LIKE '" + userid + "%' ");
		}
		if (userPassword != null && userPassword.length() > 0) {
			searchQuery.append(" AND  USERPASSWORD LIKE '" + userPassword
					+ "%' ");
		}
		if (roleName != null && roleName.length() > 0) {
			searchQuery.append(" AND   ROLENAME LIKE '" + roleName + "%' ");
		}
		if (address != null && address.length() > 0) {
			searchQuery.append(" AND  ADDRESS LIKE '" + address + "%' ");
		}
		if (gender != null && gender.length() > 0) {
			searchQuery.append(" AND  GENDER  LIKE '" + gender + "%' ");
		}
		if (telephonNo != null && telephonNo.length() > 0) {
			searchQuery.append(" AND  TELEPHONNO  LIKE '" + telephonNo + "%' ");
		}
		if (organization != null && organization.length() > 0) {
			searchQuery.append(" AND  ORGANIZATION  LIKE '" + organization
					+ "%' ");
		}
		if (centerId != null) {
			searchQuery.append(" AND CENTERID = '" + centerId + "' ");
		}
		if (centerName != null && centerName.length() > 0) {
			searchQuery.append(" AND  CENTERNAME  LIKE '" + centerName + "%' ");
		}

		if (planId != null) {
			searchQuery.append(" AND PLANID = '" + planId + "' ");
		}
		if (planName != null && planName.length() > 0) {
			searchQuery.append(" AND  PLANNAME  LIKE '" + planName + "%' ");
		}
		if (referredById != null) {
			searchQuery.append(" AND REFERREDBYID = '" + referredById + "' ");
		}
		if (referredByName != null && referredByName.length() > 0) {
			searchQuery.append(" AND  REFERREDBYNAME  LIKE '" + referredByName
					+ "%' ");
		}

		List list = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery.toString());
		while (resultSet.next()) {
			UserModel userModel = new UserModel();
			userModel.setId(resultSet.getInt(1));
			userModel.setFirstName(resultSet.getString(2));
			userModel.setLastName(resultSet.getString(3));
			userModel.setDateOfBirth(resultSet.getDate(4));
			userModel.setUserid(resultSet.getString(5));
			userModel.setUserPassword(resultSet.getString(6));

			userModel.setAddress(resultSet.getString(7));
			userModel.setGender(resultSet.getString(8));
			userModel.setRoleName(resultSet.getString(9));
			userModel.setTelephonNo(resultSet.getString(10));
			userModel.setOrganization(resultSet.getString(11));
			userModel.setCenterId(resultSet.getLong(12));
			userModel.setCenterName(resultSet.getString(13));
			userModel.setReferredById(resultSet.getLong(14));
			userModel.setReferredByName(resultSet.getString(15));
			userModel.setPlanId(resultSet.getLong(16));
			userModel.setPlanName(resultSet.getString(17));

			list.add(userModel);
		}
		statement.close();
		DatabaseUtility.closeConnection(connection);
		return list;

	}

	public int nextPK() throws Exception {

		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT MAX(ID) FROM USER ");
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

	public UserModel authenticate() throws Exception {
		System.out.println("in usermodelauth");
		DatabaseUtility.openConnection();
		Connection connection = DatabaseUtility.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT U.*,R.NAME FROM USER U INNER JOIN ROLE R ON(U.ROLE_ID=R.ID) WHERE U.USER_ID=? AND U.USER_PASSWORD=?");
		preparedStatement.setString(1, userid);
		preparedStatement.setString(2, userPassword);
		ResultSet resultSet = preparedStatement.executeQuery();
		UserModel userModel = null;

		if (resultSet.next()) {
			System.out.println("in resultset");
			userModel = new UserModel();
			userModel.setFirstName(resultSet.getString(2));
			userModel.setLastName(resultSet.getString(3));
			roleModel = new RoleModel();
			roleModel.setName(resultSet.getString(18));
			userModel.setRoleModel(roleModel);
		}
		preparedStatement.close();
		connection.close();
		return userModel;
	}
}
