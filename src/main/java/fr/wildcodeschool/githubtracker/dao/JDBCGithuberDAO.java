package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@InJDBC
@ApplicationScoped

public class JDBCGithuberDAO implements GithuberDAO {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/githubtracker";

    // Database credentials
    static final String USER = "wilder";
    static final String PASS = "wilder";

    Connection conn = null;
    Statement stmt = null;

    public List<Githuber> getGithubers() throws SQLException {
        List<Githuber> githubersList = new LinkedList<>();


        //STEP 2: Register JDBC driver

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultat = null;

        try {
            resultat = stmt.executeQuery("SELECT * from githuber");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn == null) {
            System.out.println("Error getting the connection. Please check if the DB server is running");
            return githubersList;
        }

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