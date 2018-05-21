package org.print.controler.commands;

import org.print.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Alina on 04.03.2018.
 */
public class UpdatePageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        request.getSession().getAttribute("users");
        int id = Integer.valueOf(request.getParameter("id"));


        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        User user = new User (id, login, password, User.ROLES.valueOf(role));
        request.getSession().setAttribute("user", user);


        return "/WEB-INF/AdminPage/AdminPageUserUpdate.jsp";
    }
}
