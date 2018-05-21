package org.print.controler.listener;

import org.print.controler.util.ControllerUtil;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Alina on 26.02.2018.
 */
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ControllerUtil.deleteLoggedUserFromContext(httpSessionEvent.getSession());
    }
}
