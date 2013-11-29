package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.RoleModel;

public class RoleCtl extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Integer id = null;
		String name = null;

		try {
			id = Integer.parseInt(request.getParameter("id"));
			name = request.getParameter("name");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String operation = request.getParameter("operation");
		RoleModel roleModel = new RoleModel();
		if ("Save".equalsIgnoreCase(operation)) {
			try {
				roleModel.setId(id);
				roleModel.setName(name);
				roleModel.add();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Role.jsp");
				requestDispatcher.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if ("Update".equalsIgnoreCase(operation)) {
			try {
				roleModel.setId(id);
				roleModel.setName(name);
				roleModel.update();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Role.jsp");
				requestDispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		if ("Delete".equalsIgnoreCase(operation)) {
			try {
				roleModel.setId(id);
				roleModel.delete();
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Role.jsp");
				requestDispatcher.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ("Get".equalsIgnoreCase(operation)) {
			try {
				roleModel.setId(id);
				roleModel = roleModel.findByPK(id);
				request.setAttribute("get", roleModel);

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Role.jsp");
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
				.getRequestDispatcher("BaseLayout.jsp?body=Role.jsp");
		requestDispatcher.forward(request, response);
	}

}
