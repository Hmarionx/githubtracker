package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import java.sql.SQLException;
import java.util.List;

public interface GithuberDAO {
    List<Githuber> getGithubers() throws SQLException;

    void saveGithuber(Githuber githuber);

    void deleteGithuber(String login);

    void addGithuber(String login);
}
