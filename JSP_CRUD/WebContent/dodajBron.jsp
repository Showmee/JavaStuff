<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Weapon Adding Form ::</title>
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
			<form action="insertData.jsp" action="post">
				<table align="center" width="300" height="100" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="140">Weapon Name/Type:</td>
						<td width="160"><input class="in" type='text' name='wname'></td>
					</tr>

					<tr>
						<td>Magazine size:</td>
						<td><input class="in" type='text' name='mag'></td>
					</tr>

					<tr>
						<td>Description:</td>
						<td><input class="in" type='text' name='descr'></td>
					</tr>
					
					<tr>
						<td></td>
						<td align="right"><input class="button" type='submit' value='Add'></td>
					</tr>
					
				</table>

			</form>
		</div>
	</div>




</body>
</html>