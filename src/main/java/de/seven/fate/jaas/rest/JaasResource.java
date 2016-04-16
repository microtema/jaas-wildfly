package de.seven.fate.jaas.rest;

import javax.ejb.Stateless;
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

@Path("/")
@Stateless
public class JaasResource {

    private static final Logger LOGGER = Logger.getLogger(JaasResource.class.getName());

    @Context
    private HttpServletRequest request;

    @POST
    @Path("/login")
    public Response login(@FormParam("j_username") String username, @FormParam("j_password") String password) {

        try {
            request.login(username, password);
            LOGGER.info("Login Success for: " + username);
        } catch (ServletException e) {
            LOGGER.log(Level.WARNING, "Login Exception: " + e.getMessage());
        }

        return seeOther("../");
    }

    @GET
    @Path("/logout")
    public Response logout() {

        Principal principal = request.getUserPrincipal();

        String username = principal.getName();

        try {
            request.logout();
            LOGGER.info("Logout Success for: " + username);
        } catch (ServletException e) {
            LOGGER.log(Level.WARNING, "Logout Exception: " + e.getMessage());
        }
        return seeOther("../");
    }

    @GET
    @Path("/in/{role}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response role(@PathParam("role") String role) {

        boolean userInRole = request.isUserInRole(role);
        return Response.ok(userInRole).build();
    }

    private static Response seeOther(String url) {
        try {
            return Response.seeOther(new URI(url)).build();
        } catch (URISyntaxException e) {
            return null;
        }
    }

}