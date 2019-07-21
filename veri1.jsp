<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! String Name2, password2; %>
        <% 
            
            Name2 = request.getParameter("Name2");
            password2 = request.getParameter("password2");
            if(Name2.equals("Office")&&password2.equals("MSV009") )
            {%>
            <jsp:forward page="studentinfo.jsp"/>
            <%} else
                                               {%>
    <center> <h1>Enter a valid UserName/Password Try again!!!!!</h1></center>
               <jsp:include page="LoginPage1.jsp"/>
               <%}%>
    </body>
</html>
