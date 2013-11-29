package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.CenterModel;
import com.sunrays.javarefbook.mlm.model.UserModel;

public class UserCtl extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

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

		String operation = request.getParameter("operation");
		UserModel userModel = new UserModel();
		if ("Save".equalsIgnoreCase(operation)) {
			try {
				userModel.setId(id);
				userModel.setFirstName(firstName);
				userModel.setLastName(lastName);
				userModel.setDateOfBirth(new Date());

				userModel.setUserid(userid);
				userModel.setUserPassword(userPassword);
				userModel.setAddress(address);
				userModel.setGender(gender);
				userModel.setRoleName(roleName);

				userModel.setTelephonNo(telephonNo);
				userModel.setOrganization(organization);
				userModel.setCenterId(centerId);
				userModel.setCenterName(centerName);
				userModel.setReferredById(referredById);
				userModel.setReferredByName(referredByName);
				userModel.setPlanId(planId);
				userModel.setPlanName(planName);

				userModel.add();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=User.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data added");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if ("Update".equalsIgnoreCase(operation)) {
			try {
				userModel.setId(id);
				userModel.setFirstName(firstName);
				userModel.setLastName(lastName);
				userModel.setDateOfBirth(new Date());

				userModel.setUserid(userid);
				userModel.setUserPassword(userPassword);
				userModel.setRoleName(roleName);
				userModel.setAddress(address);
				userModel.setGender(gender);
				userModel.setTelephonNo(telephonNo);
				userModel.setOrganization(organization);
				userModel.setCenterId(centerId);
				userModel.setCenterName(centerName);
				userModel.setPlanId(planId);
				userModel.setPlanName(planName);
				userModel.setReferredById(referredById);
				userModel.setReferredByName(referredByName);
				userModel.update();
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=User.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data Updated");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
		if ("Delete".equalsIgnoreCase(operation)) {
			try {
				userModel.setId(id);
				userModel.delete();
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=User.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data delete");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ("Get".equalsIgnoreCase(operation)) {
			try {
				userModel.setId(id);
				userModel = userModel.findByPK(id);
				request.setAttribute("get", userModel);
				RequestDispatcher requestDispatcher = request

				.getRequestDispatcher("BaseLayout.jsp?body=User.jsp");
				requestDispatcher.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request

		.getRequestDispatcher("BaseLayout.jsp?body=User.jsp");
		requestDispatcher.forward(request, response);
	}

}
