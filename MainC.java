package Japplet2;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class MainC extends Applet implements Runnable,MouseListener {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

int width, height;
   
   Thread t = null;
   
   Text txt;
   Text txt2;
   Image buffer;
   int refresh = 100;
   boolean state;
   
   
   public void init() {
      
      width = 600;
      height = 300;
      setSize(width, height);
      setBackground( Color.black );
      state = false;
      buffer = createImage(width, height);
      addMouseListener( this );
      txt = new Text("Hello", 100, 100);
      txt2 = new Text("GoodBye", 100, 150);
   }

   
   public void destroy() {
      ;
   }

   
   public void start() {
      
      if ( t == null ) {
         
         t = new Thread( this );        
         t.start();
         
      }
      else {
         
            ;
            
            synchronized( this ) {
               notify();
            
         }
      }
     
   }

 
   public void stop() {
      ;
     
   }

   
   public void run() {
     
      try {
         while (true) {
            

            update();
            repaint();
            
            Thread.sleep( refresh );  
         }
      }
      catch (InterruptedException e) { }
      
   }

  
   
   
   
   public void update(Graphics g){
	   paint(g);
   }
   
   
   
   
  public void update(){
	   txt.update(width);
	   txt2.update(width);
   }
   
   
   
   
   
   public void paint( Graphics g ) {
	   Graphics bg = buffer.getGraphics();
	   bg.clearRect(0, 0, width, height);
	   bg.setColor( Color.green );
	   bg.drawRect(0, 0, width - 3, height - 3);
	   
	   
	  
      
      
	   txt.draw(bg);
	   txt2.draw(bg);
      
	   g.drawImage(buffer, 0, 0, null);
	   g.dispose();
   }


public void toggleSpeed(){
	if (state){
		refresh = 10;
	}else if(!state){
		refresh = 50;
	}
}
	


public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



public void mousePressed(MouseEvent e) {
	state = !state;
	toggleSpeed();
	
}



public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}