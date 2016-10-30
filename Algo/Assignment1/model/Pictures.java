package model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.util.Vector;
import model.Swap;

import java.util.Arrays;

public class Pictures{
	Vector<Pic> m_Pics;
	Swap m_Swap;
	Lens m_Lens;
	Pic m_CenterImg;
	int m_CurrentCenterImg;
	Vector<int[]> m_Colors;
	boolean m_LensOn;
	
	
	public Pictures(){
		m_Pics = new Vector<Pic>();	
		m_Lens = new Lens(800,600);
		m_CenterImg = new Pic(null);
		m_CurrentCenterImg = 0;
		m_Colors = new Vector<int[]>(100,10000);
		
		m_CenterImg.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e){
				if(m_LensOn) {
					
					getCenterImage().setPixel(
							getLens().lens(
									e.getPoint(),
									getCenterImage().getPixel(), 
									getPicVector().get(getnextImg(getCurrentCenterImg())).getPixel(),
									getCenterImage().getPixel()));
					getCenterImage().getMemoryImgSrc().newPixels();
					m_CenterImg.validate();
					m_CenterImg.repaint();
				}
			}	
		});
		
	}
	// Für das Histogramm
	public void calcColor(Pic pic){
		int[] pixel = new int[m_Pics.get(0).W * m_Pics.get(0).H];
		pixel = pic.getPixel();
		Arrays.sort(pixel);
		
		//Vector löschen
		m_Colors.clear();
		
		//Vector m_Color fï¿½llen
		int[] tmp = {pixel[0],1};
		m_Colors.add(tmp);
		for(int i = 1;i < pixel.length; ++i){
			if(tmp[0] == pixel[i]){
				m_Colors.lastElement()[1] += 1;
			}else{
				tmp = new int[2];
				tmp[0] = pixel[i];
				tmp[1] = 1;
				m_Colors.add(tmp);
			}
		}
		

	}
	
	public void setLensOn() {
		 m_LensOn = !m_LensOn;
	}
	
	public Lens getLens() {
		return m_Lens;
	}
	
	public Vector<int[]> getColors(){
		return m_Colors;
	}
	
	public Vector<Pic> getPicVector(){
		return m_Pics;
	}
	
	public int getCurrentCenterImg(){
		return m_CurrentCenterImg;
	}
	
	public void nextCenterImg(){
//		while(m_Pics.get(m_CurrentCenterImg+1).m_Selected == false){
//			m_CurrentCenterImg++;
//		}
		if(m_CurrentCenterImg < m_Pics.size()-1){
			m_CurrentCenterImg++;
		}else{
			m_CurrentCenterImg = 0;
		}
		
		if(m_Pics.get(getCurrentCenterImg()).m_Selected == false){
			nextCenterImg();
		}	
	}
	
	public int getnextImg(int current) {
		int next = current;

		if(current < m_Pics.size()-1){
			next++;
		}else{
			next = 0;
		}
		
		if(m_Pics.get(next).m_Selected == false){
			return getnextImg(next);
		}else {
			return next;
		}
	}
	
	public Pic getCenterImage() {
//		if(m_Pics.size() != 0) {
			return m_CenterImg;
//		}
//		return null;
	}
	
	public void setCenterImagePixel(int[] p) {
		m_CenterImg.m_Pixel = p;
		m_CenterImg.getMemoryImgSrc().newPixels();
	}
	
	public void startLens() {
		//Bedingung: Keine Diashow
		
	}
	
	public void changeCenterImg(Pic pic){
		m_CenterImg.m_ImgBig = pic.m_ImgBig;
		m_CenterImg.m_Pixel = pic.m_Pixel;
		
	}
	
	//addPics soll aufgerufen werden wenn das Menï¿½ "Hinzufï¿½gen" aufgerufen wird
	public void addPics(File[] file){
		for(int i = 0; i < file.length; ++i){
			m_Pics.add(new Pic(file[i]));	
		}
//		m_CenterImg.m_ImgBig = getPicVector().get(0).m_ImgBig;
		getPicVector().get(0).m_Selected = true;
	}
}

