package city;

import java.awt.*;
import java.util.*;

public class Building 
{
   private int baseX;     // center of building
   private int baseY;     // floor (bottom of building)
  
   private int height;    // height of building
   private int width;    // width of building
   
   private int type; // type of the building


    /**
     * The only constructor for the class, 
     * initializes all the private data,
     * @param int center, int bottom, int w, int size, int t
     */
   public Building (int center, int bottom, int w, int size, int t)
   {
      baseX = center;
      baseY = bottom;
      height = size;
      width = w;
      type = t;
   }


   /** Draws a building relative to the baseX, baseY, height, width, and type
      @param Graphics page
     * @return n/a 
      */
   public void draw (Graphics page)
   {
      //sets the buildings to be a dark gray
      page.setColor(new Color(44, 47, 58));

      //basic building - just a rectangle
      if (type == 0)
      {
          page.fillRect(baseX - width/2, baseY - height, width, height);
      }
      //a building with a smaller rectange on top
      else if (type == 1)
      {
          page.fillRect(baseX - width/2, baseY - height+20, width, height-20);
          //smaller rectangle
          page.fillRect(baseX - width/2+20, baseY - height, width-40, 20);
      }
      //a building that has two rectange cutouts on the side towards the top 
      else if (type == 2)
      {
          //bottom rectangle
          page.fillRect(baseX - width/2, baseY - height+40, width, height-40);
          //smaller rectangle
          page.fillRect(baseX - width/2+10, baseY - height+20, width-20, 20);
          //same width rectangle as the bottom rectangle to give illusion of cutouts 
          page.fillRect(baseX - width/2, baseY - height, width, 20);
      }
      //a building with a slanted roof
      else if (type == 3)
      {
          //base of building
          page.fillRect(baseX - width/2, baseY - height+width, width, height-width);
          //points for triangle on top of building
          int [] x = {baseX - width/2, baseX + width/2, baseX - width/2};
          int [] y = {baseY - height+width, baseY - height+width, baseY-height};
          //draws a triangle on top to give illusion of a slanted roof
          page.fillPolygon(x,y, 3);
      }
      //a needle type building with a hemisphere and rectangle in the middle
      else if (type == 4)
      {
          //bottom skinny rectangle
          page.fillRect(baseX - 10, baseY - 175, 20, 175);
          //wider rectangle in the middle, base for hemisphere
          page.fillRect(baseX - 40, baseY - 205, 80, 50);
          //hemisphere in the middle
          page.fillOval(baseX - 30, baseY - 235, 60, 60);
          //top skinny rectangle
          page.fillRect(baseX - 10, baseY - 405, 20, 175);
      }
      //a building with evenly spaced small square cutouts on the sides
      else if (type == 5)
      {
          //draws a bigger rectangle, then a small rectangle on top of each other 
          //repeatedly to give off the illusion of cutouts
          page.fillRect(baseX - width/2, baseY - 60, width, 60);
          page.fillRect(baseX - width/2+10, baseY - 70, width-20, 10);
          page.fillRect(baseX - width/2, baseY - 130, width, 60);
          
          page.fillRect(baseX - width/2+10, baseY - 140, width-20, 10);
          page.fillRect(baseX - width/2, baseY - 200, width, 60);
          
          page.fillRect(baseX - width/2+10, baseY - 210, width-20, 10);
          page.fillRect(baseX - width/2, baseY - 270, width, 60);
      }
      //a building with two little pillars towards the top
      else if (type == 6)
      {
    	  	//big rectangle at bottom
         page.fillRect(baseX - width/2, baseY - height+40, width, height-40);
         
         //two little pillars, should be symmetrical along baseX
         page.fillRect(baseX - 30, baseY - height+30, 10, 10);
         page.fillRect(baseX + 20, baseY - height+30, 10, 10);
         
         //little rectangle at top to form a top section, should have same width as first rectangle 
         page.fillRect(baseX - width/2, baseY - height, width, 30);
      }
   }
}