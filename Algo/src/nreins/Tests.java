package nreins;

import javax.swing.*;
import java.awt.*;

public class Tests extends JFrame {
	
	Tests(){
		JFileChooser diag = new JFileChooser();
		diag.showOpenDialog(this);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String [] args){
		new Tests();
	}
}




