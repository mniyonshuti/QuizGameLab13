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
import java.util.List;

@WebServlet("/guessNumber")
public class GuessNumberServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        HttpSession session = req.getSession();

        String questions = req.getParameter("questions");
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        Integer currCount = Integer.valueOf(req.getParameter("count"));
        Integer score = Integer.valueOf(req.getParameter("score"));
        Integer answer = Integer.valueOf(req.getParameter("answer"));

        if (currCount < 5){

            if(answer == quiz.getAnswerList().get(currCount- 1)) score++;
            req.setAttribute("question", quiz.getQuestion(currCount));
            session.setAttribute("quiz", quiz);
            req.setAttribute("count", ++currCount);
            req.setAttribute("score", score);
            RequestDispatcher rd = req.getRequestDispatcher("question.jsp");
            rd.forward(req, resp);
        }
        else {
            req.setAttribute("score", score);
            req.setAttribute("score", score);
            RequestDispatcher rd = req.getRequestDispatcher("final.jsp");
            rd.forward(req, resp);
        }
    }

}

