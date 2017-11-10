package com.tieto.service;

import com.tieto.domain.ClientDTO;

import java.util.List;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 09/11/2017.
 */
public interface ClientService {

    List<ClientDTO> getAllClient();

    void remove(ClientDTO c);

    void startEdit(ClientDTO clientDTO);

    void updateClientOrCreate(String name, String address);

    void create(String name, String address);

    ClientDTO getById(Long id);
}
