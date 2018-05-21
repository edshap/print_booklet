package org.print.controler.commands;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Alina on 18.02.2018.
 */
public interface Command {
    String execute (HttpServletRequest request) throws SQLException;
}
