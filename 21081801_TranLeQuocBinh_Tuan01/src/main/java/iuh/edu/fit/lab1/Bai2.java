package iuh.edu.fit.lab1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Bai2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Bai2() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello Servlet</title><head>");
		out.println("<body>");
		out.println("<h3>Hello World</h3>");
		out.println("</body>");
		out.println("</html>");	
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }

}
