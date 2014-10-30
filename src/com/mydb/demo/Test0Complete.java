package com.mydb.demo;

import java.sql.Connection;//this Connection not the other one in com.mysql.jdbc
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test0Complete {

	public static void main(String[] args) {
		query();//detailed process
	}
	
	static void query(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//initialize the Driver class   
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "select * from producttb";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);//exception ADUS using query key word
			//cursor
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				int number = rs.getInt(4);
				float priceIn = rs.getFloat(5);
				float priceOut = rs.getFloat(6);
				System.out.println(id+"\t"+name+"\t"+type+"\t"+number+"\t"+priceIn+"\t"+priceOut);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();//never forget to close the conn
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
