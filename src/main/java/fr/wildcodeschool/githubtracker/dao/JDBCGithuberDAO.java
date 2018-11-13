package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@InJDBC
@ApplicationScoped

public class JDBCGithuberDAO implements GithuberDAO {

    @Resource(lookup = "jdbc/githubtrackerPool")
    private DataSource datasource;

    @PostConstruct
    public void postConstruct() {
        try {
            conn = datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection conn = null;
    Statement stmt = null;

    public List<Githuber> getGithubers() throws SQLException {
        List<Githuber> githubersList = new LinkedList<>();

        try {

            stmt = conn.createStatement();
            ResultSet resultat = null;
            resultat = stmt.executeQuery("SELECT DISTINCT * FROM githuber");

            while (resultat.next()) {
                Githuber githuber = new Githuber();
                githuber.setId(resultat.getInt("github_id"));
                githuber.setName(resultat.getString("name"));
                githuber.setLogin(resultat.getString("login"));
                githuber.setUrl(resultat.getString("url"));
                githuber.setEmail(resultat.getString("email"));
                githuber.setBio(resultat.getString("bio"));
                githuber.setLocation(resultat.getString("location"));
                githuber.setAvatar_url(resultat.getString("avatar_url"));
                githubersList.add(githuber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return githubersList;

    }

    public void saveGithuber(Githuber githuber) {

        String statement = "INSERT INTO githuber(github_id,name,login,url,email,bio,location,avatar_url) VALUES('"
                + githuber.getId() + "','" + githuber.getName() + "', '" + githuber.getLogin() + "','" + githuber.getUrl() +
                "','" + githuber.getEmail() + "','" + githuber.getBio() + "','" + githuber.getLocation() + "','" + githuber.getAvatar_url() + "')";

        PreparedStatement insertStatement = null;
        try {
            insertStatement = conn.prepareStatement(statement);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGithuber(String login) {
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM githuber where login = '" + login + "';  ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}