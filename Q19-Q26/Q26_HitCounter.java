package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q26_HitCounter")
public class Q26_HitCounter extends HttpServlet {
	
	private int count = 0;
	
	public void init() { 
	    count = 0;
	   } 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		count++;
		
		out.print("<h1>Page Hit by "+count+" times </h1>");
		
	}
	
}
