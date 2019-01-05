package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Credentials;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Dependent
public class CredentialsDAO {

    @PersistenceContext
    private EntityManager em;

    public void authenticate(String login, String password) {
        TypedQuery <Credentials> query = em.createNamedQuery(Credentials.FIND_BY_LOGIN_PASSWORD, Credentials.class);
        query.setParameter("login", login);
        //query.setParameter("password", PasswordUtils.digestPassword(password));
        query.setParameter("password", password);
        Credentials credentials = query.getSingleResult();

        if (credentials == null)
            throw new SecurityException("Invalid user/password");
    }
}
