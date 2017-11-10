package com.tieto.service;

import lombok.Getter;
import lombok.Setter;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */

@Stateless
@Getter
@Setter
@Remote(ApplicationService.class)
public class ApplicationServiceImpl implements ApplicationService {

    @Inject
    private CommonService commonService;

    public void incrementSession() {
        this.commonService.setSessionCount(this.commonService.getSessionCount() + 1);
    }

    public void decrementSession() {
        this.commonService.setSessionCount(this.commonService.getSessionCount() - 1);
    }

    public int getSessionCount() {
        return this.commonService.getSessionCount();
    }

    public Integer getSoapRequestCount() {
        return this.commonService.getSoapRequestCount();
    }

    public Integer getRestRequestSoap() {
        return this.commonService.getRestRequestCount();
    }
}
