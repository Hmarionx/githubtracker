package fr.wildcodeschool.githubtracker.model;

import javax.persistence.*;

@Entity

@Table(name = "Users")
@NamedQueries({
        @NamedQuery(name = Credentials.FIND_BY_LOGIN_PASSWORD, query = "SELECT c FROM Credentials c WHERE c.login = :login AND c.password = :password")
})
public class Credentials {

    public static final String FIND_BY_LOGIN_PASSWORD = "Credentials.findByLoginAndPassword";

    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public Credentials() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
