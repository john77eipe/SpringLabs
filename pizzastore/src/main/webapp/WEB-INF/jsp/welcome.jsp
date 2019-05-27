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

		<main role="main" class="inner cover">
			<h1 class="cover-heading">Cover your page.</h1>
			<p class="lead">Cover is a one-page template for building simple
				and beautiful home pages. Download, edit the text, and add your own
				fullscreen background photo to make it your own.</p>
			<p class="lead">
				<a href="#" class="btn btn-lg btn-secondary">Learn more</a>
			</p>
		</main>

		<jsp:include page="./fragments/footer.jsp" />

	</div>
</body>

</html>