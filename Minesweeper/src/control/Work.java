package control;

import view.CellButtons;

import view.GamePanel;
import view.LabelNumber;
import view.SmileButton;

import view.LabelNumber;
import view.SmileButton;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

// Apply BFS ( Breadth-First Search)

public class Work {

    private Random random; // mine is -1

    private CellButtons[][] mineFieldContainer;

    private int[][] mineField;



    private boolean[][] visited;
    private final boolean[][] setFlagVisited;

    private boolean isCompleted;
    private boolean isEnd;

    private int w, h, mine;

    private int Flag;
    public Work(int w, int h, int mine){

        this.w = w;
        this.h = h;
        this.mine = mine;


        mineFieldContainer = new CellButtons[w][h];
        mineField = new int[w][h];
        visited = new boolean[w][h];
        setFlagVisited = new boolean[w][h];
        for (int j = 0; j < w; j++) {
            Arrays.fill(visited[j], false);
            Arrays.fill(setFlagVisited[j], false);

        }

        random = new Random();


        createMineField();

        FillNumber();




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


    public boolean clickDouble(int i, int j) {

        boolean isMine = false;

        int[] drow = new int[]{0, 0, -1, 1, 1, -1, 1, -1};
        int[] dcol = new int[]{-1, 1, 0, 0, 1, -1, -1, 1};

        for (int k = 0; k < 8; k++) {
            int x = i + drow[k];
            int y = j + dcol[k];
            if (isValid(x, y)) {
                if (mineField[x][y] == -1 && setFlagVisited[x][y]) {
                    isMine = true;
                    mineFieldContainer[x][y].setNumber(12);
                    mineFieldContainer[x][y].repaint();
                    visited[x][y] = false;
                } else if (mineField[x][y] == -1) {
                    isMine = true;
                    mineFieldContainer[x][y].setNumber(11);
                    mineFieldContainer[x][y].repaint();
                    visited[x][y] = false;
                } else if (visited[x][y]) {
                    open(x, y);
                }
            }
        }
        if (isMine) {
            for (int k = 0; k < w; k++) {
                for (int l = 0; l < h; l++) {
                    if (mineField[k][l] == -1 && visited[k][l]) {
                        mineFieldContainer[k][l].setNumber(10); // Boom
                        mineFieldContainer[k][l].repaint();
                    }
                }
            }
            return false;
        }
        return true;
    }


    public void Flagging(int i, int j){
        if (visited[i][j]) {
            if (setFlagVisited[i][j]) {
                Flag--;
                setFlagVisited[i][j] = false;
                mineFieldContainer[i][j].setNumber(-1);
                mineFieldContainer[i][j].repaint();
            }else if (Flag < mine) {
                Flag++;
                setFlagVisited[i][j] = true;
                mineFieldContainer[i][j].setNumber(9);
                mineFieldContainer[i][j].repaint();
            }
        }
    }

    // Apply BFS Algorithm and matrix to open when click to cell "0" using recursion
    public boolean open(int i, int j) {

        if (!isCompleted && !isEnd) {


            if (visited[i][j]) {
                if (mineField[i][j] == 0) { // open around until the cells have mines around

                    visited[i][j] = false;
                    mineFieldContainer[i][j].setNumber(0);
                    mineFieldContainer[i][j].repaint();

                    if (isWin()) {
                        isEnd = true;

                        return false;
                    }


                    int[] drow = new int[]{0, 0, -1, 1, 1, -1, 1, -1};
                    int[] dcol = new int[]{-1, 1, 0, 0, 1, -1, -1, 1};

                    for (int k = 0; k < 8; k++) {
                        int x = i + drow[k];
                        int y = j + dcol[k];

                        if (isValid(x, y) && visited[x][y]) {
                            open(x, y);
                        }
                    }
                    if (isWin()) {
                        isEnd = true;

                        return false;
                    }
                } else {
                    visited[i][j] = false;
                    int num = mineField[i][j];
                    if (num != -1) {
                        mineFieldContainer[i][j].setNumber(num);
                        mineFieldContainer[i][j].repaint();


                        if (isWin()) {
                            isEnd = true;

                            return false;
                        }
                        return true;

                    }
                }
            }
            if (mineField[i][j] == -1) {
                mineFieldContainer[i][j].setNumber(11); // BoomRed
                mineFieldContainer[i][j].repaint();
                isCompleted = true;


                for (int k = 0; k < w; k++) {
                    for (int l = 0; l < h; l++) {
                        if (mineField[k][l] == -1 && visited[k][l]) {
                            if (k != i || l != j) {
                                mineFieldContainer[k][l].setNumber(10); // Boom
                                mineFieldContainer[k][l].repaint();

                            }
                        }
                    }
                }
                return false;

            } else {
                if (isWin()) {
                    isEnd = true;

                    return false;
                }

                return true;
            }

        }
        return false;

    }


    public boolean isWin() {
        int count = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (visited[i][j]) {
                    count++;
                }
            }
        }
        return count == mine;
    }

    // apply BFS algorithm and matrix algorithm without recursion
    private boolean isValid(int ux, int vy){
        return (0 <= ux && ux < w) && (0<=vy && vy < h);
    }
    public void FillNumber(){

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

                if (isValid(ux, vy) && mineField[ux][vy] == -1) {
                    countMines++;
                } else if (isValid(ux, vy) && mineField[ux][vy] == 0 && !visited[ux][vy]) {

                    queue.add(new Cells(ux, vy));
                    visited[ux][vy] = true;
                }
            }
            if (mineField[u][v] != -1) {
                mineField[u][v] = countMines;
            }

        }

    }


    public void createMineField(){

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





    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public boolean[][] getSetFlagVisited() {
        return setFlagVisited;
    }

    public boolean[][] getVisited() {
        return visited;
    }

    public void setFlag(int flag) {
        Flag = flag;
    }

    public int getFlag() {
        return Flag;
    }

}
