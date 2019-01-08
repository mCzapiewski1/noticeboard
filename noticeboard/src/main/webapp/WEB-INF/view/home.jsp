<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Home Page</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/showMyAuctions">Moje Aukcje</a></p>
<h4>STRONA GLOWNA</h4>

<table>
	<tr>
		<th>Kategoria</th>
	</tr>
	<c:forEach var="tempCategory" items="${productCategories}">
		<c:url var="categoryLink" value="/showProductPage">
			<c:param name="categoryId" value="${tempCategory.id}"/>
		</c:url>
		<tr>
			<th><a href="${categoryLink}">${tempCategory.name}</a></th>
		</tr>
	</c:forEach>
</table>
</body>
</html>