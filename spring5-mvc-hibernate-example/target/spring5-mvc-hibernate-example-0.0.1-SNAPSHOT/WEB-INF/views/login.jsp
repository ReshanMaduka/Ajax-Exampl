<%--
  Created by IntelliJ IDEA.
  User: Reshan
  Date: 21/09/2018
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<!-- Spring Security Core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

    <%--<c:if test="${not empty errorMessge}">--%>
    <%--<script>--%>
    <%--swal("Oopz! Check Your Password or Username!", "Please Enter Your Valid Username & Password!", "error");--%>
    <%--</script>--%>
    <%--</c:if>--%>
</head>
<body onload='document.loginForm.username.focus();'>
<h1>Spring Security 5 - Login Form</h1>

<form action='<spring:url value="/loginAction"/>' method="post">
    <c:if test="${not empty errorMessge}">
        <div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div>
    </c:if>
    <table>
        <tr>
            <td>UserName:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit"/></td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>