package de.seven.fate.jaas.rest;

import de.seven.fate.jaas.dao.RoleDAO;
import de.seven.fate.jaas.dao.UserDAO;
import de.seven.fate.jaas.model.Role;
import de.seven.fate.jaas.model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/role")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class RoleResource {

    private static final Logger LOGGER = Logger.getLogger(RoleResource.class.getName());


    @Inject
    private RoleDAO dao;

    @POST
    public Response create(Role role) {

        dao.save(role);

        return Response.ok(role).build();
    }

    @PUT
    public Response update(Role role) {

        return Response.ok(dao.update(role)).build();
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long roleId) {

        dao.remove(roleId);

        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long roleId) {

        return Response.ok(dao.get(roleId)).build();
    }

    @GET
    public Response list() {

        return Response.ok(dao.list()).build();
    }

}