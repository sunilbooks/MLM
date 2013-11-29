package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.CenterModel;

public class CenterCtl extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		CenterModel centerModel = new CenterModel();

		Integer id = null;
		String name = null;
		String address = null;
		String loginId = null;
		String password = null;
		String phoneNo = null;
		String permissionId = null;
		String operation = request.getParameter("operation");

		try {

			id = Integer.parseInt(request.getParameter("id"));

			name = request.getParameter("name");
			address = request.getParameter("address");
			loginId = request.getParameter("loginId");
			password = request.getParameter("password");
			phoneNo = request.getParameter("phoneno");
			permissionId = request.getParameter("permissionId");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("in ctl " + operation);

		if ("save".equalsIgnoreCase(operation)) {
			System.out.println("in save");
			centerModel.setId(id);
			centerModel.setName(name);
			centerModel.setAddress(address);
			centerModel.setPermissionId(permissionId);
			centerModel.setPhoneNo(phoneNo);
			centerModel.setLoginId(loginId);
			centerModel.setPassword(password);
			try {
				centerModel.add();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Center.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data added");

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		if ("Update".equalsIgnoreCase(operation)) {

			centerModel.setId(id);
			centerModel.setName(name);
			centerModel.setAddress(address);
			centerModel.setPermissionId(permissionId);
			centerModel.setPhoneNo(phoneNo);
			centerModel.setLoginId(loginId);
			centerModel.setPassword(password);
			try {
				centerModel.update();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Center.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data added");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String operation = request.getParameter("operation");

		if ("Get".equalsIgnoreCase(operation)) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				CenterModel centerModel = new CenterModel();
				centerModel.setId(id);
				centerModel = centerModel.findByPK(id);
				request.setAttribute("getRecord", centerModel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("BaseLayout.jsp?body=Center.jsp");
		requestDispatcher.forward(request, response);
	}

}