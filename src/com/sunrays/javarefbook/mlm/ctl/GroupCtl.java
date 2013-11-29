package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.GroupModel;
import com.sunrays.javarefbook.mlm.model.UserModel;

public class GroupCtl extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		GroupModel groupModel = new GroupModel();
		Integer id = null;
		Integer groupId = null;
		Integer userId = null;
		Integer noOfId = null;
		String operation = null;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			groupId = Integer.parseInt(request.getParameter("groupId"));
			userId = Integer.parseInt(request.getParameter("userId"));
			noOfId = Integer.parseInt(request.getParameter("noOfId"));
		} catch (Exception e) {
		}
		operation = request.getParameter("operation");

		if ("Save".equalsIgnoreCase(operation)) {
			try {
				groupModel.setId(id);
				groupModel.setGroupId(groupId);
				groupModel.setUserId(userId);
				groupModel.setNoOfId(noOfId);

				groupModel.add();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Group.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data added");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ("Update".equalsIgnoreCase(operation)) {
			groupModel.setId(id);
			groupModel.setGroupId(groupId);
			groupModel.setUserId(userId);
			groupModel.setNoOfId(noOfId);

			try {
				groupModel.update();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("BaseLayout.jsp?body=Group.jsp");
			requestDispatcher.forward(request, response);
			System.out.println("data Updated");

		}
		if ("Delete".equalsIgnoreCase(operation)) {
			try {
				groupModel.setId(id);
				groupModel.delete();
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=GroupList.jsp");
				dispatcher.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			GroupModel groupModel = new GroupModel();
			
			String operation = request.getParameter("operation");
			 Integer id = Integer.parseInt(request.getParameter("id"));


			if ("Get".equalsIgnoreCase(operation)) {

				try {
					groupModel.setId(id);
					groupModel = groupModel.findByPK(id);
					request.setAttribute("get", groupModel);
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("BaseLayout.jsp?body=Group.jsp");
					requestDispatcher.forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			List list = groupModel.search();
			request.setAttribute("groupList", list);

			UserModel userModel = new UserModel();
			list = userModel.search();
			request.setAttribute("userList", list);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("BaseLayout.jsp?body=Group.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {

		}

	}

}
