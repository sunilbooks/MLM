package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.OrganizationModel;

/**
 * Servlet implementation class OrganizationListCtl
 */
public class OrganizationListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("in list");
			OrganizationModel organizationModel = new OrganizationModel();
			List list = organizationModel.search();

			request.setAttribute("List", list);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("BaseLayout.jsp?body=OrganizationList.jsp");
			dispatcher.forward(request, response);
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
