<!DOCTYPE html>

<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />

		<main role="main" class="inner cover">
			<!-- Pizza list goes here -->
			<c:forEach var="pizza" items="${pizzas}">
                <c:out value="${pizza.name}"/>
            </c:forEach>
		</main>

		<jsp:include page="../fragments/footer.jsp" />

	</div>
</body>

</html>
