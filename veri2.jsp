<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! String password2; %>
        <% 
            
            password2 = request.getParameter("password2");
            if(password2.equals("MSV009"))
            {%>
            
    <jsp:forward page="chpass_o1.jsp"/>
            <%} else
                                               {%>
    <center> <h1>Password Incorrect!!!!!</h1></center>
               <jsp:include page="chpass_o.jsp"/>
               <%}%>
    </body>
</html>
