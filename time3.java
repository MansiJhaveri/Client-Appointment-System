import java.util.*;
import java.text.*;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class time3 extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
         java.util.Date datePreviousDate = null;
        
        
        try (PrintWriter out = response.getWriter()) {
          Connection conn = null;
          
          int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
          
          Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    String prevDate = sdf.format(date.getTime() - MILLIS_IN_DAY);   
   Statement stmt = null;
   try{
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection("jdbc:odbc:ss");
      System.out.println("Connected database successfully...");
      
      
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();  
      
      String sql = "DELETE * FROM BookedClient WHERE CDate = '"+prevDate+"' ";
      stmt.executeUpdate(sql);      
       }
   catch(SQLException se){
      
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
      response.sendRedirect("clientinfo.jsp");
   }
   System.out.println("Goodbye!");
        }
    }

    private Object yesterday() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private static class myDate {

        private static int getTime() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        public myDate() {
        }
    }

    private static class dateSelectedFrom {

        public dateSelectedFrom() {
        }
    }

}
