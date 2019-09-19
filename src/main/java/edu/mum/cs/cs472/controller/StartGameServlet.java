package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.model.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start")
public class StartGameServlet extends HttpServlet {

    public static  String currSession = "currSession";
    private Quiz quiz;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        Integer currCount = 0;
        int score = 0;
        quiz = new Quiz();
        req.setAttribute("question", quiz.getQuestion(currCount));
        req.setAttribute("count", currCount);
        req.setAttribute("score", score);
        RequestDispatcher rd = req.getRequestDispatcher("question.jsp");
        rd.forward(req, resp);
    }
}
