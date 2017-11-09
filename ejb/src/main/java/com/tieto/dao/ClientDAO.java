package com.tieto.dao;

import com.tieto.entity.Client;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Stateless
public class ClientDAO extends MainDAO<Client> {

    private static final long serialVersionUID = -8616482406731283137L;

    @PostConstruct
    private void init() {
        super.setPersistedClass(Client.class);
    }

}
