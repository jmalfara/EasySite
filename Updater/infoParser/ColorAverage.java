/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Jordan
 */
public class ColorAverage {

    /**
     * @param args the command line arguments
     */
    private static int red = 0;
    private static int blue = 0;
    private static int green = 0;
    private static int number = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
      File f = new File ("../images/");
      File values = new File("../text/ColorValue.txt");
      if (f == null) {
        System.out.println("Null This is an error");
      }
      
        System.out.println("Running" + f);
        getAllFiles(f);        
        getFinalAv();
        try {
          printValueToFile(values);
        } catch (IOException e) {
          System.out.println("error");
        }
    }
    
    public static void getAllFiles(final File folder) {        
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getAllFiles(fileEntry);
            } else {
                System.out.println("File: " + fileEntry + " " + number);
                try {
                    if (!(fileEntry.getName().contains(".ico"))) {
                        number++;
                        getAverageColor(fileEntry);
                    }
                } catch (IOException e) {
                  System.out.println("error"); 
                }
            }            
        }
    }
    
    public static void getAverageColor(File file) throws IOException {
        BufferedImage bi = ImageIO.read(file);
        int r = 0,b = 0,g = 0;
        int x;
        int y = 1;
        for (x = 0; x < bi.getWidth(); x++) {
            for (y = 0; y < bi.getHeight(); y++) {
                Color pixel = new Color(bi.getRGB(x, y));
                r += pixel.getRed();
                b += pixel.getBlue();
                g += pixel.getGreen();
            }
        }
        red += r/(x*y);
        green += g/(x*y);
        blue += b/(x*y);
        System.out.println("Not Av: " + red + " " + green + " " + blue);
    }
    
    public static void getFinalAv() {
      red = red/number;
      blue = blue/number;
      green = green/number;
      System.out.println("Final Av: " + red + " " + green + " " + blue);
    }
    
    public static void printValueToFile(File file) throws IOException {      
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            String hex = String.format("#%02x%02x%02x", red, green, blue);
            bw.write(hex);
            System.out.println("Color Values: Done");
        }
    }
}
