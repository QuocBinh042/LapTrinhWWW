<%@page import="bai1.entity.Student"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result submit</title>
</head>

<body>
    <% Student student=(Student) request.getAttribute("student"); if (student !=null) { %>
        First name: <%= student.getFirstName() %><br/>
        Last name: <%= student.getLastName() %><br/>
        Birthday: <%= student.getBirthday() %><br/>
        Email: <%= student.getEmail() %><br/>
        Mobile number: <%= student.getMobileNumber() %><br/>
        Gender: <%= student.getGender() %><br/>
        Address: <%= student.getAddress() %><br/>
        City: <%= student.getCity() %><br/>
        Pin code: <%= student.getPinCode() %><br/>
        State: <%= student.getState() %><br/>
        Country: <%= student.getCountry() %><br/>
        Hobbies: <%= student.getHobbies() %><br/>
        Qualification: <%= student.getQualifications() %><br/>
        Course applies for: <%= student.getCourseApplies() %><br/>
    <% } else { out.println("No student data found."); } %>

</body>
</html>