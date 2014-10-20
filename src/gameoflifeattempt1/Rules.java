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
    public boolean[][] board;
    public Board canvas;
    public void intialize(boolean[][] board){
        this.board = board;
    }
    public void draw(){
        int a =canvas.xcanvassize;
        int b =canvas.ycanvassize;
        for(int x = 0;x<board.length;x++){
            for(int y = 0;y<board[0].length;y++){
                if(board[x][y])Board.filledRectangle((double)x,(double)y,(double)a,(double)b);
            }
        }
    }
}
