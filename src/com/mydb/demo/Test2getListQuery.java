package com.mydb.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Test2getListQuery {

	public static void main(String[] args) {
		testQuery();
	}
	
	static List<Customer> testQuery() {
		List<Customer> list = new ArrayList<Customer>();
		Connection conn = DBUtil.open();
		String sql = "select id,name,tel from CustomerTable";
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
				String tel = rs.getString("tel");
				Customer c = new Customer();
				c.setId(id);
				c.setName(name);
				c.setTel(tel);
				list.add(c);
			}
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn);
		return null;//?why need this
	}	
}