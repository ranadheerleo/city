package city;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CarPanel extends JPanel{
	   private Car car1, car2, car3;
	   private final int DELAY = 20;
	   private int x, y;
	   private final int SPEED = 2;
       public CarPanel ()
	   {
	      car1 = new Car(200, 150, Color.BLUE);
	      car2 = new Car(50, 50, Color.RED);
	      car3 = new Car(0, 220, Color.GREEN);
	      x = 0;
	      y = 220;
		  setPreferredSize(new Dimension(450, 300));
		  
		  ActionListener taskPerformer = new ActionListener() 
		  { 
			  public void actionPerformed(ActionEvent evt) 
				{
					x = car3.getXOffset() + SPEED;
					y = car3.getYOffset();
					if (x > getWidth()) x = 0;
					car3 = new Car(x, y, Color.GREEN);
					x = car2.getXOffset() + SPEED + 5;
					if (x > getWidth()) x = 0;
					y = car2.getYOffset();
					car2 = new Car(x, y, Color.RED);
					repaint();
				}
		  };
			
		  new Timer(DELAY, taskPerformer).start();

	   }

 	   //-----------------------------------------------------------------
	   //  Draws the car.
	   //-----------------------------------------------------------------
	   public void paint(Graphics page)
	   {
		  super.paint(page);
	      car1.draw(page);
	      car2.draw(page);
	      car3.draw(page);
	   }
}
