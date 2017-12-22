<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maxa
  Date: 12/19/2017
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="WEB-INF/style.css" rel="stylesheet" type="text/css">
</head>
<body>
  <form:form action="studentData" modelAttribute="student">
    First name: <form:input path="firstName"></form:input>
    <hr/>
    Last name: <form:input path="lastName"></form:input>
    <form:errors path="lastName" cssClass="error"></form:errors>
    <hr/>
    Number of Passes: <form:input path="freePasses"></form:input>
    <form:errors path="freePasses" cssClass="error"></form:errors>
    <hr/>
    Course Code: <form:input path="courseCode"></form:input>
    <form:errors path="courseCode" cssClass="error"></form:errors>
    <hr/>
    Country: <form:select path="country">
                <form:options items="${student.countryOptions}"></form:options>
             </form:select>
    <input type="submit" value="Submit"/>
  </form:form>
</body>
</html>
