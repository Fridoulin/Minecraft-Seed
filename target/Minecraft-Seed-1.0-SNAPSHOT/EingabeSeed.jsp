<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% //JAVA-Code
    Object seed = session.getAttribute("seed");
    Object beschreibung = session.getAttribute("beschreibung");
    String s = (String) seed;
    String b = (String) beschreibung;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        body {
            background: url("background.png");
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="formatierung.css" rel="stylesheet" type="text/css">
    <title>Insert title here</title>
</head>
<body>
<div class="background">
    <div class="shape"></div>
    <div class="shape"></div>
</div>
<form method="post" action="DoEingabeSeed">

        <label for="seed">Seed:</label>
        <input type="text" id="seed" name="seed" placeholder="Seed">

        <label for="beschreibung">Bescheibung</label>
        <textarea type="text" id="beschreibung" name="beschreibung" placeholder="Bescheibung" cols="40" rows="4"></textarea>

    <button type="submit" value="Senden">Senden</button>
    <button type="submit" formaction="AllesAnzeigen.jsp">Alle Seeds Anzeigen</button>
</form>
</body>
</html>
