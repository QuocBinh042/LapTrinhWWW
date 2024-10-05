package bai1.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.Set;

import bai1.dao.UserDAO;
import bai1.dao.Impl.UserDAOImpl;
import bai1.models.User;
import bai1.utils.EntityManagerFactoryUtil;

@WebServlet("/registration-form")
public class UsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EntityManagerFactoryUtil entityManageFactory;
    private UserDAO userDao;

    public UsersServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.entityManageFactory = new EntityManagerFactoryUtil();
        this.userDao = new UserDAOImpl(this.entityManageFactory.getEnManager());
    }

    @Override
    public void destroy() {
        this.entityManageFactory.close();
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Handle GET requests by forwarding to the registration form page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserRegisterForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String reenterEmail = request.getParameter("reenterEmail");
        String password = request.getParameter("password");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String birthdate = day + " " + month + " " + year;
        String gender = request.getParameter("gender");
        User user = new User(0, firstName, lastName, email, password, birthdate, gender);

        // Initialize Validator for checking constraints
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (violations.isEmpty() && email.equals(reenterEmail)) {
            this.userDao.save(user);
            request.setAttribute("user", user);
            request.setAttribute("users", this.userDao.getAll());
            request.getRequestDispatcher("/views/common/result-form.jsp").forward(request, response);
        } else {
            StringBuilder errors = new StringBuilder();
            for (ConstraintViolation<User> violation : violations) {
                errors.append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("<br />");
            }

            if (!email.equals(reenterEmail)) {
                errors.append("Emails do not match.<br />");
            }

            request.setAttribute("user", user);
            
            request.setAttribute("errors", errors.toString());

            request.getRequestDispatcher("/views/common/result-form.jsp").forward(request, response);
        }
    }

}
