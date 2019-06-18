<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="include/header.jsp"%>
<%@ include file="include/navigation.jsp"%>

 <body>
 	<h4 style="text-align:center">Edit Country</h4>
 	<div class="container">
 	 <div class="row">
 	  <div class="col-sm-4">
	<form action="/updateCountry" method="POST">
		<input type="hidden" name="id" value="${con.id}" >
		<label>Country Name: </label>
		<input type="text" name="name" pattern="[A-Za-z]{3,20}" value="${con.name}" required class="form-control"//>
		<br>
		<input type="submit" name="submit" class="btn btn-success" value="Update Country" />
	</form>
	</div>
	</div>
	</div>
</body>
<%@ include file="include/footer.jsp"%>