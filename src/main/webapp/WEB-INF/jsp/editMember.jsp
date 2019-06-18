<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<%@ include file="include/header.jsp"%>
<%@ include file="include/navigation.jsp"%>

 <body>
  <%       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
          Date now=new Date();
  %>
 
 	<h4 style="text-align:center">Edit Member</h4>
 	<div class="container">
 	 <div class="row">
 	  <div class="col-sm-4">
	<form action="/updateMember" method="POST">
		<input type="hidden" name="id" value="${member.id}">
		<label>Country: </label>
		<input list="country" name="country_id" value="${member.country}"  required class="form-control">
		<datalist id="country">
		  <c:forEach items="${conList}" var="con" >
     		<option value="${con.id}">${con.name}</option>
	    </c:forEach>
		</datalist>
		
		<label>Member Name: </label>
		<input type="text" name="name" pattern="[A-Za-z]{3,20}" value="${member.name}" placeholer="min-3 and max-20 letters" required class="form-control"/>
		<label>Member's D-o-B: </label>
		<input type="date" name="dob" value="${member.dob}" max="<%=formatter.format(now)%>" required class="form-control"/>
		<label>Member's Role: </label>
		<input list="role" name="role" value="${member.role}"  required class="form-control">
		<datalist id="role">
		    <option value="Player">Player</option>
     		<option value="Coach">Coach</option>
     		<option value="Manager">Manager</option>
		</datalist>
     		
		<label>Member's E-mail: </label>
		<input type="email" name="contact" value="${member.contact}" required class="form-control"/>
		<br>
		<input type="submit" name="submit" class="btn btn-success" value="Update Member" />
	</form>
	</div>
	</div>
	</div>
</body>
