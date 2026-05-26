package test.java;

import com.gamestudio.tictactoe.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    // Diese Methode läuft automatisch VOR JEDEM einzelnen Test,
    // damit wir immer mit einem frischen Spielfeld starten.
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testBoardInitialization() {
        // Prüfen, ob nach dem Erstellen wirklich alle Felder leer sind
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                assertTrue(board.isCellEmpty(x, y), "Zelle (" + x + "," + y + ") sollte leer sein.");
            }
        }
        assertFalse(board.isFull(), "Ein neues Board darf nicht voll sein.");
    }

    @Test
    public void testPlaceMarkerSuccessfully() {
        // Gültigen Zug testen
        boolean result = board.place(0, 0, 'X');
        assertTrue(result, "Der Zug auf ein leeres Feld sollte true zurückgeben.");
        assertFalse(board.isCellEmpty(0, 0), "Die Zelle sollte nach dem Zug nicht mehr leer sein.");
        assertEquals('X', board.getCells()[0][0], "Der Marker in der Zelle sollte 'X' sein.");
    }

    @Test
    public void testPlaceMarkerOnOccupiedCell() {
        // Erst ein Feld besetzen
        board.place(1, 1, 'X');
        // Versuchen, auf dasselbe Feld zu setzen
        boolean result = board.place(1, 1, 'O');
        assertFalse(result, "Der Zug auf ein besetztes Feld muss false zurückgeben.");
        assertEquals('X', board.getCells()[1][1], "Der ursprüngliche Marker 'X' darf nicht überschrieben werden.");
    }

    @Test
    public void testPlaceMarkerOutOfBounds() {
        // Testen von ungültigen Koordinaten (kleiner 0 oder größer 2)
        assertFalse(board.place(-1, 0, 'X'), "Negativer Index darf nicht erlaubt sein.");
        assertFalse(board.place(3, 0, 'X'), "Index größer als 2 darf nicht erlaubt sein.");
        assertFalse(board.place(0, -1, 'X'), "Negativer Spaltenindex darf nicht erlaubt sein.");
        assertFalse(board.place(0, 3, 'X'), "Spaltenindex größer als 2 darf nicht erlaubt sein.");
    }

    @Test
    public void testIsFull() {
        // Das Board komplett manuell füllen
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board.place(x, y, 'X');
            }
        }
        assertTrue(board.isFull(), "Das Board sollte als voll erkannt werden.");
    }

    @Test
    public void testClear() {
        // Ein paar Marker platzieren
        board.place(0, 0, 'X');
        board.place(2, 2, 'O');

        // Board zurücksetzen
        board.clear();

        // Prüfen, ob wieder alles leer ist
        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(2, 2));
        assertFalse(board.isFull());
    }
}