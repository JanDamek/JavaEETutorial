package com.tieto.service;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 09/11/2017.
 */
public interface ApplicationService {

    void incrementSession();

    void decrementSession();

    int getSessionCount();

    Integer getSoapRequestCount();

    Integer getRestRequestSoap();
}
