package eu.tieto.controller;

import eu.tieto.service.SessionListener;
import eu.tieto.service.SessionService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import java.util.logging.Logger;

@ManagedBean
@Getter @Setter
public class IndexController {

    @ManagedProperty(value ="#{sessionListener}")
    private SessionListener sessionListener;

    @ManagedProperty(value ="#{sessionService}")
    private SessionService sessionService;

    @Inject
    private Logger logger;

    private String name;

    public void save() {
          logger.info("Call save method.");
          sessionService.setName(name);
    }

    public String getNameFromSessionService() {
        return sessionService.getName();
    }

    public int getSessionCount() {
        return sessionListener.getCnt();
    }
}
