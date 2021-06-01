package tictactoe.validation.interfaces_;

import tictactoe.mainclasses.Board;

public interface StateChecker {
    
    boolean check(char symbol, Board board);
    
}
