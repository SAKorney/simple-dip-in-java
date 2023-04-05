package edu.home.dip.imageio;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class ImageViewer extends JFrame {
    private final static int MAX_WIDTH = 1600;
    private final static int MAX_HEIGHT = 900;

    private ImageViewer(BufferedImage image) {
        super("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int width = Math.min(MAX_WIDTH, image.getWidth());
        int height = Math.min(MAX_HEIGHT, image.getHeight());
        setSize(new Dimension(width, height));

        JLabel label = new JLabel(new ImageIcon(image));
        JPanel panel = new JPanel();
        panel.add(label);
        JScrollPane scrollPane = new JScrollPane(panel);

        add(scrollPane);
        setVisible(true);
    }

    public static void show(BufferedImage image) {
        new ImageViewer(image);
    }
}
