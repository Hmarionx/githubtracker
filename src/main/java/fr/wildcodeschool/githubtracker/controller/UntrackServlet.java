package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UntrackServlet", urlPatterns = {"/untrack"})
public class UntrackServlet extends HttpServlet {

    @Inject
    GithubersService ghu;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String loginUntrack = request.getParameter("login");
        try {
            ghu.untrackGithuber(loginUntrack);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/githubers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/untrack.jsp").forward(request, response);
    }

}


