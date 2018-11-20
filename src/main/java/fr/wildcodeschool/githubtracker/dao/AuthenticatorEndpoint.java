package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.controller.jwt.SimpleKeyGenerator;
import fr.wildcodeschool.githubtracker.model.Credentials;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.util.Date;
import java.util.logging.Logger;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.ietf.jgss.GSSException.UNAUTHORIZED;

@Consumes(APPLICATION_JSON)
@Path("/login")

public class AuthenticatorEndpoint {
    //@Inject
    //private Logger logger;
    final private Logger logger = Logger.getLogger("logger");
    //@Inject
    //private KeyGenerator keyGenerator;
    final private SimpleKeyGenerator keyGenerator = new SimpleKeyGenerator();

    @Context
    private UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON) //eg: { "login": "wilder", "password": "wcs12345" }
    public Response authenticate(Credentials creds) {
        logger.info("login/password : {}/{}" + creds.getLogin() + creds.getPassword());

        if (true) {  //LET'S ASSUME WE LOG IN HERE
            // Issue a token for the user and return it within the response
            String token = issueToken(creds.getLogin());
            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
        } else {
            return Response.status(UNAUTHORIZED).build();
        }
    }

    private String issueToken(String login) {
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        logger.info("#### generating token for a key : " + jwtToken + " - " + key);
        return jwtToken;

    }

}

