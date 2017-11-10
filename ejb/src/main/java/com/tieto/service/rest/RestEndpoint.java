package com.tieto.service.rest;

import com.tieto.domain.ClientDTO;
import com.tieto.event.RestRequestEvent;
import com.tieto.service.ClientService;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Project: mazlusek
 * For:
 * Created by damekjan on 25/04/16.
 */
@Stateless
@Path("/API")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class RestEndpoint {

    @Inject
    private ClientService clientService;

    @Inject
    private Event<RestRequestEvent> restRequestEvent;

    @GET
    @Path("client/id/{id}")
    public ClientDTO getClientById(
            @PathParam("id") final Long id) {
        this.restRequestEvent.fire(new RestRequestEvent());
        return this.clientService.getById(id);
    }

    @GET
    @Path("client")
    public ClientDTO getClientByIdFromQuery(
            @QueryParam("id") final Long id) {
        this.restRequestEvent.fire(new RestRequestEvent());
        return this.clientService.getById(id);
    }

    @GET
    @Path("clients")
    public Response getAllClients() {
        this.restRequestEvent.fire(new RestRequestEvent());
        try {
            final List<ClientDTO> clientDTOList = this.clientService.getAllClient();
            return Response.ok(clientDTOList).build();
        } catch (final Exception e) {
            Logger.getLogger("Rest").log(Level.WARNING, "Exception:{0}", e.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
