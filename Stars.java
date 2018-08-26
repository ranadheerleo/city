package city;

import java.awt.*;
import java.util.*;

public class Stars 
{
   //private data
   private int x; //beginning x coordinate of star cluster
   private int height; //height of star cluster (always start from the top of the window, or 0)
   private int num; //number of stars in cluster
   private int width; //width of star cluster
   private boolean fixed = true;
   private ArrayList<Integer> lx;
   private ArrayList<Integer> ly;

   /**
    * The only constructor for the class, 
    * initializes all the private data,
    * @param int x, int y, int number, int w
    */
   public Stars (int x, int y, int number, int w)
   {
      this.x = x;
      height = y;
      num = number;
      width = w;
      lx = new ArrayList<Integer>();
      ly = new ArrayList<Integer>();
      Random rand = new Random();
      for (int i = 0; i < num; i++) {
    	  	  //save the current starts	
          lx.add(rand.nextInt(width)+x);
          ly.add(rand.nextInt(height));
      }
   }

   public void setFixed(boolean f) {fixed = f;}
   /** Draws a star cluster relative to the x, height, num, width
   @param Graphics page
  * @return n/a 
   */
   public void draw (Graphics page)
   {
      
      page.setColor(Color.white);
      Random rand = new Random();
      
      //draws the amount of randomly placed stars specified by user
      for (int i = 0; i < num; i++)
      {
    	  //the random coordinates are generated to be within specified area given the height, width, and beginning of star cluster
    	  //all stars are little tiny squares
          if (fixed) {
        	  	page.fillRect(lx.get(i), ly.get(i), 2, 2); 
        	  	if (i%10 == 0) {
        	  		page.drawLine(lx.get(i)+x-4,ly.get(i), lx.get(i)+x+4, ly.get(i));
        	  		page.drawLine(lx.get(i)+x,ly.get(i)-4, lx.get(i)+x, ly.get(i)+4);
        	  	}
          }
          else {
        	    lx.set(i, rand.nextInt(width));
        	    ly.set(i, rand.nextInt(height));
        	  	page.fillRect(lx.get(i)+x, ly.get(i), 2, 2);
        	  //bigger star - in the shape of a tiny cross for variety 
        	      //generated randomly in the same way as the stars above
        	      int xStar = rand.nextInt(width)+x;
        	      int yStar = rand.nextInt(height);
        	      //horizantal line 
        	      page.drawLine(xStar+x-4,yStar, xStar+x+4, yStar);
        	      //vertical line
        	      page.drawLine(xStar+x,yStar-4, xStar+x, yStar+4);
          }
      }
      
      
    
    

   }
   
  
  
   
 
}