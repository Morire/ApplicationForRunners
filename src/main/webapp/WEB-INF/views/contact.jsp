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

<link rel="stylesheet" href="<c:url value="static/css/index.css"/>">
</head>
<body style="background-image: url(<c:url value="static/img/woman.jpeg"/>)">

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
        <a class="nav-link active" href="<c:url value="/contact"/>">Contact</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disactive" href="<c:url value="/admin"/>">Admin panel</a>
      </li>
    </ul>
  </div>
</div>


<form:form metod="post" modelAttribute="contact" style="margin-top: 150px;">
<div align="center">
<form:input class="form-control" path="name" placeholder="Name"/></br>
<form:input class="form-control" path="email" placeholder="Email adress"/></br>
<form:input class="form-control" path="subject" placeholder="Subject"/></br>
<form:textarea class="form-control" path="quote" rows="10" cols="30" placeholder="Message"/></br>

<form:errors path="*"></form:errors>
<button type="submit" class="btn btn-primary">Send message</button>
<font color="red"><b><h1>${information}</h1></b></font>
</div>
</form:form>

  
  
  </body>
</html>