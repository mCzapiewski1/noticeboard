<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Product List</title>
</head>
<body>
	<h1>${category.name}</h1>
 	<table>
 		<tr>
 			<th>Produkt</th>
 		</tr>
 		<c:forEach var="tempProducts" items="${products}">
 			<c:url var="auctionLink" value="/showAuctionPage">
 				<c:param name="productId" value="${tempProducts.id}"/>
 			</c:url>
 		<tr>
 			<th><a href="${auctionLink}">${tempProducts.name}</a></th>
 		</tr>
 		</c:forEach>	
 	</table>
</body>
</html>