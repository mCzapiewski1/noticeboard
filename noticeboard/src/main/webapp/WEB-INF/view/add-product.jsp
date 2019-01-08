<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Dodaj produkt do aukcji</title>
</head>
<body>

	<form:form action="saveProduct${auction.id}" modelAttribute="newProduct" method="POST">
		<label>Nazwa:</label> <form:input path="name"/><br>
		<label>Cena:</label> <form:input path="price"/><br>
		<form:select path="productCategory.id">
			<form:options items="${productCategories}" itemLabel="name" itemValue="id"/>
		</form:select><br>
		<input type="submit" value="Dodaj" class="save"/><br>
	</form:form>

</body>
</html>

