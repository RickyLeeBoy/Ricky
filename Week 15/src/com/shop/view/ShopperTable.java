package com.shop.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ShopperTable extends AbstractTableModel{
	Vector rowData,columnNames;
	
	
	
	ResultSet rs;
	Connection con;
	PreparedStatement pstmt;
	
	public ShopperTable()
	{
		columnNames=new Vector();
		columnNames.add("用户名");
		columnNames.add("管理员");
		columnNames.add("密码");
		columnNames.add("真实姓名");
		columnNames.add("身份证号码");
		columnNames.add("联系方式");
		columnNames.add("类别");

		
		rowData=new Vector();
			

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/schoolshops", "root",
						"224203");
				pstmt = con.prepareStatement("select * from shopper");
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					Vector hang=new Vector();
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					hang.add(rs.getString(3));
					hang.add(rs.getString(4));
					hang.add(rs.getInt(5));
					hang.add(rs.getInt(6));
					hang.add("商家");
					rowData.add(hang);
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			
			
			
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
