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
<link rel="stylesheet" href="<c:url value="static/css/admin.css"/>">
</head>

<body style="background-image: url(<c:url value="static/img/stadion.jpeg"/>)">

<div class="card text-center" style="margin-top: 60px;">
  <div class="card-header">
    <ul class="nav nav-pills card-header-pills">
      <li class="nav-item">
        <a class="nav-link disactive" href="<c:url value="/"/>">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disactive" href="<c:url value="/calculator"/>">Calculator</a>
      </li>
       <li class="nav-item">
        <a class="nav-link disactive" href="<c:url value="/calendar"/>">Calendar</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disactive" href="<c:url value="/contact"/>">Contact</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="<c:url value="/admin"/>">Admin panel</a>
      </li>
    </ul>
  </div>
</div>

<form:form method="post" modelAttribute="challenge" style="margin-top: 50px;">
<div align="center">
	<form:input class="form-control" path="title" placeholder="Run name:"/></br>
	<form:input class="form-control" path="distance" /></br>
	<form:input class="form-control" path="place" placeholder="Place"/> </br>
	<form:select class="form-control" path="type"> 
	<form:option value="Mountain">Mountain</form:option>
	<form:option value="City">City</form:option>
	</form:select></br>
	<button type="submit" class="btn btn-primary">Add new competition</button>
	</div>
</form:form>

</br>

<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Title</th>
      <th scope="col">Distance</th>
      <th scope="col">Place</th>
      <th scope="col">Type</th>
    </tr>
  </thead>
	<c:forEach items="${challenges}" var="challenge">
		<tr>
			<td>${challenge.id}</td>
			<td>${challenge.title}</td>
			<td>${challenge.distance}</td>
			<td>${challenge.place}</td>
			<td>${challenge.type}</td>
			<td><a href="<c:url value="/admin/delete/${challenge.id}" />">Remove</a> <a href="<c:url value="/admin/edit/${challenge.id}" />">Edit</a>
	</c:forEach>
</table>

  

</body>
</html>