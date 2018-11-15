package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.controller.GithubUtils;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@InJPA
@ApplicationScoped
public class JPAGithuberDAO implements GithuberDAO, Serializable {

    @PersistenceContext
    EntityManager entityManager;

    public List <Githuber> getGithubers() {
        TypedQuery <Githuber> query = entityManager.createQuery("select c from Githuber c", Githuber.class);
        return query.getResultList();
    }

    @Transactional
    public void saveGithuber(Githuber githuber) {
        if (githuber != null) {
            entityManager.persist(githuber);
        }
    }

    @Transactional
    public void deleteGithuber(String login) {
        TypedQuery query = entityManager.createQuery("SELECT c from Githuber c where c.login = :login", Githuber.class);
        query.setParameter("login", login);
        List results = query.getResultList();
        for (Object result : results) {
            entityManager.remove(result);
        }
    }

    @Inject
    GithubUtils ghu;

    @Transactional
    public void addGithuber(String login) {
        if (ghu.parseGithuber(login) != null) {
            saveGithuber(ghu.parseGithuber(login));
        }
    }
}
