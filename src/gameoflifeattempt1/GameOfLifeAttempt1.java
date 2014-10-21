/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflifeattempt1;

/**
 *
 * @author s-xuch
 */
public class GameOfLifeAttempt1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Input the dimensions plox");
        int dimensions = StdIn.readInt();
        Board board = new Board(dimensions, dimensions);
        Rules.intialize(dimensions,dimensions);
        // TODO code application logic here
    }

}
