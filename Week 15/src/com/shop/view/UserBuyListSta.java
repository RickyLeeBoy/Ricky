package com.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserBuyListSta extends JFrame implements ActionListener{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserBuyListSta();
	}
	JButton jb1;
	JTable jt1,jt2;
	JScrollPane jsp1,jsp2;
	JPanel jp1,jp2,jp3;
	ImageIcon ii;
	
	
	
	public UserBuyListSta()
	{
		
		
		jb1=new JButton("·µ»Ø");
		jb1.addActionListener(this);
		jp1=new JPanel();
	
		
		
		jp1.add(jb1);
		this.add(jp1,"South");
		
		UserBuyListTable blt=new UserBuyListTable();
		jt1=new JTable(blt);
		jsp1=new JScrollPane(jt1);
		this.add(jsp1,"North");
		jt1.setOpaque(false);
		
		

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
			new User();
		}
	}
	

}
