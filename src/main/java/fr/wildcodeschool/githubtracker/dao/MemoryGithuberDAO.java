package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class MemoryGithuberDAO implements GithuberDAO {

    @Override
    public List<Githuber> getGithubers() {
        return null;
    }

    @Override
    public void saveGithuber(Githuber githuber) {

    }
}
