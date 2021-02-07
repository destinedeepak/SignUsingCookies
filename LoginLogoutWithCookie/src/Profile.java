import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/profile")
public class Profile extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
	res.setContentType("text/html");
	PrintWriter pw = res.getWriter();
	
	
	RequestDispatcher rd = req.getRequestDispatcher("link.html");
	rd.include(req, res);
	
	Cookie ck[] = req.getCookies();
	if(ck!=null) {
		String name = ck[0].getValue();
		if(!name.equals("")||name!=null) {
			
			
			pw.print("<br>Welcome to profile<br>");
			pw.print("Welcome "+ ck[0].getValue());	
		}
	}else{	
		
		pw.print("<h1>you need to login to access profile page.</h1>");
		RequestDispatcher rd1 = req.getRequestDispatcher("/login.html");
		rd1.include(req, res);
	}
}
}
