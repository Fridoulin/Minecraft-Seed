<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>

<html>
<head>
    <link href="formatierung.css" rel="stylesheet" type="text/css">
    <style>
        th, td, tr {
            
            border: 1px solid black;
            width: 1000px;
            font-weight: bold;
            text-align: center;

        }
    </style>
</head>
<%
    String driver = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String database = "MinecraftSeed";
    String userid = "root";
    String password = "NicerSpeck#";
    try {
        Class.forName(driver);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>

<body>
<form class="tableForm" action="EingabeSeed.jsp">
    <div class="background">
        <div class="shape"></div>
        <div class="shape"></div>
    </div>
    <table>
        <tr>
            <td>Seed</td>
            <td>Beschreibung</td>

        </tr>
        <%
            try {
                connection = DriverManager.getConnection(connectionUrl + database, userid, password);
                statement = connection.createStatement();
                String sql = "select * from seedDB";
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
        %>
        <tr>
            <td><%=resultSet.getString("seed") %>
            </td>
            <td><%=resultSet.getString("beschreibung") %>
            </td>
        </tr>
        <%
                }
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>
    <button type="submit"> Seed hinzufuegen</button>
</form>
</body>
</html>