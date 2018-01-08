<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

</head>
<body>
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Title</th>
      <th scope="col">Distance</th>
      <th scope="col">Place</th>
    </tr>
  </thead>
	<c:forEach items="${challenges}" var="challenge">
		<tr>
			<td>${challenge.id}</td>
			<td>${challenge.title}</td>
			<td>${challenge.distance}</td>
			<td>${challenge.place}</td>
			<td><a href="<c:url value="/admin/delete/${challenge.id}" />">Remove</a> <a href="<c:url value="/admin/edit/${challenge.id}" />">Edit</a>
	</c:forEach>
</table>
</body>
</html>

