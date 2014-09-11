package com.shop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlHelper {
	
	PreparedStatement pstmt;
	Connection conn;
	ResultSet rs;
	
	public SqlHelper()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/schoolshops", "root", "224203");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String sql,String[] paras)
	{
		try {
			pstmt=conn.prepareStatement(sql);
			if(paras!=null)
			{
				for(int i=0;i<paras.length;i++)
				{
					pstmt.setString(i+1, paras[i]);
				}
			}
		
			rs=pstmt.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
	
	public void insert(String sql,String[] paras)
	{
		try {
			pstmt=conn.prepareStatement(sql);
			
			for(int i=0;i<paras.length;i++)
			{
				pstmt.setString(i+1, paras[i]);
			}
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void delete(String sql,String[] paras)
	{
		try {
			pstmt=conn.prepareStatement(sql);
			
			for(int i=0;i<paras.length;i++)
			{
				pstmt.setString(i+1, paras[i]);
			}
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void update(String sql,String[] paras)
	{
		try {
			pstmt=conn.prepareStatement(sql);
			
			for(int i=0;i<paras.length;i++)
			{
				pstmt.setString(i+1, paras[i]);
			}
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		try {
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean updExecute(String sql,String []paras)
	{
		boolean b=true;
    	try
    	{
    		pstmt = conn.prepareStatement(sql);
    		for (int i = 0; i < paras.length; i++)
    		{
    			pstmt.setString(i + 1, paras[i]);
    		}
    		if (pstmt.executeUpdate() != 1) 
    		{
    			b = false;
    		}
    	} 
    	catch (Exception e) 
    	{
		// TODO: handle exception
    		b=false;
    		e.printStackTrace();
		}finally
		{
			this.close();
		}
		return b;
	}

}
