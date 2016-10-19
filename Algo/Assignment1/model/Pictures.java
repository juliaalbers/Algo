package model;

import java.io.File;
import java.util.Vector;
import model.Swap;

public class Pictures{
	public Vector<Pic> m_Pics;
	Swap m_Swap;
	
	public Pictures(){
		m_Pics = new Vector<Pic>();	
		m_Swap = new Swap(800, 600);
	}
	
	public Pic getCenterImage() {
		if(m_Pics.size() != 0) {
			return m_Pics.get(0);
		}
		return null;
	}
	
	public void startSwap() {
		for(int i = 0; i < m_Pics.size(); ++i) {
			if(m_Pics.get(i).m_Selected == true) {
				m_Swap.shuffle(50, m_Pics.get(i).m_Pixel, getCenterImage().m_Pixel);
				m_Pics.get(0).m_Pixel = m_Swap.getNewPic();
			}
		}
	}
	
	//addPics soll aufgerufen werden wenn das Menü "Hinzufügen" aufgerufen wird
	public void addPics(File[] file){
		for(int i = 0; i < file.length; ++i){
			m_Pics.add(new Pic(file[i]));
			
		}
	}
}

