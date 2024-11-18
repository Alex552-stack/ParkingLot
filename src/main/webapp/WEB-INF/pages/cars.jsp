<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pageTemplate pageTitle="Cars">
  <h1>
    Cars
  </h1>
  <div class="container text-center">
    <c:forEach var="car" items="${cars}">
      ${car.licensePlate}

    </c:forEach>
    <h5>
      Free parking spot: ${numberOfFreeParkingSport}
    </h5>
  </div>
</t:pageTemplate>