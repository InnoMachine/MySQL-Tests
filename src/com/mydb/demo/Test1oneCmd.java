package com.mydb.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1oneCmd {

	public static void main(String[] args) {
//		testCreateTable();
//		testInsert();
//		testUpdate();
//		testDelete();
		testQuery();
//		runMysqlCmd("delete from CustomerTable where id = 4");
//		runMysqlCmd("insert into CustomerTable(name,tel) values('Jimmy','911')");
	}
	
	static void runMysqlCmd(String cmd){//run any cmds except show-func
		Connection conn = DBUtil.open();
		String sql = cmd;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn);	
	}
	
	static void testCreateTable(){
		Connection conn = DBUtil.open();
		String sql = "create table CustomerTable(id int primary key auto_increment, name varchar(20), tel varchar(20))";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn);	
	}
	
	static void testInsert(){
		Connection conn = DBUtil.open();
		String sql = "insert into CustomerTable(name,tel) values('Tom','18023332333')";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn);
	}
	
	static void testUpdate(){
		Connection conn = DBUtil.open();
		String sql = "update CustomerTable set name = 'kite',tel = '18012341234' where id = 1";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn);
	}
	
	static void testDelete(){
		Connection conn = DBUtil.open();
		String sql = "delete from CustomerTable where id = 3";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn);
	}
	
	static void testQuery(){
		Connection conn = DBUtil.open();
		String sql = "select * from CustomerTable";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
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
