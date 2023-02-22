package com.itstep.htmltip.controller;

import java.io.IOException;
import java.io.Serial;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itstep.htmltip.dao.AdminDao;
import com.itstep.htmltip.dao.TipDao;
import com.itstep.htmltip.entity.Tip;

/**
 * Servlet implementation class TipController
 */
@WebServlet("/tip")
public class TipController extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String target = request.getParameter("target");

		switch (target) {
			case "creation" -> request.getRequestDispatcher("tipCreation.jsp").forward(request, response);
			case "create" -> this.creation(request, response);
			case "details" -> {
				int tipId = Integer.parseInt(request.getParameter("id"));
				Tip tip = TipDao.getTip(tipId);
				request.setAttribute("tip", tip);
				request.getRequestDispatcher("tipDetails.jsp").forward(request, response);
			}
			case "update" -> {
				Tip tip = TipDao.getOneById(Integer.valueOf(request.getParameter("id")));
				request.setAttribute("id", tip.getTipId());
				request.setAttribute("description", tip.getDescription());
				request.setAttribute("title", tip.getTitle());
				request.setAttribute("exampleHtmlEscape", tip.getExampleHtmlEscape());
				request.getRequestDispatcher("tipEdit.jsp").forward(request, response);
			}
			case "edit" -> {
				Tip tip = new Tip();
				tip.setTitle(request.getParameter("title"));
				tip.setDescription(request.getParameter("description"));
				tip.setExampleHtmlEscape(request.getParameter("exampleHtmlEscape"));
				Integer id = Integer.valueOf(request.getParameter("id"));
				if (TipDao.updateTip(id, tip) > 0) {
					request.setAttribute("success", "Tip updated Successfully!");

				} else {
					request.setAttribute("fail", "Cannot update Tip!!!");
				}

				response.sendRedirect(request.getContextPath()+"/tip?target=details&id=" + id);
			}
			case "delete" -> {
				Integer id = Integer.valueOf(request.getParameter("id"));
				TipDao.deleteTip(id);
				response.sendRedirect(request.getContextPath());
			}
			default -> {
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void creation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String des = request.getParameter("description");
		String html = request.getParameter("exampleHtmlEscape");

		Tip tip = new Tip(title, des, html);

		int status = TipDao.save(tip);

		if (status > 0) {
			request.setAttribute("success", "Tip created Successfully!");
		} else {
			request.setAttribute("fail", "Cannot create tip!!!");
		}

		request.getRequestDispatcher("tipCreation.jsp").forward(request, response);
	}

	protected void update(HttpServletRequest req, HttpServletResponse resp) {
		String title = req.getParameter("title");
		String des = req.getParameter("description");
		String html = req.getParameter("exampleHtmlEscape");

		Tip tip = new Tip(title, des, html);
	}
}
