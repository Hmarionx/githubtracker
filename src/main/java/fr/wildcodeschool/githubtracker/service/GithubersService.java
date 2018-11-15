package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InJPA;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class GithubersService implements Serializable {

    @Inject
    //@InMemory
    //@InJDBC
    @InJPA
    private GithuberDAO dao;


    public List<Githuber> getGithubers() throws SQLException {
        return dao.getGithubers();
    }

    public void untrackGithuber(String login) {
        dao.deleteGithuber(login);
    }

    public void trackGithuber(String login) {
        dao.addGithuber(login);
    }

}