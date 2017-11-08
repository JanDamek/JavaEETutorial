package com.tieto.dao;

import com.tieto.entity.Client;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.Query;

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

    public void update(final Client editing) {
        final Query query = this.em.createQuery("UPDATE Client c SET c.name = :name, c.address = :address WHERE c.id" +
                                                " = :id");
        query.setParameter("id", editing.getId());
        query.setParameter("name", editing.getName());
        query.setParameter("address", editing.getAddress());
        query.executeUpdate();

    }
}
