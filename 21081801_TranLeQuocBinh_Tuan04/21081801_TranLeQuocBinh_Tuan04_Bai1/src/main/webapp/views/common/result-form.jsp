<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Result Submit</title>
<script src="https://cdn.tailwindcss.com"></script>
<style>
    .error {
        color: red;
        font-weight: bold;
        margin-bottom: 20px;
    }
</style>
</head>
<body class="bg-gray-100 p-8">

    <div class="max-w-7xl mx-auto bg-white p-6 shadow rounded-lg">

        <c:if test="${not empty errors}">
            <div class="error">
                <strong>Error(s):</strong><br />
                <ul class="list-disc pl-5">
                    <c:forEach var="error" items="${errors}">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <c:if test="${not empty user}">
            <h2 class="text-2xl font-bold mb-4">New User</h2>
            <div class="grid grid-cols-2 gap-4 mb-6">
                <div><strong>First Name:</strong> ${user.firstName}</div>
                <div><strong>Last Name:</strong> ${user.lastName}</div>
                <div><strong>Birthday:</strong> ${user.birthday}</div>
                <div><strong>Email:</strong> ${user.email}</div>
                <div><strong>Gender:</strong> ${user.gender}</div>
            </div>
        </c:if>

        <c:if test="${empty users}">
            <div class="text-red-500">
                No user data found.
            </div>
        </c:if>

    </div>

    <div class="max-w-7xl mx-auto bg-white p-6 shadow rounded-lg mt-8">
        <h2 class="text-2xl font-bold mb-4">User List</h2>
        <table class="min-w-full table-auto">
            <thead class="bg-gray-50">
                <tr>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">First Name</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Last Name</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Email</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Birthday</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Gender</th>
                </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td class="px-6 py-4 whitespace-nowrap">${user.firstName}</td>
                        <td class="px-6 py-4 whitespace-nowrap">${user.lastName}</td>
                        <td class="px-6 py-4 whitespace-nowrap">${user.email}</td>
                        <td class="px-6 py-4 whitespace-nowrap">${user.birthday}</td>
                        <td class="px-6 py-4 whitespace-nowrap">${user.gender}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
