package bai1.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bai1.entity.Qualification;
import bai1.entity.Student;
import bai1.entity.Student.Hobby;

@WebServlet("/registration-form")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> errors = validateFormData(request);
		if (errors.isEmpty()) {
			Student student = new Student();
			student.setFirstName(request.getParameter("firstName"));
			student.setLastName(request.getParameter("lastName"));
			String birthdate = request.getParameter("day") + " " + request.getParameter("month") + " "+ request.getParameter("year");
			student.setBirthday(birthdate);
			student.setEmail(request.getParameter("email"));
			student.setMobileNumber(request.getParameter("mobile"));
			student.setGender(request.getParameter("gender"));
			student.setAddress(request.getParameter("address"));
			student.setCity(request.getParameter("city"));
			student.setPinCode(Integer.parseInt(request.getParameter("pincode")));
			student.setCountry(request.getParameter("country"));
			student.setCourseApplies(request.getParameter("course"));

			String[] hobbyArray = request.getParameterValues("hobby");
			Set<Hobby> hobbies = new HashSet<>();
			if (hobbyArray != null) {
				for (String hobbyStr : hobbyArray) {
					hobbies.add(Hobby.valueOf(hobbyStr.toUpperCase()));
				}
			}
			student.setHobbies(hobbies);

			List<Qualification> qualifications = new ArrayList<>();
			qualifications.add(new Qualification("Class X", request.getParameter("classXBoard"),
					Double.parseDouble(request.getParameter("classXPercentage")),
					Integer.parseInt(request.getParameter("classXPassingYear"))));
			qualifications.add(new Qualification("Class XII", request.getParameter("classXIIBoard"),
					Double.parseDouble(request.getParameter("classXIIPercentage")),
					Integer.parseInt(request.getParameter("classXIIPassingYear"))));
			qualifications.add(new Qualification("Graduation", request.getParameter("gradBoard"),
					Double.parseDouble(request.getParameter("gradPercentage")),
					Integer.parseInt(request.getParameter("gradPassingYear"))));
			qualifications.add(new Qualification("Masters", request.getParameter("mastersBoard"),
					Double.parseDouble(request.getParameter("mastersPercentage")),
					Integer.parseInt(request.getParameter("mastersPassingYear"))));

			student.setQualifications(qualifications);
			System.out.println(student);
			
			request.setAttribute("student", student);			
			RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
			rd.forward(request, response);
		} else {
			System.out.println(errors);
		}
	}

	private List<String> validateFormData(HttpServletRequest request) {
		List<String> errors = new ArrayList<>();

		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		if (fname == null || fname.isEmpty() || !fname.matches("[a-zA-Z]{1,30}")) {
			errors.add("Invalid first name. Only alphabets allowed, max length 30.\n");
		}
		if (lname == null || lname.isEmpty() || !lname.matches("[a-zA-Z]{1,30}")) {
			errors.add("Invalid last name. Only alphabets allowed, max length 30.\n");
		}

		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		if (day.equals("Day") || month.equals("Month") || year.equals("Year")) {
			errors.add("Invalid date of birth.\n");
		}

		String email = request.getParameter("email");
		if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			errors.add("Invalid email address.\n");
		}

		String mobile = request.getParameter("mobile");
		if (mobile == null || !mobile.matches("\\d{10}")) {
			errors.add("Invalid mobile number. It must be a 10 digit number.\n");
		}

		String gender = request.getParameter("gender");
		if (gender == null || (!gender.equals("male") && !gender.equals("female"))) {
			errors.add("Please select a gender.\n");
		}
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pincode = request.getParameter("pincode");
		if (city == null || city.isEmpty() || !city.matches("[a-zA-Z]{1,30}")) {
			errors.add("Invalid city. Only alphabets allowed, max length 30.\n");
		}
		if (state == null || state.isEmpty() || !state.matches("[a-zA-Z]{1,30}")) {
			errors.add("Invalid state. Only alphabets allowed, max length 30.\n");
		}
		if (pincode == null || !pincode.matches("\\d{6}")) {
			errors.add("Invalid pin code. It must be a 6 digit number.\n");
		}
		String course = request.getParameter("course");
		if (course == null || course.isEmpty()) {
			errors.add("Please select a course.\n");
		}
		return errors;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/StudentRegisterForm.jsp");
		dispatcher.forward(req, resp);
	}
}
