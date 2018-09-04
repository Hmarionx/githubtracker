package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TrackerServlet", urlPatterns = {"/track"})
public class TrackerServlet extends HttpServlet {

    @Inject
    @InMemory
    private GithuberDAO dao;

    @Inject
    private GithubUtils ghu;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        dao.saveGithuber(ghu.parseGithuber(login));
        response.sendRedirect(request.getContextPath() + "/githubers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/track.jsp").forward(request, response);

    }
}
