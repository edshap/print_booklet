package org.print.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        try {
            String language = "EN_en";
            request.getSession().setAttribute("language", language);
            //String lang = (String) request.getSession().getAttribute("language");
            Locale locale = (Locale) request.getSession().getAttribute("language");
            ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (ClassCastException e){
            Locale locale = new Locale((String)request.getSession().getAttribute("language"));
            ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
