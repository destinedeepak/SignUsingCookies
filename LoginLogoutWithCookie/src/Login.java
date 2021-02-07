import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	
	res.setContentType("text/html");
	PrintWriter pw = res.getWriter();
	RequestDispatcher rd = req.getRequestDispatcher("link.html");
	rd.include(req, res);
	
	if(password.equals("admin123")) {
		pw.print("<br>You are succesfully logged in!");
		pw.print("<br>Welcome "+username);
		Cookie ck = new Cookie("user",username);
		res.addCookie(ck);
	}else {
		pw.print("<br>password is invalid.<br> please login first!");
		RequestDispatcher rd1 = req.getRequestDispatcher("login.html");
		rd1.include(req, res);
	}
}
}
