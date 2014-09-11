package com.shop.model;

import java.sql.ResultSet;

import com.shop.db.SqlHelper;

public class ManagerModel {

	
	public boolean checkManager(String uid,String p)
	{
		SqlHelper sh = null;
		try {
			String sql="select * from manager where managerId=? and password=?";
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
	
	public boolean checkManagerPassword(String p)
	{
		SqlHelper sh=null;
		try {
			
			String sql="select * from manager where password=?";
			String paras[]={p};
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
	
	public void addGoods(String[] paras)
	{
		SqlHelper sh=null;
		try{
			
			String sql="insert into goods values(?,?,?,?,?,?,?)";
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
	
	public void deleteUser(String[] paras)
	{
		SqlHelper sh=null;
		try{
			
			String sql="delete from user where userId=?";
			sh=new SqlHelper();
			sh.delete(sql, paras);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			sh.close(); 
		}
	}
	
	public void deleteGoods(String[] paras)
	{
		SqlHelper sh=null;
		try{
			
			String sql="delete from goods where goodId=?";
			sh=new SqlHelper();
			sh.delete(sql, paras);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			sh.close(); 
		}
	}
	
	public void uptateUser(String[] paras)
	{
		SqlHelper sh=null;
		try{
			
			String sql="update user set userId=?,password=?,phoneNo=? where userId=?";
			sh=new SqlHelper();
			sh.update(sql, paras);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			sh.close(); 
		}
	}
	
}
