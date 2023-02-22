package com.itstep.htmltip.controller;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itstep.htmltip.dao.AdminDao;
import com.itstep.htmltip.dao.TipDao;
import com.itstep.htmltip.entity.Tip;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/")
public class HomeController extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Tip> tips = TipDao.retrieveAll();
		request.setAttribute("tips", tips);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
