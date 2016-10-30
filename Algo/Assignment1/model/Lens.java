package model;

import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Lens extends Swap {

	public Lens(int w, int h){
		super(w,h, null, null);
	}
	
	
	/*	Irgendwie ist Img1Pix das gleiche wie Img2Pix!! 
	 * 
	 * Keine Ahung warum! :(
	 * 
	 * 
	 * */
	
	
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
		pix = Img2Pix;
		if(Img1Pix != Img2Pix) {
			System.out.println("Nicht Gleich :D");
		}else {
			System.out.println("GLEICH!!!!!");
		}
//		System.out.println("N�chstes Img berechnen");
		return pix;
	}
	

}