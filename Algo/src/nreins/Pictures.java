package nreins;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;


class Shuffle extends Component {
	final int W = 500; final int H = 300;
	Image m_Img1,m_Img2,m_Img;
	int[] m_Img1Pix = new int[W*H]; int[] m_Img2Pix = new int[W*H];
	int[] m_Pix = new int[W*H]; MemoryImageSource m_ImgSrc;
	
	public Shuffle(Frame father) {
		try {
			FileDialog diag = new FileDialog(father);
			diag.setVisible(true);
			m_Img1 = getToolkit().getImage(diag.getDirectory()+diag.getFile()).getScaledInstance(W,H, Image.SCALE_SMOOTH);
			diag.setFile(""); 


			MediaTracker mt = new MediaTracker(this);
			mt.addImage(m_Img1,0);
//			mt.addImage(m_Img2,0);
			mt.waitForAll();
//			PixelGrabber grab1 = new PixelGrabber(m_Img1,0,0,W,H,m_Img1Pix,0,W);
//			
//			grab1.grabPixels();
//			
//			m_ImgSrc = new MemoryImageSource(W,H,m_Img1Pix,0,W);
//			m_ImgSrc.setAnimated(true);
//			m_Img = createImage(m_Img1);
			
		} catch (InterruptedException e) {}
	}
	public void paint(Graphics g) {g.drawImage(m_Img1,0,0, getWidth(),getHeight(),this);}
	
//	public Dimension getPreferredSize() {return getMinimumSize();}
//	public Dimension getMinimumSize() { return new Dimension(W,H);}
//	
//	private int compColor(int x1,int x2,int p) { return x1+(x2-x1)*p/100; }
//	private int compPix(int pix1,int pix2,int p) {
//		final int RED = compColor((pix1 >> 16) & 0xff,(pix2 >> 16) & 0xff,p);
//		final int GREEN = compColor((pix1 >> 8) & 0xff,(pix2 >> 8) & 0xff,p);
//		final int BLUE = compColor(pix1 & 0xff,pix2 & 0xff,p);
//		return 0xff000000 | (RED << 16) | (GREEN << 8) | BLUE;
//	}
//	public void shuffle(int p) {
//		for(int i = 0;i < W*H;++i) {
//			m_Pix[i] = compPix(m_Img1Pix[i],m_Img2Pix[i],p);
//		}
//		m_ImgSrc.newPixels();
//		repaint();
//	}
}

class Pictures extends Frame {
	public Pictures() {
		super("Hey, pictures ...");
		setLayout(new BorderLayout());
		final Shuffle SHUF = new Shuffle(this);
		final Scrollbar BAR = new Scrollbar(Scrollbar.HORIZONTAL,100,1,0,101);
		final Label LAB = new Label("100 %"); Panel pan = new Panel();
		pan.setLayout(new BorderLayout());
		add(BorderLayout .CENTER,SHUF); add(BorderLayout.SOUTH,pan);
		pan.add(BorderLayout.CENTER,BAR); pan.add(BorderLayout.EAST,LAB);
		BAR.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
//					SHUF.shuffle(BAR.getValue()); LAB.setText(BAR.getValue() + "%");
			}
		});
		setSize(500,300);
		setVisible(true);
//		SHUF.shuffle(100);
	}
	public void update(Graphics g) {paint(g);}
	public static void main(String[] args) throws Exception {
		new Pictures();
	}
}













//@SuppressWarnings("serial")
//class Pic extends Component {
//	Image m_img1;
//	MemoryImageSource m_ImgSrc;
//	
//	Pic(Frame father) throws InterruptedException{
//		FileDialog f = new FileDialog(father);
//		
//		m_img1 = getToolkit().getImage(f.getDirectory()+f.getFile()).getScaledInstance(500,500,Image.SCALE_SMOOTH);
//		f.setFile("");
//		f.setVisible(true);
//		
////		MediaTracker mt = new MediaTracker(this);
////		mt.addImage(m_img1, 0);
////		mt.waitForAll();
////		m_ImgSrc = new MemoryImageSource(500,500,m_Pix,0,500);
////		m_ImgSrc.setAnimated(true);
////		m_Img = createImage(m_imgSrc);
//	}
//	
//	public void paint(Graphics g){
//		g.drawImage(m_img1, 0, 0,500, 500, this);
//	}
//	
//	
//	
//	
//}
//
//public class Pictures extends Frame{
//	public Pictures() throws InterruptedException{
//		super("ZEIG MIR DAS BILD!");
//		setLayout(new BorderLayout());
//		final Pic p = new Pic(this);
//		add(BorderLayout.CENTER, p);
//		setSize(500,500);
//		setVisible(true);
//	}
//	public void update(Graphics g){paint(g);}
//	
//	public static void main(String[] args) throws InterruptedException{
//		new Pictures();
//	}
//}
