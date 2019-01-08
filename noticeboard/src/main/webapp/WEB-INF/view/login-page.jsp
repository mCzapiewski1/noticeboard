<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Strona Logowania</title>
</head>
<body>
	<h4>Logowanie do serwisu</h4>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
		<p>Login: <input type="text" name="username"></p>
		<p>Haslo: <input type="password" name="password"></p>
		<p><input type="submit" value="Zaloguj sie!"></p>
	</form:form>
	<p>Nie masz konta?<a href="${pageContext.request.contextPath}/showRegistrationPage">Zarejestruj sie!</a></p>
</body>
</html>