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
import com.sunrays.javarefbook.mlm.model.MajorCategoryModel;
import com.sunrays.javarefbook.mlm.model.MinorCategoryModel;

public class ItemCtl extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		ItemModel itemModel = new ItemModel();

		Integer id = null;
		String itemName = null;
		String majorCategory = null;
		String minorCategory = null;
		Integer itemSize = null;
		String operation = null;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			itemName = request.getParameter("ItemName");
			majorCategory = request.getParameter("majorCategory");
			minorCategory = request.getParameter("minorCategory");
			itemSize = Integer.parseInt(request.getParameter("itemSize"));

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		operation = request.getParameter("operation");
		if ("Save".equalsIgnoreCase(operation)) {
			itemModel.setId(id);
			itemModel.setItemName(itemName);
			itemModel.setMajorCategory(majorCategory);
			itemModel.setMinorCategory(minorCategory);
			itemModel.setItemSize(itemSize);
			try {
				itemModel.add();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Item.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data added");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ("Update".equalsIgnoreCase(operation)) {
			try {
				itemModel.setId(id);
				itemModel.setItemName(itemName);
				itemModel.setMajorCategory(majorCategory);
				itemModel.setMinorCategory(minorCategory);
				itemModel.setItemSize(itemSize);

				itemModel.update();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Item.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data updated");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if ("Get".equalsIgnoreCase(operation)) {
			try {
				itemModel.setId(id);
				itemModel = itemModel.findByPK(id);
				request.setAttribute("get", itemModel);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Item.jsp");
				requestDispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			MajorCategoryModel majorCategoryModel = new MajorCategoryModel();
			List list = majorCategoryModel.search();

			request.setAttribute("majorList", list);

			MinorCategoryModel minorCategoryModel = new MinorCategoryModel();
			list = minorCategoryModel.search();

			request.setAttribute("minorList", list);

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("BaseLayout.jsp?body=Item.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
