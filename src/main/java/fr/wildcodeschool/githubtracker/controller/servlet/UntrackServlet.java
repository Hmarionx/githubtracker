package fr.wildcodeschool.githubtracker.controller.servlet;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UntrackServlet", urlPatterns = {"/untrack"})
public class UntrackServlet extends HttpServlet {

    @Inject
    GithubersService ghu;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String loginUntrack = request.getParameter("login");

        ghu.untrackGithuber(loginUntrack);

        response.sendRedirect(request.getContextPath() + "/githubers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/untrack.jsp").forward(request, response);
    }

}



