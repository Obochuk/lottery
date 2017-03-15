package obochuk.vlad.etc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Images {

    public static InputStream toInputStream(BufferedImage image){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", outputStream);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    public static BufferedImage scaleImage(BufferedImage image, int maxHeight){
        if (image.getHeight() > maxHeight){
            int width = image.getWidth();
            int height = image.getHeight();
            double k = height / (double)maxHeight;
            int newWidth = (int)Math.round(width / k);
            BufferedImage scaled = new BufferedImage(newWidth, maxHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = scaled.createGraphics();
            g.drawImage(image, 0, 0, newWidth, maxHeight, null);
            g.dispose();
            return scaled;
        }
        return image;
    }
}
