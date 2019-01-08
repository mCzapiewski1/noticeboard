<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Moje aukcje</title>
</head>
<body>
<h2>Stworz Aukcje</h2>

	<form:form action="saveAuction" modelAttribute="newAuction" method="POST">
		<label>Tytul:</label> <form:input path="title"/><br>
		<label>Opis:</label>  <form:textarea path="description"/><br>
		<label>Telefon kontaktowy:</label>  <form:input path="contactPhone"/><br>
		<label>Email kontaktowy:</label>  <form:input path="contactEmail"/><br>
		<input type="submit" value="Utworz" class="save"/><br><br>
	</form:form>
	
	<table border="1">
			<tr>
				<th>Tytul</th>
				<th>Opis</th>
				<th>Numer Kontaktowy</th>
				<th>Email kontaktowy</th>
				<th></th>
			</tr>
		<c:forEach var="tempAuction" items="${auctions}">
			<c:url var="productLink" value="/addProductPage">
				<c:param name="auctionId" value="${tempAuction.id}"/>
			</c:url>
			<c:url var="auctionLink" value="/showMyAuctionPage">
				<c:param name="auctionId" value="${tempAuction.id}"/>
			</c:url>
			<tr>
				<th><a href="${auctionLink}">${tempAuction.title}</a></th>
				<th>${tempAuction.description}</th>
				<th>${tempAuction.contactPhone}</th>
				<th>${tempAuction.contactEmail}</th>
				<th><a href="${productLink}">Dodaj przedmiot</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>