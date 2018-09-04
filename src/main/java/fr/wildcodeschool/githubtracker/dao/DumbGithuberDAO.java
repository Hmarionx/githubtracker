package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SessionScoped
public class DumbGithuberDAO implements GithuberDAO, Serializable {

    public List <Githuber> getGithubers() {
        List <Githuber> allgithubers = new ArrayList <Githuber>(5);
        allgithubers.add(new Githuber(1, "Hervé", "herve.marion@pole-emploi.fr", "Hmarionx","https://api.adorable.io/avatars/100"));
        allgithubers.add(new Githuber(2, "Julien C", "julien.cordenod@pole-emploi.fr", "djul60", "https://api.adorable.io/avatars/100"));
        allgithubers.add(new Githuber(3, "Stéphane", "stephane.couedelo@pole-emploi.fr ", "isco", "https://api.adorable.io/avatars/100"));
        allgithubers.add(new Githuber(4, "Jean-François", "jfrancois.manrique@pole-emploi.fr ", "jfm17", "https://api.adorable.io/avatars/100"));
        allgithubers.add(new Githuber(5, "Julien R", "julien.royer@wildcodeschool.fr", "julienroyer", "https://api.adorable.io/avatars/100"));

        Collections.unmodifiableList(allgithubers);

        return allgithubers;

    }

    @Override
    public void saveGithuber(Githuber githuber) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
