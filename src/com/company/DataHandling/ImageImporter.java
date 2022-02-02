package com.company.DataHandling;
import com.company.windows.WindowSizeConstants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageImporter extends JPanel {


    private BufferedImage imageScaled;


    public ImageImporter(File imageFile,Dimension wymiaryObrazka) {
        super();


        try {
            BufferedImage image = ImageIO.read(imageFile);
            imageScaled=resize(image,wymiaryObrazka.width,wymiaryObrazka.height);
            this.setBounds(0,0, WindowSizeConstants.getCurrentDimension().width,WindowSizeConstants.getCurrentDimension().height);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }

    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imageScaled, 0, 0, this);
    }
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
