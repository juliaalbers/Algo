package model;

import java.io.File;
import java.util.Vector;
import model.Swap;

public class Pictures{
	Vector<Pic> m_Pics;
	Swap m_Swap;
	Pic m_CenterImg;
	int m_CurrentCenterImg;
	
	public Pictures(){
		m_Pics = new Vector<Pic>();	
		m_Swap = new Swap(800, 600);
		m_CenterImg = new Pic();
		m_CurrentCenterImg = 0;
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

