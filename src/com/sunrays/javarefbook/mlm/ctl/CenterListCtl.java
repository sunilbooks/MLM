package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.CenterModel;

public class CenterListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			CenterModel centerModel = new CenterModel();
			List list = centerModel.search();
			request.setAttribute("centerList", list);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("BaseLayout.jsp?body=CenterList.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CenterModel centerModel = new CenterModel();
		String operation = request.getParameter("operation");
		String[] ids = request.getParameterValues("ids");

		if ("Delete".equalsIgnoreCase(operation)) {
			try {
				for (int i = 0; i < ids.length; i++) {
					Integer id = Integer.valueOf(ids[i]);
					centerModel.setId(id);
					centerModel.delete();
				}
				doGet(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
