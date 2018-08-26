package city;

import javax.swing.*;
import java.awt.*;

public class UniversityPark {
	public static void main(String[] args) {
		JFrame frame = new JFrame("City Naperville");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CityPanel panel = new CityPanel();
		frame.getContentPane().add(panel);
	    frame.pack();
	    frame.setVisible(true);
	}
}