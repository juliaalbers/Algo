package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener{
	
	public MyFrame(){
		super("");
		setLayout(new BorderLayout());
		
		
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

	}
	
	
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getSource());
	}
}
