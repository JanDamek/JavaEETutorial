package com.tieto.listener;

import com.tieto.service.ApplicationService;

import javax.ejb.EJB;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @EJB(lookup = "java:jboss/exported/ear-0.0.1-SNAPSHOT/tutorialEjb/ApplicationServiceImpl!com.tieto.service.ApplicationService")
    private ApplicationService applicationService;

    public void sessionCreated(final HttpSessionEvent httpSessionEvent) {
        this.applicationService.incrementSession();
    }

    public void sessionDestroyed(final HttpSessionEvent httpSessionEvent) {
        this.applicationService.decrementSession();
    }

}
