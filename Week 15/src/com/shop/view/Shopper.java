package com.shop.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.shop.model.UserModel;

public class Shopper extends JFrame implements ActionListener{

	JButton jb;
	JButton add,uptate,delete,find;
	JTextField jtf;
	JLabel jl1;
	JPanel jp,jp1;
	JScrollPane jsp;
	JTable jt;
	ShopperGoodTable sm;
	

	
	public Shopper(ShopperGoodTable sgt)
	{
		jp=new JPanel();
		jp1=new JPanel();
		
		jl1=new JLabel("��Ʒ���");
		jtf=new JTextField(20);
		find=new JButton("��ѯ");
		find.addActionListener(this);
		jp1.add(jl1);
		jp1.add(find);
		
		add=new JButton("�����Ʒ");
		add.addActionListener(this);
		jp.add(add);
		
		uptate=new JButton("�޸���Ʒ");
		uptate.addActionListener(this);
		jp.add(uptate);
		
		delete=new JButton("ɾ����Ʒ");
		delete.addActionListener(this);
		jp.add(delete);
		
		
		
		jb=new JButton("ע��");
		jb.addActionListener(this);
		jp.add(jb);
		
		
		
		this.add(jp,"South");
		
		

		jt=new JTable(sgt);
		jt.setRowSelectionAllowed(false);
		jt.setSelectionBackground(Color.red);
		jt.setSelectionForeground(Color.red);
		jt.setDragEnabled(false);
		
		
		jsp=new JScrollPane(jt);
		this.add(jsp);
		
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb)
		{
			this.dispose();
			new Login();
		}
		else if(e.getSource()==add)
		{
			String s=JOptionPane.showInputDialog("�̼��˺�");
			ShopperAddGoods sag=new ShopperAddGoods(this,"�����Ʒ",true);
			sm=new ShopperGoodTable(s);
			String paras[]={"1",s};
			sm.queryGoods("select * from goods where 1=? and shopperId=?", paras);
			jt.setModel(sm);
			
		}
		else if(e.getSource()==find)
		{
			String s=JOptionPane.showInputDialog("�̼��˺�");
			System.out.println("�û�ϣ����ѯ");	
			String goodId=this.jtf.getText().trim();
			String sql="select * from goods where goodId=? and shopperId=?";
			String paras[]={goodId,s};
			sm=new ShopperGoodTable(s);
			sm.queryGoods(sql,paras);
			jt.setModel(sm);
		}
		else if(e.getSource()==uptate)
		{
			String s=JOptionPane.showInputDialog("�̼��˺�");
			int rowNum=this.jt.getSelectedRow();
			if (rowNum==-1)	
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return ;
			}
			//��ʾ�޸ĶԻ���
			sm=new ShopperGoodTable(s);
			new ShopperUpdateGoods(this,"�޸���Ʒ",true,sm,rowNum);
			
			String [] paras2={"1",s};
			sm.queryGoods("select * from goods where 1=? and shopperId=?",paras2);
			jt.setModel(sm);	
		}
		else if(e.getSource()==delete)
		{
			int rowNum=this.jt.getSelectedRow();
			if (rowNum==-1)
			{
			//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return ;
			}
			
			String s=JOptionPane.showInputDialog("�̼��˺�");
			String goodId=(String)sm.getValueAt(rowNum,0);
			//����һ��sql���
			String sql="delete from goods where goodId=? and shopperId=?";
			String[]paras={goodId,s};
			sm=new ShopperGoodTable(s);
			sm.updGoods(sql,paras);
			String [] paras2={"1",s};
			sm.queryGoods("select * from goods where 1=? and shopperId=?",paras2); 
			jt.setModel(sm);
		}
	}





	

}
