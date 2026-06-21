package org.example.tictactoe;

import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PlayerTest {
    @Test
    public void testPlayerConstructorAndGetMarkerWithX() {
        // Arrange & Act: Spieler mit Marker 'X' erstellen
        Player player = new Player('X');

        // Assert: Prüfen, ob getMarker() wirklich 'X' zurückgibt
        assertEquals('X', player.getMarker(), "Der Marker sollte 'X' sein.");
    }

    @Test
    public void testPlayerConstructorAndGetMarkerWithO() {
        // Arrange & Act: Spieler mit Marker 'O' erstellen
        Player player = new Player('O');

        // Assert: Prüfen, ob getMarker() wirklich 'O' zurückgibt
        assertEquals('O', player.getMarker(), "Der Marker sollte 'O' sein.");
    }
}
