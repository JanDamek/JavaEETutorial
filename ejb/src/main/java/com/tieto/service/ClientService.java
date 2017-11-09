package com.tieto.service;

import com.tieto.dao.ClientDAO;
import com.tieto.entity.Client;

import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Stateful
@SessionScoped
@StatefulTimeout(value = 20)
public class ClientService implements Serializable {

    private static final long serialVersionUID = 8401318615026298113L;

    @Inject
    private ClientDAO clientDAO;

    private Client editing;
    private List<Client> clients;

    public List<Client> getAllClient() {
        if (this.clients == null) {
            this.clients = this.clientDAO.getAll();
        }
        return this.clients;
    }

    public void remove(final Client c) {
        this.clientDAO.delete(c);
        this.clients = null;
    }

    public void startEdit(final Client client) {
        this.editing = client;
    }

    public void updateClientOrCreate(final String name, final String address) {
        if (this.editing == null) {
            create(name, address);
        } else {
            this.editing.setName(name);
            this.editing.setAddress(address);
            this.clientDAO.update(this.editing);
            this.editing = null;
        }
        this.clients = null;
    }

    public void create(final String name, final String address) {
        final Client client = new Client();
        client.setAddress(address);
        client.setName(name);
        this.clientDAO.create(client);
        this.clients = null;
    }
}
