/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflifeattempt1;

import javax.swing.JFrame;

/**
 *
 * @author s-xuch
 */
public class Board {

    private int[][] board;

    //Frame initialization
    private static JFrame frame;
    private static int xcanvassize;
    private static int ycanvassize;

    //Board Borders
    private static double borderratio = 0.005;
    private static double xmin;
    private static double xmax;
    private static double ymin;
    private static double ymax;
    private static double DEFAULT_BORDER_SIZE = 1;

    public void xSize(double min, double max) {
        double size = max - min;

    }

    public Board(int xDim, int yDim) {
        board = new int[xDim][yDim];
    }

}
