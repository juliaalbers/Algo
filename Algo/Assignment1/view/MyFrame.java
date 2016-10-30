package view;

import model.Pic;
import model.Pictures;
import model.Swap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;


@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener{
	private Pictures m_Pictures;
	Swap m_Swap;
	JPanel pa;
	
	public MyFrame(Pictures pic){
		super("");
		//Initialisierung MVC
		m_Pictures = pic;
		
		//Initialisierung Oberfl�che
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
	
	public void startSwap() {
		Vector<Pic> pv = m_Pictures.getPicVector();
		for(int i = 1; i < pv.size(); ++i) {
			if(pv.get(i).m_Selected == true) {
				m_Swap = new Swap(800, 600, pv.get(i).getPixel(), m_Pictures.getCenterImage().getPixel());
				Thread t = new Thread(new Runnable() {
		            @Override
		            public void run(){
		            	try {
		            		m_Swap.setPics(m_Pictures);
			            	for(int j = 0; j <= 100; j += 2) {
								m_Swap.shuffle(j);
								Thread.sleep(20);
							}
		            	} catch(InterruptedException e) {}
		            }
		        });
				t.start();
			}
		}
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("Bild");
		JMenu m2 = new JMenu("Zeichnen");
		JMenu m3 = new JMenu("Histogramm");
		JMenu m4 = new JMenu("Lupe");
		
		JMenuItem hin = new JMenuItem("Hinzuf�gen");
		JMenuItem start = new JMenuItem("Diashow starten");
		JMenuItem stop = new JMenuItem("Diashow stoppen");
		JMenuItem linien = new JMenuItem("Linien");
		JMenuItem kreis = new JMenuItem("Kreise");
		JRadioButtonMenuItem ausf = new JRadioButtonMenuItem("Kreise ausf�llen");
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
			startSwap();
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
			if(m_Pictures.getCenterImage() != null) {
				
				m_Pictures.calcColor(m_Pictures.getCenterImage());
				
				
				JTextArea ta = new JTextArea(1,m_Pictures.getColors().size());
				JScrollPane sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				ta.setEditable(false);
				ta.setText(""); //l�schen 
				
				for(int i = 0; i < m_Pictures.getColors().size(); ++i){
					String text = "Die Farbe " + m_Pictures.getColors().get(i)[0] + " ist " + m_Pictures.getColors().get(i)[1] + "-mal im Bild enthalten." ;
					ta.append(text + "\n");
				}
				
				JDialog dia = new JDialog();
				dia.setBounds(400, 400, 400, 400);
				dia.add(sp);
				dia.setVisible(true);
			}
			
		});
		
		lupe.addActionListener(e->{
			m_Pictures.setLensOn();
		});
		
//		addMouseMotionListener(new MouseMotionAdapter(){
//			public void mouseMoved(MouseEvent e){
//				if(lupe.getState()) {
//					
//					m_Pictures.getCenterImage().setPixel(m_Pictures.getLens().lens(e.getPoint(), m_Pictures.getCenterImage().getPixel(), m_Pictures.getPicVector().get(m_Pictures.getnextImg(m_Pictures.getCurrentCenterImg())).getPixel(),
//							m_Pictures.getCenterImage().getPixel()));
//					m_Pictures.getCenterImage().getMemoryImgSrc().newPixels();
//					repaint();
//				}
//			}	
//		});
		
		weiter.addActionListener(e->{
			m_Pictures.nextCenterImg();
			m_Pictures.changeCenterImg(m_Pictures.getPicVector().get(m_Pictures.getCurrentCenterImg()));
			repaint();
		});
		
	}
	
	public void update(Graphics g) {
		paint(g);
	}
}
