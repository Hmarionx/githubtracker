package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class DumbGithuberDAO implements GithuberDAO {

    public List <Githuber> getGithubers() {
        List <Githuber> githuber = new ArrayList <>(5);
        githuber.add(new Githuber(1, "Hervé", "herve.marion@pole-emploi.fr", "Hmarionx","https://api.adorable.io/avatars/100"));
        githuber.add(new Githuber(2, "Julien C", "julien.cordenod@pole-emploi.fr", "djul69", "https://api.adorable.io/avatars/100"));
        githuber.add(new Githuber(3, "Stéphane", "stephane.couedelo@pole-emploi.fr ", "stephwildcode", "https://api.adorable.io/avatars/100"));
        githuber.add(new Githuber(4, "Jean-François", "jfrancois.manrique@pole-emploi.fr ", "jfm17", "https://api.adorable.io/avatars/100"));
        githuber.add(new Githuber(5, "Julien R", "julien.royer@wildcodeschool.fr", "julienroyer", "https://api.adorable.io/avatars/100"));

        Collections.unmodifiableList(githuber);

        return githuber;

    }

    @Override
    public void saveGithuber(Githuber githuber) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

}
