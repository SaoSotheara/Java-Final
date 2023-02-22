package com.itstep.htmltip.controller;

import com.itstep.htmltip.dao.AdminDao;
import com.itstep.htmltip.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String target = req.getParameter("target");
        target = target == null ? "list" : target;
        HttpSession session = req.getSession();
//        if(session.getAttribute("username") == null) {
//            resp.sendRedirect(req.getContextPath());
//        } else {
            switch (target) {
                case "creation"->req.getRequestDispatcher("userCreation.jsp").forward(req, resp);
                case "insert" -> this.creation(req, resp);
                case "list" -> {
                    List<Admin> users = AdminDao.getAll();
                    req.setAttribute("users", users);
                    req.getRequestDispatcher("user.jsp").forward(req, resp);
                }
                case "delete" -> {
                    AdminDao.deleteUser(Integer.valueOf(req.getParameter("id")));
                    resp.sendRedirect(req.getContextPath()+"/user");
                }
                case "edit" -> {
                    Admin user = AdminDao.getOneById(Integer.valueOf(req.getParameter("id")));
                    req.setAttribute("username", user.getUsername());
                    req.setAttribute("password", user.getPassword());
                    req.setAttribute("id", user.getId());
                    req.getRequestDispatcher("userEdit.jsp").forward(req, resp);
                }
                case "update" -> {
                    this.updateUser(req,resp);
                }
                default -> {

                }
            }
//        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    protected void creation (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Admin user = new Admin(username, password);

        if (AdminDao.save(user) > 0) {
            req.setAttribute("success", "User created Successfully!");

        } else {
            req.setAttribute("fail", "Cannot create User!!!");
        }

        req.getRequestDispatcher("userCreation.jsp").forward(req, resp);
    }

    protected void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (AdminDao.editUser(id, username, password) > 0) {
            req.setAttribute("success", "User updated Successfully!");

        } else {
            req.setAttribute("fail", "Cannot update User!!!");
        }

        resp.sendRedirect(req.getContextPath()+"/user");
    }
}
