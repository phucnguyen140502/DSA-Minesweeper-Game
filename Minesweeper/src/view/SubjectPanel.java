package view;

import control.Work;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observer;

public abstract class SubjectPanel extends Panel {

    protected ArrayList<ObserverPanel> observerPanel = new ArrayList<>();
    protected int w;
    protected int h;
    protected int mine;
    protected Work work;

    public SubjectPanel(int weight, int height, int mine, GameFrame gameFrame) {

        w = weight;
        h = height;
        this.mine = mine;

        work = new Work(w, h, mine);


    }

    public void AttachObserver(ObserverPanel observer){
        observerPanel.add(observer);
    }


    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public Work getWork() {
        return work;
    }

    public int getMine() {
        return mine;
    }


}
