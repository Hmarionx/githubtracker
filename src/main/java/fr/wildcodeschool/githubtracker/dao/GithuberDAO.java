package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import java.io.Serializable;
import java.util.List;


public interface GithuberDAO extends Serializable {

    List <Githuber> getGithubers();

    void saveGithuber(Githuber githuber);
}
