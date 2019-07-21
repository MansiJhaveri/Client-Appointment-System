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
public class all extends HttpServlet {

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
      
      
     
     
     
      String sql = "select * from AllClient";
      System.out.println("hi");
      
     ResultSet rs =   stmt.executeQuery(sql);
         
    out.println("<html>");
    out.println("<title> All Client Detail </title>");
    out.println("<body bgcolor=lightpink >");
    out.println("<h1 align=center>--- All Client ---</h1>");
    out.println("<table border=1 width=100% height=25% >");
    out.println("<tr><th>Name</th><th>Address</th><th>Mobile No.</th></tr>");
    //out.println("<table border=1>");
    
     while(rs.next())
    {
        out.println("<tr>");
        out.println("<td align = center>"+rs.getString(1)+"</td>");
        out.println("<td align = center>"+rs.getString(2)+"</td>");
        out.println("<td align = center>"+rs.getString(3)+"</td>");
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
