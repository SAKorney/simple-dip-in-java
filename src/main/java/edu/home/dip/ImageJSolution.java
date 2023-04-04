package edu.home.dip;

import java.util.Arrays;

import ij.IJ;
import ij.ImagePlus;

public class ImageJSolution {
    public static void run(String firstFileName, String secondFileName) {
        ImagePlus firstImg = IJ.openImage(firstFileName);
        ImagePlus secondImg = IJ.openImage(secondFileName);

        long diff = calcDiff(firstImg, secondImg);
    }

    public static long calcDiff(ImagePlus first, ImagePlus second) {
        int width = first.getWidth();
        int height = first.getHeight();
        long diff = 0L;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (Arrays.equals(first.getPixel(x, y), second.getPixel(x, y)))
                    continue;
                diff++;
            }
        }
        return diff;
    }
}
