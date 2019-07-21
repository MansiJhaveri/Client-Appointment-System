<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! String cpo3, cpo4; %>
        <% 
            cpo3 = request.getParameter("cpo3");
            cpo4 = request.getParameter("cpo4");
            if(cpo3.equals("MSV099")==cpo4.equals(cpo3))
            {%>
    <center><h1>Password changed successfully</h1></center>
    <jsp:forward page="studentinfo.jsp"/>
            <%} else
                                               {%>
    <center> <h1>Password did not match. Try again!!!!!</h1></center>
               <jsp:include page="chpass_o1.jsp"/>
               <%}%>
    </body>
</html>
