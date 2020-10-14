package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Q25_FirstServlet")
public class Q25_FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Q25_SecondServlet");
		
		
		rd.forward(request, response);
		//rd.include(request, response);
		
		//response.sendRedirect("Q25_SecondServlet");
//		response.setContentType("text/html");
//		
//		PrintWriter out = response.getWriter();
//		out.print("forwaded to second servlet");
//		
//		out.flush();
//		out.close();
		
	}

}
