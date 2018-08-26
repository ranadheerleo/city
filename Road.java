package city;
import java.awt.*;
import java.util.*;

public class Road 
{
   private int baseY;     // bottom of the road
   private int height;    // height of the road
   private int width;    // width of the road
   


   /**
     * The only constructor for the class, 
     * initializes all the private data,
     * @param int w, int bottom, int size
     */
   public Road (int w, int bottom, int size)
   {
      baseY = bottom;
      height = size;
      width = w;
   }


  /** Draws a road relative to the width, baseY, and height
      @param Graphics page
     * @return n/a 
      */
   public void draw (Graphics page)
   {
      //the basic gray road, without any other lines
      page.setColor(Color.gray);
      page.fillRect(0, baseY-height, width, height);
      
      //add yellow lines
      int x = 0; //increases as yellow lines are drawn
      //draws yellow lines until the yellow lines reaches about the road width
      while (x < width)
      {
          x += 10; 
          page.setColor(Color.yellow);
          //the yellow line is really a rectangle to have more weight
          //centered to middle of the width of the road
          page.fillRect(x, baseY-height/2-2, 20, 4);
          x+=20;
      }
      
    
    

    }
  
  
   
 
}