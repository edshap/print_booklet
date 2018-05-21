package org.print.controler.commands;

import org.print.model.dao.DaoFactory;
import org.print.model.dao.UserDao;
import org.print.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alina on 04.03.2018.
 */
public class UpdateCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) throws SQLException {

        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user);

        int id = user.getId();
        String role = request.getParameter("role");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        user.setRole(User.ROLES.valueOf(role));
        user.setLogin(login);
        user.setPassword(password);
        System.out.println(user);

        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.createUserDao();
        userDao.update(user);
        request.getSession().getAttribute("users");
        List<User> users = userDao.findAll();
        request.getSession().setAttribute("users", users);


        return "/WEB-INF//AdminPage/AdminPage.jsp";
    }
}
