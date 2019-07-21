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

public class free extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection("jdbc:odbc:ss");
      System.out.println("Connected database successfully...");
      
      
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();     
      String sql = "select * from BookedClient";
      
     ResultSet rs =   stmt.executeQuery(sql);
    out.println("<html>");
    out.println("<title> Check Available Slot </title>");
    out.println("<body background=\"C:\\Users\\DAKSH\\Desktop\\Final Year Project\\ProjectPhotos\\xyz1.jpg\">");
    out.println("<h1 align=center>--- Booked Appointment ---</h1>");
    out.println("<table border=1 width=100% height=25% >");
    out.println("<tr><th>Name</th><th>Mobile No.</th><th>Date</th><th>Time</th></tr>");
    
     while(rs.next())
    {
        out.println("<tr>");
        out.println("<td align = center>"+rs.getString(1)+"</td>");
        out.println("<td align = center>"+rs.getString(2)+"</td>");
        out.println("<td align = center>"+rs.getString(3)+"</td>");
        out.println("<td align = center>"+rs.getString(4)+"</td>");
        out.println("</tr>");
    }
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
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
   }
   System.out.println("Goodbye!");
        }
    }
}
