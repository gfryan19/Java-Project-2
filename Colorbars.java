/*
 * Author: Greg Ryan
 * Email: gfryan19@g.holycross.edu
 * Written: 10/1/2015
 *
 * Description: Displays an example of the classic colorbars picture according
 * to the width input by the user. The user may also choose between the 
 * bright or dim version of the image.
 *
 * Note: The width must be a positive number and a multiple of 16.
 *
 * Example: java Colorbars smpte.png 240 dim
 *-------------------------------------------------------*/

import java.awt.Color; // imports the color library

public class Colorbars {
    public static void main(String[] args){

        int b; // Allows for the easy switch bewteen dim and bright colors
        if (args[2].equalsIgnoreCase("dim")){
            b = 192;
        }
        else {
            b = 255;
        }
        
        // Height and Width variables
        int width = Integer.parseInt(args[1]);
        int height = (int)Math.round((0.75) * width);
        int test = width % 16;
        Picture bars = new Picture(width, height);
        int longW = width / 7;
        int longH = (int)Math.round(height * 0.6667);
        int bottomW = width / 6;
        int bottomH = (int)Math.round(height - (height * .25));
        int midW = longW;
        int midH = (int)Math.round(height - (height * 0.33333));

        // Color Variables
        Color gray = new Color(b, b, b); 
        Color yellow = new Color(b, b, 0);
        Color cyan = new Color(0, b, b);
        Color green = new Color(0, b, 0);
        Color magenta = new Color(b, 0, b);
        Color red = new Color(b, 0, 0);
        Color blue = new Color(0, 0, b);
        Color white = new Color(255, 255, 255);
        Color black = new Color(0, 0, 0);
        Color darkBlue = new Color(0, 33, 76);
        Color darkPurple = new Color(50, 0, 106);
        
        // Error message if an invalid width is input
        if (test != 0 || width < 0){
            System.out.println("Error. Invalid width entry. Goodbye");
            System.exit(1);
        }
        
        // Loops to set the colors of the top row of bars
        for (int y = 0; y < longH; y++){
            for (int x = 0; x < longW; x++){
                bars.set(x, y, gray);
            }
            for (int x = longW; x < (2 * longW); x++){
                bars.set(x, y, yellow);
            }
            for (int x = (2 * longW); x < (3 * longW); x++){
                bars.set(x, y, cyan);
            }
            for (int x = (3 * longW); x < (4 * longW); x++){
                bars.set(x, y, green);
            }
            for (int x = (4 * longW); x < (5 * longW); x++){
                bars.set(x, y, magenta);
            }
            for (int x = (5 * longW); x < (6 * longW); x++){
                bars.set(x, y, red);
            }
            for (int x = (6 * longW); x < width; x++){
                bars.set(x, y, blue);
            }
        }
        
        // Loops to set the colors for the bottom row of bars
        for (int y = bottomH; y < height; y++){
            for (int x = 0; x < bottomW; x++){
                bars.set(x, y, darkBlue);
            }
            for (int x = bottomW; x < (2 * bottomW); x++){
                bars.set(x, y, white);
            }
            for (int x = (2 * bottomW); x < (3 * bottomW); x++){
                bars.set(x, y, darkPurple);
            }
            for (int x = (3 * bottomW); x < width; x++){
                bars.set(x, y, black);
            }
        }
        
        // Loops to set the colors for the middle row of bars
        for (int y = midH; y < bottomH; y++){
            for (int x = 0; x < midW; x++){
                bars.set(x, y, blue);
            }
            for (int x = midW; x < (2 * midW); x++){
                bars.set(x, y, black);
            }
            for (int x = (2 * midW); x < (3 * midW); x++){
                bars.set(x, y, magenta);
            }
            for (int x = (3 * midW); x < (4 * midW); x++){
                bars.set(x, y, black);
            }
            for (int x = (4 * midW); x < (5 * midW); x++){
                bars.set(x, y, cyan);
            }
            for (int x = (5 * midW); x < (6 * midW); x++){
                bars.set(x, y, black);
            }
            for (int x = (6 * midW); x < width; x++){
                bars.set(x, y, gray);
            }
        }
        
       



        bars.save(args[0]);
        bars.show();

    }
}