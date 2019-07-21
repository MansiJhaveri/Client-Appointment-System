import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author S khan
 */
public class book extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection("jdbc:odbc:ss");
      System.out.println("Connected database successfully...");
      
      
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();
      String dd=" ";
      String nb="";
     String mb="";
     String tt="";
     
    dd=request.getParameter("d");
     nb=request.getParameter("nameu");
     
   
     
     mb=request.getParameter("contactNo10");
     tt=request.getParameter("t");
      
    String sql = "select * from AllClient";
     ResultSet rs =   stmt.executeQuery(sql);
     String bn="";
     String bm="";
     
     String count = "a";
     while(rs.next())
       {
         bn=rs.getString(1);
         bm=rs.getString(3);
         
         
         if(nb.equals(bn))
         {
             if(mb.equals(bm))
             {
         
            
                 String sql1 = "UPDATE BookedClient SET CName = '"+nb+"' , MobileNo = '"+mb+"' WHERE CDate = '"+dd+"' AND CTime = '"+tt+"' ";
                 stmt.executeUpdate(sql1);
                  response.sendRedirect("clientinfo.jsp");
                        count = "b";
              
            }
       }
         if(count.equals("a"))
         
         {
             request.getRequestDispatcher("clientinfo.jsp").include(request, response); 
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Enter all valid details');");
            out.println("</script>");
             //out.println("Enter all valid details");
             break;
         }
       }
     
       }catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }
   
   finally
{
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
     
   }
   //response.sendRedirect("cilentbook.jsp");
        }
   System.out.println("Goodbye!");
        }
    
}
