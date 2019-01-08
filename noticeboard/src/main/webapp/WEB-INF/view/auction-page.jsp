<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Auction page</title>
</head>
<body>
	<h1>Opis</h1>
	<hr>
	<p>${auction.description}</p>
	<hr>
	<table border=1>
		<tr>
			<th>Nazwa</th><th>Cena</th>
		</tr>
		<c:forEach var="tempProducts" items="${products}">
		<tr>
			<td>${tempProducts.name}</td>
			<td>${tempProducts.price}</td>
		</tr>
		</c:forEach>	
	
	</table>
</body>
</html>