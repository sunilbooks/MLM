package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.UserModel;

/**
 * Servlet implementation class UserListCtl
 */
public class UserListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UserModel userModel = new UserModel();
			List list = userModel.search();
			request.setAttribute("List", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("BaseLayout.jsp?body=UserList.jsp");
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
