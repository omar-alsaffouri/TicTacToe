package com.gamestudio.tictactoe;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public boolean place(int x, int y, char marker) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        }

        if (!isCellEmpty(x, y)) {
            return false;
        }

        cells[x][y] = marker;
        return true;
    }

    public boolean isFull() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (cells[x][y] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                cells[x][y] = ' ';
            }
        }
    }

    public void print() {
        System.out.println("-------");
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print("|" + cells[x][y]);
            }
            System.out.println("|");
            System.out.println("-------");
        }
    }

    public char[][] getCells() {
        return cells;
    }
}