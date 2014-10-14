<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page
	import="java.sql.Connection,java.sql.DriverManager,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Weapons table ::</title>
</head>
<body>

<div class="all">

		<div class="miejsce_menu">
			<div class="menu">
				<ul>
					<li><a href="index.jsp" target="_self">Main</a></li>
					<li><a href="bron.jsp" target="_self">Weapons</a></li>
					<li><a href="ammo.php" target="_self">Ammunition</a></li>
					<li><a href="outfits.php" target="_self">Outfits</a></li>
					<li><a href="info.php" target="_self">Information</a></li>
					<li><a href="about.php" target="_self">How to contact us</a></li>
				</ul>

			</div>
		</div>

		<div class="podmenu">
			<ul>
				<li><a href="dodajBron.jsp" target="_self">Add</a></li>
				<li><a href="editData.jsp" target="_self">Edit/Remove</a></li>
				<li><a href="displayData.jsp" target="_self">Browse</a></li>
			</ul>
		</div>

		<br />
		<hr />
		<div class="all_text">

<%
String id = request.getParameter("id");
String weapon_name = request.getParameter("wname");
String magazine_size = request.getParameter("mag");
String description = request.getParameter("descr");
String sql3 = "";

//out.print("id: "+id+ " | wname: "+weapon_name + " | mag: "+magazine_size+ " |descr: "+description );

try{
	Class.forName("com.mysql.jdbc.Driver"); 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arsenal","root","");

if (request.getParameter("update") != null) {
    //update button is clicked
    //Do the update action or forward the request to the servlet to do update action 
    sql3 = "Update weapons_table set wname='"+weapon_name+"', mag='"+magazine_size+"', descr='"+description+"' where id='"+id+"' ";
    
    int action = con.createStatement().executeUpdate(sql3);
	con.setAutoCommit(true);
	
	if (action>=1){
		out.println("Record was updated!");
		
	}else{
		out.println("Error! Record was not updated.");
	}
	
    
    

} else if (request.getParameter("delete") != null) {
      //delete button is clicked
      //Do the delete action or forward the request to the servlet to do delete action
      sql3 = "Delete from weapons_table where id='"+id+"' and wname='"+weapon_name+"' and mag='"+magazine_size+"' and descr='"+description+"' ";
      
    		  int action = con.createStatement().executeUpdate(sql3);
  	con.setAutoCommit(true);
  	
  	if (action>=1){
  		out.println("Record was DELETED!");
  		
  	}else{
  		out.println("Error! Record was not deleted.");
  	}
}	




//String sql = "insert into weapons_table(wname, mag, descr) values ('"+weapon_name+"','"+magazine_size+"','"+description+"')";

	
}catch(Exception e){
	out.println("Blad przy polaczeniu z baza.\n "+ e);
	e.printStackTrace();
	
}
finally{
	%> <a href="index.jsp" target="_self">Back to main page.</a><br />
	<a href="dodajBron.jsp" target="_self">Click here to add more weapons!</a><%
}
%>
</div></div>

</body>
</html>