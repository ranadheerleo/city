package city;

import java.awt.*;
import java.util.*;

public class GradientBackground 
{
  
   private int height;    // height of gradient
   private int width;    // width of gradient
   /**
     * The only constructor for the class, 
     * initializes all the private data,
     * @param int w, int size
     */
   public GradientBackground (int w, int size)
   {
      height = size;
      width = w;
   }


   /** Draws a gradient relative to the height and width
      @param Graphics page
     * @return n/a 
      */
   public void draw (Graphics page)
   {
      //sets initially blue value to be 0
      int b = 0;
      //increases the blue value gradually
      for (int y = 0; y < height; y+=5,b+=2)
      {
          page.setColor(new Color(0,0,b));
          //sets each color to have a height of 5 to have more weight and
          //not limit the gradient height to just 256
          page.fillRect(0, y, width, 5);
      }
   }
}