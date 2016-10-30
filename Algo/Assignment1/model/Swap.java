package model;

import java.awt.*;

public class Swap {
	final int W, H;
	int[] m_ImgPix, m_Img1, m_Img2;
	Pictures m_Pics;
	
	
	public Swap(int w, int h, int[] img1, int[] img2) {
		W = w;
		H = h;
		m_Img1 = img1;
		m_Img2 = img2;
		m_ImgPix = new int[W*H];
	}
	
	private int compColor(int x1, int x2, int p) {
		return x1+(x2-x1)*p/100;
	}
	
	private int compPix(int pix1, int pix2, int p) {
		final int RED = compColor((pix1 >> 16) & 0xff, (pix2 >> 16) & 0xff, p);
		final int GREEN = compColor((pix1 >> 8) & 0xff, (pix2 >> 8) & 0xff, p);
		final int BLUE = compColor(pix1 & 0xff, pix2 & 0xff, p);
		return 0xff000000 | (RED << 16) | (GREEN << 8) | BLUE;
	}
	
	public void shuffle(int p) {
		for(int i = 0; i < W; ++i) {
			m_ImgPix[i] = compPix(m_Img1[i], m_Img2[i], p);
		}
		System.out.println(p);
		m_Pics.setCenterImagePixel(m_ImgPix);
	}
	
	public void setPics(Pictures p) {
		m_Pics = p;
	}
	
	public Dimension getPreferredSize() {
		return getMinimumSize();
	}
	
	public Dimension getMinimumSize() {
		return new Dimension(W, H);
	}
	
	
	
	public int[] getNewPic() {
		return m_ImgPix;
	}
}
