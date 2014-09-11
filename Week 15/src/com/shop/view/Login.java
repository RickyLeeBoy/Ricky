package com.shop.view;


import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import javax.imageio.*;

import com.shop.model.ManagerModel;
import com.shop.model.ShopperModel;
import com.shop.model.UserModel;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Login extends JDialog implements ActionListener{
	
	
	//定义需要的组件
	JLabel jl1,jl2,jl3;
	JTextField jtf1;
	JPasswordField jpf;
	JButton jcon,jcancel,jregister;
	JRadioButton jrb1,jrb2,jrb3;
	ButtonGroup bg;
	
	//执行JDBC操作的对象
	ManagerModel mm=null;
	UserModel um=null;
	ShopperModel sm=null;
	
	ShopperGoodTable sgt=null;
	

	public Login()
	{	
		mm=new ManagerModel();
		um=new UserModel();
		sm=new ShopperModel();
		
		Container ct=this.getContentPane();
		//做成空布局，不用之前的布局方式。
		this.setLayout(null);
		Font f1=new Font("隶书",Font.PLAIN,12);
		Font f3=new Font("隶书",Font.BOLD,15);
		Font f2=new Font("黑体",Font.BOLD,16);
		//创建各个组件
		
		

		
		jl1=new JLabel("请输入用户名：");
		//设置组件位置
		jl1.setBounds(60, 190, 150, 30);
		//设置组件上面字体
		jl1.setFont(f2);
		jl1.setForeground(Color.cyan);
		
		ct.add(jl1);
		
		jtf1=new JTextField();
		jtf1.setBounds(170, 190, 130, 30);
		//设置下陷感觉
		jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf1);
		
		jl2=new JLabel("（或管理员账号）");
		jl2.setBounds(70, 210, 100, 30);
		jl2.setFont(f1);
		//设置前景色
		jl2.setForeground(Color.red);
		ct.add(jl2);		
		
		jl3=new JLabel("请输入密  码：");
		jl3.setBounds(60, 230, 150, 30);
		jl3.setFont(f2);
		jl3.setForeground(Color.cyan);
		ct.add(jl3);
		
		jpf=new JPasswordField(20);
		jpf.setBounds(170, 230, 130, 30);
		jpf.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpf);
		
		jrb1=new JRadioButton("管理员", false);
		jrb1.setForeground(Color.red);
		jrb1.setOpaque(false);
		jrb1.setFont(f3);
		jrb1.setBounds(70, 250, 80, 50);
		jrb1.addActionListener(this);
		ct.add(jrb1);
		
		jrb2=new JRadioButton("普通用户",true);
		jrb2.setForeground(Color.red);
		jrb2.setFont(f3);
		jrb2.setOpaque(false);
		jrb2.setBounds(230, 250, 100, 50);
		jrb2.addActionListener(this);
		ct.add(jrb2);
		
		jrb3=new JRadioButton("商家",true);
		jrb3.setForeground(Color.red);
		jrb3.setFont(f3);
		jrb3.setOpaque(false);
		jrb3.setBounds(150, 250, 100, 50);
		jrb3.addActionListener(this);
		ct.add(jrb3);
		
		bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		
		jcon=new JButton("确定");
		jcon.addActionListener(this);
		jcon.setFont(f1);
		jcon.setBounds(60, 300, 70, 30);		
		ct.add(jcon);
		
	
		
		jcancel=new JButton("取消");
		jcancel.addActionListener(this);
		jcancel.setFont(f1);
		jcancel.setBounds(150, 300, 70, 30);		
		ct.add(jcancel);
		
		jregister=new JButton("注册");
		jregister.addActionListener(this);
		jregister.setFont(f1);
		jregister.setBounds(240, 300, 70, 30);
		ct.add(jregister);
		
		
		
		//创建一个BackImage类
		BackImage bi=new BackImage("IndexPic.jpg");
		//把图片位置确定
		bi.setBounds(0, 0, 360, 360);
		
		
		ct.add(bi);
		
		//不使用上下框
		this.setUndecorated(true);
		this.setSize(360,360);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	
	
		
	
	

	//响应用户登录的请求
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jcon && jrb1.isSelected())
		{
			try {
				if(mm.checkManager(jtf1.getText(),jpf.getText()))
				{
					JOptionPane.showMessageDialog(this, "管理员登陆成功");
					this.dispose();
					new Manager();
				}else 
				{ 
					JOptionPane.showMessageDialog(this, "登陆错误");
				}
			
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			
			
		}else if(e.getSource()==jcon && jrb2.isSelected())
		{
			try {
				if(um.checkUser(jtf1.getText(),jpf.getText()))
				{
					JOptionPane.showMessageDialog(this, "普通用户登陆成功");
					this.dispose();
					new User();
				}else 
				{
					JOptionPane.showMessageDialog(this, "登陆错误");
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==jcon && jrb3.isSelected())
		{
			try {
				if(sm.checkShopper(jtf1.getText(),jpf.getText()))
				{
					JOptionPane.showMessageDialog(this, "商家登陆成功");
					this.dispose();
					sgt=new ShopperGoodTable(jtf1.getText());
					new Shopper(sgt);
				}else 
				{
					JOptionPane.showMessageDialog(this, "登陆错误");
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}	
		}
		
		else if(e.getSource()==jcancel)
		{
			this.dispose();
			System.exit(0);
		}else if(e.getSource()==jregister)
		{
			this.dispose();
			new UserRegister();
		}		
	}
		
}