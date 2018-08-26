package city;

import java.awt.*;
import java.util.*;

public class Trees 
{
   private int baseY;     // floor (bottom of the tree line)
   private int width;    // width of the tree line
   


   /**
     * The only constructor for the class, 
     * initializes all the private data,
     * @param int bottom, int w
     */
   public Trees (int bottom, int w)
   {
      baseY = bottom;
      width = w;
   }


   /** Draws a tree line relative to the baseY and width
      @param Graphics page
     * @return n/a 
      */
   public void draw (Graphics page)
   {
      //initial space from edge of treeline, increases as each tree is drawn
      int x = 20;
      
      //draws trees until the tree line reaches about the desired width
      while (x < width)
      {
          //tree trunk
          page.setColor(new Color (49, 16, 9));
          page.fillRect(x+15, baseY-20, 10, 20);
          
          //tree leaves
          page.setColor(new Color (1, 53, 9));
          page.fillOval(x,baseY-55, 40, 40);
          
          //spacing
          x += 100;
      }
        

   }
  
  
   
 
}