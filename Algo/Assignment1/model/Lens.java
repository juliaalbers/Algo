package model;

import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Lens extends Swap {

	public Lens(int w, int h){
		super(w,h, null, null);
		
		//evtl in MyFrame auslagern???--------------------------------------
//		addMouseMotionListener(new MouseMotionAdapter(){
//			public void mouseMoved(MouseEvent e){
//				lens(e.getPoint());
//			}
//			
//		});
		
		//-----------------------------------------------------------------
	}
	
	public int[] lens(Point p, int [] Img1Pix, int[] Img2Pix, int[] pix){

		for(int x = 0; x < W; ++x){
			for(int y = 0; y < H; ++y){
				final int IDX = y * W + x;
				final int X_DIFF = p.x - x;
				final int Y_DIFF = p.y - y;
				final int VAL = (X_DIFF * X_DIFF + Y_DIFF * Y_DIFF) /100;
				final int MAX_VAL = VAL > 100 ? 100 : VAL;
				pix[IDX] = compPix(Img1Pix[IDX], Img2Pix[IDX], MAX_VAL);
				
			}
		}
		System.out.println("Nächstes Img berechnen");
		return pix;
	
		
		//in MyFrame packen
//		m_ImgSrc.newPixels();
//		repaint();
	}
	

}