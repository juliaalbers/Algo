package model;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.File;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Pic extends JComponent{
	public Image m_Img;
	public Image m_ImgBig;

	int[] m_Pixel;
	boolean m_Selected;

	final int H,W;
	MemoryImageSource m_MSrc;
	boolean m_Big;
	
	Pic(File file){
		W = 800;
		H = 600;
		m_Selected = false;
		m_Big = false;
		if(null != file){
			m_ImgBig = getToolkit().getImage(file.getAbsolutePath()).getScaledInstance(W,H, Image.SCALE_SMOOTH);
			m_Img = m_ImgBig.getScaledInstance(125, 75, Image.SCALE_SMOOTH);
		
			m_Pixel = new int[W * H];
			PixelGrabber grab = new PixelGrabber(m_ImgBig,0,0, W,H, m_Pixel, 0,W);
			try {
				grab.grabPixels();
			} catch (InterruptedException e) {}
			
			m_MSrc = new MemoryImageSource(W, H, m_Pixel, 0, W);
			m_MSrc.setAnimated(true);
			m_ImgBig = createImage(m_MSrc);
		}
		
		addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				if(m_Selected){
					m_Selected = false;
				}else{
					m_Selected = true;
				}
				repaint();
			}
		});
	}
	
	Pic(){
		this(null);
	}
	
	public void setBigImage() {
		m_Big = !m_Big;
	}
	
	public void paint(Graphics g){
		if(m_Big) {
			g.drawImage(m_ImgBig, 0, 0, getWidth(), getHeight(), this);
		} else {
			g.drawImage(m_Img, 0, 0, 125, 75, this);
			g.setColor(Color.red);
			if(m_Selected){
				for(int i = 0; i < 5; ++i){
					g.drawRect(i, i, 124-2*i, 74-2*i);
				}
			}
		}
		
	
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(m_Img.getWidth(this), m_Img.getHeight(this));
	}
}
