package com.tieto.dao;

import com.tieto.entity.Item;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Stateless
public class ItemDAO extends MainDAO<Item, Number> {

    @PostConstruct
    private void init() {
        super.setPersistedClass(Item.class);
    }

}
