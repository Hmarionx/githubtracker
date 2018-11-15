package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    @Override
    public void saveGithuber(Githuber githuber) {

    }

    @Override
    public void deleteGithuber(String login) {

    }

    @Override
    public void addGithuber(String login) {

    }
}
