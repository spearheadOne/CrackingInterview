package org.abondar.experimental.problems.other;

public class TicTacToe {

    private final char[][] board;
    private char currentPlayer;
    private boolean gameOver = false;


    public TicTacToe() {
        this.board = new char[3][3];
        this.currentPlayer = 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean move(int row, int col) {
        if (gameOver) return false;
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        if (board[row][col] != ' ') {
            return false;
        }

        board[row][col] = currentPlayer;
        if (hasWinner() || isDraw()) {
            gameOver = true;
            return true;
        }


        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        return true;
    }

    public boolean hasWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return true;
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
                return true;
        }

        // Top-left to bottom-right
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;

        // Top-right to bottom-left
        return board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0];
    }

    public boolean isDraw() {
        if (hasWinner()) return false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;

    }

    public char getWinner() {
        return hasWinner() ? currentPlayer : ' ';
    }

    public boolean isGameOver() {
        return gameOver;
    }

}
