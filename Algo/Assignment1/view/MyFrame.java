package view;

import model.Pictures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class MyFrame extends JFrame implements ActionListener{
	private Pictures m_Pictures;
	JPanel pa;
	public MyFrame(Pictures pic){
		super("");
		//Inizialisierung MVC
		m_Pictures = pic;
		
		//Inizialisierung Oberfläche
		setLayout(new BorderLayout());
		
		pa = new JPanel();
		pa.setLayout(new FlowLayout());
		pa.add(new Button("TEST"));
		
		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("Datei");
		JMenu subm = new JMenu("Bild");
		JMenuItem hin = new JMenuItem("Hinzufügen");
		setJMenuBar(mb);
		
		mb.add(m);
		m.add(subm);
		subm.add(hin);
		
		//Event-Listener 
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
		
		hin.addActionListener(e->{
			this.newPicture();
		});
		
//		pack();
		setSize(500,500);
		setVisible(true);
	}
		
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getSource());
	}
	
	private void newPicture(){
		//JFileChooser 
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("C:\\Users\\Julia\\Documents\\Pictures"));
		int result = fc.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			m_Pictures.addPics(fc.getSelectedFile());	//neues Pic mit ausgesuchtem File
		}
		//MediaTracker
		try{
			MediaTracker mt = new MediaTracker(this);
			for(int i = 0; i < m_Pictures.m_Pics.size(); ++i){
				mt.addImage(m_Pictures.m_Pics.get(i).m_Img, 0);
			}
			mt.waitForAll();
		}catch(InterruptedException e){}
		
		//Neue Pics ins Layout packen
		for(int i = 0; i < m_Pictures.m_Pics.size(); ++i){
//			m_Pictures.m_Pics.get(i).Mypaint(getGraphics());
			pa.add(m_Pictures.m_Pics.get(i));
		}
		add(pa, BorderLayout.SOUTH);
	}
}
