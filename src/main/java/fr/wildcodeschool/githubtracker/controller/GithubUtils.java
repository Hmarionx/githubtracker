package fr.wildcodeschool.githubtracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.InputStream;
import java.net.URL;

@ApplicationScoped
public class GithubUtils {
    private static final String GITHUB_URL = "https://api.github.com/users/";

    @Inject
    private ObjectMapper om;

    public Githuber parseGithuber(String login){

        String userUrl = GITHUB_URL + login;
        Githuber githuber = null;
        try(InputStream is = new URL(userUrl).openStream()){
            githuber = om.readValue(is, Githuber.class);

        }catch(Exception e){
            e.printStackTrace();
        }

        return githuber;
    }
}
