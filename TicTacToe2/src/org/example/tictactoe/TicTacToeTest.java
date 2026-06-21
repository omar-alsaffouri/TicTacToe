package org.example.tictactoe;
import static org.junit.jupiter.api.Assertions.*;

import org.example.TicTacToe;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TicTacToeTest {

    // Hilfsmethode, um Konsoleneingaben für den Scanner zu simulieren
    private void simulateInput(String data) {
        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
    }

    @Test
    public void testPlayerXWinsWithHorizontalRow() {
        // Ablauf (Reihe 0 für X):
        // X setzt (0,0), O setzt (1,0)
        // X setzt (0,1), O setzt (1,1)
        // X setzt (0,2) -> Gewinn! Danach "no" für kein neues Spiel.
        String input = "0\n0\n1\n0\n0\n1\n1\n1\n0\n2\nno\n";
        simulateInput(input);

        TicTacToe game = new TicTacToe();

        // Wenn hasWinner() funktioniert, bricht die Schleife ab und start() endet fehlerfrei
        assertDoesNotThrow(() -> game.start(), "Das Spiel sollte ohne Fehler beendet werden, wenn X horizontal gewinnt.");
    }

    @Test
    public void testPlayerOWinsWithVerticalColumn() {
        // Ablauf (Spalte 1 für O):
        // X setzt (0,0), O setzt (0,1)
        // X setzt (1,0), O setzt (1,1)
        // X setzt (2,2), O setzt (2,1) -> Gewinn O! Danach "no".
        String input = "0\n0\n0\n1\n1\n0\n1\n1\n2\n2\n2\n1\nno\n";
        simulateInput(input);

        TicTacToe game = new TicTacToe();
        assertDoesNotThrow(() -> game.start(), "Das Spiel sollte ohne Fehler beendet werden, wenn O vertikal gewinnt.");
    }

    @Test
    public void testPlayerXWinsDiagonal() {
        // Ablauf (Hauptdiagonale für X):
        // X (0,0), O (0,1)
        // X (1,1), O (0,2)
        // X (2,2) -> Gewinn X! Danach "no".
        String input = "0\n0\n0\n1\n1\n1\n0\n2\n2\n2\nno\n";
        simulateInput(input);

        TicTacToe game = new TicTacToe();
        assertDoesNotThrow(() -> game.start(), "Das Spiel sollte enden, wenn X diagonal gewinnt.");
    }

    @Test
    public void testGameEndsInADraw() {
        // Ablauf für ein volles Board ohne Gewinner (Unentschieden):
        // Board-Muster am Ende:
        // X O X
        // X X O
        // O X O
        String input = "0\n0\n0\n1\n0\n2\n1\n2\n1\n0\n2\n0\n1\n1\n2\n2\n2\n1\nno\n";
        simulateInput(input);

        TicTacToe game = new TicTacToe();
        assertDoesNotThrow(() -> game.start(), "Das Spiel sollte bei einem Unentschieden (Draw) sauber enden.");
    }

    @Test
    public void testInvalidMoveAndRecovery() {
        // Ablauf:
        // X setzt (0,0)
        // O versucht AUCH (0,0) zu setzen -> Ungültig!
        // O setzt stattdessen gültig auf (1,1)
        // X setzt (0,1), O (1,0), X (0,2) -> Gewinn X. Danach "no".
        String input = "0\n0\n0\n0\n1\n1\n0\n1\n1\n0\n0\n2\nno\n";
        simulateInput(input);

        TicTacToe game = new TicTacToe();
        assertDoesNotThrow(() -> game.start(), "Das Spiel sollte fehlerhafte Eingaben abfangen und normal weiterlaufen.");
    }

    @Test
    public void testPlayAgainOption() {
        // Erstes Spiel: X gewinnt schnell (0,0 -> 0,1 -> 0,2). Danach Eingabe "yes".
        // Zweites Spiel: X gewinnt wieder schnell. Danach Eingabe "no".
        String input = "0\n0\n1\n0\n0\n1\n1\n1\n0\n2\nyes\n0\n0\n1\n0\n0\n1\n1\n1\n0\n2\nno\n";
        simulateInput(input);

        TicTacToe game = new TicTacToe();
        assertDoesNotThrow(() -> game.start(), "Das Spiel sollte bei der Eingabe 'yes' eine neue Runde starten.");
    }
}