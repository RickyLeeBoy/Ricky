package com.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.shop.model.ManagerModel;

public class ManagerUptateUser extends JDialog implements ActionListener{

	/**
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		new ManagerUptateUser();
	}
	
	ManagerModel mm=null;
	
	JLabel jl1,jl2,jl3,jl4,jl5;
	JTextField jtf1,jtf2,jtf3;
	JPasswordField jpf1,jpf2;
	JButton jcon,jcancel;
	
	
	public ManagerUptateUser()
	{
		mm=new ManagerModel();
		Font f=new Font("黑体",Font.BOLD,16);
		Container ct=this.getContentPane();
		ct.setLayout(null);
		jl1=new JLabel("原用户名");
		jl1.setBounds(60, 50, 150, 30);
		jl1.setFont(f);
		jl1.setForeground(Color.black);
		ct.add(jl1);
		
		jtf1=new JTextField();
		jtf1.setBounds(170, 50, 130, 30);
		jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf1);
		
		jl3=new JLabel("新用户名");
		jl3.setBounds(60, 90, 150, 30);
		jl3.setFont(f);
		jl3.setForeground(Color.black);
		ct.add(jl3);
		
		jtf2=new JTextField();
		jtf2.setBounds(170, 90, 130, 30);
		jtf2.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf2);
		
		jl4=new JLabel("新密码");
		jl4.setBounds(60, 130, 150, 30);
		jl4.setFont(f);
		jl4.setForeground(Color.black);
		ct.add(jl4);
		
		jpf2=new JPasswordField(20);
		jpf2.setBounds(170, 130, 130, 30);
		jpf2.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpf2);
		
		jl5=new JLabel("新联系方式");
		jl5.setBounds(60, 170, 150, 30);
		jl5.setFont(f);
		jl5.setForeground(Color.black);
		ct.add(jl5);
		
		jtf3=new JTextField();
		jtf3.setBounds(170, 170, 130, 30);
		jtf3.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf3);
		
		jl2=new JLabel("管理员密码");
		jl2.setBounds(60, 210, 150, 30);
		jl2.setFont(f);
		jl2.setForeground(Color.black);
		ct.add(jl2);
		
		jpf1=new JPasswordField(20);
		jpf1.setBounds(170, 210, 130, 30);
		jpf1.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpf1);
		
		jcon=new JButton("确认");
		jcon.addActionListener(this);
		jcon.setFont(f);
		jcon.setBounds(60, 300, 70, 30);		
		ct.add(jcon);
		
		jcancel=new JButton("取消");
		jcancel.addActionListener(this);
		jcancel.setFont(f);
		jcancel.setBounds(240, 300, 70, 30);		
		ct.add(jcancel);
		
		BackImage bi=new BackImage("IndexPic.jpg");
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
		String olduser=this.jtf1.getText().trim();
		String newuser=this.jtf2.getText().trim();
		String phone=this.jtf3.getText().trim();
		String newpassword=this.jpf2.getText();
		String managerpassword=this.jpf1.getText();
		String[] paras={newuser,newpassword,phone,olduser};
		if(e.getSource()==jcon)
		{
			if(mm.checkManagerPassword(managerpassword))
			{
				mm.uptateUser(paras);
				JOptionPane.showMessageDialog(this, "修改成功");
				this.dispose();
				new Manager();
				
			}else
			{
				JOptionPane.showMessageDialog(this, "密码错误");
			}
		}
		else if(e.getSource()==jcancel)
		{
			this.dispose();
			new Manager();
		}
	}
}


