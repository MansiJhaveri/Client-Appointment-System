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
public class w1 extends HttpServlet {

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
      String bname1="";
      String bdate1="";
      String wn="";
      String wm="";
      String bm1="";
      
     
     bname1=request.getParameter("bname");
     bdate1=request.getParameter("bdate");
     bm1=request.getParameter("bm");
     
      String sql = "select * from WaitingList";
      System.out.println("hi");
      
     ResultSet rs =   stmt.executeQuery(sql);
     
     if(rs.next())
     {
     wn=rs.getString(1);
     wm=rs.getString(2);    
    // out.println(wn);
     //out.println(wm);
    // out.println(bname1);
     //out.println(bdate1);
     
     
    String sql1 = "UPDATE BookedClient SET CName = '"+wn+"' , MobileNo = '"+wm+"' WHERE CName = '"+bname1+"' AND CDate='"+bdate1+"' ";
    stmt.executeUpdate(sql1);
    String sql2 = "DELETE FROM WaitingList WHERE CName = '"+wn+"' AND MobileNo = '"+wm+"' ";
    stmt.executeUpdate(sql2);
     }
    else
    {
         String sql3 = "UPDATE BookedClient SET CName = '' , MobileNo = '' WHERE CName = '"+bname1+"' AND CDate = '"+bdate1+"' "; 
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
      response.sendRedirect("bdel.jsp");
   }
   System.out.println("Goodbye!");
        }
    }

}
