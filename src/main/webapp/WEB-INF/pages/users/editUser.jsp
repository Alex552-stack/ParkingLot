<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pageTemplate pageTitle="Edit User">
    <div class="container">
        <br>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditUser">
        <input type="hidden" name="id" value="${user.id}" />
        <div class="row">
            <div class="col-md-6">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" value="${user.username}" required />
                <div class="invalid-feedback">
                    Username is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email" value="${user.email}" required />
                <div class="invalid-feedback">
                    Email is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="password">Password</label>
                <input type="text" class="form-control" id="password" name="password"/>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
        <a href="${pageContext.request.contextPath}/Users" class="btn btn-secondary">Cancel</a>
    </form>
</t:pageTemplate>