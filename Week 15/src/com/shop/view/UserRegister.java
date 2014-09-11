package com.shop.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;


import javax.imageio.ImageIO;
import javax.swing.*;

import com.shop.model.UserModel;




public class UserRegister extends JDialog implements ActionListener{

	JLabel jl1,jl2,jl3,jl4;
	JTextField jtf1,jtf2,jtf3;
	JPasswordField jpf;
	JButton jcon,jcancel;
	JRadioButton jrb2,jrb3;
	ButtonGroup bg;
	
	UserModel um=null;
	
	public UserRegister()
	{
		um=new UserModel();
		
		Font f=new Font("黑体",Font.BOLD,16);
		Font f3=new Font("隶书",Font.BOLD,15);
		
		Container ct=this.getContentPane();
		ct.setLayout(null);
		jl1=new JLabel("新的用户名");
		jl1.setBounds(60, 100, 150, 30);
		jl1.setFont(f);
		jl1.setForeground(Color.black);
		ct.add(jl1);
		
		jtf1=new JTextField();
		jtf1.setBounds(170, 100, 130, 30);
		jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf1);
		
		jl2=new JLabel("密码");
		jl2.setBounds(60, 140, 150, 30);
		jl2.setFont(f);
		jl2.setForeground(Color.black);
		ct.add(jl2);
		
		jpf=new JPasswordField(20);
		jpf.setBounds(170, 140, 130, 30);
		jpf.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpf);
		
		jl3=new JLabel("联系方式");
		jl3.setBounds(60, 180, 150, 30);
		jl3.setFont(f);
		jl3.setForeground(Color.black);
		ct.add(jl3);
		
		jtf2=new JTextField();
		jtf2.setBounds(170, 180, 130, 30);
		jtf2.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf2);
		
		jl4=new JLabel("管理员账号");
		jl4.setBounds(60, 220, 150, 30);
		jl4.setFont(f);
		jl4.setForeground(Color.black);
		ct.add(jl4);
		
		jtf3=new JTextField();
		jtf3.setBounds(170, 220, 130, 30);
		jtf3.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf3);
		
		
		
		jrb3=new JRadioButton("商家", false);
		jrb3.setForeground(Color.red);
		jrb3.setOpaque(false);
		jrb3.setFont(f3);
		jrb3.setBounds(70, 50, 80, 50);
		jrb3.addActionListener(this);
		ct.add(jrb3);
		
		
		
		jrb2=new JRadioButton("普通用户",true);
		jrb2.setForeground(Color.red);
		jrb2.setFont(f3);
		jrb2.setOpaque(false);
		jrb2.setBounds(230, 50, 100, 50);
		jrb2.addActionListener(this);
		ct.add(jrb2);
		
		bg=new ButtonGroup();
		bg.add(jrb2);
		bg.add(jrb3);
		
		
		jcon=new JButton("注册");
		jcon.addActionListener(this);
		jcon.setFont(f);
		jcon.setBounds(60, 300, 70, 30);		
		ct.add(jcon);
		
		jcancel=new JButton("取消");
		jcancel.addActionListener(this);
		jcancel.setFont(f);
		jcancel.setBounds(240, 300, 70, 30);		
		ct.add(jcancel);
		
		//创建一个BackImage类
		BackImage bi=new BackImage("IndexPic.jpg");
		//把图片位置确定
		bi.setBounds(0, 0, 360, 360);
		
		
		ct.add(bi);
		
		
		this.setUndecorated(true);
		this.setSize(360,360);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jcon && jrb2.isSelected())
		{
			String user=this.jtf1.getText().trim();
			String password=new String(this.jpf.getPassword());
			String phone=this.jtf2.getText();
			String manager=this.jtf3.getText();
			String[] paras={user,manager,password,phone};
			um.registerUser(paras);
			JOptionPane.showMessageDialog(this, "普通用户注册成功");
			this.dispose();
			new Login();
			
		}
		else if(jrb3.isSelected())
		{
			this.dispose();
			new ShopperRegister();
		}
		else if(e.getSource()==jcancel)
		{
			this.dispose();
			new Login();
		}
	}
	
	public static void main(String[] args)
	{
		new UserRegister();
	}
}
