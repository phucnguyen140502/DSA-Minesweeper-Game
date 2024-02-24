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
            listImage.put("Unmarked", image.getSubimage(0,39, 16, 16));
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
