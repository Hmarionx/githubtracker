package fr.wildcodeschool.githubtracker.controller.rest;

import fr.wildcodeschool.githubtracker.model.Credentials;
import fr.wildcodeschool.githubtracker.service.CredentialsService;
import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Dependent
public class AuthenticatorEndpoint {
    @Inject
    private Logger logger;

    @Inject
    private CredentialsService credentialsService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticate(Credentials creds) {
        try {
            logger.info(" asking login/password : {}/{}" + creds.getLogin() + " / " + creds.getPassword());

            // Authenticate the user using the credentials provided
            credentialsService.authenticateUser(creds.getLogin(), creds.getPassword());

            // Issue a token for the user
            String token = credentialsService.issueToken(creds.getLogin());

            // Return the token on the response
            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

        } catch (Exception e) {
            logger.info("invalid login/password : {}/{}" + creds.getLogin() + " / " + creds.getPassword());
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
