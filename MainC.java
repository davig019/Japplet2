package Japplet2;
import java.applet.*;
import java.awt.*;

public class MainC extends Applet implements Runnable {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

int width, height;
   
   Thread t = null;
   
   Text txt;
   Text txt2;
   Image buffer;
   
   public void init() {
      
      width = 600;
      height = 600;
      setSize(width, height);
      setBackground( Color.black );
      
      buffer = createImage(width, height);
      
      txt = new Text("Hello", 100, 100);
      txt2 = new Text("GoodBye", 100, 150);
   }

   
   public void destroy() {
      System.out.println("destroy()");
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
      System.out.println("stop(): begin");
     
   }

   
   public void run() {
     
      try {
         while (true) {
            

            
            
          
               
            
            
            update();
            repaint();
            
            Thread.sleep( 10 );  
         }
      }
      catch (InterruptedException e) { }
      
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
}