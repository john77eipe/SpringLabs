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

	<jsp:include page="../fragments/adminHeader.jsp" />

<br><br><br>

	<div class="row">
		<div class="leftcolumn">
			<form action="/pizza/save" method="POST">
				Pizza Title:&nbsp;
				<input type="text" name="pizza_name" value="Amazing Pizza">
				<br><br>
				Pizza Description:&nbsp;
				<input type="text" name="pizza_desc" value="The Best Pizza in the world">
				<br><br>
				Pizza Price:&nbsp;
				<input type="text" name="pizza_price" value="10">
				<br><br>
				Select a Category:&nbsp;
		    	<select name="pizza_cat">
			        <c:forEach items="${listCategory}" var="categoryItem">
			            <option value="${categoryItem.id}">${categoryItem.category}</option>
			        </c:forEach>
			    </select>
				<br><br>
				Pizza Quantity:&nbsp;
				<input type="text" name="pizza_quantity" value="100">
				<br><br>
				Pizza Tax:&nbsp;
				<input type="text" name="pizza_tax" value="0">
				<br><br>
				<input type="submit" value="Submit">
			</form> 
		</div>
	</div>
</div>
	<jsp:include page="../fragments/footer.jsp" />
</body>

</html>