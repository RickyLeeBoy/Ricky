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
	
	
	//������Ҫ�����
	JLabel jl1,jl2,jl3;
	JTextField jtf1;
	JPasswordField jpf;
	JButton jcon,jcancel,jregister;
	JRadioButton jrb1,jrb2,jrb3;
	ButtonGroup bg;
	
	//ִ��JDBC�����Ķ���
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
		//���ɿղ��֣�����֮ǰ�Ĳ��ַ�ʽ��
		this.setLayout(null);
		Font f1=new Font("����",Font.PLAIN,12);
		Font f3=new Font("����",Font.BOLD,15);
		Font f2=new Font("����",Font.BOLD,16);
		//�����������
		
		

		
		jl1=new JLabel("�������û�����");
		//�������λ��
		jl1.setBounds(60, 190, 150, 30);
		//���������������
		jl1.setFont(f2);
		jl1.setForeground(Color.cyan);
		
		ct.add(jl1);
		
		jtf1=new JTextField();
		jtf1.setBounds(170, 190, 130, 30);
		//�������ݸо�
		jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf1);
		
		jl2=new JLabel("�������Ա�˺ţ�");
		jl2.setBounds(70, 210, 100, 30);
		jl2.setFont(f1);
		//����ǰ��ɫ
		jl2.setForeground(Color.red);
		ct.add(jl2);		
		
		jl3=new JLabel("��������  �룺");
		jl3.setBounds(60, 230, 150, 30);
		jl3.setFont(f2);
		jl3.setForeground(Color.cyan);
		ct.add(jl3);
		
		jpf=new JPasswordField(20);
		jpf.setBounds(170, 230, 130, 30);
		jpf.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpf);
		
		jrb1=new JRadioButton("����Ա", false);
		jrb1.setForeground(Color.red);
		jrb1.setOpaque(false);
		jrb1.setFont(f3);
		jrb1.setBounds(70, 250, 80, 50);
		jrb1.addActionListener(this);
		ct.add(jrb1);
		
		jrb2=new JRadioButton("��ͨ�û�",true);
		jrb2.setForeground(Color.red);
		jrb2.setFont(f3);
		jrb2.setOpaque(false);
		jrb2.setBounds(230, 250, 100, 50);
		jrb2.addActionListener(this);
		ct.add(jrb2);
		
		jrb3=new JRadioButton("�̼�",true);
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
		
		jcon=new JButton("ȷ��");
		jcon.addActionListener(this);
		jcon.setFont(f1);
		jcon.setBounds(60, 300, 70, 30);		
		ct.add(jcon);
		
	
		
		jcancel=new JButton("ȡ��");
		jcancel.addActionListener(this);
		jcancel.setFont(f1);
		jcancel.setBounds(150, 300, 70, 30);		
		ct.add(jcancel);
		
		jregister=new JButton("ע��");
		jregister.addActionListener(this);
		jregister.setFont(f1);
		jregister.setBounds(240, 300, 70, 30);
		ct.add(jregister);
		
		
		
		//����һ��BackImage��
		BackImage bi=new BackImage("IndexPic.jpg");
		//��ͼƬλ��ȷ��
		bi.setBounds(0, 0, 360, 360);
		
		
		ct.add(bi);
		
		//��ʹ�����¿�
		this.setUndecorated(true);
		this.setSize(360,360);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	
	
		
	
	

	//��Ӧ�û���¼������
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jcon && jrb1.isSelected())
		{
			try {
				if(mm.checkManager(jtf1.getText(),jpf.getText()))
				{
					JOptionPane.showMessageDialog(this, "����Ա��½�ɹ�");
					this.dispose();
					new Manager();
				}else 
				{ 
					JOptionPane.showMessageDialog(this, "��½����");
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
					JOptionPane.showMessageDialog(this, "��ͨ�û���½�ɹ�");
					this.dispose();
					new User();
				}else 
				{
					JOptionPane.showMessageDialog(this, "��½����");
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
					JOptionPane.showMessageDialog(this, "�̼ҵ�½�ɹ�");
					this.dispose();
					sgt=new ShopperGoodTable(jtf1.getText());
					new Shopper(sgt);
				}else 
				{
					JOptionPane.showMessageDialog(this, "��½����");
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