package org.print.controler.util;

import org.print.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

/**
 * Created by Alina on 25.02.2018.
 */
public class ControllerUtil {

    public static void setUserRole(HttpServletRequest request,
                                   String role, String login) {
        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("role", role);
    }

    public static boolean checkUserAlreadyIsLogged(HttpServletRequest request, String userLogin){

        HashSet<String> loggedUsers = (HashSet<String>) request
                .getSession()
                .getServletContext()
                .getAttribute("loggedUser");

        if(loggedUsers.stream().anyMatch(userLogin::equals)){
            return true;
        }else{
            loggedUsers.add(userLogin);
            request.getSession()
                    .setAttribute("loggedUser", loggedUsers);
            return false;
        }
    }

    public static void deleteLoggedUserFromContext(HttpSession session) {
        HashSet<String> loggedUsers = (HashSet<String>) session
                .getServletContext().getAttribute("loggedUser");
        loggedUsers.remove(session.getAttribute("login").toString());
        session.setAttribute("loggedUser", loggedUsers);
    }
}
