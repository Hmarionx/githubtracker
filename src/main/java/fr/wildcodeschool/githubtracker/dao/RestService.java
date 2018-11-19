package fr.wildcodeschool.githubtracker.dao;


import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/")
@Dependent


public class RestService {

    @Inject
    GithubersService ghs;

    @GET
    @Path("/test")
    @Produces("text/plain")

    public String Test(@Context UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().path("githuber").build().toString();
    }

    @GET
    @Path("/githubers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response List() throws SQLException {
        List <Githuber> githuberList = ghs.getGithubers();
        return Response
                .ok(githuberList)
                .build();

    }
    @POST
    @Path("/githuber/{login}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Track(@Context UriInfo uriInfo, @PathParam("login") String login) throws SQLException {
        Githuber githuber = ghs.getGithubers().stream().filter(extractGithuber -> extractGithuber.getLogin().equals(login)).findFirst().orElse(null);
        if (githuber == null) {
            ghs.trackGithuber(login);
            return Response.created(uriInfo.getBaseUriBuilder().path("githuber").path("{" + login + "}").build("{login}", login)).status(201).entity("Ajout du Githuber : " + login).build();
        } else {
            return Response.created(null).status(409).entity("Ce login est déjà dans la DB").build();
        }
    }

    @DELETE
    @Path("/githuber/{login}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Untrack (@PathParam("login") String login) throws SQLException {
        Githuber githuber = ghs.getGithubers().stream().filter(extractGithuber -> extractGithuber.getLogin().equals(login)).findFirst().orElse(null);
        if (githuber == null) {
            return Response.created(null).status(404).entity("Githuber inexistant").build();
        } else {
            ghs.untrackGithuber(login);
            return Response.created(null).status(201).entity("le githuber " + login + " est supprimé de la DB").build();
        }
    }
}

