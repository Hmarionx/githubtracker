package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.DumbGithuberDAO;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;


@WebServlet(name = "GithubersServlet", urlPatterns = {"/githubers"})


public class GithubersServlet extends javax.servlet.http.HttpServlet {

    private GithuberDAO dao;

    // GithuberDAO dao = new DumbGithuberDAO();
    GithubersService ghs = new GithubersService(dao);
    private String login = "ihma";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request.setAttribute("githubers", Arrays.asList(ghs.getGithuber(login)));
        request.setAttribute("githubers", ghs.getAllGithubers());

        request.getRequestDispatcher("/WEB-INF/githubers.jsp").forward(request, response);
    }
}

