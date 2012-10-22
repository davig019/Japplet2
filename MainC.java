package Japplet2;
import java.applet.*;
import java.awt.*;

public class MainC extends Applet implements Runnable {

   int width, height;
   boolean drawOnce = true;
   Thread t = null;
   
   Text txt;
   Text txt2;

   
   public void init() {
      
      width = getSize().width;
      height = getSize().height;
      setBackground( Color.black );
      
      
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
            
            t.sleep( 10 );  
         }
      }
      catch (InterruptedException e) { }
      
   }

  
   
   
   
   
   
   
   
   
  public void update(){
	   txt.update(width);
	   txt2.update(width);
   }
   
   
   
   
   
   public void paint( Graphics g ) {
	   g.setColor( Color.green );
	   if (drawOnce){
		   g.drawRect(0, 0, width - 3, height - 3);
	   }
	   
      
      
	   txt.draw(g);
	   txt2.draw(g);
      
      
   }
}