package com.tieto.service;

import com.tieto.event.RestRequestEvent;
import com.tieto.event.SoapRequestEvent;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Singleton;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 09/11/2017.
 */
@Singleton
@Getter
@Setter
public class CommonService {

    private int sessionCount;

    private int soapRequestCount;

    private int restRequestCount;
    
    public void soapRequestListener(@Observes(notifyObserver = Reception.ALWAYS) final SoapRequestEvent event) {
        this.soapRequestCount++;
    }

    public void restRequestListener(@Observes(notifyObserver = Reception.ALWAYS) final RestRequestEvent event) {
        this.restRequestCount++;
    }
}
