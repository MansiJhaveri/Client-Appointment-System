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
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author S khan
 */
public class as extends HttpServlet {

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
      
      String d2="";
      String t2="";
      
      d2=request.getParameter("d1");
      t2=request.getParameter("t1");
      
      //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
   // Date d3 = dateFormat.parse(d2);
      
      
      
     
     
     
    
    
    
    
    
    
    
    //d3=dateFormat.parse(d2);
      
    // t2= request.getParameter("t1");
      String sql = "INSERT INTO BookedClient (CDate,CTime) VALUES ('"+d2+"','"+t2+"') ";
      System.out.println("hi");
     stmt.executeUpdate(sql);
     out.println("SLOT ADDED SUCCESSFULLY");
     
     String sql1 = "select * from WaitingList";
     ResultSet rs =   stmt.executeQuery(sql1);
     
     String n11 = "";
     String m11 = "";
     
     if(rs.next())
     {
         n11=rs.getString(1);
         m11=rs.getString(2);
         String sql2 = "UPDATE BookedClient SET CName = '"+n11+"' , MobileNo = '"+m11+"' WHERE CDate='"+d2+"' AND CTime='"+t2+"' ";
      System.out.println("hi");
     stmt.executeUpdate(sql2);
     String sql3 = "DELETE FROM WaitingList WHERE CName = '"+n11+"' AND MobileNo = '"+m11+"' ";
     stmt.executeUpdate(sql3);
     }
     
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
      response.sendRedirect("as.jsp");
   }
   
   
   
     }
   System.out.println("Goodbye!");
        }
    }
