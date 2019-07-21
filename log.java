import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author S khan
 */
public abstract class log extends HttpServlet implements Servlet , Filter {
    
    private static final long serialVersionUID = 1L;
    public String username =null, password=null;
    public HttpSession session ;
    public PrintWriter pw;
    int do_get =0 ;
    /**
     * Default constructor. 
     */


    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession(false);         
        if (session == null || session.getAttribute("Name2") == null) {
            response.sendRedirect("studentinfo.jsp"); // No logged-in user found, so redirect to login page.
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
        } else {
            chain.doFilter(req, res);  
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {

        do_get=1;
        pw = response.getWriter();
        session=request.getSession(false);
        try
        {
            if(request.getParameter("action")!=null)
            {
                if(request.getParameter("action").equals("logout"))
                {

                    session = request.getSession(true);
                    session.setAttribute("Name2", "");
                    session.setAttribute("pw2", "");
                    session.invalidate();
                     response.sendRedirect("studentinfo.jsp");
                    return; 
                }
            }
            else
            if(session !=null)
                {
                 if( (String)session.getAttribute(username)!=null)
                username = (String)session.getAttribute("Name2").toString();
                if( (String)session.getAttribute("pw2") !=null)
                 password =session.getAttribute("pw2").toString();
                pw.write("not new-");
                serviced(request,response);
                }

        }
        catch(Exception ex)
        {
            pw.write("Error-"+ex.getMessage());
        } 

    }

    private void serviced(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
