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
				// tabelka z wynikami 
				JTable tab = new JTable();
				tab.setPreferredScrollableViewportSize(new Dimension(400, 150));
				String sql = "select * from weapons_table";
				DefaultTableModel model = (DefaultTableModel) tab.getModel();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/arsenal", "root", "");
					//int action = con.createStatement().executeUpdate(sql);

					model.setRowCount(0);
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);

					//con.setAutoCommit(true);
			%>
			<table class="dispData" cellspacing="2" cellpadding="2">
				<tr>
					<td class="th" width="15">ID</td>
					<td class="th" width="130">Weapon Name/Type</td>
					<td class="th" width="90">Magazine Size</td>
					<td class="th" width="270">Description</td>
				</tr>
				<%
					while (rs.next()) {
							String d1, d2, d4, d3;

							d1 = rs.getString("id");
							d2 = rs.getString("wname");
							d3 = rs.getString("mag");
							d4 = rs.getString("descr");
				%><tr>
					<td>
						<%
							out.println(d1);
						%>
					</td>
					<td>
						<%
							out.println(d2);
						%>
					</td>
					<td>
						<%
							out.println(d3);
						%>
					</td>
					<td>
						<%
							out.println(d4);
						%>
					</td>
				</tr>
				<%
					//out.println(d1+" "+d2+" "+d3+" "+d4+"\n");
							model.addRow(new Object[] { d1, d2, d3, d4 });
						}
				%>
			</table>
			<%
				rs.close();
					con.close();
					tab.setModel(model);
					/*if (action >= 1) {
						out.println("Record was saved to database");

					} else {
						out.println("Error! Record was not added to database.");
					}*/
				} catch (Exception e) {
					out.println("Blad przy polaczeniu z baza.\n " + e);
					e.printStackTrace();

				} finally {

				}
			%>


		</div>
	</div>




</body>
</html>