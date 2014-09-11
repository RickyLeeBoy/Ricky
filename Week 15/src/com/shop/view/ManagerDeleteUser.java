package com.shop.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.shop.model.ManagerModel;

public class ManagerDeleteUser extends JDialog implements ActionListener{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManagerDeleteUser();
	}
	
	JLabel jl1,jl2;
	JTextField jtf;
	JPasswordField jpf;
	JButton jcon,jcancel;
	
	ManagerModel mm=null;
	
	
	public ManagerDeleteUser()
	{
		mm=new ManagerModel();
		Font f=new Font("黑体",Font.BOLD,16);
		Container ct=this.getContentPane();
		ct.setLayout(null);
		jl1=new JLabel("删除的用户名");
		jl1.setBounds(60, 150, 150, 30);
		jl1.setFont(f);
		jl1.setForeground(Color.black);
		ct.add(jl1);
		
		jtf=new JTextField();
		jtf.setBounds(170, 150, 130, 30);
		jtf.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf);
		
		jl2=new JLabel("管理员密码");
		jl2.setBounds(60, 190, 150, 30);
		jl2.setFont(f);
		jl2.setForeground(Color.black);
		ct.add(jl2);
		
		jpf=new JPasswordField(20);
		jpf.setBounds(170, 190, 130, 30);
		jpf.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpf);
		
		jcon=new JButton("删除");
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
		String user=this.jtf.getText().trim();
		String p=this.jpf.getText();
		String[] paras={user};
		if(e.getSource()==jcon)
		{
			if(mm.checkManagerPassword(p))
			{
				mm.deleteUser(paras);
				JOptionPane.showMessageDialog(this, "删除成功");
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
