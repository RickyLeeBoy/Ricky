package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test1 {
	PreparedStatement pstmt;
	Connection conn;
	public Test1()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/schoolshops", "root", "224203");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			pstmt=conn.prepareStatement("insert into user values(?,?,?,?)");
			pstmt.setString(1, "111");
			pstmt.setString(2, "12345");
			pstmt.setString(3, "111");
			pstmt.setInt(4, 111);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args)
	{
		new Test1();
	}
}
