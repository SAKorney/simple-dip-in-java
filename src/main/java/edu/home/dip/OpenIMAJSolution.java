package edu.home.dip;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;

public class OpenIMAJSolution {
    public static void run(String firstFileName, String secondFileName) throws IOException{
        File file0 = new File(firstFileName);
        MBFImage img0 = ImageUtilities.readMBF(file0);

        File file1 = new File(secondFileName);
        MBFImage img1 = ImageUtilities.readMBF(file1);

        long diff = calcDiff(img0, img1);
    }

    public static long calcDiff(MBFImage img0, MBFImage img1) {
        int width = img0.getWidth();
        int height = img0.getHeight();
        long diff = 0L;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (Arrays.equals(img0.getPixel(x, y), img1.getPixel(x, y)))
                    continue;
                diff++;
            }
        }
        return diff;
    }
}