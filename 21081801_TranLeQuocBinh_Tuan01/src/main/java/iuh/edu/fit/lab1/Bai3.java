package iuh.edu.fit.lab1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import iuh.edu.fit.lab1.entity.User;
@WebServlet("/user")
public class Bai3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Bai3() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		resp.getWriter().println();
		User user = new User("001", "Binh");
		String string = new ObjectMapper().writeValueAsString(user);
		resp.setContentType("application/json");
		resp.getWriter().write(string);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }


}
