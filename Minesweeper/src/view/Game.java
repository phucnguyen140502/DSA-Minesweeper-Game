package view;

import ui.LoadAudio;

public class Game {
    public static void main(String[] args) {
        LoadAudio.LoadData();
        LoadAudio.playStart();
        new GameFrame(20,20, 20);

    }
}
