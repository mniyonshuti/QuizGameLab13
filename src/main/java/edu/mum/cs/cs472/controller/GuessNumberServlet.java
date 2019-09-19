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
import java.io.PrintWriter;

@WebServlet("/guessNumber")
public class GuessNumberServlet extends HttpServlet {

    public static  String currSession = "currSession";
    private Quiz quiz;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        HttpSession session = req.getSession();

        Integer currCount = 0;
        int score = 0;
        if(session.getAttribute(currSession) != null){
            quiz = (Quiz)session.getAttribute(currSession);
            currCount = (Integer) session.getAttribute("count");
            session.setAttribute("count", ++currCount);
        }
        else {
            quiz = new Quiz();
            session.setAttribute(currSession, quiz);
            session.setAttribute("count", currCount);
            session.setAttribute("score", score);
        }
        if(currCount < 5){
            score = (Integer) session.getAttribute("score");
            req.setAttribute("quiz", quiz);
            RequestDispatcher rd = req.getRequestDispatcher("question.jsp");
            rd.forward(req, resp);
        }
        else {
            int score2 = (Integer) session.getAttribute("score");
            RequestDispatcher rd = req.getRequestDispatcher("final.jsp");
            rd.forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        quiz = (Quiz)session.getAttribute(currSession);
        if(quiz != null){
            int answerValue = Integer.valueOf(req.getParameter("answer"));
            int score = (Integer) session.getAttribute("score");
            int count = (Integer) session.getAttribute("count");
            if(answerValue == quiz.getAnswer(count)) score ++;
            session.setAttribute("score", score);
            resp.sendRedirect("guessNumber");
        }
    }


}

