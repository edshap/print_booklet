package org.print.controler.commands;

import org.print.model.dao.DaoFactory;
import org.print.model.dao.UserDao;
import org.print.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alina on 28.02.2018.
 */
public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        request.getSession().getAttribute("users");
        String role = request.getParameter("role");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.createUserDao();
        userDao.create(new User(login, password, User.ROLES.valueOf(role)));
        List<User> users = userDao.findAll();
        request.getSession().setAttribute("users", users);


        return "/WEB-INF/AdminPage/AdminPage.jsp";
    }
}
