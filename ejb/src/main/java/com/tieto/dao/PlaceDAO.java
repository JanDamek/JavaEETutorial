package com.tieto.dao;

import com.tieto.entity.Place;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Stateless
public class PlaceDAO extends MainDAO<Place> {

    @PostConstruct
    private void init() {
        super.setPersistedClass(Place.class);
    }

}
