package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.CredentialsDAO;
import fr.wildcodeschool.githubtracker.jwt.KeyGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Dependent
public class CredentialsService {

    @Context
    private UriInfo uriInfo;

    @Inject
    private Logger logger;

    @Inject
    private CredentialsDAO dao;

    @Inject
    private KeyGenerator keyGenerator;

    public void authenticateUser(String login, String password) {
        dao.authenticate(login, password);
    }

    public String issueToken(String login) {

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
