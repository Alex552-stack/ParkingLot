package org.parking.parkinglot;

import org.parking.parkinglot.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "AddUser", value = "/AddUser")
public class AddUser extends HttpServlet {

    @Inject
    UsersBean usersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        request.setAttribute("userGroups", new String[]{"READ_CARS", "WRITE_CARS",
                "READ_USERS", "WRITE_USERS", "INVOICING",});
        request.getRequestDispatcher("/WEB-INF/pages/users/addUser.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String[] userGroups =
                request.getParameterValues("user_groups");
        if (userGroups == null) {
            userGroups = new String[0];
        }
        usersBean.createUser(username, email, password,
                Arrays.asList(userGroups));
        response.sendRedirect(request.getContextPath() + "/Users");
    }
}