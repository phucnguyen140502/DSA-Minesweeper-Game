package control;

import view.Cells;

// Apply BFS ( Breadth-First Search)
public class World {

    private Cells[][] mineField;

    public World(int w, int h, int mine){
        mineField = new Cells[w][h];
    }



    public Cells[][] getMineField() {
        return mineField;
    }

    public void setMineField(Cells[][] mineField) {
        this.mineField = mineField;
    }
}
