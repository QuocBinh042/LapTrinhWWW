package bai2.controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.sql.DataSource;

import bai2.dao.UserDAO;
import bai2.daoImpl.UserDAOImpl;
import bai2.models.User;

@WebServlet("/registration-form")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/UserDB")
	private DataSource dataSource;

	private UserDAO userDAO;

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		userDAO = new UserDAOImpl(this.dataSource);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String reenterEmail = request.getParameter("reenterEmail");
		String password = request.getParameter("password");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String gender = request.getParameter("gender");
		String birthdate = day + " " + month + " " + year;
		User user = new User(firstName, lastName, email, password, birthdate, gender);
		
		if (email.equals(reenterEmail)) {
			userDAO.addUser(user);
			request.setAttribute("users", userDAO.findAll());
		}
		else {
			request.setAttribute("errors", "Email not equals Re-enter Email");
		}
		request.getRequestDispatcher("views/common/result-form.jsp").forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Handle GET requests by forwarding to the registration form page
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserRegisterForm.jsp");
		dispatcher.forward(req, resp);
	}
}
