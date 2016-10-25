package view;

import model.Pic;
import model.Pictures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener{
	private Pictures m_Pictures;
	JPanel pa;
	Pic m_CenterImage;
	
	public MyFrame(Pictures pic){
		super("");
		//Initialisierung MVC
		m_Pictures = pic;
		
		//Initialisierung Oberfläche
		setLayout(new BorderLayout());
		pa = new JPanel();
		pa.setLayout(new FlowLayout());
		pa.setBackground(Color.blue);
		
		this.add(m_Pictures.getCenterImage(), BorderLayout.CENTER);
		m_Pictures.getCenterImage().setBigImage();
		
		JScrollPane sp = new JScrollPane(pa, JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(sp, BorderLayout.SOUTH);
		
		createMenu();
		
		//Event-Listener 
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
		
		setBounds(500, 200, 500, 500);
		setVisible(true);
	}
		
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getSource());
	}
	
	private void newPicture(){
		//JFileChooser 
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("C:\\Users\\Julia\\Documents\\Pictures"));
		fc.setMultiSelectionEnabled(true);
		int result = fc.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			m_Pictures.addPics(fc.getSelectedFiles());	//neues Pic mit ausgesuchtem File
		}
		//MediaTracker
		try{
			MediaTracker mt = new MediaTracker(this);
			for(int i = 0; i < m_Pictures.getPicVector().size(); ++i){
				mt.addImage(m_Pictures.getPicVector().get(i).getImg(), i);
			}
			mt.waitForAll();
		}catch(InterruptedException e){}
		
		//Neue Pics ins Layout packen
		for(int i = 0; i < m_Pictures.getPicVector().size(); ++i){
			this.pa.add(m_Pictures.getPicVector().get(i));
		
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
		
		JMenuItem weiter = new JMenuItem("Weiter");
		
		setJMenuBar(mb);
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		
		m1.add(hin);
		m1.add(start);
		m1.add(stop);
		
		m1.add(weiter);
		
		m2.add(linien);
		m2.add(kreis);
		m2.addSeparator();
		m2.add(ausf);
		
		m3.add(histo);
		
		m4.add(lupe);

		
		hin.addActionListener(e->{
			this.newPicture();

		
			m_Pictures.changeCenterImg(m_Pictures.getPicVector().get(m_Pictures.getCurrentCenterImg()));
//			m_CenterImage = addCenterImage();
//			if(m_CenterImage != null) {
//				add(m_CenterImage, BorderLayout.CENTER);
//			}

			getContentPane().validate();
			getContentPane().repaint();
		});
		
		start.addActionListener(e->{
			m_Pictures.startSwap();
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
//			if(m_CenterImage != null) {
				m_Pictures.calcColor(m_Pictures.getCenterImage());
				
				JFrame dia = new JFrame();
				dia.setBounds(400, 400, 400, 400);
				JScrollPane sp = new JScrollPane();
				JPanel p = new JPanel();
				p.setLayout(new FlowLayout());
				
				System.out.println(String.valueOf(m_Pictures.getColors().get(0)[1]));	
				for(int i = 0; i < m_Pictures.getColors().size(); ++i) {
					JTextField t = new JTextField(20);
					JTextField t2 = new JTextField(20);
					JTextField t3= new JTextField(20);
					t.setText(String.valueOf(m_Pictures.getColors().get(i)[0]));
					t2.setText(String.valueOf(m_Pictures.getColors().get(i)[1]));
					t3.setText("Fick deine Mutter");
					p.add(t);
					p.add(t2);
					p.add(t3);
				}
				
				
				p.setBackground(new Color(m_Pictures.getColors().get(0)[0]));
				sp.add(p);
				dia.add(p);
				dia.setVisible(true);
//			}
			
		});
		
		lupe.addActionListener(e->{
			
		});
		
		weiter.addActionListener(e->{
			m_Pictures.nextCenterImg();
			m_Pictures.changeCenterImg(m_Pictures.getPicVector().get(m_Pictures.getCurrentCenterImg()));
			repaint();
		});
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
//	private Pic addCenterImage() {
//		if(m_CenterImage != m_Pictures.getCenterImage()) {
//			m_CenterImage = m_Pictures.getCenterImage();
//			m_CenterImage.setBigImage();
//		}
//
//		if(m_CenterImage == null) {
//			return null;
//		}
//
//		return m_CenterImage;
//	}
}
