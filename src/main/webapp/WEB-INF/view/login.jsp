<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 04/11/17
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sistema Spring</title>
        <spring:url value="/static/css/bootstrap.min.css" var="bootstrapmincss"/>
        <link rel='stylesheet prefetch' href='${bootstrapmincss}'>
        <spring:url value="/static/css/style.css" var="stylecss"/>
        <link rel="stylesheet" href="${stylecss}">
    </head>
    <body>
        <div class="wrapper">
            <form class="form-signin" action="<spring:url value="${'/login'}"/>" method="post">
                <h2 class="form-signin-heading">Sistema Spring</h2>
                <input type="text" class="form-control" name="username" placeholder="Usuário" required="" autofocus="" />
                <input type="password" class="form-control" name="password" placeholder="Senha" required=""/>
                <security:csrfInput/>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
            </form>
        </div>
    </body>
</html>