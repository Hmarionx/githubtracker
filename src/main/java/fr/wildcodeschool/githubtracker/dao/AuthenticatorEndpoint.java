package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.controller.jwt.SimpleKeyGenerator;
import fr.wildcodeschool.githubtracker.model.Credentials;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/")
@Produces(APPLICATION_JSON)
@Transactional
@Consumes(APPLICATION_JSON)
public class AuthenticatorEndpoint {
    //@Inject
    //private Logger logger;
    final private Logger logger = Logger.getLogger("logger");
    //@Inject
    //private KeyGenerator keyGenerator;
    final private SimpleKeyGenerator keyGenerator = new SimpleKeyGenerator();

    @PersistenceContext
    private EntityManager em;

    @Context
    private UriInfo uriInfo;

    @POST
    @Path("/login")
    //@Consumes(APPLICATION_FORM_URLENCODED)
    //public Response authenticateUser(@FormParam("login") String login,
    //                                 @FormParam("password") String password) {
    @Consumes(MediaType.APPLICATION_JSON) //eg: { "login": "wilder", "password": "wcs12345" }
    public Response authenticate(Credentials creds) {
        try {

            logger.info("login/password : {}/{}" + creds.getLogin() + creds.getPassword());

            // Authenticate the user using the credentials provided
            authenticate(creds.getLogin(), creds.getPassword());

            // Issue a token for the user
            String token = issueToken(creds.getLogin());

            // Return the token on the response
            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void authenticate(String login, String password) throws Exception {
        TypedQuery<Credentials> query = em.createNamedQuery(Credentials.FIND_BY_LOGIN_PASSWORD, Credentials.class);
        query.setParameter("login", login);
        //query.setParameter("password", PasswordUtils.digestPassword(password));
        query.setParameter("password", password);
        Credentials credentials = query.getSingleResult();

        if (credentials == null)
            throw new SecurityException("Invalid user/password");
    }

    private String issueToken(String login) {
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        logger.info("#### generating token for a key : " + jwtToken + " - " + key);
        return jwtToken;

    }

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

}

