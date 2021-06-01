package tictactoe.mainclasses;

import tictactoe.interfaces_.UserInput;

public class Player {
    
    UserInput positionGetter;
    Board board;
    
    public Player(UserInput positionGetter, Board board){
        this.positionGetter = positionGetter;
        this.board = board;
    }
    
    void play(char symbol){

       int[] position = playerMove(positionGetter, board);
       board.getBoard()[position[0]][position[1]] = symbol;        
        
    }


    private static int[] playerMove(UserInput positionGetter, Board board){

        char[] coordinates = positionGetter.getUserInput();
        int row = Integer.parseInt(String.valueOf(coordinates[0])) - 1;
        int column = Integer.parseInt(String.valueOf(coordinates[1])) - 1;

        while(board.getBoard()[row][column] != ' '){

            row = Integer.parseInt(String.valueOf(coordinates[0])) - 1;
            column = Integer.parseInt(String.valueOf(coordinates[1])) - 1;

        }

        return new int[]{row, column};

    }



}
