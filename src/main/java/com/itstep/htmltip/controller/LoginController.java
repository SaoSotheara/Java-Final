package com.itstep.htmltip.controller;

import java.io.IOException;
import java.io.Serial;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itstep.htmltip.dao.AdminDao;
import com.itstep.htmltip.entity.Admin;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Admin admin = new Admin(username, password);
		
		Admin found = AdminDao.auth(admin);
		if (found != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", found.getUsername());
			session.setAttribute("password", found.getPassword());
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			request.setAttribute("fail", "Invalid credentials.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
