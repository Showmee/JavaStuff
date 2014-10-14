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
<title>:: Edit/Remove Weapons ::</title>
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
		String opcja = request.getParameter("lista1");

		//out.print(opcja);

		
		
		String sql2 = "select id, wname, mag, descr from weapons_table where wname = '"
				+ opcja + "' ";
		
		/*String weapon_name = request.getParameter("wname");
		String magazine_size = request.getParameter("mag");
		String description = request.getParameter("descr");*/
		String tabs[] = new String[4];
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/arsenal", "root", "");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql2);
			String d1;
			while (rs.next()) {
				tabs[0] = rs.getString("id");
				tabs[1] = rs.getString("wname");
				tabs[2] = rs.getString("mag");
				tabs[3] = rs.getString("descr");
				
			}
			
			%>
			
<form action="delOrEditData.jsp" action="post">
<input class="in" type='hidden' id="id" name='id' value="<%out.print(tabs[0]);%>">
<input class="in" type='text' id="wname" name='wname' value="<%out.print(tabs[1]);%>">
<input class="in" type='text' id="mag" name='mag' value="<%out.print(tabs[2]);%>">
<input class="in" type='text' id="descr" name='descr' value="<%out.print(tabs[3]);%>">

<input class="button" type='submit' value='Update' name="update">
<input class="button" type='submit' value='Remove' name="delete">
</form>
			
			<%
			
			rs.close();
			con.close();
		} catch (Exception e) {
			out.println("Blad przy polaczeniu z baza.\n " + e);
			e.printStackTrace();

		} finally {
	
		}
	%>

</div></div>

</body>
</html>