package com.shop.view;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class ShopperAddGoods extends JDialog implements ActionListener{


	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;  
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;  
	JPanel jp1,jp2,jp3;
	ShopperGoodTable sgt;

	public ShopperAddGoods(Frame owner,String title,boolean model)
	{
		
		
		super(owner,title,model);
		jl1=new JLabel("商品编号");   
		jl2=new JLabel("管理员编号");
		jl3=new JLabel("商家编号");  
		jl4=new JLabel("商品名称");
		jl5=new JLabel("单价");  
		jl6=new JLabel("进货日期");
		jl7=new JLabel("商品数量");
		
		jtf1=new JTextField();   
		jtf2=new JTextField();
		jtf3=new JTextField();   
		jtf4=new JTextField();
		jtf5=new JTextField();  
		jtf6=new JTextField();
		jtf7=new JTextField();
		jb1=new JButton("添加");

		jb1.addActionListener(this);  
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jp1=new JPanel();  
		jp2=new JPanel();	  
		jp3=new JPanel();
		//设置布局
		jp1.setLayout(new GridLayout(7,1)); 
		jp2.setLayout(new GridLayout(7,1));
		//添加组件
		jp1.add(jl1); 
		jp1.add(jl2);    
		jp1.add(jl3);
		jp1.add(jl4);   
		jp1.add(jl5);   
		jp1.add(jl6);
		jp1.add(jl7);
		
		jp2.add(jtf1);  
		jp2.add(jtf2);  
		jp2.add(jtf3);
		jp2.add(jtf4);  
		jp2.add(jtf5);  
		jp2.add(jtf6);
		jp2.add(jtf7);
		
		jp3.add(jb1);   
		jp3.add(jb2);
		
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		//展现
		this.setLocationRelativeTo(null);
		this.setSize(300,250);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true); 
		}
	   
	
	
	public void actionPerformed(ActionEvent e)
	{
		String sql="insert into goods values(?,?,?,?,?,?,?)";
		String[] paras={jtf1.getText(),jtf2.getText(),jtf3.getText(),
		jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText() };
		if(e.getSource()==jb1)
		{
			//希望添加
			sgt=new ShopperGoodTable(jtf3.getText());
			JOptionPane.showMessageDialog(this,"添加成功");
			this.dispose();
			
		}if(!sgt.updGoods(sql, paras))
		{
			JOptionPane.showMessageDialog(this,"添加失败");
			this.dispose() ;
		}
		//关闭对话框
		if(e.getSource()==jb2)
		{
			this.dispose();
		}
	    		
	    }
	    	
}
