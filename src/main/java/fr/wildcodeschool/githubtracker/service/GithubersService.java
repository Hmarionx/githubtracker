package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.MemoryGithuberDAO;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
public class GithubersService {
    MemoryGithuberDAO dao;
    //@Inject
    //GithuberDAO dao;

    @Inject
    public GithubersService(MemoryGithuberDAO dao) {
        this.dao = dao;
    }

    public List<Githuber> getAllGithubers() {
        return dao.getGithubers();
    }

    public Githuber getGithuber(String login) {
        return getAllGithubers().stream().filter(x -> login.equals(x.getLogin())).findFirst().orElse(null);
    }

    public void track(String login){
        //TODO
    }

}
