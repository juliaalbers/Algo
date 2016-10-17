package view;

import model.Pictures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


@SuppressWarnings("serial")
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
		pa.setBackground(Color.blue);
		add(pa, BorderLayout.SOUTH);
		
		createMenu();
		
		//Event-Listener 
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
		
		pack();
//		setSize(500,500);
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
				mt.addImage(m_Pictures.m_Pics.get(i).m_Img, i);
			}
			mt.waitForAll();
		}catch(InterruptedException e){}
		
		//Neue Pics ins Layout packen
		for(int i = 0; i < m_Pictures.m_Pics.size(); ++i){
			this.pa.add(m_Pictures.m_Pics.get(i));
		
		}

	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("Bild");
		JMenu m2 = new JMenu("Zeichnen");
		JMenu m3 = new JMenu("Histogramm");
		JMenu m4 = new JMenu("Lupe");
		
		JMenuItem hin = new JMenuItem("Hinzufügen");
		JMenuItem start = new JMenuItem("Diashow starten");
		JMenuItem stop = new JMenuItem("Diashow stoppen");
		JMenuItem linien = new JMenuItem("Linien");
		JMenuItem kreis = new JMenuItem("Kreise");
		JRadioButtonMenuItem ausf = new JRadioButtonMenuItem("Kreise ausfüllen");
		JMenuItem histo = new JMenuItem("Anzeigen");
		JCheckBoxMenuItem lupe = new JCheckBoxMenuItem("Lupe an/aus");
		
		setJMenuBar(mb);
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		
		m1.add(hin);
		m1.add(start);
		m1.add(stop);
		
		m2.add(linien);
		m2.add(kreis);
		m2.addSeparator();
		m2.add(ausf);
		
		m3.add(histo);
		
		m4.add(lupe);

		
		hin.addActionListener(e->{
			this.newPicture();
			getContentPane().validate();
			getContentPane().repaint();
			pack();
		});
		
		start.addActionListener(e->{
			
		});
		
		stop.addActionListener(e->{
			
		});
		
		linien.addActionListener(e->{
			
		});
		
		kreis.addActionListener(e->{
			
		});
		
		ausf.addActionListener(e->{
			
		});
		
		histo.addActionListener(e->{
			
		});
		
		lupe.addActionListener(e->{
			
		});
	}
}
