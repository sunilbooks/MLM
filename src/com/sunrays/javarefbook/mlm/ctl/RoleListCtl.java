package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.RoleModel;

/**
 * Servlet implementation class RoleListCtl
 */
public class RoleListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			RoleModel roleModel = new RoleModel();
			List list = roleModel.search();
			request.setAttribute("List", list);

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("BaseLayout.jsp?body=RoleList.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
