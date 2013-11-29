package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.MajorCategoryModel;

public class MajorCategoryListCtl extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MajorCategoryModel majorCategoryModel = new MajorCategoryModel();
		try {
			List list = majorCategoryModel.search();
			request.setAttribute("majorCategoryList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("BaseLayout.jsp?body=MajorCategoryList.jsp");
		dispatcher.forward(request, response);
	}
}