<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <style>
            form {display: inline-block;}
        </style>

    </head>
    <body background="C:\Users\DAKSH\Desktop\Final Year Project\ProjectPhotos\xyz1.jpg">
    <img src="C:\Users\DAKSH\Desktop\Final Year Project\ProjectPhotos\bsd.jpg">
        <hr>
        <h3 align="right">
        <a href="studentinfo.jsp">HOME</a> &nbsp;&nbsp;<a href="AU_o.jsp">ABOUT US</a> &nbsp;&nbsp;<a href="CU.jsp">CONTACT US </a> &nbsp;&nbsp;
        </h3>
        <hr>
    <center>
        <h1> Information</h1>
    </center>
    <br>
    <div align="right">
    <form action="deleted.jsp">        
                  <input type="submit" value="Delete" />
    </form>
    <form action="Edit.jsp">
                  <input type="submit" value="Edit" />
    </form>
    </div>
    <center>
        <div>
    <form action="student_info111">
        <table cellpadding="7">
            <tr>
                <td> Name : </td> <td><input type="memo" name="n1" size="40"/></td>
            </tr><br/><br/>
            <tr>
                <td>Address : </td> <td><input type="memo" name="a1" size="40"/></td>
            </tr><br/><br/>
            <tr>
                <td>Mobile No. :</td> <td> <input type="memo" name="m1" size="40"/></td>
            </tr><br/><br/>
        </table>
                  <input type="submit" value="Add" />
    </form>
        </div>
        </center>
    <br/><br/><br/>
    <div align="center">
        <form action="as.jsp" method="POST">
    <input type="submit" value="Add new slots" name="sl1" />
        </form>
        <form action="chpass_o.jsp" method="POST">
    <input type="submit" value="Change office password" name="pass1" />
        </form>
        <form action="all">
            <input type="submit" value="All Clients" name="ac" />
        </form>
        <form action="free">
            <input type="submit" value="Booked Appointments" name="ba" />
        </form>
        <form action="index.jsp" method="link">
            <input type="submit" value="Log Out" name="loo" />
        </form>
    </div>
    
    
                 
    </body>
</html>
