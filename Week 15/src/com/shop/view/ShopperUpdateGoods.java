package com.shop.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event. ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JDialog;


public class ShopperUpdateGoods extends JDialog implements ActionListener{
	//��������Ҫ��swing���
		JLabel jl1,jl2,jl3,jl4,jl5,jl6;
		JButton jb1,jb2;
		JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
		JPanel jp1,jp2,jp3;
		//owne ���ĸ�����
		//rtitle������
		//modelָ����ģʽ���ڣ����Ƿ�ģʽ�Ĵ���
		public ShopperUpdateGoods(Frame owner,String title,boolean model,ShopperGoodTable sgt,int rowNums)
		{
		super(owner,title,model);
		jl1=new JLabel("��Ʒ���");
		jl2=new JLabel("��Ʒ����");	
		jl3=new JLabel("����");
		jl4=new JLabel("��������");	
		jl5=new JLabel("��Ʒ����");
		jl6=new JLabel("�̼ұ��");
		
		jtf1=new JTextField();
		jtf1.setEditable(false);
		jtf1.setText((String)sgt.getValueAt( rowNums,0) );
		
		jtf2=new JTextField();
		jtf2.setText((String)sgt.getValueAt( rowNums,3) );
		
		jtf3=new JTextField();
		jtf3.setText(sgt.getValueAt( rowNums,4).toString());
		
		jtf4=new JTextField();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(sgt.getValueAt( rowNums,5));
		jtf4.setText(dateStr);
		
		jtf5=new JTextField();
		jtf5.setText(sgt.getValueAt( rowNums,6).toString() );
		
		jtf6=new JTextField();
		jtf6.setEditable(false);
		jtf6.setText((String)sgt.getValueAt( rowNums,2) );
		jb1=new JButton("�޸�");
		//ע�����
		jb1.addActionListener(this);  
		jb2=new JButton("ȡ��");
		jp1=new JPanel(); jp2=new JPanel();  
		jp3=new JPanel();
		//���ò���
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		//������
		jp1.add(jl1);   
		jp1.add(jl2); 	
		jp1.add(jl3);
		jp1.add(jl4);   
		jp1.add(jl5);   
		
		jp1.add(jl6);
		jp2.add(jtf1);  
		jp2.add(jtf2);  
		jp2.add(jtf3);
		jp2.add(jtf4);  
		jp2.add(jtf5);  
		jp2.add(jtf6);
		
		jp3.add(jb1);  
		jp3.add(jb2);
		
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		//չ��
		this.setSize(300,250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);}
		
		
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==jb1)
			{
			//��һ��sql
		    //�����������
				String sql ="update goods g,shopper s,shopperGoods sg set g.name=?,g.price=?,g.date=?,g.goodNo=?" +
				" where g.goodId=sg.goodId and g.shopperId=sg.shopperId and s.shopperId=sg.shopperId and sg.shopperId=? and sg.goodId=?";
				String []paras={jtf2.getText(),jtf3.getText(),
						jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf1.getText()};
				ShopperGoodTable sgt=new ShopperGoodTable(jtf6.getText());
				sgt.updGoods(sql,paras);
				this.dispose();
			}else if(e.getSource()==jb2)
			{
				this.dispose();
			}
		
		} 
	}
