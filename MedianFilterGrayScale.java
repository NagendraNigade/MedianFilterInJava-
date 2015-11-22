/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medianfilter.grayscale;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Nagendra
 */
public class MedianFilterGrayScale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int width = 512; // Dimensions of the output image
        int height = 512;

        // Let's create a BufferedImage for a gray level image.
        BufferedImage im = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        // We need its raster to set the pixels' values.
        WritableRaster raster = im.getRaster();

        // Read The Image On Which You Want To Apply Median Filter
        try {

            //Replace Below Path With Required Imput File Path
            File fl = new File("C:\\Users\\Nagendra\\Desktop\\Test.jpg");
            BufferedImage br = ImageIO.read(fl);
            int w = br.getWidth();
            int h = br.getHeight();
            int pixs[][] = new int[w][h];
            int newpixs[][] = new int[w][h];
            int i, j = 0;
            for (i = 0; i < w; i++) {
                for (j = 0; j < h; j++) {
                    pixs[i][j] = br.getRaster().getSample(i, j, 0);
                }
            }

            for (i = 1; i < 511; i++) {
                for (j = 1; j < 511; j++) {

                    int i1 = 0, j1 = 0;
                    int temp[] = new int[9];
                    int tempcount = 0;
                    for (i1 = i - 1; i1 <= i + 1; i1++) {
                        for (j1 = j - 1; j1 <= j + 1; j1++) {
                            temp[tempcount++] = pixs[i1][j1];
                        }

                    }

                    int asize = temp.length;
                    int temp2 = 0;
                    for (int i2 = 0; i2 < asize; i2++) {
                        for (int j2 = i2 + 1; j2 < asize; j2++) {
                            if (temp[i2] > temp[j2]) {
                                temp2 = temp[i2];
                                temp[i2] = temp[j2];
                                temp[j2] = temp2;
                            }
                        }
                    }
                    newpixs[i][j] = temp[asize / 2];

                }

            }

            //End Of My Work
            // Put the pixels on the raster, using values between 0 and 255.
            for (h = 0; h < height; h++) {
                for (w = 0; w < width; w++) {
                    if (h != 0 && w != 0 && h != 511 && w != 511) {
                        raster.setSample(h, w, 0, newpixs[h][w]);
                    } else {
                        raster.setSample(h, w, 0, pixs[h][w]);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception Occured");
        }

        try {
            // Store the image using the PNG format.
            //Replace Below Path With Required Output File Path
            ImageIO.write(im, "PNG", new File("C:\\Users\\Nagendra\\Desktop\\AfterNoiseReduction.jpg"));
        } catch (IOException ex) {
            System.out.println("Exception Occured");
        }

    }

}
