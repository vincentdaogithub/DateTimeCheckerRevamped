<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : Jun 5, 2023, 1:55:45 PM
    Author     : Vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css" />
        <title>Date Time Checker Revamped</title>
    </head>
    <body>
        <form action="Controller" method="post">
            <img src="logo_FPT.jpg" alt="FPT logo" />
            
            <h2>Date Time Checker</h2>
            
            <div>
                <label for="day">Day </label>
                <input id="day" type="text" name="day" value="${prevDay}" />
                <c:choose>
                    <c:when test="${invalidDayFormat}">
                        <p>Input data for Day is incorrect format!</p>
                    </c:when>
                        
                    <c:when test="${invalidDayRange}">
                        <p>Input data for Day is out of range!</p>
                    </c:when>
                </c:choose>
            </div>
            
            <div>
                <label for="month">Month </label>
                <input id="month" type="text" name="month" value="${prevMonth}" />
                <c:choose>
                    <c:when test="${invalidMonthFormat}">
                        <p>Input data for Month is incorrect format!</p>
                    </c:when>
                        
                    <c:when test="${invalidMonthRange}">
                        <p>Input data for Month is out of range!</p>
                    </c:when>
                </c:choose>
            </div>
            
            <div>
                <label for="year">Year </label>
                <input id="year" type="text" name="year" value="${prevYear}" />
                <c:choose>
                    <c:when test="${invalidYearFormat}">
                        <p>Input data for Year is incorrect format!</p>
                    </c:when>
                        
                    <c:when test="${invalidYearRange}">
                        <p>Input data for Year is out of range!</p>
                    </c:when>
                </c:choose>
            </div>
            
            <c:choose>
                <c:when test="${isValidDate == true}">
                    <p>${prevDay}/${prevMonth}/${prevYear} is correct date time!</p>
                </c:when>

                <c:when test="${isValidDate == false}">
                    <p>${prevDay}/${prevMonth}/${prevYear} is NOT correct date time!</p>
                </c:when>
            </c:choose>
            
            <div>
                <input type="submit" name="action" value="Clear" />
                <input type="submit" name="action" value="Check" />
            </div>
        </form>
    </body>
</html>
