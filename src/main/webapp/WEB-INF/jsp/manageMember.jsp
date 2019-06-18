<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<%@ include file="include/header.jsp"%>
<%@ include file="include/navigation.jsp"%>




<body>
<br>
	<br>
	<h2>${msg}</h2>
	
	<!-- Incomplete Search Country wise -->
	<form action="#" mehod="POST">
	<select name="country_id"  >
			<option disabled>---select country---</option>
		<c:forEach items="${conList}" var="con" >
     		<option value="${con.id}">${con.name}</option>
	    </c:forEach>
	</select>
	<input type="submit" name="submit" class="btn btn-warning" value="Search">
   </form>

	<h3>Member List</h3>
		<table class="table table-striped table-bordered table-hover table-dark" id="catTable">
		 <thead style="background-color: black; color:white; font-size: 18px; font-weight: bold;">
		  <tr>
		    <th>ID</th>
		    <th>Country</th>
		    <th>Name</th>
		    <th>Date of Birth</th>
		    <th>Age</th>
		    <th>Role</th>
		    <th>Contact</th>
		    <th colspan="2">Action</th>
		  </tr>
		</thead>
			<tbody>
			<c:forEach items="${memberList}" var="mem" >
				<tr>
					<td>${mem.id}</td>
					<td> ${mem.country}</td>
					<td>${mem.name}</td>
					<td>${mem.dob}</td>
					<td>${mem.age}</td>
					<td>${mem.role}</td>
					<td>${mem.contact}</td>
					<td><a href="/deleteMember/${mem.id}">Delete</a></td>
					<td><a href="/updateMember/${mem.id}">Update</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
<%@ include file="include/footer.jsp"%>