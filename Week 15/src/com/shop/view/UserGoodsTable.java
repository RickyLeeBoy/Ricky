package com.shop.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

class UserGoodsTable extends AbstractTableModel{
	
	
	Vector rowData,columnNames;
	ResultSet rs;
	Connection con;
	PreparedStatement pstmt;
	
	
	public void init(String sql)
	{
		if(sql.equals(""))
		{
			sql="select * from goods";
		}
		
		columnNames=new Vector();
		columnNames.add("商品编号");
		columnNames.add("管理员");
		columnNames.add("商家");
		columnNames.add("商品名称");
		columnNames.add("价格(单价：元)");
		columnNames.add("进货日期");
		columnNames.add("商品数量");
		columnNames.add("快点买吧,亲");

		
		rowData=new Vector();
			

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/schoolshops", "root",
						"224203");
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					Vector hang=new Vector();
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					hang.add(rs.getString(3));
					hang.add(rs.getString(4));
					hang.add(rs.getFloat(5));
					hang.add(rs.getDate(6));
					hang.add(rs.getInt(7));
					hang.add("购买");
					rowData.add(hang);
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
	}
	
	public UserGoodsTable()
	{			
		this.init("");
	}
	
	public UserGoodsTable(String sql)
	{			
		this.init(sql);
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