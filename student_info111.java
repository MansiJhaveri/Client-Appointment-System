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
public class student_info111 extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
   {
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
      
      String n = " ";
     String a = " ";
     String m = " ";
     
     
     
     
     
     
    
      n=request.getParameter("n1");
      
     a= request.getParameter("a1");
     
     m=request.getParameter("m1");
     
     int l=m.length();
     int l1=n.length();
     int l2=a.length();
     
     if(l1>0)
     {
         if(l2>0)
         {
     if(l==10)
     {   
         if((m.charAt(0)=='9')||(m.charAt(0)=='8')||(m.charAt(0)=='7'))
         {
             
                 if((m.charAt(1)=='1')||(m.charAt(1)=='2')||(m.charAt(1)=='3')||(m.charAt(1)=='4')||(m.charAt(1)=='5')||(m.charAt(1)=='6')||(m.charAt(1)=='7')||(m.charAt(1)=='8')||(m.charAt(1)=='9')||(m.charAt(1)=='0'))
                 {
                     if((m.charAt(2)=='1')||(m.charAt(2)=='2')||(m.charAt(2)=='3')||(m.charAt(2)=='4')||(m.charAt(2)=='5')||(m.charAt(2)=='6')||(m.charAt(2)=='7')||(m.charAt(2)=='8')||(m.charAt(2)=='9')||(m.charAt(2)=='0'))
                     {
                         if((m.charAt(3)=='1')||(m.charAt(3)=='2')||(m.charAt(3)=='3')||(m.charAt(3)=='4')||(m.charAt(3)=='5')||(m.charAt(3)=='6')||(m.charAt(3)=='7')||(m.charAt(3)=='8')||(m.charAt(3)=='9')||(m.charAt(3)=='0'))
                         {
                             if((m.charAt(4)=='1')||(m.charAt(4)=='2')||(m.charAt(4)=='3')||(m.charAt(4)=='4')||(m.charAt(4)=='5')||(m.charAt(4)=='6')||(m.charAt(4)=='7')||(m.charAt(4)=='8')||(m.charAt(4)=='9')||(m.charAt(4)=='0'))
                             { 
                                 if((m.charAt(5)=='1')||(m.charAt(5)=='2')||(m.charAt(5)=='3')||(m.charAt(5)=='4')||(m.charAt(5)=='5')||(m.charAt(5)=='6')||(m.charAt(5)=='7')||(m.charAt(5)=='8')||(m.charAt(5)=='9')||(m.charAt(5)=='0'))
                                 {
                                     if((m.charAt(6)=='1')||(m.charAt(6)=='2')||(m.charAt(6)=='3')||(m.charAt(6)=='4')||(m.charAt(6)=='5')||(m.charAt(6)=='6')||(m.charAt(6)=='7')||(m.charAt(6)=='8')||(m.charAt(6)=='9')||(m.charAt(6)=='0'))
                                     {
                                         if((m.charAt(7)=='1')||(m.charAt(7)=='2')||(m.charAt(7)=='3')||(m.charAt(7)=='4')||(m.charAt(7)=='5')||(m.charAt(7)=='6')||(m.charAt(7)=='7')||(m.charAt(7)=='8')||(m.charAt(7)=='9')||(m.charAt(7)=='0'))
                                         {
                                             if((m.charAt(8)=='1')||(m.charAt(8)=='2')||(m.charAt(8)=='3')||(m.charAt(8)=='4')||(m.charAt(8)=='5')||(m.charAt(8)=='6')||(m.charAt(8)=='7')||(m.charAt(8)=='8')||(m.charAt(8)=='9')||(m.charAt(8)=='0'))
                                             {
                                                 if((m.charAt(9)=='1')||(m.charAt(9)=='2')||(m.charAt(9)=='3')||(m.charAt(9)=='4')||(m.charAt(9)=='5')||(m.charAt(9)=='6')||(m.charAt(9)=='7')||(m.charAt(9)=='8')||(m.charAt(9)=='9')||(m.charAt(9)=='0'))
                                                 {
                                         String sql = "INSERT INTO AllClient(Client_Name,Address,MobileNo) VALUES ('"+n+"','"+a+"','"+m+"') ";
                                     
                                     System.out.println("hi");
                                     stmt.executeUpdate(sql);
    
    out.println("CLIENT ADDED SUCCESSFULLY");
    response.sendRedirect("studentinfo.jsp");
                                 } }}}}}}} }}
     else
         {
           request.getRequestDispatcher("studentinfo.jsp").include(request, response); 
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please enter valid mobile no.');");
            out.println("</script>"); 
            
         }
         
     }
     else
     {
         request.getRequestDispatcher("studentinfo.jsp").include(request, response); 
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please enter 10 digit mobile no.');");
            out.println("</script>");
     }
         }
     else
         {
             request.getRequestDispatcher("studentinfo.jsp").include(request, response); 
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please enter all Details');");
            out.println("</script>");
         }
             }
     else
     {
         request.getRequestDispatcher("studentinfo.jsp").include(request, response); 
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please enter all Details');");
            out.println("</script>");
            
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
      
     // response.sendRedirect("studentinfo.jsp");
   }
   
        }
   System.out.println("Goodbye!");
   
        }
    
}
