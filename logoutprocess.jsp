<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
       <body bgcolor="khaki">
        <%
            session.invalidate();
        %>
        <h1><font color="Red">You are Successfully logged out...</font></h1>
        <a href="index.jsp">Go-Back To Home Page</a>
    </body>
</html>
