package org.print.controler.commands;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class Contact implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        return "/WEB-INF/Contact.jsp";
    }
}
