package com.tieto.controller;

import com.tieto.entity.Client;
import com.tieto.service.ClientService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@ManagedBean
@ViewScoped
@Getter
@Setter
public class ClientController {

    @Inject
    private ClientService clientService;
    private boolean editing;
    private String name;
    private String address;
    private List<Client> clients;

    public List<Client> getClients() {
        if (this.clients == null) {
            this.clients = this.clientService.getAllClient();
        }
        return this.clients;
    }

    public void createNewClient() {
        this.editing = true;
        this.name = "";
        this.address = "";
    }

    public void edit(final Client c) {
        this.name = c.getName();
        this.address = c.getAddress();
        this.clientService.startEdit(c);
        this.editing = true;
        this.clients = null;
    }

    public void save() {
        this.editing = false;
        this.clientService.updateClientOrCreate(this.name, this.address);
        this.clients = null;
    }

    public void remove(final Client c) {
        this.clientService.remove(c);
    }
}
