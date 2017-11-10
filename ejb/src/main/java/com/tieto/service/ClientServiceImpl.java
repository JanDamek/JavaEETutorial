package com.tieto.service;

import com.tieto.dao.ClientDAO;
import com.tieto.domain.ClientDTO;
import com.tieto.entity.Client;
import cz.rpridal.j8mapper.mapper.Mapper;
import cz.rpridal.j8mapper.mapper.MapperBuilder;

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
public class ClientServiceImpl implements Serializable, ClientService {

    private static final long serialVersionUID = 8401318615026298113L;
    private final Mapper<ClientDTO, Client> mapperToENT = MapperBuilder.autoBuild(ClientDTO.class, Client.class);
    private final Mapper<Client, ClientDTO> mapperToDomain = MapperBuilder.autoBuild(Client.class, ClientDTO.class);
    @Inject
    private ClientDAO clientDAO;
    private Client editing;
    private List<Client> clients;

    public List<ClientDTO> getAllClient() {
        if (this.clients == null) {
            this.clients = this.clientDAO.getAll();
        }
        return this.mapperToDomain.mapToList(this.clients);
    }

    public void remove(final ClientDTO clientDTO) {
        this.clientDAO.delete(this.mapperToENT.map(clientDTO));
        this.clients = null;
    }

    public void startEdit(final ClientDTO clientDTO) {
        this.editing = this.mapperToENT.map(clientDTO);
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

    public ClientDTO getById(final Long id) {
        return this.mapperToDomain.map(this.clientDAO.getById(id));
    }
}
