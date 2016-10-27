package model;

import java.io.File;
import java.util.Vector;
import model.Swap;

import java.util.Arrays;

public class Pictures{
	Vector<Pic> m_Pics;
	Swap m_Swap;
	Pic m_CenterImg;
	int m_CurrentCenterImg;
	Vector<int[]> m_Colors;
	
	public Pictures(){
		m_Pics = new Vector<Pic>();	
		m_Swap = new Swap(800, 600);
		m_CenterImg = new Pic(null);
		m_CurrentCenterImg = 0;
		m_Colors = new Vector<int[]>(100,10000);
	}
	
	public void calcColor(Pic pic){
		int[] pixel = new int[m_Pics.get(0).W * m_Pics.get(0).H];
		pixel = pic.getPixel();
		Arrays.sort(pixel);
		
		//Vector löschen
		m_Colors.clear();
		
		//Vector m_Color füllen
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
		
		System.out.println(pic.getPixel()[0]);
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
	
	public Pic getCenterImage() {
//		if(m_Pics.size() != 0) {
			return m_CenterImg;
//		}
//		return null;
	}
	
	public void startSwap() {
		for(int i = 0; i < m_Pics.size(); ++i) {
			if(m_Pics.get(i).m_Selected == true) {
				m_Swap.shuffle(50, m_Pics.get(i).m_Pixel, getCenterImage().m_Pixel);
				m_Pics.get(0).m_Pixel = m_Swap.getNewPic();
			}
		}
	}
	
	public void changeCenterImg(Pic pic){
		m_CenterImg.m_ImgBig = pic.m_ImgBig;
		m_CenterImg.m_Pixel = pic.m_Pixel;
		
	}
	
	//addPics soll aufgerufen werden wenn das Menü "Hinzufügen" aufgerufen wird
	public void addPics(File[] file){
		for(int i = 0; i < file.length; ++i){
			m_Pics.add(new Pic(file[i]));	
		}
//		m_CenterImg.m_ImgBig = getPicVector().get(0).m_ImgBig;
		getPicVector().get(0).m_Selected = true;
	}
}

