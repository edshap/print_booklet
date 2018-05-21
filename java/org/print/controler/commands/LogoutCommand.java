package org.print.controler.commands;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Alina on 25.02.2018.
 */
public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        request.getSession().invalidate();
        return "/WEB-INF/login.jsp";
    }
}
