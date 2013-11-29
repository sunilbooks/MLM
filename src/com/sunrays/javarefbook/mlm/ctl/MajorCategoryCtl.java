package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.CenterModel;
import com.sunrays.javarefbook.mlm.model.MajorCategoryModel;

public class MajorCategoryCtl extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		CenterModel centerModel = new CenterModel();
		Integer id = null;
		String categoryCode = null;
		String name = null;

		try {
			id = Integer.parseInt(request.getParameter("id"));
			categoryCode = request.getParameter("categoryCode");
			name = request.getParameter("name");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String operation = request.getParameter("operation");
		MajorCategoryModel majorCategoryModel = new MajorCategoryModel();
		if ("Save".equalsIgnoreCase(operation)) {
			try {
				majorCategoryModel.setId(id);
				majorCategoryModel.setCategoryCode(categoryCode);
				majorCategoryModel.setName(name);
				majorCategoryModel.add();
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=MajorCategory.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data added");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ("Update".equalsIgnoreCase(operation)) {
			try {
				majorCategoryModel.setId(id);
				majorCategoryModel.setCategoryCode(categoryCode);
				majorCategoryModel.setName(name);
				majorCategoryModel.update();
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=MajorCategory.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data updated");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if ("Get".equalsIgnoreCase(operation)) {
			try {
				majorCategoryModel.setId(id);
				majorCategoryModel = majorCategoryModel.findByPK(id);

				request.setAttribute("get", majorCategoryModel);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=MajorCategory.jsp");
				dispatcher.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("BaseLayout.jsp?body=MajorCategory.jsp");
		requestDispatcher.forward(request, response);
	}

}
