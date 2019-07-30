package com.taskstorage.controller;

import com.taskstorage.model.Role;
import com.taskstorage.model.User;
import com.taskstorage.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userlist")
public class UserController extends HttpServlet {

    private UserRepository userRepository;

    public UserController() {
        userRepository = new UserRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("edit")) {
            editUser(request, response);
        } else {
            listUser(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("edit")) {
            editUser(request, response);
        } else if (action != null && action.equalsIgnoreCase("delete")) {
            deleteUser(request, response);
        } else {
            listUser(request, response);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userRepository.selectAll();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/userJSP/listUser.jsp").forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equals("GET")) {
            try {
                Long id = Long.parseLong(request.getParameter("id"));
                User user = userRepository.selectById(id);
                if (user != null) {
                    request.setAttribute("user", user);
                    getServletContext().getRequestDispatcher("/userJSP/editUser.jsp").forward(request, response);
                } else {
                    notFound(request, response);
                }
            } catch (Exception ex) {
                notFound(request, response);
            }
        } else {
            try {
                Long id = Long.parseLong(request.getParameter("id"));
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                Role role = Role.valueOf(request.getParameter("role"));

                User user = new User(id, username, password, role);
                userRepository.updateUser(user);
                response.sendRedirect(request.getContextPath() + "/userlist");
            } catch (Exception ex) {
                notFound(request, response);
            }
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            userRepository.deleteUser(id);
            response.sendRedirect(request.getContextPath() + "/userlist");
        } catch (Exception ex) {
            System.out.println(ex);
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    private void notFound(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/taskJSP/createTask.jsp").forward(request, response);
    }
}