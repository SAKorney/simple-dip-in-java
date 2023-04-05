package edu.home.dip.imageio;

public final class Utils {
    public static void printPixel(int pixel) {
        int blue = pixel & 0xff;
        int green = (pixel & 0xff00) >> 8;
        int red = (pixel & 0xff0000) >> 16;
        int alpha = (pixel & 0xff000000) >>> 24;
        System.out.println("R: " + red);
        System.out.println("G: " + green);
        System.out.println("B: " + blue);
        System.out.println("Alpha:" + alpha);
    }
}
