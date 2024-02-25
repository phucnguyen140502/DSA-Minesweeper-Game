package control;

import view.CellButtons;
import view.LabelNumber;
import view.SmileButton;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

// Apply BFS ( Breadth-First Search)
public class World {

    private Random random; // mine is -1

    private CellButtons[][] mineFieldContainer;

    private int[][] mineField;

    private SmileButton smileButton;

    private LabelNumber labelTime, labelResMine;

    private final boolean[][] visited;

    private boolean isCompleted;


    public World(int w, int h, int mine){
        mineFieldContainer = new CellButtons[w][h];
        mineField = new int[w][h];
        visited = new boolean[w][h];
        for (int j = 0; j < w; j++) {
            Arrays.fill(visited[j], false);
        }

        random = new Random();

        createMineField(mine, w, h);

        FillNumber(w,h);

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                System.out.print(mineField[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
//        for (int i = 0; i < w; i++) {
//            for (int j = 0; j < h; j++) {
//                System.out.print(visited[i][j] +" ");
//            }
//            System.out.println();
//        }
    }

    // Apply BFS Algorithm and matrix to open when click to cell "0" using recursion
    public boolean open(int i, int j) {
        if (!isCompleted) {
            if (visited[i][j]) {
                if (mineField[i][j]  == 0) { // open around until the cells have mines around

                    visited[i][j] = false;
                    mineFieldContainer[i][j].setNumber(0);
                    mineFieldContainer[i][j].repaint();

                    int[] drow = new int[]{0,0,-1,1,1,-1,1,-1};
                    int[] dcol = new int[]{-1,1,0,0,1,-1,-1,1};

                    for (int k = 0; k < 8; k++) {
                        int x = i + drow[k];
                        int y = j + dcol[k];
                        if (visited[x][y]) {
                            open(x,y);
                        }
                    }

                } else {
                    visited[i][j] = false;
                    int num = mineField[i][j];
                    if (num != -1) {
                        mineFieldContainer[i][j].setNumber(num);
                        mineFieldContainer[i][j].repaint();
                        return true;
                    }
                }
            }
            return mineField[i][j] != -1;
        }
        return false;

    }

    // apply BFS algorithm and matrix algorithm without recursion
    private boolean isValid(int ux, int vy, int N, int M){
        return (0 <= ux && ux < N) && (0<=vy && vy < M);
    }
    public void FillNumber(int w, int h){
        Queue<Cells> queue = new LinkedList<>();

        Cells start = new Cells(0, 0);

        int startX = start.getX();
        int startY = start.getY();

        visited[startX][startY] = true;

        int[] drow = new int[]{0,0,-1,1,1,-1,1,-1};
        int[] dcol = new int[]{-1,1,0,0,1,-1,-1,1};
        queue.add(start);

        while (!queue.isEmpty()){
            Cells cells = queue.poll();
            int countMines = 0;
            int u = cells.getX();
            int v = cells.getY();

            for (int i = 0; i < 8; i++) {
                int ux = u + drow[i];
                int vy = v + dcol[i];
                if (isValid(ux, vy, w, h) && mineField[ux][vy] == -1) {
                    countMines++;
                } else if (isValid(ux, vy, w, h) && mineField[ux][vy] == 0 && !visited[ux][vy]) {
                    queue.add(new Cells(ux, vy));
                    visited[ux][vy] = true;
                }
            }
            if (mineField[u][v] != -1) {
                mineField[u][v] = countMines;
            }

        }

    }


    public void createMineField(int mine, int w, int h){
        int count;
        do{
            int locationX = random.nextInt(w);
            int locationY = random.nextInt(h);
            if (mineField[locationX][locationY] == -1) {
                break;
            }
            mineField[locationX][locationY] = -1;
            visited[locationX][locationY] = true;

            count = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (mineField[i][j] == -1) {
                        count++;

                    }
                }
            }

        }while (count != mine);




    }


    public CellButtons[][] getMineFieldContainer() {
        return mineFieldContainer;
    }

    public void setMineFieldContainer(CellButtons[][] mineFieldContainer) {
        this.mineFieldContainer = mineFieldContainer;
    }

    public SmileButton getSmileButton() {
        return smileButton;
    }

    public void setSmileButton(SmileButton smileButton) {
        this.smileButton = smileButton;
    }

    public LabelNumber getLabelTime() {
        return labelTime;
    }

    public void setLabelTime(LabelNumber labelTime) {
        this.labelTime = labelTime;
    }

    public LabelNumber getLabelResMine() {
        return labelResMine;
    }

    public void setLabelResMine(LabelNumber labelResMine) {
        this.labelResMine = labelResMine;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
