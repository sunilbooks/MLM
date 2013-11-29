package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyProfileCtl extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer id = null;
		String firstName = null;
		String lastName = null;
		Date dateOfBirth = null;
		String userid = null;
		String userPassword = null;
		String roleName = null;
		String address = null;
		String gender = null;
		String telephonNo = null;
		String organization = null;
		Long centerId = null;
		String centerName = null;
		Long planId = null;
		String planName = null;
		Long referredById = null;
		String referredByName = null;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			firstName = request.getParameter("firstName");
			lastName = request.getParameter("lastName");
			userid = request.getParameter("userid");
			userPassword = request.getParameter("userPassword");
			address = request.getParameter("address");
			gender = request.getParameter("gender");
			roleName = request.getParameter("roleName");

			telephonNo = request.getParameter("telephonNo");
			organization = request.getParameter("organization");
			centerId = Long.parseLong(request.getParameter("centerId"));
			centerName = request.getParameter("centerName");
			referredById = Long.parseLong(request.getParameter("referredById"));
			referredByName = request.getParameter("referredByName");
			planId = Long.parseLong(request.getParameter("planId"));
			planName = request.getParameter("planName");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
