
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Users">
    <h1>Users</h1>
    <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
    <form method="POST" actions="${pageContext.request.contextPath}/Users">
        <a class="btn btn-primary btn-lg" aria-current="page" href="${pageContext.request.contextPath}/AddUser">Add User</a>

    <c:if test="${pageContext.request.isUserInRole('INVOICING')}">
        <button class="btn btn-primary btn-lg" type="submit">Invoice</button>
    </c:if>

        <div class="container text-center">
            <c:forEach var="user" items="${users}">
                <div class="row">
                    <div class="col">
                        <c:if test="${pageContext.request.isUserInRole('INVOICING')}">
                        <input type="checkbox" name="user_ids" value="${user.id}"/>
                        </c:if>
                    </div>
                    <div class="col">
                            ${user.username}
                    </div>
                    <div class="col">
                            ${user.email}
                    </div>
                    <div class="col">
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditUser?id=${user.id}">Edit
                            User</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </form>
    </c:if>

    <c:if test="${pageContext.request.isUserInRole('INVOICING')}">
        <h2>Invoices</h2>
        <c:forEach var="username" items="${invoices}" varStatus="status">
            ${status.index + 1}, ${username}
            <br/>
        </c:forEach>
    </c:if>
</t:pageTemplate>