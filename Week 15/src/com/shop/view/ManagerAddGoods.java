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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.shop.model.ManagerModel;

public class ManagerAddGoods extends JDialog implements ActionListener{

	/**
	 * @param args
	 */
	
	ManagerModel mm=null;
	
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;
	JButton jcon,jcancel;
	
	
	public ManagerAddGoods()
	{
		mm=new ManagerModel();
	
		Font f=new Font("黑体",Font.BOLD,16);
		Container ct=this.getContentPane();
		ct.setLayout(null);
		
		jl1=new JLabel("商品编号");
		jl1.setBounds(60, 50, 150, 30);
		jl1.setFont(f);
		jl1.setForeground(Color.black);
		ct.add(jl1);
		
		jtf1=new JTextField();
		jtf1.setBounds(170, 50, 130, 30);
		jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf1);
		
		jl3=new JLabel("管理员账号");
		jl3.setBounds(60, 100, 150, 30);
		jl3.setFont(f);
		jl3.setForeground(Color.black);
		ct.add(jl3);
		
		jtf4=new JTextField(20);
		jtf4.setBounds(170, 100, 130, 30);
		jtf4.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf4);
		
		jl4=new JLabel("商家账号");
		jl4.setBounds(60, 150, 150, 30);
		jl4.setFont(f);
		jl4.setForeground(Color.black);
		ct.add(jl4);
		
		
		
		jtf2=new JTextField(20);
		jtf2.setBounds(170, 150, 130, 30);
		jtf2.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf2);
		
		jl5=new JLabel("商品名称");
		jl5.setBounds(60, 200, 150, 30);
		jl5.setFont(f);
		jl5.setForeground(Color.black);
		ct.add(jl5);
		
		
		
		jtf3=new JTextField(20);
		jtf3.setBounds(170, 200, 130, 30);
		jtf3.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf3);
		
		jl2=new JLabel("商品单价");
		jl2.setBounds(60, 250, 150, 30);
		jl2.setFont(f);
		jl2.setForeground(Color.black);
		ct.add(jl2);
		
		jtf5=new JTextField(20);
		jtf5.setBounds(170, 250, 130, 30);
		jtf5.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf5);
		
		jl6=new JLabel("进货时间");
		jl6.setBounds(60, 290, 150, 30);
		jl6.setFont(f);
		jl6.setForeground(Color.black);
		ct.add(jl6);
		
		jtf6=new JTextField(20);
		jtf6.setBounds(170, 290, 130, 30);
		jtf6.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf6);
		
		jl7=new JLabel("商品数量");
		jl7.setBounds(60, 330, 150, 30);
		jl7.setFont(f);
		jl7.setForeground(Color.black);
		ct.add(jl7);
		
		jtf7=new JTextField(20);
		jtf7.setBounds(170, 330, 130, 30);
		jtf7.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf7);
		
		jcon=new JButton("添加");
		jcon.addActionListener(this);
		jcon.setFont(f);
		jcon.setBounds(60, 370, 70, 30);		
		ct.add(jcon);
		
		jcancel=new JButton("取消");
		jcancel.addActionListener(this);
		jcancel.setFont(f);
		jcancel.setBounds(240, 370, 70, 30);		
		ct.add(jcancel);
		
		BackImage bi=new BackImage("IndexPic.jpg");
		bi.setBounds(0, 0, 350, 400);
		ct.add(bi);
		
		this.setUndecorated(true);
		this.setSize(350,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String goodId=this.jtf1.getText().trim();
		String manager=this.jtf4.getText().trim();
		String shopper=this.jtf2.getText();
		String goodName=this.jtf3.getText();
		String price=this.jtf5.getText();
		String date=this.jtf6.getText();
		String goodNo=this.jtf7.getText();
		String paras[]={goodId,manager,shopper,goodName,price,date,goodNo};
		if(e.getSource()==jcon)
		{
				mm.addGoods(paras);
				JOptionPane.showMessageDialog(this, "添加成功");
				this.dispose();
				new Manager();
		}
		else if(e.getSource()==jcancel)
		{
			this.dispose();
			new Manager();
		}
	}
	
	
}

