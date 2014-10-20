/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflifeattempt1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author s-xuch
 */
public class Board {

    private boolean[][] board;

    //COLORS!
    public static final Color BLACK = Color.BLACK;
    public static final Color BLUE = Color.BLUE;
    public static final Color CYAN = Color.CYAN;
    public static final Color DARK_GRAY = Color.DARK_GRAY;
    public static final Color GRAY = Color.GRAY;
    public static final Color GREEN = Color.GREEN;
    public static final Color LIGHT_GRAY = Color.LIGHT_GRAY;
    public static final Color MAGENTA = Color.MAGENTA;
    public static final Color ORANGE = Color.ORANGE;
    public static final Color PINK = Color.PINK;
    public static final Color RED = Color.RED;
    public static final Color WHITE = Color.WHITE;
    public static final Color YELLOW = Color.YELLOW;
    public static final Color DEFAULT_BACKGROUND_COLOR = WHITE;
    public static final Color DEFAULT_PEN_COLOR = BLACK;
    //Frame initialization
    private static JFrame frame;
    public int xcanvassize;
    public int ycanvassize;

    //Board Borders (The sizes, and the ratio of border to
    //total size of frame
    private static final double borderratio = 0.005;
    private static double xmin;
    private static double xmax;
    private static double ymin;
    private static double ymax;
    private static final double DEFAULT_BORDER_SIZE = 1;

    //Buffers for Images
    private BufferedImage offscreenImage, onscreenImage;
    private Graphics2D offscreen, onscreen;

    // mouse state
    private static boolean mousePressed = false;
    private static double mouseX = 0;
    private static double mouseY = 0;

    public void xSize() {
        xSize(0, 1);
    }

    public void xSize(double min, double max) {
        double size = max - min;
        xmin = min - borderratio * size;
        xmax = max + borderratio * size;
    }

    public void ySize() {
        ySize(0, 1);
    }

    public void ySize(double min, double max) {
        double size = max - min;
        ymin = min - borderratio * size;
        ymax = max + borderratio * size;
    }

    public void showBoard() {
        setCanvasSize();
    }

    public void hideBoard() {
        frame.setVisible(false);
    }

    public void setCanvasSize() {
        setCanvasSize(600, 600);
    }
    //Canvas refers to the size of the frame, which makes no sense...

    public void setCanvasSize(int width, int height) {
        frame.setSize(width, height);
        xcanvassize = width;
        ycanvassize = height;
        intialize();
    }

    private void intialize() {
        frame = new JFrame("Game of Life");
        frame.setVisible(false);
        setCanvasSize();
        onscreenImage = new BufferedImage(xcanvassize, ycanvassize, BufferedImage.TYPE_INT_ARGB);
        offscreenImage = new BufferedImage(xcanvassize, ycanvassize, BufferedImage.TYPE_INT_ARGB);
        onscreen = onscreenImage.createGraphics();
        offscreen = offscreenImage.createGraphics();

    }

    public void filledRectangle(double x, double y, double width, double height) {
        if (width < 0) {
            throw new RuntimeException("width must be positive");
        }
        if (height < 0) {
            throw new RuntimeException("width must be positive");
        }
        double xcoord = xcanvassize / (xmax - xmin) * (x - xmin);
        double ycoord = ycanvassize / (ymax - ymin) * (y - ymin);
        double xsize = width * xcanvassize / (xmax - xmin);
        double ysize = height * ycanvassize / (ymax - ymin);
        if (xsize <= 1 && ysize <= 1) {
            pixel(x, y);
        } else {
            offscreen.draw(new Rectangle2D.Double(xcoord - xsize / 2, ycoord - ysize / 2, xsize, ysize));
        }
    }

    public void filledSquare(double x, double y, double width) {
        if (width < 0) {
            throw new RuntimeException("width must be positive");
        }
        double xcoord = xcanvassize / (xmax - xmin) * (x - xmin);
        double ycoord = ycanvassize / (ymax - ymin) * (y - ymin);
        double xsize = width * xcanvassize / (xmax - xmin);
        double ysize = xsize;
        if (xsize <= 1 && ysize <= 1) {
            pixel(x, y);
        } else {
            offscreen.draw(new Rectangle2D.Double(xcoord - xsize / 2, ycoord - ysize / 2, xsize, ysize));
        }
    }

    public void pixel(double x, double y) {
        offscreen.fillRect((int) Math.round(xcanvassize / (xmax - xmin) * (x - xmin)),
                (int) Math.round(ycanvassize / (ymax - ymin) * (y - ymin)), 1, 1);
    }

    public void show() {
        onscreen.drawImage(offscreenImage, 0, 0, null);
        frame.repaint();
        frame.setVisible(true);
    }

    public Board(int xDim, int yDim) {
        board = new boolean[xDim][yDim];
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setCanvasSize();
    }

}
