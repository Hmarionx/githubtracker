package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.controller.GithubUtils;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@InMemory
@ApplicationScoped
public class MemoryGithuberDAO implements GithuberDAO {

    //@Inject
    //private ObjectMapper om;

    private HashMap <String, Githuber> githubers = new HashMap <>();

    public List <Githuber> getGithubers() {
        List <Githuber> githubersList = new LinkedList <>();
        if (githubers != null && githubers.size() > 0) {
            for (Map.Entry <String, Githuber> entry : githubers.entrySet()) {
                Githuber g = entry.getValue();
                githubersList.add(g);
            }
        }
        return githubersList;

    }

    public void saveGithuber(Githuber githuber) {
        if (githuber != null) {
            githubers.put(githuber.getLogin(), githuber);
        }
    }

    @Override
    public void deleteGithuber(String login) {

    }

    @Override
    public void addGithuber(String login) {

    }


    @Inject
    GithubUtils ghu;
    @PostConstruct
    public void Githuber() {
        List <Githuber> ghList;
        DumbGithuberDAO dao= new DumbGithuberDAO();
        ghList = dao.getGithubers();
        for (Githuber githubers : ghList) saveGithuber(ghu.parseGithuber(githubers.getLogin()));
    }
}

