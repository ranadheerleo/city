package city;

import java.awt.*;
import java.util.*;

public class GradientBuilding 
{
   private int baseX;     // center of building
   private int baseY;     // floor (bottom of building)
   private int height;    // height of building
   private int width;    // height of building
   
   /**
     * The only constructor for the class, 
     * initializes all the private data,
     * @param int center, int bottom, int w, int size
     */
   public GradientBuilding (int center, int bottom, int w, int size)
   {
      baseX = center;
      baseY = bottom;
      height = size;
      width = w;

   }


   /** Draws a gradient building relative to the baseX, baseY, height, width
      @param Graphics page
     * @return n/a 
      */
   public void draw (Graphics page)
   {
      //this is the rgb value for all colors to have all colors produced be gray
      //since r, g, b values are the same for each color
      int x = 0;
      //starts from the top of the building and draws down
      //the rgb (x) value increases to go from black to white
      for (int y = height; y > 0; y-=5,x++)
      {
          page.setColor(new Color(x,x,x));
          //sets each color to have a height of 5 to have more weight and
          //not limit the gradient height to just 256
          page.fillRect(baseX - width/2, baseY-y, width, 5);
        }
      
      
     
    
    

   }
  
  
   
 
}