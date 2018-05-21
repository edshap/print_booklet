package org.print.filter;

import org.print.model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Alina on 27.02.2018.
 */

public class IndexPageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String role = (String) request.getSession().getAttribute("role");
        if (role == null){
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (role.equals((User.ROLES.ADMIN).toString())){
            request.getRequestDispatcher("/WEB-INF/AdminPage/AdminPage.jsp").forward(servletRequest, servletResponse);
        } else if (role.equals((User.ROLES.USER).toString())){
            request.getRequestDispatcher("/WEB-INF/UserPage/UserPage.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
