package org.print.controler.commands;

import org.print.controler.util.ControllerUtil;
import org.print.model.dao.DaoFactory;
import org.print.model.dao.UserDao;
import org.print.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alina on 18.02.2018.
 */
public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");


        //Check if login or password are not empty
        if( login == null || login.equals("") || password == null || password.equals("")  ){
            request.setAttribute("message", "LOGIN_OR_PASS_MISSED");
            return "/WEB-INF/login.jsp";
        }

        //Check if user is registered in system and password is correct
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.createUserDao();
        User user = userDao.findByLogin(login);
        List<User> users = userDao.findAll();
        request.getSession().setAttribute("users", users);
        if (user.getLogin() == null || user.getId()==0 || user.getRole()==null || !user.getPassword().equals(password)) {
            request.setAttribute("message", "WRONG_LOGIN_OR_PASS");
            return "/WEB-INF/login.jsp";
        }

        //Check if user is not already logged the system
        if (ControllerUtil.checkUserAlreadyIsLogged(request, login)){
            request.setAttribute("message", "USER_ALREADY_LOGGED");
            return "/WEB-INF/login.jsp";
        }


        //Forward to the web-page depends on user role

        if (user.getRole().equals(User.ROLES.ADMIN)){
            ControllerUtil.setUserRole(request, (User.ROLES.ADMIN).toString(), login);
            return "/WEB-INF/AdminPage/AdminPage.jsp";
        } else if (user.getRole().equals(User.ROLES.USER)) {
            ControllerUtil.setUserRole(request, (User.ROLES.USER).toString(), login);
            return "/WEB-INF/UserPage/UserPage.jsp";
        } else {
            ControllerUtil.setUserRole(request, (User.ROLES.UNKNOWN).toString(), login);
            return "/WEB-INF/login.jsp";
        }
    }
}
