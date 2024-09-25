package com.engineeringwithsandeep.learning.patterns.observer.exercise;

import com.engineeringwithsandeep.learning.youtube.patterns.observer.exercise.Game;
import com.engineeringwithsandeep.learning.youtube.patterns.observer.exercise.Rat;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RatTest {

    @Test
    public void threeRatsOneDiesBeforeLast()
            throws IOException {
        Game game = new Game();

        Rat rat3;
        try (Rat rat = new Rat(game)) {
            assertEquals(1, rat.attack);

            try (Rat rat2 = new Rat(game)) {
                assertEquals(2, rat.attack);
                assertEquals(2, rat2.attack);
            }
            assertEquals(1, rat.attack);

            rat3 = new Rat(game);
            assertEquals(2, rat.attack);
        }
        assertEquals(3, rat3.attack); // This is actually 3
    }
}