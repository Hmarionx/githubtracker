package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Dependent
public class GithubersService implements Serializable {

    @Inject
    public GithuberDAO dao;

    public List <Githuber> getAllGithubers() {

        return dao.getGithubers();
    }

    // Méthode pour extraire un seul
    public Githuber getGithuber(String login) {

        return getAllGithubers().stream().filter(x -> login.equals(x.getLogin())).findFirst().orElse(null);

    }

    public void track(String login) {

        //TODDO
    }

}
