<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 18/09/2019
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>GuessNextNumber</title>
</head>
<body>
<h1>The Number Quiz</h1>
<%
    int score = (Integer) request.getAttribute("score");
%>
<p>Your current score is ${score} </p>
<p>Guess the next number in the sequence</p>
<p>"${question}"</p>
<form action="guessNumber" method="post">
    <p> Your answer: <input name="answer" type=\"number\" required></p>
    <p><input type="submit" value="Submit"></p>
</form>
</body>
</html>
