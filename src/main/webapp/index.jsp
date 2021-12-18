<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link href="formatierung.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="background">
    <div class="shape"></div>
    <div class="shape"></div>
</div>
<form method="post">
    <%
        String err = (String) request.getAttribute("errMsg");
        if (err != null) {
            PrintWriter out2 = response.getWriter();
            out2.append("<p class='error'>" + err + "</p>");
        }
    %>
    <%--@declare id="password"--%><h3>Login </h3>
    <label for="email">EMail:</label>
    <input type="text" id="email" name="email" placeholder="EMail">
    <label for="password">Passwort:</label>
    <input type="password" id="password" name="password" placeholder="Passwort">
    <button type="submit" formaction="Welcome">Login</button>
    <button type="submit" formaction="Register.jsp">Register</button>
</form>
</body>
</html>