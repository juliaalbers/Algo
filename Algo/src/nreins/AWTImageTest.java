package nreins;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.*;
  
public class AWTImageTest
{
    public static void main(String[] args)
    {
    	Frame f = new Frame();
    	 AWTImageComponent component = new AWTImageComponent(f);
    	 AWTImageComponent component2 = new AWTImageComponent(f);
//        ScrollPane scrollPane = new ScrollPane();
//        scrollPane.add(component);
        f.setLayout(new FlowLayout());
        
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        f.add(component);
        f.add(component2);
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}
  
class AWTImageComponent extends Panel
{
    Image image;
  
    public AWTImageComponent(Frame father)
    {
//        loadImage();
    	try{
			FileDialog diag = new FileDialog(father);
			diag.setVisible(true);
			image = getToolkit().getImage(diag.getDirectory()+diag.getFile()).getScaledInstance(500,350, Image.SCALE_SMOOTH);
			diag.setFile(""); 
			
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(image, 0);
			mt.waitForAll();
			
		}catch(InterruptedException e) {}
    }
  
    public void paint(Graphics g)
    {
//      super.paint(g);
        g.drawImage(image, 0, 0, this);
    }
  
    /**
     * For the ScrollPane or other Container.
     */
    public Dimension getPreferredSize()
    {
        return new Dimension(image.getWidth(this), image.getHeight(this));
    }
  
    private void loadImage()
    {
        String fileName = "images/coyote.jpg";
        URL url = getClass().getResource(fileName);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        image = toolkit.getImage(url);
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(image, 0);
        try
        {
            tracker.waitForID(0);
        }
        catch(InterruptedException ie)
        {
            System.out.println("interrupt: " + ie.getMessage());
        }
    }
}
