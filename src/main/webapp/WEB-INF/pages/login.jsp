<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Login">
<%--    <jsp:useBean id="message" scope="request" type="java.lang.String"/>--%>
    <c:if test="${message != null}">
        <div class="alert alert-warning" role="alert">
            ${message}
        </div>
    </c:if>

    <form class="form-signin" method="post" action="j_security_check">
        <h1 class="h3 mb-3 font-weight-normal">Sign In</h1>
        <label for="username" class="st-only">Username</label>
        <input type="text" id="username" name="j_username" class="form-control" placeholder="Username" required autofocus/>
        <label for="password" class="st-only">Password</label>
        <input type="password" id="password" name="j_password" class="form-control" placeholder="Password" required/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign In</button>
    </form>
</t:pageTemplate>