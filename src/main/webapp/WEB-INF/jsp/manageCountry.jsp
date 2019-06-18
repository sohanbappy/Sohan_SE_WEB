<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="include/header.jsp"%>
<%@ include file="include/navigation.jsp"%>

 <body>
 <a href="/addCountry" class="btn btn-warning">Add Country</a>
	<br>
	<br>
	<h2>${msg}</h2>
	<h3>Country List</h3>

	<table class="table table-striped table-bordered table-hover table-dark" id="catTable">
	 <thead style="background-color: black; color:white; font-size: 18px; font-weight: bold;">
	  <tr>
	    <th>ID</th>
	    <th>Country Name</th>
	    <th colspan="2">Action</th>
	  </tr>
	</thead>
		<tbody>
		<c:forEach items="${conList}" var="con" >
			<tr>
				<td id="con">${con.id}</td>
				<td> ${con.name}</td>
				<td><a href="/deleteCountry/${con.id}">Delete</a></td>
				<td><a href="/updateCountry/${con.id}">Update</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript">
	   
	        function deleteCon(){
	            var id = $('#con').val();
	            $.ajax({
	                url: url+'/deleteCountry/'+id,
	                type: 'GET',
	              success : function(ResData){
	                
	               }
	            });
	      } 
	
	</script>
	
</body>
