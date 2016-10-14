package nreins;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;

import javax.swing.*;

public class Pics extends Component{
	Image m_Img;
	Boolean bigPic;
	ActionListener actionListener;
	File m_File;
	int[] m_int;
	
	
	Pics(Frame father){
		bigPic = false;
		try{
			JFileChooser diag = new JFileChooser();
			diag.setCurrentDirectory(new File("C:\\Users\\Julia\\Documents\\Pictures"));
			int result = diag.showOpenDialog(father);
			if(result == JFileChooser.APPROVE_OPTION){
				m_File = diag.getSelectedFile();
				m_Img = getToolkit().getImage(m_File.getAbsolutePath()).getScaledInstance(800,600, Image.SCALE_SMOOTH);;
			}
				
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(m_Img, 0);
			mt.waitForAll();
			
		}catch(InterruptedException e) {}
		
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseReleased(MouseEvent e){
				if(!bigPic){
					
					released();
					
				}
			}
		});
	}
	
	public void addActionListener(ActionListener l){
		actionListener = AWTEventMulticaster.add(actionListener, l);
	}
	
	private void released(){
		if(bigPic){
			bigPic = false;
		}else{
			bigPic = true;
		}
		repaint();
		if(actionListener != null){
			actionListener.actionPerformed(
					new ActionEvent(this,ActionEvent.ACTION_PERFORMED, "Bild 1"));
		}
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(m_Img.getWidth(this), m_Img.getHeight(this));
	}
	
	public void paint(Graphics g){
		if(bigPic){
			g.drawImage(m_Img,0,0,getWidth(), getHeight(), this);
		}else{
			g.drawImage(m_Img, 0, 0, 125, 75, this);
		}
	}
	
	public static void main(String[] args){
		new MyFrame();
	}
}

class MyFrame extends JFrame implements ActionListener{
	Pics MainImage;
	
	
	public MyFrame(){
		super("");
		setLayout(new BorderLayout());
		pic1 = new Pics(this);
		pic2 = new Pics(this);
		pic3 = new Pics(this);

		MainImage = pic1;
		MainImage.bigPic=true;
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		

		p.add(pic1);
		p.add(pic2);
		p.add(pic3);
		add(p, BorderLayout.SOUTH);
		add(MainImage, BorderLayout.CENTER);
		
//		pic1.addActionListener(this);
//		pic2.addActionListener(this);
		
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
		
//		setSize(1000,700);
		pack();
		setVisible(true);
	}
	
	public void switchPics() {
		
	}
	

	
	public void actionPerformed(ActionEvent e){
//		MainImage =  e.getSource();
		System.out.println(e.getSource());
	}
	
}
