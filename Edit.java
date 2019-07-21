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
public class Edit extends HttpServlet {

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
      
     String en = " ";
     String ea = " ";
     String em = " ";
     
     
    
     en=request.getParameter("ne");
      
    ea= request.getParameter("ae");
     
    em=request.getParameter("me");
      
     
    
    
      String sql = "UPDATE AllClient SET MobileNo = '"+em+"' , Address = '"+ea+"' WHERE Client_Name = '"+en+"' ";
      System.out.println("hi");
     stmt.executeUpdate(sql);
     out.println("CLIENT EDITED SUCCESSFULLY");
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
      response.sendRedirect("studentinfo.jsp");
   }
   
   
   
     }
   System.out.println("Goodbye!");
        }
    }
