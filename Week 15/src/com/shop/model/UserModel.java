package com.shop.model;

import java.sql.ResultSet;

import javax.swing.table.AbstractTableModel;

import com.shop.db.SqlHelper;

public class UserModel {
	

	
	public boolean checkUser(String uid,String p)
	{
		SqlHelper sh = null;
		try {
			String sql="select * from user where userId=? and password=?";
			String paras[]={uid,p};
			sh=new SqlHelper();
			ResultSet rs=sh.query(sql, paras);
			if(rs.next())
			{
				return true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally
		{
			sh.close(); 
		}
		
		return false;
	}
	
	public void registerUser(String[] paras)
	{
		SqlHelper sh=null;
		try{
			
			String sql="insert into user values(?,?,?,?)";
			sh=new SqlHelper();
			sh.insert(sql, paras);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			sh.close(); 
		}
	}
	
	public void buyGoods(String shopperId,String goodId,String userId,String goodNo)
	{
		SqlHelper sh=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		try{
			
			String sql="select sg.shoppingId from shoppergoods sg,goods g,shopper s " +
					"where sg.goodId=g.goodId and s.shopperId=sg.shopperId and g.goodId=? and s.shopperId=?";
			String paras1[]={goodId,shopperId};
			sh=new SqlHelper();
			rs1=sh.query(sql, paras1);
			String sql1="insert into usergoods values(?,?,?,?)";
			rs1.next();
			String sql2="select * from usergoods";
			rs2=sh.query(sql2, null);
			rs2.last();
			String buyId1=rs2.getString(1);
			int buyId2=Integer.parseInt(buyId1);
			buyId2++;
			String paras2[]={String.valueOf(buyId2),rs1.getString(1),userId,goodNo};
			sh.insert(sql1, paras2);
			
			}catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
			}finally
			{
			sh.close(); 
			}
			
	}
	
}
