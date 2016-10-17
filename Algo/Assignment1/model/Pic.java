package model;

import java.awt.*;
import java.io.File;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Pic extends JComponent{
	public Image m_Img;
	public Image m_ImgBig;
	int[] m_Pixel;
	
	Pic(File file){
		m_ImgBig = getToolkit().getImage(file.getAbsolutePath()).getScaledInstance(800,600, Image.SCALE_SMOOTH);
		m_Img = m_ImgBig.getScaledInstance(125, 75, Image.SCALE_SMOOTH);
	}
	
	public void paint(Graphics g){
		g.drawImage(m_Img, 0, 0, 125, 75, this);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(m_Img.getWidth(this), m_Img.getHeight(this));
	}
}
