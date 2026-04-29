package org.abondar.experimental.other;

import org.abondar.experimental.problems.other.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }


    @Test
    void negativeRowTest() {
        assertFalse(game.move(-1, 0));
    }

    @Test
    void rowTooLargeTest() {
        assertFalse(game.move(3, 0));
    }

    @Test
    void negativeColTest() {
        assertFalse(game.move(0, -1));
    }

    @Test
    void colTooLargeTest() {
        assertFalse(game.move(0, 3));
    }

    @Test
    void cellOccupiedTest() {
        game.move(0, 0);
        game.move(0, 0);
        assertFalse(game.move(0, 0));
    }

    @Test
    void validMoveTest() {
        assertTrue(game.move(1, 1));
    }

    @Test
    void alternatesTest() {
        // Verify X → O → X alternation: no winner after just 3 moves
        game.move(0, 0); // X
        game.move(1, 1); // O occupies the diagonal centre — X can't win it
        game.move(2, 2); // X

        assertFalse(game.hasWinner());
        assertEquals(' ', game.getWinner());
        assertFalse(game.isGameOver());
    }

    @Test
    void oCanWinAfterAlternationTest() {
        // Proves O is actually placed (not skipped): O wins the middle column
        game.move(0, 0); // X
        game.move(0, 1); // O
        game.move(1, 0); // X
        game.move(1, 1); // O
        game.move(2, 2); // X
        game.move(2, 1); // O wins middle column

        assertTrue(game.hasWinner());
        assertEquals('O', game.getWinner());
    }

    @Test
    void noSwitchAfterWinTest() {
        // X wins on top row
        game.move(0, 0); // X
        game.move(1, 0); // O
        game.move(0, 1); // X
        game.move(1, 1); // O
        game.move(0, 2); // X wins

        assertEquals('X', game.getWinner());
    }

    @Test
    void topRowTest() {
        playXWinsRow(0);
        assertTrue(game.hasWinner());
    }

    @Test
    void middleRowTest() {
        playXWinsRow(1);
        assertTrue(game.hasWinner());
    }

    @Test
    void bottomRowTest() {
        playXWinsRow(2);
        assertTrue(game.hasWinner());
    }

    @Test
    void leftColumnTest() {
        playXWinsCol(0);
        assertTrue(game.hasWinner());
    }

    @Test
    void middleColumnTest() {
        playXWinsCol(1);
        assertTrue(game.hasWinner());
    }

    @Test
    void rightColumnTest() {
        playXWinsCol(2);
        assertTrue(game.hasWinner());
    }

    @Test
    void mainDiagonalTest() {
        // X: (0,0) (1,1) (2,2) — O plays safe cells
        game.move(0, 0); // X
        game.move(0, 1); // O
        game.move(1, 1); // X
        game.move(0, 2); // O
        game.move(2, 2); // X wins
        assertTrue(game.hasWinner());
    }

    @Test
    void antiDiagonalTest() {
        // X: (0,2) (1,1) (2,0) — O plays safe cells
        game.move(0, 2); // X
        game.move(0, 0); // O
        game.move(1, 1); // X
        game.move(0, 1); // O
        game.move(2, 0); // X wins
        assertTrue(game.hasWinner());
    }

    @Test
    void emptyBoardTest() {
        assertFalse(game.hasWinner());
    }

    @Test
    void partialBoardTest() {
        game.move(0, 0); // X
        game.move(1, 1); // O
        assertFalse(game.hasWinner());
    }

    @Test
    void drawBoardTest() {
        // X O X
        // X X O
        // O X O  — no winner
        game.move(0, 0); // X
        game.move(0, 1); // O
        game.move(0, 2); // X
        game.move(1, 2); // O
        game.move(1, 0); // X
        game.move(2, 0); // O
        game.move(1, 1); // X
        game.move(2, 2); // O
        game.move(2, 1); // X
        assertFalse(game.hasWinner());
        assertTrue(game.isDraw());
    }

    @Test
    void emptyBoardNotDrawTest() {
        assertFalse(game.isDraw());
    }

    @Test
    void partialBoardNotDrawTest() {
        game.move(0, 0);
        assertFalse(game.isDraw());
    }

    @Test
    void winnerNotDrawTest() {
        game.move(0, 0); // X
        game.move(1, 0); // O
        game.move(0, 1); // X
        game.move(1, 1); // O
        game.move(0, 2); // X wins
        assertFalse(game.isDraw());
    }

    @Test
    void fullBoardDrawTest() {
        // X O X
        // X X O
        // O X O
        game.move(0, 0); // X
        game.move(0, 1); // O
        game.move(0, 2); // X
        game.move(1, 2); // O
        game.move(1, 0); // X
        game.move(2, 0); // O
        game.move(1, 1); // X
        game.move(2, 2); // O
        game.move(2, 1); // X
        assertTrue(game.isDraw());
    }

    @Test
    void noMovesAfterWinTest() {
        game.move(0, 0); // X
        game.move(1, 0); // O
        game.move(0, 1); // X
        game.move(1, 1); // O
        game.move(0, 2); // X wins
        assertFalse(game.move(2, 0), "No moves allowed after game ends");
    }

    @Test
    void noMovesAfterDrawTest() {
        game.move(0, 0); // X
        game.move(0, 1); // O
        game.move(0, 2); // X
        game.move(1, 2); // O
        game.move(1, 0); // X
        game.move(2, 0); // O
        game.move(1, 1); // X
        game.move(2, 2); // O
        game.move(2, 1); // X — draw
        // Board is full, but ensure the guard is in place
        assertTrue(game.isGameOver());
    }

    @Test
    void notOverAtStartTest() {
        assertFalse(game.isGameOver());
    }

    @Test
    void noWinnerReturnsSpaceTest() {
        assertEquals(' ', game.getWinner());
    }

    @Test
    void xWinsTest() {
        game.move(0, 0); // X
        game.move(1, 0); // O
        game.move(0, 1); // X
        game.move(1, 1); // O
        game.move(0, 2); // X wins
        assertEquals('X', game.getWinner());
    }

    @Test
    void oWinsTest() {
        game.move(2, 2); // X
        game.move(0, 0); // O
        game.move(2, 0); // X
        game.move(0, 1); // O
        game.move(1, 2); // X
        game.move(0, 2); // O wins top row
        assertEquals('O', game.getWinner());
    }

    private void playXWinsCol(int col) {
        int safeRow = (col == 0) ? 1 : 0;
        game.move(0, col);               // X
        game.move(safeRow, (col + 1) % 3); // O
        game.move(1, col);               // X
        game.move(safeRow, (col + 2) % 3); // O
        game.move(2, col);               // X wins
    }

    /**
     * X fills the given row; O plays a safe column.
     */
    private void playXWinsRow(int row) {
        int safeCol = (row == 0) ? 1 : 0; // column O uses that is NOT in X's row
        game.move(row, 0);                 // X
        game.move((row + 1) % 3, safeCol); // O (different row)
        game.move(row, 1);                 // X
        game.move((row + 2) % 3, safeCol); // O (different row)
        game.move(row, 2);                 // X wins
    }

}

