package com.shop.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.shop.model.ShopperModel;

public class ShopperRegister extends JDialog implements ActionListener{

	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	JPasswordField jpf;
	JButton jcon,jcancel;
	JRadioButton jrb1,jrb2,jrb3;
	ButtonGroup bg;
	
	ShopperModel sm=null;
	
	public ShopperRegister()
	{
		sm=new ShopperModel();
		
		Font f=new Font("黑体",Font.BOLD,16);
		Font f3=new Font("隶书",Font.BOLD,15);
		
		Container ct=this.getContentPane();
		ct.setLayout(null);
		jl1=new JLabel("商家用户名");
		jl1.setBounds(60, 50, 150, 30);
		jl1.setFont(f);
		jl1.setForeground(Color.black);
		ct.add(jl1);
		
		jtf1=new JTextField();
		jtf1.setBounds(170, 50, 130, 30);
		jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf1);
		
		
		jl6=new JLabel("管理员账号");
		jl6.setBounds(60, 90, 150, 30);
		jl6.setFont(f);
		jl6.setForeground(Color.black);
		ct.add(jl6);
		
		jtf5=new JTextField();
		jtf5.setBounds(170, 90, 130, 30);
		jtf5.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf5);
		
	
		
		jl2=new JLabel("密码");
		jl2.setBounds(60, 130, 150, 30);
		jl2.setFont(f);
		jl2.setForeground(Color.black);
		ct.add(jl2);
		
		jpf=new JPasswordField(20);
		jpf.setBounds(170, 130, 130, 30);
		jpf.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpf);
		
		jl4=new JLabel("真实姓名");
		jl4.setBounds(60, 170, 150, 30);
		jl4.setFont(f);
		jl4.setForeground(Color.black);
		ct.add(jl4);
		
		jtf3=new JTextField();
		jtf3.setBounds(170, 170, 130, 30);
		jtf3.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf3);
		
		jl5=new JLabel("身份证号码");
		jl5.setBounds(60, 210, 150, 30);
		jl5.setFont(f);
		jl5.setForeground(Color.black);
		ct.add(jl5);
		
		jtf4=new JTextField();
		jtf4.setBounds(170, 210, 130, 30);
		jtf4.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf4);
		
		jl3=new JLabel("联系方式");
		jl3.setBounds(60, 250, 150, 30);
		jl3.setFont(f);
		jl3.setForeground(Color.black);
		ct.add(jl3);
		
		jtf2=new JTextField();
		jtf2.setBounds(170, 250, 130, 30);
		jtf2.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf2);
		
		
		
		jrb3=new JRadioButton("商家", true);
		jrb3.setForeground(Color.red);
		jrb3.setOpaque(false);
		jrb3.setFont(f3);
		jrb3.setBounds(50, 10, 80, 50);
		jrb3.addActionListener(this);
		ct.add(jrb3);
		
		
		
		jrb2=new JRadioButton("普通用户",false);
		jrb2.setForeground(Color.red);
		jrb2.setFont(f3);
		jrb2.setOpaque(false);
		jrb2.setBounds(230, 10, 100, 50);
		jrb2.addActionListener(this);
		ct.add(jrb2);
		
		bg=new ButtonGroup();
		bg.add(jrb1);
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

	
	public static void main(String[] args)
	{
		new ShopperRegister();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jrb1)
		{
			this.dispose();
			new UserRegister();
		}
		else if(e.getSource()==jcancel)
		{
			this.dispose();
			new Login();
		}
		else if(e.getSource()==jcon && jrb3.isSelected())
		{
			String shopper=this.jtf1.getText().trim();
			String manager=this.jtf5.getText();
			String password=this.jpf.getText();
			String phone=this.jtf2.getText();
			String name=this.jtf3.getText();
			String personId=this.jtf4.getText();
			String[] paras={shopper,manager,password,phone,name,personId};
			sm.registerShopper(paras);
			JOptionPane.showMessageDialog(this, "商家注册成功");
			this.dispose();
			new Login();
			
		}else if(e.getSource()==jrb2)
		{
			this.dispose();
			new UserRegister();
		}
	}
}

