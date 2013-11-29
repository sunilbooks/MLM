package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.ItemModel;
import com.sunrays.javarefbook.mlm.model.OrganizationModel;

public class OrganizationCtl extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Integer id = null;
		String name = null;
		String address = null;
		String phoneNo = null;
		String faxNo = null;
		String email = null;
		String url = null;
		String logo = null;
		String operation = null;

		try {
			id = Integer.parseInt(request.getParameter("id"));
			name = request.getParameter("name");
			address = request.getParameter("address");
			phoneNo = request.getParameter("phoneNo");
			faxNo = request.getParameter("faxNo");
			email = request.getParameter("email");
			url = request.getParameter("url");
			logo = request.getParameter("logo");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		operation = request.getParameter("operation");
		OrganizationModel organizationModel = new OrganizationModel();

		if ("Save".equalsIgnoreCase(operation)) {
			try {
				organizationModel.setId(id);
				organizationModel.setName(name);
				organizationModel.setAddress(address);
				organizationModel.setPhoneNo(phoneNo);
				organizationModel.setFaxNo(faxNo);
				organizationModel.setEmail(email);
				organizationModel.setUrl(url);
				organizationModel.setLogo(logo);

				organizationModel.add();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Organization.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data added");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		if ("Update".equalsIgnoreCase(operation)) {

			try {
				organizationModel.setId(id);
				organizationModel.setName(name);
				organizationModel.setAddress(address);
				organizationModel.setPhoneNo(phoneNo);
				organizationModel.setFaxNo(faxNo);
				organizationModel.setEmail(email);
				organizationModel.setUrl(url);
				organizationModel.setLogo(logo);

				organizationModel.update();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Organization.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data updated");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if ("Get".equalsIgnoreCase(operation)) {
			try {
				organizationModel.setId(id);
				organizationModel = organizationModel.findByPK(id);
				request.setAttribute("get", organizationModel);
				RequestDispatcher requestDispatcher = request

				.getRequestDispatcher("BaseLayout.jsp?body=Organization.jsp");
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

		.getRequestDispatcher("BaseLayout.jsp?body=Organization.jsp");
		requestDispatcher.forward(request, response);
	}

}
