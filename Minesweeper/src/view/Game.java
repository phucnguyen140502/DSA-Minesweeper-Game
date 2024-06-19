package view;

import ui.LoadAudio;

public class Game {
    public static void main(String[] args) {
        LoadAudio.LoadData();
        GameFrame.getInstance(9,9,10);
    }
}
