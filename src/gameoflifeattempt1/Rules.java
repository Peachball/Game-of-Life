/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflifeattempt1;

/**
 *
 * @author chen
 */
public class Rules {

    public static boolean[][] board;
    public Board canvas;

    public Rules(boolean[][] file) {
        board = file;
        canvas = new Board(board.length, board[0].length);
    }

    public Rules(int x, int y) {
        board = new boolean[x][y];
        canvas = new Board(board.length, board[0].length);
    }

    public void draw() {
        canvas.setPenColor(Board.BLACK);
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y]) {
                    StdDraw.filledRectangle((double) x, (double) y, 1, 1);
                }
            }
        }
        canvas.show();
    }

    public void create() {
        int sides = 0;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (x > 1 && board[x - 1][y]) {
                    sides += 1;
                }
                if (x > 1 && y > 1 && board[x - 1][y - 1]) {
                    sides += 1;
                }
                if (y > 1 && board[x][y - 1]) {
                    sides += 1;
                }
                if (x + 1 < board.length && board[x + 1][y]) {
                    sides += 1;
                }
                if (x + 1 < board.length && y + 1 < board[0].length && board[x + 1][y + 1]) {
                    sides += 1;
                }
                if (y + 1 < board.length && board[x][y + 1]) {
                    sides += 1;
                }
                if (y > 1 && x + 1 < board.length && board[x + 1][y - 1]) {
                    sides += 1;
                }
                if (x > 1 && y + 1 < board[0].length && board[x - 1][y + 1]) {
                    sides += 1;
                }
                if (sides == 3 && !board[x][y]) {
                    board[x][y] = true;
                }
                if (sides > 3 && board[x][y]) {
                    board[x][y] = false;
                }
                if (sides < 2 && board[x][y]) {
                    board[x][y] = false;
                }
            }
        }
        canvas.show();
    }

    public void intializeFrame() {
        canvas.setPenColor(Board.BLACK);
        canvas.filledRectangle(-board.length, -board[0].length, board.length,
                board[0].length);
    }
}
