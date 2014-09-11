package com.shop.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class BackImage extends JPanel
{
	Image im;
	//¹¹Ôìº¯Êý
	public BackImage(String picture)
	{
		try {
			im=ImageIO.read(new File(picture));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(im, 0, 0, 360, 360, this);
		
	}
}
