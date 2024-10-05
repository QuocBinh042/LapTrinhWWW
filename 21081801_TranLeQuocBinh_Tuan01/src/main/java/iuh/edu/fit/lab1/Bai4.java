package iuh.edu.fit.lab1;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.print.PrinterAbortException;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.io.PrintWriter;

public class Bai4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Bai4() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		String id = this.getServletConfig().getInitParameter("ID");
		String name = this.getServletConfig().getInitParameter("Name");
		out.println("id " + id);
		out.println("name " + name);
		out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    }

}
