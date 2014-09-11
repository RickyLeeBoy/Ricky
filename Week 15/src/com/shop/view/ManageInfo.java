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

	JFrame jf = new JFrame("����Ա��Ʒϵͳ");
	private JScrollPane scrollPane;
	private ManagerGoodsTable mgtable;
	//����װ�����ݱ��JComboBox
	private JComboBox tableNames = new JComboBox();
	private JTextArea changeMsg = new JTextArea(4, 60);
	private ResultSet rs;
	private Connection conn;
	private Statement pstmt;


	public void init()
	{
		//ΪJComboBox����¼������������û�ѡ������������ݱ�
		tableNames.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					//���װ��JTable��JScrollPane��Ϊ��
					if (scrollPane != null)
					{
						//����������ɾ�����
						jf.remove(scrollPane);
					}
					//��JComboBox��ȡ���û���ͼ��������ݱ�ı���
					String tableName = (String) tableNames.getSelectedItem();
					//����������Ϊ�գ���رս����
					if (rs != null) 
					{
						rs.close();
					}
					String query = "select * from " + tableName;
					//��ѯ�û�ѡ������ݱ�
					rs = pstmt.executeQuery(query);
					//ʹ�ò�ѯ����ResultSet����TableModel����
					mgtable = new ManagerGoodsTable(rs);
					//ΪTableModel��Ӽ������������û����޸�
					mgtable.addTableModelListener(new TableModelListener()
					{
						public void tableChanged(TableModelEvent evt)
						{
							int row = evt.getFirstRow();
							int column = evt.getColumn();
							changeMsg.append("�޸ĵ���:" + column  + " ���޸ĵ���:" + row
								+ " ���޸ĺ��ֵ:" + mgtable.getValueAt(row , column));
						}
					});
					//ʹ��TableModel����JTable��������Ӧ�����ӵ�������
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
			//��ȡ���ݿ�����
			conn = getConnection();
			//��ȡ���ݿ��MetaData����
			DatabaseMetaData meta = conn.getMetaData();
			//����Statement
			pstmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
			//��ѯ��ǰ���ݿ��ȫ�����ݱ�
			ResultSet tables = meta.getTables(null, null, null, new String[] { "TABLE" });
			//��ȫ�����ݱ���ӵ�JComboBox��
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
		//ͨ������conn.ini�ļ�����ȡ���ݿ����ӵ���ϸ��Ϣ
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("conn.ini");
		props.load(in);
		in.close();
		String drivers = props.getProperty("jdbc.drivers");
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		//�������ݿ�����
		Class.forName(drivers);
		//ȡ�����ݿ�����
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void main(String[] args)
	{
		
		new ManageInfo().init();
	}

}
