
import static java.lang.System.out;
import java.util.Date;



import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;

public class time {

  public static void main(String[] args) {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    String strDate = sdf.format(date);
    //System.out.println("formatted date in dd/MM/yyyy : " + strDate.toString());
    String date1=strDate.toString();
    out.println(date1);
    request.getRequestDispatcher(date1);
    RequestDispatcher rd=request.getRequestDispatcher("time1.java");
      
  }

    private static class response {

        private static void sendRedirect(String time1java) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public response() 
        {
            response.sendRedirect("time1.java");
        }
    }
}
