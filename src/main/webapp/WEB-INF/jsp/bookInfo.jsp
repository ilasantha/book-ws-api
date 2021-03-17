<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<title>Books Store - Book Details</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

	<body>
		<h2>Book Details!</h2>
		
			ISBN:  ${book.isbn} <br/>
			Title: ${book.title} <br/>
			Author:${book.authour} <br/>
			Price: ${book.price} <br/>
			
			<br>
			<p><a href="/mvc/addBook">Add New Book</a></p>
	</body>

</html>