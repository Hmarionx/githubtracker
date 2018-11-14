package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InJDBC;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TrackerServlet", urlPatterns = {"/track"})
public class TrackerServlet extends HttpServlet {

    @Inject
    @InJDBC
    private GithuberDAO dao;

    @Inject
    GithubersService ghu;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");
        try {
            ghu.trackGithuber(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/githubers");


//        String login = request.getParameter("login");
//        if (ghu.parseGithuber(login) != null) {
//            dao.saveGithuber(ghu.parseGithuber(login));
//            response.sendRedirect(request.getContextPath() + "/githubers");
//        } else {
//            request.getRequestDispatcher("/WEB-INF/track.jsp").forward(request, response);
//        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/track.jsp").forward(request, response);

    }
}
