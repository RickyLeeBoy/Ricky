package com.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserSta extends JFrame implements ActionListener{
	
	JButton jb1;
	JTable jt1,jt2;
	JScrollPane jsp1,jsp2;
	JPanel jp1,jp2,jp3;
	ImageIcon ii;
	
	
	
	public UserSta()
	{
		
		
		jb1=new JButton("·µ»Ø");
		jb1.addActionListener(this);
		jp1=new JPanel();
	
		
		
		jp1.add(jb1);
		UserTable su=new UserTable();
		jt1=new JTable(su);
		jsp1=new JScrollPane(jt1);
		this.add(jsp1,"North");
		jt1.setOpaque(false);
		ShopperTable st=new ShopperTable();
		jt2=new JTable(st);
		jsp2=new JScrollPane(jt2);
		this.add(jsp2);
		
		this.add(jp1,"South");
		
		

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
			new Manager();
		}
	}
	

}
