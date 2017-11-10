package com.tieto.dao;

import com.tieto.entity.Cd;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Stateless
public class CdDAO extends MainDAO<Cd, Number> {

    @PostConstruct
    private void init() {
        super.setPersistedClass(Cd.class);
    }

}
