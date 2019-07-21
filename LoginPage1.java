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
import javax.swing.JOptionPane;

/**
 *
 * @author S khan
 */
public class LoginPage1 extends HttpServlet {

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
      
      String name11 = " ";
     String pw11 = " ";
     
      name11=request.getParameter("Name2");
      pw11= request.getParameter("pw2");
    
     String n11 = "";
     String p11 = "";
     
      String sql = "select * from OfficeLogin ";
      ResultSet rs = stmt.executeQuery(sql);
      
      int u=0;
      int p;
      u=name11.compareTo(n11);
      p=pw11.compareTo(p11);
      
      while(rs.next())
      {
         n11=rs.getString(1);
         p11=rs.getString(2);
      }
      if((name11.equals(n11)) && (pw11.equals(p11)))
      {
          
              response.sendRedirect("time1");
     
      }
      
      
      else if((name11.equals(n11)) && ((p>0)||(p<0)))
      {
          request.getRequestDispatcher("LoginPage1.jsp").include(request, response); 
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please enter a valid Password');");
            out.println("</script>");
      }
      
      else if(((u>0)||(u<0)) && (pw11.equals(p11)))
      {
          request.getRequestDispatcher("LoginPage1.jsp").include(request, response); 
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please enter a valid Username');");
            out.println("</script>");
      }
    
    else
      {
          
         
            request.getRequestDispatcher("LoginPage1.jsp").include(request, response); 
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please enter a valid Username/Password');");
            out.println("</script>");
          
      }
      out.close();
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
   
        }
   System.out.println("Goodbye!");
        }
    
}
