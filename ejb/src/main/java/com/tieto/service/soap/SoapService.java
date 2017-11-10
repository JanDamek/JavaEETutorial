package com.tieto.service.soap;

import com.tieto.domain.ClientDTO;
import com.tieto.event.SoapRequestEvent;
import com.tieto.service.ClientService;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 09/11/2017.
 */
@Stateless
@WebService
public class SoapService {

    @Inject
    private ClientService clientService;

    @Inject
    private Event<SoapRequestEvent> soapRequestEvent;

    @WebMethod
    public List<ClientDTO> getAllClients() {
        this.soapRequestEvent.fire(new SoapRequestEvent());
        return this.clientService.getAllClient();
    }

    @WebMethod
    public ClientDTO getById(@WebParam(name = "id") final Long id) {
        this.soapRequestEvent.fire(new SoapRequestEvent());
        return this.clientService.getById(id);
    }

}
