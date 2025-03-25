/**
 * Final Project, subject ICC (2024)
 * 
 * This program converts an image into ASCII art. It scales the image to a
 * specific size, maps pixel brightness values to ASCII characters, and saves
 * the result to a text file.
 * 
 * @author Angel Andrade Castañeda
 * @author Urrutia Alfaro Isaac Arturo
 *
 * MIT License
 * Copyright (c) 2024 Angel Andrade Castañeda y Urrutia Alfaro Isaac Arturo
 */

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {

    /**
     * Program entry point. Converts an image to ASCII art.
     * 
     * @param args Command-line arguments, where the first argument should be the
     *             image file name with its extension.
     */
    public static void main(String[] args) {

        String fileName = "";

        // Verify that a file name is provided.
        if (args.length == 0) {
            System.err.println("Error: No arguments provided. Specify the image file name as an argument.");
            return;
        }

        // Concatenate all arguments to form the file name
        for (int a = 0; a < args.length; a++) {
            fileName += args[a];
        }
        
        // Grayscale characters for pixel representation
        final String grayscale = "@%${|*+=-:. ";
        final int newWidth = 90; // Desired width
        final double aspectRatio = 1.5; // Adjusted aspect ratio for ASCII characters

        try {
            // Load the image
            BufferedImage originalImage = ImageIO.read(new File(fileName));
            if (originalImage == null) {
                System.err.println("Error: Unable to load the image. Check the path or format.");
                return;
            }

            // Calculate new dimensions
            int originalWidth = originalImage.getWidth();
            int originalHeight = originalImage.getHeight();
            int newHeight = (int) (newWidth * originalHeight / (originalWidth * aspectRatio));

            // Scale the image
            BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = scaledImage.createGraphics();
            g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
            g2d.dispose();

            // Generate ASCII art
            StringBuilder asciiArt = new StringBuilder();
            for (int y = 0; y < newHeight; y++) {
                for (int x = 0; x < newWidth; x++) {
                    int rgb = scaledImage.getRGB(x, y);
                    int red = (rgb >> 16) & 0xFF;
                    int green = (rgb >> 8) & 0xFF;
                    int blue = rgb & 0xFF;

                    // Calculate brightness
                    double brightness = 0.2126 * red + 0.7152 * green + 0.0722 * blue;

                    // Map brightness to a character
                    int index = (int) (brightness / 255 * (grayscale.length() - 1));
                    char asciiChar = grayscale.charAt(index);
                    asciiArt.append(asciiChar);
                }
                asciiArt.append("\n");
            }

            // Print ASCII art to console
            System.out.println(asciiArt);

            // Save ASCII art to a file
            String outputFileName = "ascii_art.txt";
            try (FileWriter writer = new FileWriter(outputFileName)) {
                writer.write(asciiArt.toString());
                System.out.println("ASCII art saved to " + outputFileName);
            } catch (Exception e) {
                System.err.println("Error writing to the file.");
            }

        } catch (IOException e) {
            System.err.println("Error loading the image. Ensure the file name is correct, exists, and is in the directory.");
        }
    }
}
