package org.print;

import org.print.controler.commands.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Alina on 17.02.2018.
 */
public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        servletConfig.getServletContext().setAttribute("loggedUser", new HashSet<String>());

        commands.put("login", new LoginCommand());
        commands.put("loginPage", new LoginPageCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("indexPage", new IndexPageCommand());
        commands.put("register", new RegisterCommand());
        commands.put("delete", new DeleteUserCommand());
        commands.put("updatePage", new UpdatePageCommand());
        commands.put("update", new UpdateCommand());
        commands.put("calculate", new Calculate());
        commands.put("basket", new ToBasket());
        commands.put("goToBasket", new GoToBasketCommand());
        commands.put("order", new OrderCommand());
        commands.put("upload", new UploadFile());
        commands.put("deleteOrder", new DeleteOrderCommand());
        commands.put("contact", new Contact());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/printbooklet/" , "");
        Command command = commands.getOrDefault(path ,
                (r)->"WEB-INF/login.jsp");
        String page = command.execute(request);
        request.getRequestDispatcher(page).forward(request,response);
    }
}
