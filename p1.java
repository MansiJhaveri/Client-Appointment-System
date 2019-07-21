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
public class p1 extends HttpServlet {

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
      
     String p2 = " ";
     String p3 = " ";
     String p4 = " ";
     String p11=" ";
     
     
    
     p2=request.getParameter("password2");
      
    p3= request.getParameter("password3");
     
    p4=request.getParameter("password4");
      
     
    String sql = "select * from OfficeLogin" ;
    ResultSet rs = stmt.executeQuery(sql);
    if(rs.next())
    {
        p11 = rs.getString(2);
    }
    
    if(p2.equals(p11))
    {
        if(p3.equals(p4))
        {
            String sql1 = "UPDATE OfficeLogin SET Password = '"+p4+"' WHERE Password = '"+p2+"' ";
            stmt.executeUpdate(sql1);
            //out.println("Password changed successfully");
            request.getRequestDispatcher("studentinfo.jsp").include(request, response);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Password changed successfully');");
            out.println("</script>");
        }
        else
        {
            //out.println("New password does not match");
            request.getRequestDispatcher("chpass_o.jsp").include(request, response);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('New password does not match');");
            out.println("</script>");
        }
    }
    else
    {
        //out.println("Current password does not match");
        request.getRequestDispatcher("chpass_o.jsp").include(request, response);
        out.println("<script type=\"text/javascript\">");
            out.println("alert('Current password does not match');");
            out.println("</script>");
    }
    
      out.close();
      
       }catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally
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
      response.sendRedirect("chpass_o.jsp");
   }
   
   
   
     }
   System.out.println("Goodbye!");
        }
    }
