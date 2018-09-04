package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.controller.GithubUtils;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@InMemory
@ApplicationScoped
public class MemoryGithuberDAO implements GithuberDAO, Serializable {

    @Inject
    private ObjectMapper om;

    HashMap <String, Githuber> githubers = new HashMap <String, Githuber>();


    public List <Githuber> getGithubers() {
        List <Githuber> githubersList = new LinkedList <Githuber>();
        if (githubers != null && githubers.size() > 0) {
            for (Map.Entry <String, Githuber> entry : githubers.entrySet()) {
                String key = entry.getKey();
                Githuber g = entry.getValue();

                githubersList.add(g);
            }
        }

        return githubersList;

    }

    ;

    public void saveGithuber(Githuber githuber) {
        if (githuber != null) {
            githubers.put(githuber.getLogin(), githuber);
        }
    }

    /*
    @PostConstruct
    public void Githuber() {
        List <Githuber> ghList;
        ghList = DumbGithuberDAO.getGithubers();
        for (Githuber githuber : ghList) {
            saveGithuber(GithubUtils.parseGithuber(githuber.getLogin()));

        }
    }
    */
}

