<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="include/header.jsp"%>

<body>
	<h2>${msg}</h2>

	<h4 style="text-align:center">Login</h4>
 	<div class="container">
 	 <div class="row">
 	  <div class="col-sm-4">
	<form action="/login" method="POST">
      <label>User Name: </label>
      <input type="text" name="uname"  required class="form-control"/>
      <label>Password: </label>
      <input type="text" name="pass"  required class="form-control"/>
      <br>
      <input type="submit" name="submit" class="btn btn-success" value="Login" />
    </form>
    </div>
    </div>
    </div>
    <a href="/addMember">Register as Team Member</a>
</body>

<%@ include file="include/footer.jsp"%>