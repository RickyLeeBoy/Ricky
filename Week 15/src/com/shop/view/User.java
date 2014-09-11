package com.shop.view;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;

import com.shop.model.UserModel;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.EventObject;
import java.util.Vector;

public class User extends JFrame implements ActionListener,MouseListener{

	
	JButton jb;
	JButton buy;
	JPanel jp;
	JScrollPane jsp;
	JTable jt;
	
	UserModel us=null;
	
	public User()
	{
		
		us=new UserModel();
		
		jb=new JButton("注销");
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jb);
		
		buy=new JButton("购买清单");
		buy.addActionListener(this);
		jp.add(buy);
		
		this.add(jp,"South");
		
		
		UserGoodsTable gt=new UserGoodsTable();
		jt=new JTable(gt);
		jt.addMouseListener(this);
		jt.setRowSelectionAllowed(false);
		jt.setSelectionBackground(Color.red);
		jt.setSelectionForeground(Color.red);
		jt.setDragEnabled(false);
		
		
		jsp=new JScrollPane(jt);
		this.add(jsp);
		
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new User();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb)
		{
			this.dispose();
			new Login();
		}
		if(e.getSource()==buy)
		{
			this.dispose();
			new UserBuyListSta();
		}
		
	}





	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==1)
		{
			for(int i=0;i<=new UserGoodsTable().getRowCount();i++)
			{
				if(jt.rowAtPoint(e.getPoint())==i && jt.columnAtPoint(e.getPoint())==7)
				{
					Float f1=Float.valueOf(jt.getValueAt(i, 4).toString());
					String goodNo=JOptionPane.showInputDialog("购买的数量:"+"(单价："+f1+"元)");
					String userId=JOptionPane.showInputDialog("用户账号:");
					String shopperId=jt.getValueAt(i, 2).toString();
					String goodId=jt.getValueAt(i, 0).toString();	
					us.buyGoods(shopperId, goodId, userId, goodNo);
					String goodName=jt.getValueAt(i, 3).toString();
					Float total=Float.valueOf(goodNo)*f1;
					JOptionPane.showMessageDialog(jt, "您已成功购买**"+goodName+"**"+goodNo+"个**"+"总价**"+total+"元**");
				}
			}
		
		}
		
	}





	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}