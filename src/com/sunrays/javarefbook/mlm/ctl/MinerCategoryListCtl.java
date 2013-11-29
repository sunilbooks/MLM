package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.MinorCategoryModel;

/**
 * Servlet implementation class MinerCategoryListCtl
 */
public class MinerCategoryListCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			System.out.println("iin List");
			MinorCategoryModel minorCategoryModel = new MinorCategoryModel();
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
