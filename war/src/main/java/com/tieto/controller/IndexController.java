package com.tieto.controller;

import com.tieto.service.ApplicationService;
import com.tieto.service.SessionService;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import java.util.logging.Logger;

@ManagedBean
@Getter
@Setter
public class IndexController {

    @EJB(lookup = "java:jboss/exported/ear-0.0.1-SNAPSHOT/tutorialEjb/ApplicationServiceImpl!com.tieto.service.ApplicationService")
    private ApplicationService applicationService;
    
    @ManagedProperty(value = "#{sessionService}")
    private SessionService sessionService;

    @Inject
    private Logger logger;

    private String name;

    public void save() {
        this.logger.info("Call save method.");
        this.sessionService.setName(this.name);
    }

    public String getNameFromSessionService() {
        return this.sessionService.getName();
    }

    public int getSessionCount() {
        return this.applicationService.getSessionCount();
    }

    public Integer getSoapRequestCount() {
        return this.applicationService.getSoapRequestCount();
    }

    public Integer getRestRequestCount() {
        return this.applicationService.getRestRequestSoap();
    }
}
