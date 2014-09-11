package com.shop.view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.sql.*;

import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class UserTable extends AbstractTableModel{

	
	Vector rowData,columnNames;
	
	
	
	ResultSet rs;
	Connection con;
	PreparedStatement pstmt;
	
	public UserTable()
	{
		columnNames=new Vector();
		columnNames.add("用户名");
		columnNames.add("密码");
		columnNames.add("联系方式");
		columnNames.add("类别");

		
		rowData=new Vector();
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/schoolshops", "root",
						"224203");
				pstmt = con.prepareStatement("select * from user");
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					Vector hang=new Vector();
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					hang.add(rs.getInt(3));
					hang.add("一般用户");
					rowData.add(hang);
				}
				
				
			} catch (Exception e) {

			}
			
			
			
			
			
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}
	
	

}
