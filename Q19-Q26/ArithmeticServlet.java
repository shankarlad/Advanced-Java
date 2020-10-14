	package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ArithmeticServlet")
public class ArithmeticServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		
		
		if(request.getParameter("add")!=null) {
			out.println("<h1>Addition : "+(num1+num2)+"<h1>");
		}
		else if(request.getParameter("subtract")!=null) {
			out.println("<h1>Subtraction :"+(num1-num2)+"<h1>");
		}
		else if(request.getParameter("multiply")!=null) {
			out.println("<h1>Multiplication :"+num1*num2+"<h1>");
		}else if(request.getParameter("devide")=="devide") {
			out.println("<h1>Multiplication :"+num1/num2+"<h1>");
		}
	}

}
