package org.parking.parkinglot;

import org.parking.parkinglot.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditUser", value = "/EditUser")
public class EditUser extends HttpServlet {
    @Inject
    UsersBean usersBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        request.setAttribute("user", usersBean.findUserById(userId));
        request.getRequestDispatcher("/WEB-INF/pages/users/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String idUser = request.getParameter("id");
        if (idUser == null || idUser.trim().isEmpty()) {
            return;
        }
        try {
            Long userId = Long.parseLong(idUser);
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if (password == null || password.isEmpty()) {
                usersBean.updateUserWithoutPassword(userId, username, email);
            } else {
                usersBean.updateUserWithPassword(userId, username, email, password);
            }

            response.sendRedirect(request.getContextPath() + "/Users");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}