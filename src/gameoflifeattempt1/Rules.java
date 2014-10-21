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

    public static void intialize(boolean[][] file) {
        board = file;
    }
    public static void intialize(int x, int y){
        board = new boolean[x][y];
    }

    public void draw() {
        double a = canvas.xcanvassize/board.length;
        double b = canvas.ycanvassize/board[0].length;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y]) {
                    canvas.filledRectangle((double) x, (double) y,  a,  b);
                }
            }
        }
        canvas.show();
    }
}
