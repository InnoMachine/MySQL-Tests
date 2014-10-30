package com.mydb.demo;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		Properties prop = new Properties();
		Reader r;
		try {
			r = new FileReader("properties.config");
			prop.load(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("user");
		password = prop.getProperty("password");	
	}
	
	public static Connection open(){
		Connection conn = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;	
	}
	
	public static void close(Connection conn){
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}		
	}

}
