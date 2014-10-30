package com.mydb.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{//Data Access Object

	@Override
	public void add(Customer c) {
		String sql = "insert into CustomerTable(name,tel)values(?,?)";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getTel());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	@Override
	public void update(Customer c) {
		String sql = "update CustomerTable set name=?,tel=? where id=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getTel());
			pstmt.setInt(3, c.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from CustomerTable where id=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	@Override
	public Customer getCustomerById(int id) {
		String sql = "select id,name,tel from CustomerTable where id=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);//sql here
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();//no sql here
			while(rs.next()){
				String name = rs.getString(2);
				String tel = rs.getString(3);
				Customer c = new Customer();
				c.setId(id);
				c.setName(name);
				c.setTel(tel);
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public List<Customer> query() {
		List<Customer> list = new ArrayList<Customer>();
		String sql = "select id,name,tel from CustomerTable";
		Connection conn = DBUtil.open();
		try {
			Statement stmt = conn.createStatement();//no sql here
			ResultSet rs = stmt.executeQuery(sql);//sql here
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				Customer c = new Customer();
				c.setId(id);
				c.setName(name);
				c.setTel(tel);
				list.add(c);
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

}
