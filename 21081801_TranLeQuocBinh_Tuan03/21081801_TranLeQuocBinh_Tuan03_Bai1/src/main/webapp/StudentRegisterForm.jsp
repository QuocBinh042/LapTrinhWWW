<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #d0ecf9;
        }

        .container {
            width: 60%;
            background-color: #d0ecf9;
            padding: 20px;
            margin: 0 auto;
            border-radius: 10px;
            border: 1px solid #b0d4e0;
        }

        h2 {
            text-align: center;
            color: #003c8f;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-top: 10px;
            color: #003c8f;
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        textarea,
        select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #b0d4e0;
            border-radius: 5px;
        }

        input[type="submit"],
        input[type="reset"] {
            width: 45%;
            padding: 10px;
            margin: 10px 2%;
            background-color: #0078d7;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #005bb5;
        }

        .gender,
        .hobbies,
        .qualification-table {
            margin-bottom: 20px;
        }

        .hobbies input[type="checkbox"] {
            margin-right: 10px;
        }

        .qualification-table {
            width: 100%;
            border-collapse: collapse;
            border: 2px solid #0078d7;
            background-color: #e0f7fa;
        }

        .qualification-table th,
        .qualification-table td {
            border: 1px solid #0078d7;
            padding: 10px;
            text-align: center;
        }

        .qualification-table th {
            background-color: #0078d7;
            color: white;
        }

        .qualification-table input[type="text"] {
            width: 80%;
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #b0d4e0;
        }

        .qualification-table input[type="text"]:focus {
            border-color: #0078d7;
            outline: none;
        }
    </style>
</head>

<body>

    <div class="container">
        <h2>Student Registration Form</h2>
        <form action="registration-form" name="registration-form" method="POST">
            <label for="firstName">First name:</label>
            <input type="text" id="firstName" name="firstName" maxlength="30"
                placeholder="max 30 characters a-z and A-Z">

            <label for="lastName">Last name:</label>
            <input type="text" id="lastName" name="lastName" maxlength="30" placeholder="max 30 characters a-z and A-Z">

            <label for="dob">Date of birth:</label>
            <div>
                <!-- Day -->
                <select id="day" name="day">
                    <option value="Day">Day</option>
                    <% for (int i=1; i <=31; i++) { %>
                        <option value="<%=i%>">
                            <%=i%>
                        </option>
                        <% } %>
                </select>

                <!-- Month -->
                <select id="month" name="month">
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

                <!-- Year -->
                <select id="year" name="year">
                    <option value="Year">Year</option>
                    <% for (int i=2024; i>= 2000; i--) { %>
                        <option value="<%=i%>">
                            <%=i%>
                        </option>
                        <% } %>
                </select>
            </div>


            <label for="email">Email:</label>
            <input type="email" id="email" name="email">

            <label for="mobile">Mobile number:</label>
            <input type="text" id="mobile" name="mobile" maxlength="10" placeholder="10 digit number">

            <label for="gender">Gender:</label>
            <div class="gender">
                <input type="radio" id="male" name="gender" value="male"> Male
                <input type="radio" id="female" name="gender" value="female"> Female
            </div>

            <label for="address">Address:</label>
            <textarea id="address" name="address"></textarea>

            <label for="city">City:</label>
            <input type="text" id="city" name="city" maxlength="30" placeholder="max 30 characters a-z and A-Z">

            <label for="pincode">Pin code:</label>
            <input type="text" id="pincode" name="pincode" maxlength="6" placeholder="6 digit number">

            <label for="state">State:</label>
            <input type="text" id="state" name="state" maxlength="30" placeholder="max 30 characters a-z and A-Z">

            <label for="country">Country:</label>
            <input type="text" id="country" name="country" value="India">

            <label for="hobbies">Hobbies:</label>
            <div class="hobbies">
                <input type="checkbox" id="drawing" name="hobby" value="Drawing"> Drawing
                <input type="checkbox" id="singing" name="hobby" value="Singing"> Singing
                <input type="checkbox" id="dancing" name="hobby" value="Dancing"> Dancing
                <input type="checkbox" id="sketching" name="hobby" value="Sketching"> Sketching
                <input type="checkbox" id="other" name="hobby" value="Other"> Other
            </div>

            <label for="qualification">Qualification:</label>
            <table class="qualification-table">
                <tr>
                    <th>Sl.No.</th>
                    <th>Examination</th>
                    <th>Board</th>
                    <th>Percentage</th>
                    <th>Year of Passing</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Class X</td>
                    <td><input type="text" name="classXBoard" maxlength="10"></td>
                    <td><input type="text" name="classXPercentage" maxlength="5" placeholder="up to 2 decimal"></td>
                    <td><input type="text" name="classXPassingYear" maxlength="4"></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Class XII</td>
                    <td><input type="text" name="classXIIBoard" maxlength="10"></td>
                    <td><input type="text" name="classXIIPercentage" maxlength="5" placeholder="up to 2 decimal">
                    </td>
                    <td><input type="text" name="classXIIPassingYear" maxlength="4"></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Graduation</td>
                    <td><input type="text" name="gradBoard" maxlength="10"></td>
                    <td><input type="text" name="gradPercentage" maxlength="5" placeholder="up to 2 decimal"></td>
                    <td><input type="text" name="gradPassingYear" maxlength="4"></td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>Masters</td>
                    <td><input type="text" name="mastersBoard" maxlength="10"></td>
                    <td><input type="text" name="mastersPercentage" maxlength="5" placeholder="up to 2 decimal">
                    </td>
                    <td><input type="text" name="mastersPassingYear" maxlength="4"></td>
                </tr>
            </table>

            <label for="course">Course applies for:</label>
            <div class="course">
                <input type="radio" id="bca" name="course" value="BCA"> BCA
                <input type="radio" id="bcom" name="course" value="B.Com"> B.Com
                <input type="radio" id="bsc" name="course" value="B.Sc"> B.Sc
                <input type="radio" id="ba" name="course" value="B.A"> B.A
            </div>

            <table>
                <tr>
                    <th><input type="submit" value="Submit"></th>
                    <th><input type="reset" value="Reset"></th>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </div>

</body>

</html>