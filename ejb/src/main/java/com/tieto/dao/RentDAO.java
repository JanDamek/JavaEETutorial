package com.tieto.dao;

import com.tieto.entity.Rent;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Stateless
public class RentDAO extends MainDAO<Rent> {

    @PostConstruct
    private void init() {
        super.setPersistedClass(Rent.class);
    }

}
