package com.shop.view;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Manager extends JFrame implements ActionListener{

	JPanel imagePanel;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8;
	JButton jadd;
	JButton jcancel;
	ImageIcon ii;
	JLabel image;
	
	

	
	public Manager()
	{
		ii=new ImageIcon("IndexPic.jpg");
		image=new JLabel(ii);
		image.setBounds(0, 0, ii.getIconWidth(), ii.getIconHeight());
		
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// 内容窗格默认的布局管理器为BorderLayout
		imagePanel.setLayout(null);
		this.getLayeredPane().setLayout(null);
		
		this.setLayout(null);
		
		
		
		
		Font f1=new Font("隶书",Font.PLAIN,8);
		Font f=new Font("黑体",Font.BOLD,14);
		
		jb1=new JButton("用户信息修改");
		jb1.setFont(f);
		jb1.setBounds(140, 100, 150, 50);
		jb1.setForeground(Color.cyan);
		jb1.addActionListener(this);
		imagePanel.add(jb1);
		
		jb2=new JButton("删除用户");
		jb2.setFont(f);
		jb2.setForeground(Color.cyan);
		jb2.setBounds(100, 300, 150, 50);
		jb2.addActionListener(this);
		imagePanel.add(jb2);
		
		jb3=new JButton("用户统计");
		jb3.setFont(f);
		jb3.setForeground(Color.cyan);
		jb3.setBounds(140, 400, 150, 50);
		jb3.addActionListener(this);
		imagePanel.add(jb3);
		
		jadd=new JButton("添加用户");
		jadd.setFont(f);
		jadd.setForeground(Color.cyan);
		jadd.setBounds(100, 200, 150, 50);
		jadd.addActionListener(this);
		imagePanel.add(jadd);
		
		
		

		
		
		jb4=new JButton("商品信息添加");
		jb4.setFont(f);
		jb4.setForeground(Color.pink);
		jb4.setBounds(430, 50, 150, 50);
		jb4.addActionListener(this);
		imagePanel.add(jb4);
		
		
		jb6=new JButton("商品信息删除");
		jb6.setFont(f);
		jb6.setForeground(Color.pink);
		jb6.setBounds(490, 250, 150, 50);
		jb6.addActionListener(this);
		imagePanel.add(jb6);
		
		
		jb8=new JButton("管理信息统计");
		jb8.setFont(f);
		jb8.setForeground(Color.pink);
		jb8.setBounds(430, 450, 150, 50);
		jb8.addActionListener(this);
		imagePanel.add(jb8);
		
		
		jcancel=new JButton("注销");
		jcancel.setFont(f1);
		jcancel.setForeground(Color.red);
		jcancel.setLocation(ii.getIconWidth(),ii.getIconHeight());
		jcancel.addActionListener(this);
		jcancel.setBounds(600, 500, 50, 50);
		imagePanel.add(jcancel);
			
	

		this.getLayeredPane().add(image, new Integer(Integer.MIN_VALUE));
		this.setTitle("校园小商品系统");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			this.dispose();
			new ManagerUptateUser();
			
		}else if(e.getSource()==jb2)
		{
			this.dispose();
			new ManagerDeleteUser();
			
		}else if(e.getSource()==jb3)
		{
			this.dispose();
			new UserSta();
			
		}else if(e.getSource()==jb4)
		{
			this.dispose();
			new ManagerAddGoods();
			
		}else if(e.getSource()==jadd)
		{
			this.dispose();
			new ManagerAddUser();
		}
		else if(e.getSource()==jb6)
		{
			this.dispose();
			new ManagerDeleteGoods();
			
			
		}else if(e.getSource()==jb8)
		{
			this.dispose();
			new ManageInfo().init();
			
		}else if(e.getSource()==jcancel)
		{
			this.dispose();
			new Login();
		}
	}
	

}
