package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "githuber")
public class Githuber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "github_id")
    private int github_id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "login")
    private String login;
    @Column(name = "bio")
    private String bio;
    @Column(name = "location")
    private String location;
    @Column(name = "html_url")
    private String html_url;
    @Column(name = "avatar_url")
    private String avatar_url;

    public Githuber() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGithub_id() {
        return github_id;
    }

    public void setGithub_id(int github_id) {
        this.github_id = github_id;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @JsonCreator
    public Githuber(@JsonProperty("id") int github_id, @JsonProperty("name") String name, @JsonProperty("email") String email, @JsonProperty("login") String login, @JsonProperty("avatar_url") String avatar_url, @JsonProperty("location") String location, @JsonProperty("bio") String bio, @JsonProperty("html_url") String html_url) {
        this.github_id = github_id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.bio = bio;
        this.location = location;
        this.html_url = html_url;
        this.avatar_url = avatar_url;
    }

}