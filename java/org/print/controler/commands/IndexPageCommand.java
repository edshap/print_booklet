package org.print.controler.commands;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Alina on 27.02.2018.
 */
public class IndexPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        return "/WEB-INF/index.jsp";
    }
}
