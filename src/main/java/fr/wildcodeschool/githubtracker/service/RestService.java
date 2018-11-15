package fr.wildcodeschool.githubtracker.service;


import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/")
@Dependent
public class RestService {
    @Inject
    GithubersService ghs;

    @GET
    @Path("/test")
    @Produces("text/plain")
    public String test() {
        return "Test REST";
    }

    @GET
    @Path("/githubers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getGithubers() throws SQLException {
        List<Githuber> githuberList = ghs.getGithubers();
        return Response.ok(githuberList).build();
    }
}
