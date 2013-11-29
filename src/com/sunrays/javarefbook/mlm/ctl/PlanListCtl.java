package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.PlanModel;

/**
 * Servlet implementation class PlanListCtl
 */
public class PlanListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			try {
			PlanModel	planModel = new PlanModel();
				List list = planModel.search();
				request.setAttribute("List", list);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?PlanList.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data added");

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
