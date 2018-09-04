package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class MemoryGithuberDAO implements GithuberDAO {
    String GIT_ULR ="https://api.github.com/users/";
    Map<String, Githuber> myMap = new HashMap<String, Githuber>();
    @Inject
    private DumbGithuberDAO dumbGithuberDAO;

    /*@Inject
    private ObjectMapper om; plus d'actualité depuis le qualifier*/

    public List<Githuber> getGithubers() {
        List<Githuber> newList = new ArrayList<>(myMap.values());
        return newList;
    }

    public void saveGithuber(Githuber githuber) {
        if (githuber!=null){
            myMap.put(githuber.getLogin(), githuber);}
    }
}
