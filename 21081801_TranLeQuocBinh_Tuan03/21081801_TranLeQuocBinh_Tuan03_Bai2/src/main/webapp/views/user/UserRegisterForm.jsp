<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>User Registration Form</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            margin-top: 10px;
            color: #555;
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        select {
            width: 90%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #0078d7;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #005bb5;
        }

        .gender {
            margin-bottom: 15px;
        }
    </style>
</head>

<body>
    <div class="container">
        <h2>User Registration Form</h2>
       	 <form action="registration-form" method="POST">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" required>

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required>

            <label for="email">Your Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="reenterEmail">Re-enter Email:</label>
            <input type="email" id="reenterEmail" name="reenterEmail" required>

            <label for="password">New Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="birthday">Birthday:</label>

            <div class="birthday">
                <select id="day" name="day">
                    <option value="Day">Day</option>
                    <% for (int i=1; i <=31; i++) { %>
                        <option value="<%=i%>">
                            <%=i%>
                        </option>
                        <% } %>
                </select>
                <select id="month" name="month">
                    <option value="Month">Month</option>
                    <option value="Month">Month</option>
                    <option value="January">January</option>
                    <option value="February">February</option>
                    <option value="March">March</option>
                    <option value="April">April</option>
                    <option value="May">May</option>
                    <option value="June">June</option>
                    <option value="July">July</option>
                    <option value="August">August</option>
                    <option value="September">September</option>
                    <option value="October">October</option>
                    <option value="November">November</option>
                    <option value="December">December</option>
                </select>

                <select id="year" name="year">
                    <option value="Year">Year</option>
                    <option value="Year">Year</option>
                    <% for (int i=2024; i>= 2000; i--) { %>
                        <option value="<%=i%>">
                            <%=i%>
                        </option>
                        <% } %>
                </select>
            </div>

            <div class="gender">
                <label>Gender:</label><br>
                <input type="radio" id="female" name="gender" value="female"> Female
                <input type="radio" id="male" name="gender" value="male"> Male
            </div>

            <input type="submit" value="Sign Up">
        </form>
    </div>
</body>

</html>