<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Ususarios</title>

        <!-- Latest compiled and minified CSS -->
        <spring:url value="/static/css/bootstrap.min.css" var="bootstrapmincss"/>
        <link rel="stylesheet" href="${bootstrapmincss}">

        <!-- Optional theme -->
        <spring:url value="/static/css/bootstrap-theme.min.css" var="bootstrapthememincss"/>
        <link rel="stylesheet" href="${bootstrapthememincss}">

        <!-- Latest compiled and minified JavaScript -->
        <spring:url value="/static/js/bootstrapminjs" var="bootstrapminjs"/>
        <script src="${bootstrapminjs}"></script>
    </head>
    <body>
        <div class="container">
            <h1>Lista de Usuários</h1>
            <hr>

            <div class="row">

                <spring:url value="/usuario/cadastro" var="cadastro"/>
                <security:authorize access="hasAnyAuthority('ROLE_ADMIN')">
                <a class="btn btn-default" href="${cadastro}">Novo Usuário</a>
                </security:authorize>
                <spring:url value="/logout" var="logout"/>
                <form action="<spring:url value="/logout"/>" method="post">
                    <security:csrfInput/>
                    <button class="btn btn-default" type="submit">Sair</button>
                </form>
            </div>

            <hr>

            <div class="panel-default">

                <div class="panel-heading">
                    <span>${message == null ? '&nbsp;' : message}</span>
                </div>

                <div>
                    <span>Usuário: ${usuarioOnline.username}</span>
                </div>

                <table class="table table-striped table-condensed">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOME</th>
                        <th>DATA NASCIMENTO</th>
                        <th>SEXO</th>
                        <th>AÇÃO</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="usuario" items="${usuarios}">
                        <tr>
                            <td>${usuario.id}</td>
                            <td>${usuario.nome}&nbsp;${usuario.sobrenome}</td>
                            <td>
                                <f:parseDate var="date" value="${usuario.dtNascimento}" pattern="yyyy-MM-dd" type="date"/>
                                <f:formatDate value="${date}" pattern="dd/MM/yyyy" type="date"/>
                            </td>
                            <td>${usuario.sexo.desc}</td>
                            <td>
                                <spring:url value="/usuario/update/${usuario.id}" var="update"/>
                                <a class="btn btn-info" href="${update}" >Editar</a>
                                <spring:url value="/usuario/delete/${usuario.id}" var="delete"/>
                                <a class="btn btn-danger" href="${delete}" >Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <hr>
            <footer class="footer">
                <p>&copy; 2017 DevMedia</p>
            </footer>
        </div>
    </body>
</html>