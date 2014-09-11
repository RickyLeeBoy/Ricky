package com.shop.view;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class ManagerGoodsTable extends AbstractTableModel{
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	//����������ʼ��rs��rsmd��������
	public ManagerGoodsTable(ResultSet aResultSet)
	{
		rs = aResultSet;
		try
		{  
			rsmd = rs.getMetaData();
		}
		catch (SQLException e)
		{  
			e.printStackTrace();
		}
	}
	//��дgetColumnName����������Ϊ��TableModel��������
	public String getColumnName(int c)
	{  
		try
		{  
			return rsmd.getColumnName(c + 1);
		}
		catch (SQLException e)
		{  
			e.printStackTrace();
			return "";
		}
	}
	//��дgetColumnCount�������������ø�TableModel������
	public int getColumnCount()
	{  
		try
		{  
			return rsmd.getColumnCount();
		}
		catch (SQLException e)
		{  
			e.printStackTrace();
			return 0;
		}
	}
	//��дgetValueAt�������������ø�TableModelָ����Ԫ���ֵ
	public Object getValueAt(int r, int c)
	{  
		try
		{  
			rs.absolute(r + 1);
			return rs.getObject(c + 1);
		}
		catch(SQLException e)
		{  
			e.printStackTrace();
			return null;
		}
	}
	//��дgetColumnCount�������������ø�TableModel������
	public int getRowCount()
	{  
		try
		{  
			rs.last();
			return rs.getRow();
		}
		catch(SQLException e)
		{  
			e.printStackTrace();
			return 0;
		}
	}
	//��дisCellEditable����true����ÿ����Ԫ��ɱ༭
	public boolean isCellEditable(int rowIndex, int columnIndex) 
	{
		return true;
	}
	//��дsetValueAt����������ʵ���û��༭��Ԫ��ʱ������������Ӧ�Ķ���
	public void setValueAt(Object aValue,
		int row,int column)
	{
		try
		{
			//�������λ����Ӧ������
			rs.absolute(row + 1);
			//�޸ĵ�Ԫ����Ӧ��ֵ
			rs.updateObject(column + 1 , aValue);
			//�ύ�޸�
			rs.updateRow();
			//������Ԫ����޸��¼�
			fireTableCellUpdated(row, column);
		}
		catch (SQLException evt)
		{
			evt.printStackTrace();
		}
	}
}
