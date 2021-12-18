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
<h1>Anmeldung</h1>
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
    <label for="email">EMail:</label>
    <input type="text" id="email" name="email" placeholder="EMail">
    <label for="password">Passwort:</label>
    <input type="password" id="password" name="password" placeholder="Passwort">
    <input type="submit" value="Absenden" formaction="Willkommen.jsp">
    <input type="submit" value="Registieren" formaction="Register.jsp">
</form>
</body>
</html>