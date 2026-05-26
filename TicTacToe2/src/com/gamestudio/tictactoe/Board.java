package com.gamestudio.tictactoe;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public boolean placeSymbol(int row, int col, char symbol) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (cells[row][col] == ' ') {
            cells[row][col] = symbol;
            return true;
        }

        return false;
    }

    public boolean hasWon(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == symbol && cells[i][1] == symbol && cells[i][2] == symbol) {
                return true;
            }

            if (cells[0][i] == symbol && cells[1][i] == symbol && cells[2][i] == symbol) {
                return true;
            }
        }

        if (cells[0][0] == symbol && cells[1][1] == symbol && cells[2][2] == symbol) {
            return true;
        }

        if (cells[0][2] == symbol && cells[1][1] == symbol && cells[2][0] == symbol) {
            return true;
        }

        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public char[][] getCells() {
        return cells;
    }

    public void printBoard() {
        System.out.println("-------");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + cells[i][j]);
            }

            System.out.println("|");
            System.out.println("-------");
        }
    }
}