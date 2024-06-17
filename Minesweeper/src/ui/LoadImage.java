package ui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class LoadImage {

    public static HashTable<String, BufferedImage> listImage;

    public static void loadData() {
        listImage = new HashTable<>(35);

        try {
            BufferedImage image = ImageIO.read(new File("assets/image/minesweeper.png"));

            // the title
            listImage.put("Title", image.getSubimage(0, 84, 114, 25));

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

            // the smile
            listImage.put("Smile", image.getSubimage(0, 55, 26, 26));
            listImage.put("SmilePress", image.getSubimage(26, 55, 26, 26));
            listImage.put("SmilePressPlay", image.getSubimage(52, 55, 26, 26));
            listImage.put("SmileLose", image.getSubimage(78, 55, 26, 26));
            listImage.put("SmileWin", image.getSubimage(104, 55, 26, 26));

            //
            listImage.put("Mark", image.getSubimage(140, 49, 7, 7));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
