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
public class DeleteUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        request.getSession().getAttribute("users");
        int id = Integer.valueOf(request.getParameter("id"));
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.createUserDao();
        userDao.delete(id);
        List<User> users = userDao.findAll();
        request.getSession().setAttribute("users", users);

        return "/WEB-INF//AdminPage/AdminPage.jsp";
    }
}
