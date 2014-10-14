package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EngineClass {

	private String weaponName="";
	
	public String getWeaponName(String arg){
		
		String sql = "select wname from weapons_table where wname = '"+arg+"'";
		
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arsenal","root","");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				weaponName = rs.getString("wname");
			}
			con.close();
			rs.close();
			
		}catch(Exception e){
			System.out.println("Error! Cannot connect to DB!");
		}finally{
			
		}
		
		
		return weaponName;
	}
	
}
