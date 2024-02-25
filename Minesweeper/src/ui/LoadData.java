package ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class LoadData {

    private Hashtable<String, BufferedImage> listImage;

    public LoadData() {
        listImage = new Hashtable<>();

        try {
            BufferedImage image = ImageIO.read(new File("assets/minesweeper.png"));

            listImage.put("Title", image.getSubimage(0, 84, 114, 25));
            listImage.put("Smile", image.getSubimage(0, 55, 26, 26));

            // the number for time and the residual of mines
            listImage.put("0", image.getSubimage(0, 0, 13, 23));
            listImage.put("1", image.getSubimage(13, 0, 13, 23));
            listImage.put("2", image.getSubimage(26, 0, 13, 23));
            listImage.put("3", image.getSubimage(39, 0, 13, 23));
            listImage.put("4", image.getSubimage(52, 0, 13, 23));
            listImage.put("5", image.getSubimage(65, 0, 13, 23));
            listImage.put("6", image.getSubimage(78, 0, 13, 23));
            listImage.put("7", image.getSubimage(91, 0, 13, 23));
            listImage.put("8", image.getSubimage(104, 0, 13, 23));
            listImage.put("9", image.getSubimage(117, 0, 13, 23));
            listImage.put("Infinity", image.getSubimage(120, 0, 13, 23));

            // the number for cells
            listImage.put("b0", image.getSubimage(0, 23, 16, 16));
            listImage.put("b1", image.getSubimage(16, 23, 16, 16));
            listImage.put("b2", image.getSubimage(32, 23, 16, 16));
            listImage.put("b3", image.getSubimage(48, 23, 16, 16));
            listImage.put("b4", image.getSubimage(64, 23, 16, 16));
            listImage.put("b5", image.getSubimage(80, 23, 16, 16));
            listImage.put("b6", image.getSubimage(96, 23, 16, 16));
            listImage.put("b7", image.getSubimage(112, 23, 16, 16));
            listImage.put("b8", image.getSubimage(128, 23, 16, 16));
            listImage.put("Unmarked", image.getSubimage(0,39, 16, 16));

            // the flag
            listImage.put("Flag", image.getSubimage(16, 39, 16, 16));

            // the mine
            listImage.put("BoomRed", image.getSubimage(32, 39, 16, 16));
            listImage.put("BoomX", image.getSubimage(48, 39, 16, 16));
            listImage.put("Boom", image.getSubimage(64, 39, 16, 16));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Hashtable<String, BufferedImage> getListImage() {
        return listImage;
    }

    public void setListImage(Hashtable<String, BufferedImage> listImage) {
        this.listImage = listImage;
    }
}
