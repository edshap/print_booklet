package org.print.controler.commands;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Alina on 25.02.2018.
 */
public class LoginPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        return "/WEB-INF/login.jsp";
    }
}
