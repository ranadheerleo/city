package city;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class CityPanel extends JPanel{
	private final int PANEL_WIDTH = 1000;
	private final int PANEL_HEIGHT = 500;
	private final int CITY_BOTTOM = 450;
	private Building b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
	private Road road; 
	private Stars s1; //, s2;
	private Trees trees;
	private Car car1, car2, car3;
	private final int DELAY = 20;
	private final int DELAY2 = 50;
	private int xc, yc, x = 80, d = 0;
	private final int SPEED = 2;
	
	private GradientBackground gb;
	private GradientBuilding gbuild1,gbuild2, gbuild3, gbuild4, gbuild5, gbuild6, gbuild7;
	   
	public CityPanel() {
		//setBackground(Color.black);
		//set size of window
	    setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
	    //set the gradient to be size of window
	    gb = new GradientBackground(PANEL_WIDTH, PANEL_HEIGHT);
	      
	    //first layers of buildings, which are all gradients
	    //creates buildings from left to right, 
	    //incrementing an variable that keeps track of the x coordinate of the next building to the right  
	    gbuild1 = new GradientBuilding (x+55, CITY_BOTTOM, 110, 330);
	    x += 100; //little overlap between buildings 
	    gbuild2 = new GradientBuilding (x+60, CITY_BOTTOM, 120, 350);
	    x += 100;
	    gbuild3 = new GradientBuilding (x+60, CITY_BOTTOM, 120, 300);
	    x += 160;
	    gbuild4 = new GradientBuilding (x+75, CITY_BOTTOM, 150, 400);
	    x += 200;
	    gbuild5 = new GradientBuilding (x+70, CITY_BOTTOM, 140, 370);
	    x += 100;
	    gbuild6 = new GradientBuilding (x+75, CITY_BOTTOM, 100, 330);
	    x += 150;
	    gbuild7 = new GradientBuilding (x+70, CITY_BOTTOM, 140, 220);
	    
	    //all of the buildings at the front, which should have 10 pixels of space between each building
	    //again, an variable is used to keep track of the x coordinate of the next building to the right
	    x = 10;
	    b1 = new Building (x+50, CITY_BOTTOM, 100, 300, 0);
	    x += 110;
	    b2 = new Building (x+60, CITY_BOTTOM, 120, 250, 1);
	    x += 130;
	    b3 = new Building (x+15, CITY_BOTTOM, 30, 70, 0);
	    x += 40;
	    b4 = new Building (x+40, CITY_BOTTOM, 80, 240, 2);
	    x += 90;
	    b5 = new Building (x+50, CITY_BOTTOM, 100, 320, 3);
	    x += 110;
	    //star cluster one, to the left of the really tall building 
	    //s1 = new Stars(0, 130, 8, x);
	    s1 = new Stars(0, 130, 18, PANEL_WIDTH); 
	    
	    //really tall building that seperates the two star clusters
	    b6 = new Building (x+40, CITY_BOTTOM, -1, -1, 4);
	    x += 90;
	      
	    //star cluster two, to the right of the really tall building 
	    //s2 = new Stars(x, 170, 8, 430);
	      
	    //rest of the buildings to the right of the really tall building
	    b7 = new Building (x+55, CITY_BOTTOM, 110, -1, 5);
	    x += 120;
	    b8 = new Building (x+30, CITY_BOTTOM, 60, 120, 0);
	    x += 70;
	    b9 = new Building (x+15, CITY_BOTTOM, 30, 40, 0);
	    x += 40;
	    b10 = new Building (x+50, CITY_BOTTOM, 100, 240, 6);
	    x += 110;
	      
	    //road and tree line that span the width of the window 
	    road = new Road(PANEL_WIDTH, PANEL_HEIGHT, 50);
	    trees = new Trees( CITY_BOTTOM, PANEL_WIDTH);
	    
	    //car1 = new Car(200, 150, Color.BLUE);
	    car2 = new Car(50, PANEL_HEIGHT - 45, Color.RED);
	    car3 = new Car(0, PANEL_HEIGHT - 75, Color.GREEN);
	    xc = 0;
	    yc = 220;
	    
	    ActionListener taskPerformer = new ActionListener() 
		  { 
			  public void actionPerformed(ActionEvent evt) 
				{
					xc = car3.getXOffset() + SPEED;
					yc = car3.getYOffset();
					if (xc > getWidth()) xc = 0;
					car3 = new Car(xc, yc, Color.GREEN);
					xc = car2.getXOffset() + SPEED + 5;
					if (xc > getWidth()) xc = 0;
					yc = car2.getYOffset();
					car2 = new Car(xc, yc, Color.RED);
					//s1 = new Stars(0, 130, 8, 500);
					repaint();
				}
		  };
		  new Timer(DELAY, taskPerformer).start();
	}

	public void paintComponent(Graphics page) {
	      super.paintComponent(page);
		   //draws the gradient background first because it should be the background
	      gb.draw(page);
	       
	      //draws the gradient builldings before the buildings so the gradient buildings will be in the background
	      gbuild1.draw(page);
	      gbuild2.draw(page);
	      gbuild3.draw(page);
	      gbuild4.draw(page);
	      gbuild5.draw(page);
	      gbuild6.draw(page);
	      gbuild7.draw(page);
	      
	    //star clusters on top
	      d++;
	      if (d >= 71 ) {
	    	  	s1.setFixed(false);
	    	  	//s2.setFixed(false);
	    	  	d = 0;
	      }
	      s1.draw(page);
  	  	  //s2.draw(page);
  	  	  s1.setFixed(true);
  	  	  //s2.setFixed(true);
	      
	      //front building line 
	      b1.draw (page);
	      b2.draw (page);
	      b3.draw (page);
	      b4.draw (page);
	      b5.draw (page);
	      b6.draw (page);
	      b7.draw (page);
	      b8.draw (page);
	      b9.draw (page);
	      b10.draw (page);
	      
	      //road at the bottom
	      road.draw(page);
	      
	      
	      //tree line in front of building, on top of the road
	      trees.draw(page);
	      
	      //car1.draw(page);	      
	      car3.draw(page);
	      car2.draw(page);
	      
	      //redraws the star clusters (the animation part of the progam)
	      //since each star is drawn randomly, each time the star cluster is redrawn, 
	      //the stars should be in different locations, which makes it look like the stars are moving 
	      /*try {
	          Thread.sleep(500); //sleep for 500 miliseconds so the stars don't move too crazily 
	        }
	      catch (InterruptedException e) {}
	      s1.draw(page);
	      repaint(); */
	}
}