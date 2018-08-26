package city;
import java.awt.*;

public class Car
{
   // Coordinates if car is drawn at position 0,0
   private int[] x = {0, 0, 20, 25, 70, 80, 105, 110};
   private int[] y = {35, 15, 15, 0, 0, 15, 15, 35};

   private int[] xCurrent = new int[x.length];
   private int[] yCurrent = new int[y.length];

   private int xOffset = 0, yOffset = 0;
   private Color carColor;

   //-----------------------------------------------------------------
   //  Sets up the graphical car with the specified offsets.
   //-----------------------------------------------------------------
   public Car(int xOff, int yOff, Color color)
   {
      xOffset = xOff;
      yOffset = yOff;
      carColor = color;
      
      for (int i=0; i < x.length; i++)
      {
         xCurrent[i] = x[i] + xOffset;
         yCurrent[i] = y[i] + yOffset;
      }
   }
   
   //HW:
   public int getXOffset() {return xOffset;}
   public int getYOffset() {return yOffset;}

   //-----------------------------------------------------------------
   //  Draws the car at a particular x and y offset.
   //-----------------------------------------------------------------
   public void draw(Graphics page)
   {
      page.setColor(carColor);
      page.fillPolygon(xCurrent, yCurrent, x.length);

      page.setColor(Color.black);
      page.fillOval(13+xOffset, 28+yOffset, 14, 14);  // rear wheel
      page.fillOval(83+xOffset, 28+yOffset, 14, 14);  // front wheel
      page.drawLine(15+xOffset, 18+yOffset, 15+xOffset, 3+yOffset);
   }
}
