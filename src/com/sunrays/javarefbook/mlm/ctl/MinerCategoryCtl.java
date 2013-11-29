package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.MinorCategoryModel;

public class MinerCategoryCtl extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do get");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		MinorCategoryModel minorCategoryModel = new MinorCategoryModel();

		Integer id = null;
		String majorCategoryId = null;
		String categoryCode = null;
		String name = null;
		String operation = null;

		try {
			id = Integer.parseInt(request.getParameter("id"));
			majorCategoryId = request.getParameter("majorCategoryId");
			categoryCode = request.getParameter("categoryCode");

			name = request.getParameter("name");
		} catch (Exception e) {
			e.printStackTrace();
		}

		operation = request.getParameter("operation");

		if ("Save".equalsIgnoreCase(operation)) {
			try {
				System.out.println("in save");
				minorCategoryModel.setId(id);
				minorCategoryModel.setMajorCategoryId(majorCategoryId);
				minorCategoryModel.setCategoryCode(categoryCode);

				minorCategoryModel.setName(name);
				minorCategoryModel.add();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=MinerCategory.jsp");
				requestDispatcher.forward(request, response);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if ("Update".equalsIgnoreCase(operation)) {
			try {
				System.out.println("in update");
				minorCategoryModel.setId(id);
				minorCategoryModel.setMajorCategoryId(majorCategoryId);
				minorCategoryModel.setCategoryCode(categoryCode);
			

				minorCategoryModel.setName(name);
				minorCategoryModel.update();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=MinerCategory.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data updated");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if ("Delete".equalsIgnoreCase(operation)) {
			try {
				minorCategoryModel.setId(id);
				minorCategoryModel.delete();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=MinerCategory.jsp");
				requestDispatcher.forward(request, response);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		if ("List".equalsIgnoreCase(operation)) {
			try {
				System.out.println("iin List");
				minorCategoryModel = new MinorCategoryModel();
				List list = minorCategoryModel.search();
				request.setAttribute("List", list);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=MinerCategoryList.jsp");
				requestDispatcher.forward(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if ("Get".equalsIgnoreCase(operation)) {
			try {
				minorCategoryModel.getId();
				minorCategoryModel = minorCategoryModel.findByPK(id);
				request.setAttribute("get", minorCategoryModel);

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=MinerCategory.jsp");
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
				.getRequestDispatcher("BaseLayout.jsp?body=MinerCategory.jsp");
		requestDispatcher.forward(request, response);}

}
