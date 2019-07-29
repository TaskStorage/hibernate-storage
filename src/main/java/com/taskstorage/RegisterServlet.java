package com.taskstorage;

import com.taskstorage.model.Role;
import com.taskstorage.model.User;
import com.taskstorage.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserRepository userRepository = new UserRepository();;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User(username, password, Role.USER);
            userRepository.createUser(user);
            response.sendRedirect(request.getContextPath() + "/");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/").forward(request, response);
        }
    }
}
