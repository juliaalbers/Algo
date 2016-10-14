package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyFrame extends JFrame implements ActionListener{
	
	public MyFrame(){
		super("");
		setLayout(new BorderLayout());
		
		JPanel pa = new JPanel();
		pa.setLayout(new FlowLayout());
		
		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("Datei");
		JMenu subm = new JMenu("Bild");
		JMenuItem hin = new JMenuItem("Hinzufügen");
		setJMenuBar(mb);
		
		mb.add(m);
		m.add(subm);
		subm.add(hin);
		
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
		
		pack();
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getSource());
	}
}
