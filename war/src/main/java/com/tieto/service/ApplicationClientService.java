package com.tieto.service;

import lombok.Getter;

import javax.inject.Singleton;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 09/11/2017.
 */
@Singleton
@Getter
public class ApplicationClientService {

    private int sessionCount;

    public Integer getSoapRequestCount() {
        return -1;
    }

    public Integer getRestRequestSoap() {
        return -1;
    }

    public void incrementSession() {
        this.sessionCount++;
    }

    public void decrementSession() {
        this.sessionCount--;
    }
}
