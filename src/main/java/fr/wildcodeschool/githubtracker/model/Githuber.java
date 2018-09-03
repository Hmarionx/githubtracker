package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Githuber {
    // getter et setter pour les githubers (pojo)
    //name, email, login, id et avatarUrl

    @JsonProperty

    private int id;
    private String name;
    private String email;
    private String login;
    private String avata_url;


    public Githuber() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avata_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avata_url = avatar_url;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonCreator

    public Githuber(int id, String name, String email, String login, String avatar_url) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.avata_url = avatar_url;
    }
}
