<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Loan</title>
</head>
<body>
    <h1>Loan Approval Page</h1>
	<h2>Apply for a Loan</h2>
    <form action="/BootSecurity/loan" method="post">
        <label for="amount">Loan Amount:</label>
        <input type="number" id="amount" name="amount" required>
        <br>
        <label for="term">Loan Term (in months):</label>
        <input type="number" id="term" name="term" required>
        <br>
        <input type="submit" value="Apply">
    </form>

    <h2>Check Loan Status</h2>
    <form action="/BootSecurity/checkLoanStatus" method="get">
        <input type="submit" value="Check Status">
    </form>

    <p><a href="/BootSecurity/home">Back to Home</a></p>
</body>
</html>