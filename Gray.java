/*
 * Author: Greg Ryan
 * Email: gfryan19@g.holycross.edu
 * Written: 9/25/2015
 *
 * Description: Opens an existing image in jpg format and converts it from its
 *              regular colors to grayscale.
 *
 * Example: java Gray Bruins.jpg
 *
 *---------------------------------------------------------*/

import java.awt.Color; // imports color library

public class Gray {
	public static void main(String[] args){

		Picture pic = new Picture(args[0]);

        for (int x = 0; x < pic.width(); x++){
            for (int y = 0; y < pic.height(); y++){
                Color color = pic.get(x, y); // Grabs every pixel from the image

                // Finds the intensity of each color in the pixel
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                // finds the grayscale equivalent of the colors
                int l = (int) Math.round((0.299 * r) + (0.587 * g) + (0.114 * b));

                // Assigns the grayscale to the pixel
                Color gray = new Color(l, l, l);
                pic.set(x, y, gray);
            }
        }
        pic.save("grayscale.jpg");// Saves the grayscale image under grayscale.jpg
		pic.show();// Displays the grayscale image

	}
}