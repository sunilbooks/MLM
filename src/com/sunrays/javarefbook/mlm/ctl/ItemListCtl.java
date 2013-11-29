package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.ItemModel;

public class ItemListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			ItemModel itemModel = new ItemModel();
			List list = itemModel.search();

			request.setAttribute("List", list);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("BaseLayout.jsp?body=ItemList.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		Integer id = Integer.parseInt(request.getParameter("id"));
		if ("Delete".equalsIgnoreCase("operation")) {
			ItemModel itemModel = new ItemModel();
			try {
				itemModel.setId(id);
				itemModel.delete();
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=ItemListCtl.do");
				requestDispatcher.forward(request, response);
				System.out.println("data added");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
