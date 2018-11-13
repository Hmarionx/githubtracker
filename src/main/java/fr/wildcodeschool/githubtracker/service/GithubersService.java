package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InJDBC;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class GithubersService {

    @Inject
    //@InMemory
    @InJDBC
    private GithuberDAO dao;


    public List<Githuber> getGithubers() throws SQLException {
        return dao.getGithubers();
    }

    public void untrackGithuber(String login) throws SQLException {
        dao.deleteGithuber(login);
    }

}