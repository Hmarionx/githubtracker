package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.DumbGithuberDAO;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.model.Githuber;

import java.util.List;
import java.util.stream.Collectors;

public class GithubersService {

    private GithuberDAO dao;

    public GithubersService(GithuberDAO dao) {
        this.dao = dao;
    }
    public List<Githuber> getAllGithubers() {
        GithuberDAO dao = new DumbGithuberDAO();
        return dao.getGithubers();
    }

    public Githuber getGithuber(String login) {

        return  getAllGithubers().stream().filter(x ->login.equals(x.getLogin())).findFirst().orElse(null);

    }

    public void track(String login) {

        //TODDO
    }

}
