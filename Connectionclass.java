package com.nucleus.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionclass {
	Connection con =null;
	String driverName="com.mysql.jdbc.Driver"; 
	String url="jdbc:mysql://localhost/db"; 
	String user ="root";
	String psw="priya";
	public Connection getDBConnection() 
	{
		
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url,user,psw);
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
}
}
