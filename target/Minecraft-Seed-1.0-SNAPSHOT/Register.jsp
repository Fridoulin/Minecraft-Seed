<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link href="formatierung.css" rel="stylesheet" type="text/css">
    <style>
        body {
            background: url("background.png");
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Registrierung</h1>
<%
    String err = (String) request.getAttribute("errMsg");
    if (err != null) {
        PrintWriter out2 = response.getWriter();
        out2.append("<p class='error'>" + err + "</p>");
    }
%>
<div class="background">
    <div class="shape"></div>
    <div class="shape"></div>
</div>
<form method="post">
    <%--@declare id="password"--%><h3>Login </h3>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" placeholder="Vorname">
    <label for="name">Nachname:</label>
    <input type="text" id="nachname" name="nachname" placeholder="Nachname">
    <label for="email">EMail:</label>
    <input type="text" id="email" name="email" placeholder="EMail">
    <label for="password">Passwort:</label>
    <input type="password" id="password" name="password" placeholder="Passwort">


    <button type="submit" formaction="DoRegister">Registrieren</button>
    <button type="submit" formaction="index.jsp">zurück zum Login</button>
</form>
</body>
</html>