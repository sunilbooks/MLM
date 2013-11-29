package com.sunrays.javarefbook.mlm.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.javarefbook.mlm.model.PlanModel;

public class PlanCtl extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Integer id = null;
		String name = null;
		Integer level1 = null;
		Integer level2 = null;
		Integer level3 = null;
		Integer level4 = null;
		Integer level5 = null;
		Integer level6 = null;
		Integer level7 = null;
		Integer level8 = null;
		Integer level9 = null;
		Integer level10 = null;

		try {
			id = Integer.parseInt(request.getParameter("id"));
			level1 = Integer.parseInt(request.getParameter("level1"));
			level2 = Integer.parseInt(request.getParameter("level2"));
			level3 = Integer.parseInt(request.getParameter("level3"));
			level4 = Integer.parseInt(request.getParameter("level4"));
			level5 = Integer.parseInt(request.getParameter("level5"));
			level6 = Integer.parseInt(request.getParameter("level6"));
			level7 = Integer.parseInt(request.getParameter("level7"));
			level8 = Integer.parseInt(request.getParameter("level8"));
			level9 = Integer.parseInt(request.getParameter("level9"));
			level10 = Integer.parseInt(request.getParameter("level10"));
			name = request.getParameter("name");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String operation = request.getParameter("operation");
		PlanModel planModel = new PlanModel();
		if ("Save".equalsIgnoreCase(operation)) {
			try {
				planModel.setId(id);

				planModel.setLevel1(level1);
				planModel.setLevel2(level2);
				planModel.setLevel3(level3);
				planModel.setLevel4(level4);
				planModel.setLevel5(level5);
				planModel.setLevel6(level6);
				planModel.setLevel7(level7);
				planModel.setLevel8(level8);
				planModel.setLevel9(level9);
				planModel.setLevel10(level10);
				planModel.setName(name);
				planModel.add();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Plan.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data added");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		if ("Update".equalsIgnoreCase(operation)) {
			try {
				planModel.setId(id);

				planModel.setLevel1(level1);
				planModel.setLevel2(level2);
				planModel.setLevel3(level3);
				planModel.setLevel4(level4);
				planModel.setLevel5(level5);
				planModel.setLevel6(level6);
				planModel.setLevel7(level7);
				planModel.setLevel8(level8);
				planModel.setLevel9(level9);
				planModel.setLevel10(level10);
				planModel.setName(name);
				planModel.update();

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Plan.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("data updeted");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if ("Get".equalsIgnoreCase(operation)) {
			try {
				planModel.setId(id);
				planModel = planModel.findByPK(id);
				request.setAttribute("get", planModel);

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("BaseLayout.jsp?body=Plan.jsp");
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
				.getRequestDispatcher("BaseLayout.jsp?body=Plan.jsp");
		requestDispatcher.forward(request, response);
	}

}
