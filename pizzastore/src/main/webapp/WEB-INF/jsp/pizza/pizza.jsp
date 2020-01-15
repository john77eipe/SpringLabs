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

		<!-- Pizza list goes here -->
        
		<div class="row">
			<div class="leftcolumn">
				<div class="card">
			    	<h2><a href="/pizza/${pizza.id}"><c:out value="${pizza.name}"/></a></h2>
			      	<h5>Price: $ ${pizza.price}</h5>
			      	<div class="fakeimg" style="height:200px;">Image</div>
			      	<h3>Category: ${pizza.category.category}</h3>
			      	<h3>Other Categories: 
			      		<c:forEach var="secondaryCategory" items="${pizza.secondaryCategories}" varStatus="loop">
			      			${secondaryCategory.category} ${!loop.last ? ',' : ''}
			      		</c:forEach>
			      	</h3>
				    <p>Description:</p>
				    <p>${pizza.description}</p>
				</div>
  			</div>
		</div>

		<jsp:include page="../fragments/footer.jsp" />

	</div>
</body>

</html>
