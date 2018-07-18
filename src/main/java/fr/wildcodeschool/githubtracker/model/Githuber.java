package fr.wildcodeschool.githubtracker.model;

public class Githuber {
    // getter et setter pour les githubers (pojo)
    //name, email, login, id et avatarUrl


    private int id;
    private String name;
    private String email;
    private String login;
    private String avatarUrl;

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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Githuber(int id, String name, String email, String login, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.avatarUrl = avatarUrl;
    }
}
