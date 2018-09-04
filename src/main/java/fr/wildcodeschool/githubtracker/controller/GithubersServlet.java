package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "GithubersServlet", urlPatterns = {"/githubers"})
public class GithubersServlet extends HttpServlet {

    @Inject
    private GithubersService ghs;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List <Githuber> githubers = ghs.getGithubers();

        request.setAttribute("githubers", githubers);
        request.getRequestDispatcher("/WEB-INF/githubers.jsp").forward(request, response);
    }

}
