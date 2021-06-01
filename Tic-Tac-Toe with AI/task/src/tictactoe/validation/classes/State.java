package tictactoe.validation.classes;

import tictactoe.mainclasses.Board;
import tictactoe.validation.interfaces_.StateChecker;

public class State {

    Board board;

    public State(Board board) {
        this.board = board;
    }

    public boolean checkState(char symbol, Board board) {

        return checkColumns.check(symbol, board)
                || checkRows.check(symbol, board)
                || checkDiagonals.check(symbol, board);
        
    }

    private final StateChecker checkColumns = (symbol, board) -> {

        for (int i = 0; i < board.getBOARD_COLUMN(); i++) {

            if (board.getBoard()[0][i] == symbol
                    && board.getBoard()[1][i] == symbol
                    && board.getBoard()[2][i] == symbol)
                return true;

        }

        return false;

    };

    private final StateChecker checkRows = (symbol, board1) -> {

        for (int i = 0; i < board.getBOARD_ROW(); i++) {

            if (board.getBoard()[i][0] == symbol
                    && board.getBoard()[i][1] == symbol
                    && board.getBoard()[i][2] == symbol)
                return true;

        }

        return false;
        
    };

    private final StateChecker checkDiagonals = (symbol, board1) -> {

        if (board.getBoard()[0][0] == symbol
                && board.getBoard()[1][1] == symbol
                && board.getBoard()[2][2] == symbol)
            return true;

        return board.getBoard()[0][2] == symbol
                && board.getBoard()[1][1] == symbol
                && board.getBoard()[2][0] == symbol;        
        
    };
   

}
