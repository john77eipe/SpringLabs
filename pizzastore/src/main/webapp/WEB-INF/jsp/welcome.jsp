<!DOCTYPE html>

<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">

<jsp:include page="./fragments/staticFiles.jsp" />

<body>
	<div class="container">
	
		<jsp:include page="./fragments/bodyHeader.jsp" />

		<main>
			<h1>Welcome</h1>
			<p>Welcome page for pizza store</p>
		</main>

		<jsp:include page="./fragments/footer.jsp" />

	</div>
</body>

</html>