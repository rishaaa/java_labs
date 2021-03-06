package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {
    BufferedImage Image;

    public JImageDisplay(int width, int height){
        Image =new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(width, height));
    }

    public void paintComponent (Graphics g){ // код отрисовки
        g.drawImage (Image, 0, 0, Image.getWidth(), Image.getHeight(), null);
    }

    public void clearImage() { // окрашивает изображение в черный цвет
        for (int x = 0; x < Image.getWidth(); x++) {
            for (int y = 0; y < Image.getHeight(); y++) {
                Image.setRGB(x,y,0);
            }
        }
    }
    public void  drawPixel (int x, int y, int rgbColor){
        Image.setRGB(x,y, rgbColor);
    }

    public BufferedImage getBufferedImage() {
        return Image;
    }

}
