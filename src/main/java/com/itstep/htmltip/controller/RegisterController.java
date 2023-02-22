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
import org.jetbrains.annotations.NotNull;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(@NotNull HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("register.jsp").forward(req, resp);
	}

	protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(AdminDao.save(new Admin(username, password)) == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			request.setAttribute("success", "User created Successfully!");
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			request.setAttribute("fail", "Cannot create user!!!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
