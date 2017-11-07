package com.tieto.service;

import lombok.Getter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@ManagedBean
@ApplicationScoped
@WebListener
@Getter
public class SessionListener implements HttpSessionListener {

    private static int cnt;

    public void sessionCreated(final HttpSessionEvent httpSessionEvent) {
        cnt++;
    }

    public void sessionDestroyed(final HttpSessionEvent httpSessionEvent) {
        cnt--;
    }

    public int getCnt() {
        return cnt;
    }
}
