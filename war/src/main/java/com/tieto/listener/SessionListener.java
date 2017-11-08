package com.tieto.listener;

import com.tieto.service.ApplicationService;

import javax.inject.Inject;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Inject
    private ApplicationService applicationService;

    public void sessionCreated(final HttpSessionEvent httpSessionEvent) {
        this.applicationService.incrementSession();
    }

    public void sessionDestroyed(final HttpSessionEvent httpSessionEvent) {
        this.applicationService.decrementSession();
    }

}
