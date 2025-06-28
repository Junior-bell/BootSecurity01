<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
    <meta charset="UTF-8">
    <title>Check Loan Status</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
		</head>
			<body>
				<div class="container">
                    <h1>Check Loan Status</h1>
                    <c:choose>
                        <c:when test="${not empty loanStatus}">
                            <p>Your loan status is: <strong>${loanStatus}</strong></p>
                        </c:when>
                        <c:otherwise>
                            <p>No loan application found.</p>
                        </c:otherwise>
                    </c:choose>
                    <p><a href="${pageContext.request.contextPath}/loan">Apply for a new loan</a></p>
                    <p><a href="${pageContext.request.contextPath}/home">Back to Home</a></p>
                </div>