package Japplet2;
import java.awt.Color;
import java.awt.Graphics;


public class Text {

	private int x;
	private int y;
	private String text;
	private boolean forwards = true;
	
	public Text(String t, int a, int b){
		text = t;
		x = a;
		y = b;
	}
	
	public void update(int w){
		if (forwards){
		x+=5;	
		//System.out.println("x" + text + "" + x + "y" + y);	
			if( x > (w-(text.length()*8)) ){
				forwards = !forwards;
				
			}
		}else if(!forwards){
		x-=5;
		//System.out.println("x" + text + "" + x + "y" + y);
			if(x < 2){
				forwards = !forwards;
			}
		
		}
	}
	
	public void draw(Graphics g){
		
		if (forwards){
			g.setColor(Color.green);
		}else if (!forwards){
			g.setColor(Color.red);
		}
		
		g.drawString(text, x, y);
	}
	
}
