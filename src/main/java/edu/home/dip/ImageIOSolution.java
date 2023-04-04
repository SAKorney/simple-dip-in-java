package edu.home.dip;

import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageIOSolution {
    public static void run(String firstFileName, String secondFileName) throws IOException {
        File file0 = new File(firstFileName);
        BufferedImage img0 = ImageIO.read(file0);

        File file1 = new File(secondFileName);
        BufferedImage img1 = ImageIO.read(file1);

        long diff = calculateDiff(img0, img1);
    }

    public static long calculateDiff(BufferedImage first, BufferedImage second) {
        int width = first.getWidth();
        int height = first.getHeight();
        long diff = 0L;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (first.getRGB(x, y) == second.getRGB(x, y))
                    continue;
                diff++;
            }
        }
        return diff;
    }

    private static void showDiff(BufferedImage first, BufferedImage second) {
        int width = first.getWidth();
        int height = first.getHeight();
        var diff = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var px = first.getRGB(x, y);
                if (px != second.getRGB(x,y)) continue;
                diff.setRGB(x, y, px);
            }
        }

        JLabel picture = new JLabel(new ImageIcon(diff));
        JPanel panel = new JPanel();
        panel.add(picture);
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(width, height));
        frame.add(panel);
        frame.setVisible(true);
    }
}
