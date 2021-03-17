<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="/mvc/do.addBook" modelAttribute="book">
		<table>
			<tr>   
			    <td><form:label path="isbn">ISBN: </form:label></td>
			    <td><form:input path="isbn" /></td>
		    </tr> 
		    <tr>
			    <td><form:label path="title">Title: </form:label></td>
			    <td><form:input path="title" /></td>
		    </tr>
		    <tr>
			    <td><form:label path="authour">Author: </form:label></td>
			    <td><form:input path="authour" /></td>
		    </tr>
		    <tr>
			    <td><form:label path="price">Price: </form:label></td>
			    <td><form:input path="price" /></td>
		    </tr>
		    <tr> 
		    	<td><input type="submit" value="Submit" /></td>
		    </tr>
	    </table>
	</form:form>

</body>
</html>