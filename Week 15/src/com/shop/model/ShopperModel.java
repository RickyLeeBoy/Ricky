package com.shop.model;

import java.sql.ResultSet;

import com.shop.db.SqlHelper;

public class ShopperModel {

	public boolean checkShopper(String uid,String p)
	{
		SqlHelper sh = null;
		try {
			String sql="select * from shopper where shopperId=? and password=?";
			String paras[]={uid,p};
			sh=new SqlHelper();
			ResultSet rs=sh.query(sql, paras);
			if(rs.next())
			{
				return true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			sh.close(); 
		}
		
		return false;
	}
	
	public void registerShopper(String[] paras)
	{
		SqlHelper sh=null;
		try{
			
			String sql="insert into shopper values(?,?,?,?,?,?)";
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
	
}
