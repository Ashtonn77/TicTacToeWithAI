package tictactoe.helpers;

import tictactoe.interfaces_.Printer;
import tictactoe.mainclasses.Board;

public class PrintUtil implements Printer {

    Board board;
    
    public PrintUtil(Board board) {
        this.board = board;
    }

    @Override
    public void print(Board board) {

        System.out.println("---------");

        for(int i = 0; i < board.getBOARD_ROW(); i++){

            System.out.print("| ");

            for(int j = 0; j < board.getBOARD_COLUMN(); j++){


                System.out.print(board.getBoard()[i][j] + " ");

            }

            System.out.println("|");

        }

        System.out.println("---------");

    }
    
}
