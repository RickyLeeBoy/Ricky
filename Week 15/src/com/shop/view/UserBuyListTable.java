package com.shop.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.shop.db.SqlHelper;

public class UserBuyListTable extends AbstractTableModel {
Vector rowData,columnNames;
	
	
	
	ResultSet rs,rs1;
	Connection con;
	PreparedStatement pstmt;
	SqlHelper sh=null;
	
	public UserBuyListTable()
	{
		columnNames=new Vector();
		columnNames.add("购买编号");
		columnNames.add("商品编号");
		columnNames.add("商品名称");
		columnNames.add("单价（元）");
		columnNames.add("购买数量");
		columnNames.add("总价");

		
		rowData=new Vector();
		
		try {
			String sql = "select ug.buyId,g.goodId,g.name,g.price,ug.goodNo "
					+ "from usergoods ug,goods g,shoppergoods sg,user u,shopper s "
					+ "where ug.shoppingId=sg.shoppingId and ug.userId=u.userId "
					+ "and g.goodId=sg.goodId and sg.shopperId=s.shopperId and ug.userId=?";
			String sql2 = "select * from usergoods";
			sh=new SqlHelper();
			rs1 = sh.query(sql2, null);
			rs1.last();
			String userId = rs1.getString(3);
			String[] paras = { userId };
			rs = sh.query(sql, paras);
			while (rs.next()) {
				Vector hang = new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getFloat(4));
				hang.add(rs.getString(5));
				float sum=rs.getFloat(4)*Float.parseFloat(rs.getString(5));
				hang.add(sum);
				rowData.add(hang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
