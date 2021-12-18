<%@ page import="models.DBManager" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<% //JAVA-Code
    Object seed = session.getAttribute("seed");
    Object beschreibung = session.getAttribute("beschreibung");
    String s = (String) seed;
    String b = (String) beschreibung;
%>
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
<form method="get">
<table>
    <tr>
        <td>Seed</td>
        <td>Beschreibung</td>
    </tr>
    {
    <tr>
        <td><%=s%></td>
        <td><%=b%></td>
    </tr>
        }
</table>
    <button type="submit" formaction="EingabeSeed.jsp">Seed hinzufügen</button>
</form>

</body>
</html>