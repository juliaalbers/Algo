package model;

import java.io.File;
import java.util.Vector;

public class Pictures{
	public Vector<Pic> m_Pics;
	
	public Pictures(){
		m_Pics = new Vector<Pic>();
	}
	
	//addPics soll aufgerufen werden wenn das Menü "Hinzufügen" aufgerufen wird
	public void addPics(File file){
		m_Pics.add(new Pic(file));
	}
}

