package de.seven.fate.jaas.rest;

import de.seven.fate.jaas.dao.UserDAO;
import de.seven.fate.jaas.model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class UserResource {

    private static final Logger LOGGER = Logger.getLogger(UserResource.class.getName());


    @Inject
    private UserDAO dao;

    @POST
    public Response create(User user) {

        dao.save(user);

        return Response.ok(user).build();
    }

    @PUT
    public Response update(User user) {

        return Response.ok(dao.update(user)).build();
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long userId) {

        dao.remove(userId);

        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long userId) {

        return Response.ok(dao.get(userId)).build();
    }

    @GET
    public Response users() {

        return Response.ok(dao.list()).build();
    }

}