<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Rejestracja uyztkownikow</title>
</head>
<body>
	<h1>Rejestracja uzytkownikow</h1>

	<form:form action="${pageContext.request.contextPath}/registerUser" modelAttribute="nbUser" method="POST">
		<p>Nazwa Uzytkownika: <form:input path="userName"/></p>
		<p>Haslo: <form:input type="password" path="password"/></p>
		<p>Powtorz Haslo: <form:input type="password" path="matchingPassword"/></p>
		<p>Imie: <form:input path="firstName"/></p>
		<p>Nazwisko: <form:input path="lastName"/></p>
		<p>Email: <form:input path="email"/></p>
		<p>Data Urodzenia: <form:input type="date" path="birthDate"/></p>
		<p><input type="submit" value="Zarejestruj!"></p>
	</form:form>

</body>
</html>