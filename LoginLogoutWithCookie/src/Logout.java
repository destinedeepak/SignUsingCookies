import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/logout")
public class Logout extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	  res.setContentType("text/html");  
	  
	  String s = req.getParameter("username");
	  PrintWriter pw = res.getWriter();
	
	  Cookie ck[] = req.getCookies();
	  if(ck != null) {
	  for(Cookie cookie:ck) {
		  cookie.setMaxAge(0);
		  res.addCookie(cookie);
	  }
	  }
	  
	  pw.print("You are logged out!<br>");
	  RequestDispatcher rd = req.getRequestDispatcher("link.html");
	  rd.include(req, res);
	  System.out.print("profile");
  }
}
