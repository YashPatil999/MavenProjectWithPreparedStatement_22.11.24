package com.yp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student {

	public static void main(String[] args) throws Exception {
		Student s = new Student();
		s.insertData();
		s.updateData();
		s.deleteData();
		s.fetchAllData();
	}

	public void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentv2?useSSL=false", "root",
				"root");
		PreparedStatement ps = conn.prepareStatement("insert into studentDetails values(?,?,?)");
		ps.setInt(1, 101);
		ps.setString(2, "Yash");
		ps.setInt(3, 25);
		ps.executeUpdate();
		conn.close();
		System.out.println("Data Inserted Successfully!!!");
	}

	public void updateData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentv2?useSSL=false", "root",
				"root");
		PreparedStatement ps = conn.prepareStatement("update studentDetails set sname=?, sage=? where sid=?");
		ps.setInt(3, 101);
		ps.setString(1, "Shubham");
		ps.setInt(2, 27);
		ps.executeUpdate();
		conn.close();
		System.out.println("Data Updated Successfully!!!");
	}

	public void deleteData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentv2?useSSL=false", "root",
				"root");
		PreparedStatement ps = conn.prepareStatement("delete from studentDetails where sid=?");
		ps.setInt(1, 101);
		ps.executeUpdate();
		conn.close();
		System.out.println("Data Deleted Successfully!!!");
	}

	public void fetchAllData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentv2?useSSL=false", "root",
				"root");
		PreparedStatement ps = conn.prepareStatement("select * from studentDetails");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("PId = " + rs.getInt(1) + "\nPName = " + rs.getString(2) + "\nPAddress = " + rs.getInt(3)
					+ "\n=======================");
		}
		conn.close();
	}
}
