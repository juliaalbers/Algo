package controller;
import model.*;
import view.*;

public class MyController {
	Pictures m_Pictures;
	MyFrame m_Frame;
	
	MyController(){
		m_Pictures = new Pictures();
		m_Frame = new MyFrame(m_Pictures);
	}
	
	public static void main(String[] args) {
		new MyController();
	}

}
