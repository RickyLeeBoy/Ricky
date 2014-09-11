package com.shop.view;

import java.awt.*;
import java.io.*;

import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;

public class Index extends JWindow implements Runnable{

	
	PaintCom pc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Index i=new Index();
		Thread t=new Thread(i);
		t.start();
		
	}
	
	public Index()
	{
		pc=new PaintCom();
		this.add(pc);
		this.setSize(360,360);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(3500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��ת����½����
			System.out.println("��������");
			new Login();
			this.dispose();
			
			break;
		}
	}

}


class PaintCom extends JPanel
{
	Font f1=new Font("����",Font.PLAIN,50);
	Font f2=new Font("����", Font.BOLD, 40);
	String s1=new String("��ӭ����");
	String s2=new String("У԰С�̳�");
	public void paint(Graphics g)
	{
		Image im = null;
		try {
			im=ImageIO.read(new File("IndexPic.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(im, 0, 0, 360, 360, this);
		g.setColor(Color.RED);
		g.setFont(f2);
		g.drawString(s1,40,50);
		g.setColor(Color.BLUE);
		g.setFont(f1);
		g.drawString(s2, 40, 150);
		
	}

}