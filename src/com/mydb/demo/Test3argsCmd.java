package com.mydb.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test3argsCmd {
	public static void main(String[] args) {
//		testCreateTable();
//		testInsert("Mike","13965426666");
//		testUpdate();
//		testDelete();
		testQuery(10);

	}
	
	static void testInsert(String name, String tel){
		Connection conn = DBUtil.open();
		String sql = "insert into CustomerTable(name,tel) values(?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);//attention!
			stmt.setString(1, "mike");
			stmt.setString(2, "135123123123");
			stmt.executeUpdate();//!
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	static void testUpdate(String name, int id){
		Connection conn = DBUtil.open();
		String sql = "update CustomerTable set name = ?, where id = ?";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setInt(2, id);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	static void testDelete(int id){
		Connection conn = DBUtil.open();
		String sql = "delete from CustomerTable where id = ?";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	static void testQuery(int idInput){
		Connection conn = DBUtil.open();
		String sql = "select * from CustomerTable where id = ?";//< or > are both okay here
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idInput);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs;
		try {
			rs = stmt.executeQuery();//no sql here
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String tel = rs.getString(3);//two choices
				System.out.println(id+"\t"+name+"\t"+tel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn);
	}
}
