package model;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.PixelGrabber;
import java.io.File;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Pic extends JComponent{
	public Image m_Img;
	public Image m_ImgBig;
	public final int[] m_Pixel;
	boolean selected;
	final int H,W;
	
	Pic(File file){
		W = 800;
		H = 600;
		selected = false;
		m_ImgBig = getToolkit().getImage(file.getAbsolutePath()).getScaledInstance(W,H, Image.SCALE_SMOOTH);
		m_Img = m_ImgBig.getScaledInstance(125, 75, Image.SCALE_SMOOTH);
		
		m_Pixel = new int[W * H];
		PixelGrabber grab = new PixelGrabber(m_ImgBig,0,0, W,H, m_Pixel, 0,W);
		try {
			grab.grabPixels();
		} catch (InterruptedException e) {}
		
		
		addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				if(selected){
					selected = false;
				}else{
					selected = true;
				}
				repaint();
			}
		});
	}
	
	public void paint(Graphics g){
		g.drawImage(m_Img, 0, 0, 125, 75, this);
		g.setColor(Color.red);
		if(selected){
			for(int i = 0; i < 5; ++i){
				g.drawRect(i, i, 124-2*i, 74-2*i);
			}
		}
	
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(m_Img.getWidth(this), m_Img.getHeight(this));
	}
}
