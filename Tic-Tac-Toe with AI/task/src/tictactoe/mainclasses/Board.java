package tictactoe.mainclasses;


public class Board{
    
    private final int BOARD_ROW = 3;
    private final int BOARD_COLUMN = 3;
    private final char[][] board;

    public Board(){
        this.board = new char[BOARD_ROW][BOARD_COLUMN];
        for(int i = 0; i < BOARD_ROW; i++)
            for(int j = 0; j < BOARD_COLUMN; j++)
                this.board[i][j] = ' ';
    }

    public char[][] getBoard() {
        return board;
    }

    public int getBOARD_ROW() {
        return BOARD_ROW;
    }

    public int getBOARD_COLUMN() {
        return BOARD_COLUMN;
    }
    
}
