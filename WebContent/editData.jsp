<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.sql.Connection,java.sql.DriverManager,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement,javax.swing.table.DefaultTableModel,javax.swing.JTable,java.awt.Dimension"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Edit/Remove Weapons ::</title>

<script type="text/javascript">


function ShowDiv() {
    document.getElementById("myDiv").style.display = "";
    document.getElementById('wname').value=request.getParameter("lista1") ;
}

</script>

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
		
		<form action="delOrEdit.jsp" action="post">
			<select name="lista1" id="lista1" >

				<% 
				
				//request.getParameter("select-one")
			//select wname, mag, descr from weapons_table where wname = '"+request.getParameter("lista1")+"'

			String sql = "select wname from weapons_table";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/arsenal", "root", "");
				
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				String d1;
				while (rs.next()) {
					d1 = rs.getString("wname");
					%><option><% out.println(d1); %></option>
				<%
				}
				
				rs.close();
				con.close();
			}catch(Exception e){
				out.println("Blad przy polaczeniu z baza.\n " + e);
				e.printStackTrace();
			}finally{
				
			}
			
			%>


			</select>

<!-- 
<input type="button" class="button value="Edit" onclick="ShowDiv()" />
 -->
<input type="submit" class="button" name="Edit" value="Edit" />
</form>
<!--
<div id="myDiv" style="display:none;" class="answer_list" >

<form action="updateData.jsp" action="post">
<input class="in" type='text' id="wname" name='wname'>
<input class="in" type='text' name='mag'>
<input class="in" type='text' name='descr'>

<input class="button" type='submit' value='Update'>
<input class="button" type='submit' value='Remove'>
</form>

</div> 
-->

		</div>
	</div>



</body>
</html>