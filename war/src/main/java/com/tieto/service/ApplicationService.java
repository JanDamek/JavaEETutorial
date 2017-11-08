package com.tieto.service;

import lombok.Getter;
import lombok.Setter;

import javax.inject.Singleton;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Singleton
@Getter
@Setter
public class ApplicationService {

    private int sessionCount;

    public void incrementSession() {
        this.sessionCount++;
    }

    public void decrementSession() {
        this.sessionCount--;
    }
}
