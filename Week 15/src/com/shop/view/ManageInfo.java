package com.shop.view;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.sql.*;
import java.io.*;
import javax.sql.rowset.*;
import com.sun.rowset.*;

public class ManageInfo {

	JFrame jf = new JFrame("管理员商品系统");
	private JScrollPane scrollPane;
	private ManagerGoodsTable mgtable;
	//用于装载数据表的JComboBox
	private JComboBox tableNames = new JComboBox();
	private JTextArea changeMsg = new JTextArea(4, 60);
	private ResultSet rs;
	private Connection conn;
	private Statement pstmt;


	public void init()
	{
		//为JComboBox添加事件监听器，当用户选择管理其他数据表
		tableNames.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					//如果装载JTable的JScrollPane不为空
					if (scrollPane != null)
					{
						//从主窗口中删除表格
						jf.remove(scrollPane);
					}
					//从JComboBox中取出用户试图管理的数据表的表名
					String tableName = (String) tableNames.getSelectedItem();
					//如果结果集不为空，则关闭结果集
					if (rs != null) 
					{
						rs.close();
					}
					String query = "select * from " + tableName;
					//查询用户选择的数据表
					rs = pstmt.executeQuery(query);
					//使用查询到的ResultSet创建TableModel对象
					mgtable = new ManagerGoodsTable(rs);
					//为TableModel添加监听器，监听用户的修改
					mgtable.addTableModelListener(new TableModelListener()
					{
						public void tableChanged(TableModelEvent evt)
						{
							int row = evt.getFirstRow();
							int column = evt.getColumn();
							changeMsg.append("修改的列:" + column  + " ，修改的行:" + row
								+ " ，修改后的值:" + mgtable.getValueAt(row , column));
						}
					});
					//使用TableModel创建JTable，并将对应表格添加到窗口中
					JTable table = new JTable(mgtable);
					scrollPane = new JScrollPane(table);
					jf.add(scrollPane, BorderLayout.CENTER);
					jf.validate();
				}            
				catch (SQLException e)
				{  
					e.printStackTrace();
				}
			}
		});
		JPanel p = new JPanel();
		p.add(tableNames);
		jf.add(p, BorderLayout.NORTH);
		jf.add(new JScrollPane(changeMsg), BorderLayout.SOUTH);
		try
		{
			//获取数据库连接
			conn = getConnection();
			//获取数据库的MetaData对象
			DatabaseMetaData meta = conn.getMetaData();
			//创建Statement
			pstmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
			//查询当前数据库的全部数据表
			ResultSet tables = meta.getTables(null, null, null, new String[] { "TABLE" });
			//将全部数据表添加到JComboBox中
			while (tables.next())
			{
				tableNames.addItem(tables.getString(3));
			}
			tables.close();
		}
		catch (IOException e)
		{  
			e.printStackTrace();
		}
		catch (Exception e)
		{  
			e.printStackTrace();
		}

		jf.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent event)
			{
				try
				{
					if (conn != null) conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}              
			}
		});

		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setSize(800, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	private static Connection getConnection()
		throws SQLException, IOException ,ClassNotFoundException
	{
		//通过加载conn.ini文件来获取数据库连接的详细信息
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("conn.ini");
		props.load(in);
		in.close();
		String drivers = props.getProperty("jdbc.drivers");
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		//加载数据库驱动
		Class.forName(drivers);
		//取得数据库连接
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void main(String[] args)
	{
		
		new ManageInfo().init();
	}

}
