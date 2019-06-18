<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

 <body>
 
 <%       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
          Date now=new Date();
 %>
 	<h4 style="text-align:center">Add Member</h4>
 	<div class="container">
 	 <div class="row">
 	  <div class="col-sm-4">
	<form action="/addMember" method="POST">
		<label>Country: </label>
		<select name="country_id"   required class="form-control">
		<c:forEach items="${conList}" var="con" >
     		<option value="${con.id}">${con.name}</option>
	    </c:forEach>
		</select>
		<label>Member Name: </label>
		<input type="text" name="name" pattern="[A-Za-z]{3,20}" placeholer="min-3 and max-20 letters" required class="form-control"/>
		<label>Member's D-o-B: </label>
		<input type="date" name="dob" max="<%=formatter.format(now)%>" required class="form-control"/>
		<label>Member's Role: </label>
		<select name="role"  required class="form-control">
     		<option value="Player">Player</option>
     		<option value="Coach">Coach</option>
     		<option value="Manager">Manager</option>
		</select>
		<label>Member's E-mail: </label>
		<input type="email" name="contact" required class="form-control"/>
		<br>
		<input type="submit" name="submit" class="btn btn-success" value="Add Member" />
		<a href="/" class="btn btn-warning">Home</a>
	</form>
	</div>
	</div>
	</div>
</body>
