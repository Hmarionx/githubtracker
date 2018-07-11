package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GithubersServlet", urlPatterns = {"/githubers"})


public class GithubersServlet extends javax.servlet.http.HttpServlet {


        public List<Githuber> githubers = new ArrayList<>(5);

        {
            githubers.add(new Githuber(1,"Hervé","herve.marion@pole-emploi.fr","ihma","https://api.adorable.io/avatars/100"));
            githubers.add(new Githuber(2,"Julien C","julien.cordenod@pole-emploi.fr","ijco","https://api.adorable.io/avatars/100"));
            githubers.add(new Githuber(3,"Stéphane","stephane.couedelo@pole-emploi.fr ","isco","https://api.adorable.io/avatars/100"));
            githubers.add(new Githuber(4,"Jean-François","jfrancois.manrique@pole-emploi.fr ","ijma","https://api.adorable.io/avatars/100"));
            githubers.add(new Githuber(5,"Julien R","julien.royer@wildcodeschool.fr","ijro","https://api.adorable.io/avatars/100"));
        }
        /*
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
        */

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("githubers", githubers);
            request.getRequestDispatcher("/WEB-INF/githubers.jsp").forward(request, response);
        }
    }

