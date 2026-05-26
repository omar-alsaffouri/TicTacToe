package com.gamestudio.tictactoe;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        initializeBoard();
    }

    // Füllt das Board am Anfang mit Leerzeichen
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    /**
     * Versucht, ein Symbol auf dem Board zu platzieren.
     * Erfüllt das Akzeptanzkriterium: "choosing an empty square"
     */
    public boolean placeSymbol(int row, int col, char symbol) {
        // 1. Prüfen, ob die Eingabe überhaupt innerhalb des Spielfelds liegt
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // 2. Prüfen, ob das ausgewählte Quadrat leer ist
        if (cells[row][col] == ' ') {
            cells[row][col] = symbol;
            return true; // Zug erfolgreich
        }

        return false; // Feld ist bereits besetzt
    }

    // Getter für die spätere Verwendung (z.B. für das UI in User Story 2)
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