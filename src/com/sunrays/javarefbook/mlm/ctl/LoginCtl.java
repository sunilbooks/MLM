package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunrays.javarefbook.mlm.model.UserModel;

public class LoginCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);

		String userid = request.getParameter("userid");
		String userPassword = request.getParameter("userPassword");
		String operation = request.getParameter("operation");
		/*
		 * String loginId = request.getParameter("loginId"); String password =
		 * request.getParameter("password");
		 */

		if ("Login".equalsIgnoreCase(operation)) {
			System.out.println("in login");
			try {
				UserModel userModel = new UserModel();
				userModel.setUserid(userid);
				userModel.setUserPassword(userPassword);
				UserModel dbModel = userModel.authenticate();

				if (dbModel != null) {
					session.setAttribute("user", dbModel);
					System.out.println("vailid user userAuth");
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("BaseLayout.jsp");
					requestDispatcher.forward(request, response);
				} else {
					System.out.println("invailid username /password");
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("BaseLayout.jsp");
					requestDispatcher.forward(request, response);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
