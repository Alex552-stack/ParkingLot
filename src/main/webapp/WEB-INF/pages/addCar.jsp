<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pageTemplate pageTitle="Users">
    <form class="needs-validation" novalidate="" method="post" action="${pageContext.request.contextPath}/AddCar">
        <div class="row g-3">
<%--            <div class="col-12">--%>
<%--                <label for="username" class="form-label">Username</label>--%>
<%--                <div class="input-group has-validation">--%>
<%--                    <span class="input-group-text">@</span>--%>
<%--                    <input type="text" class="form-control" id="username" placeholder="Username" required="">--%>
<%--                    <div class="invalid-feedback">--%>
<%--                        Your username is required.--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="col-12">--%>
<%--                <label for="email" class="form-label">Email</label>--%>
<%--                <div class="input-group has-validation">--%>
<%--                    <input type="email" class="form-control" id="email" placeholder="you@example.com">--%>
<%--                    <div class="invalid-feedback">--%>
<%--                        Please enter a valid email address for shipping updates.--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

            <div class="col-12">
                <label for="license_plate" class="form-label">License plate</label>
                <div class="input-group has-validation">
                    <input type="text" class="form-control" id="license_plate" name="license_plate" placeholder="SB00ABC" required="">
                    <div class="invalid-feedback">
                        License plate is required
                    </div>
                </div>
            </div>

    <div class="col-12">
        <label for="parking_spot" class="form-label">Parking spot</label>
        <div class="input-group has-validation">
            <input type="text" class="form-control" id="parking_spot" name="parking_spot" placeholder="0" required="">
            <div class="invalid-feedback">
                Parking Spot is required
            </div>
        </div>
    </div>

            <div class="col-md-5">
                <label for="owner_id" class="form-label">Owner</label>
                <div class="input-group has-validation">
                    <select class="form-select" id="owner_id" name="owner_id" required="">
                        <option value="" name="owner_id">Choose...</option>
                        <c:forEach var="user" items="${users}" varStatus="status">
                            <option value="${user.id}">${user.username}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Please choose an option
                    </div>
                </div>
            </div>

            <button class="w-100 btn btn-primary btn-lg" type="submit">Save</button>
        </div>
    </form>
    <script src="${pageContext.request.contextPath}/scripts/form-validation.js"></script>
</t:pageTemplate>