package org.games.guessnum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppTest {
    @Test
    public void testValidRandom()
    {
        int num = App.randomize();
        assertTrue( num >= 0);
        assertTrue( num <= 100);
    }

    @Test
    public void testValidInput() {
        String input = "50";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner mockScanner = new Scanner(inputStream);
        System.setIn(inputStream);

        int result = App.getNumber();
        assertEquals(50, result);
        mockScanner.close();
    }

    @Test
    void testInvalidInputAndThenValidInput() {
        String input = "abc\n-10\n110\n75";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner mockScanner = new Scanner(inputStream);
        System.setIn(inputStream);

        int result = App.getNumber();
        assertEquals(75, result);
        mockScanner.close();
    }

    @Test
    void testException() {
        String input = "abc";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner mockScanner = new Scanner(inputStream);
        System.setIn(inputStream);

        assertThrows(NoSuchElementException.class, App::getNumber);
        mockScanner.close();
    }
}