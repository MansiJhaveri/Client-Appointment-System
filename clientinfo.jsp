<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Info</title>
        <link href="mystyle.css" rel="stylesheet" />
        <style>
form {display: inline-block;}
        </style>
    </head>
    <body background="C:\Users\DAKSH\Desktop\Final Year Project\ProjectPhotos\xyz1.jpg">
        <img src="C:\Users\DAKSH\Desktop\Final Year Project\ProjectPhotos\bsd.jpg">
        <hr>
        <h3 align="right">
        <a href="index.jsp">HOME</a> &nbsp;&nbsp;<a href="AU.jsp">ABOUT US</a> &nbsp;&nbsp;<a href="MS.jsp">CONTACT US </a> &nbsp;&nbsp;
        </h3>
        <hr><br/>
       
    <center>
        <div style="background-color: whitesmoke; width: 600px; height: 500px; opacity: 0.9;">
            <br><br>
            <table>
            <tr>
            <td>
            <div>
            <form action="free">
                <input type="submit" value="Check Slots" >
                </form>   
             <form action="wait.jsp">
                <input type="submit" value="Waiting list" >
            </form>
            <form action="bdel.jsp">
                <input type="submit" value="Delete Appointment" >    
            </form>
            </div>
            </td>
            </tr>
            </table>
          <form action="book">
              <table cellpadding="5">
                  <tr>
                      <td>Name    : </td>  <td> <input type= "text" name="nameu" placeholder="Name"/></td>
              </tr><br/><br/>
              <tr>
                  <td>Mobile No   :</td> <td>  <input type="text" name="contactNo10" placeholder="Contact No"/></td>
              </tr><br/><br/>
              <tr>
                  <td> Date        :</td>   <td> <input type="text" name="d" placeholder="Date"/></td>
              </tr><br/><br/>
              <tr>
                  <td> Time        :</td>   <td> <input type="text" name="t" placeholder="Time"/></td>
              <tr>
              </table><br/><br/>
                             <input type="submit" value="Book Appointment" />             
          </form>
            </div>
    </center>     
    </body>
</html>
