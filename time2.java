/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author S khan
 */
/*import java.util.Date;
public class time {
    public static void main(String args[]) {
      // Instantiate a Date object
      Date date = new Date();

      // display time and date using toString()
      System.out.println(date.toString());
   }
}*/
import static java.lang.System.out;
import java.util.Date;



import java.text.SimpleDateFormat;

public class time2 {

  public static void main(String[] args) {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    String strDate = sdf.format(date);
    //System.out.println("formatted date in dd/MM/yyyy : " + strDate.toString());
    String date1=strDate.toString();
    out.println(date1);
    
    
    
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
