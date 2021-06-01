package tictactoe.mainclasses;

import tictactoe.validation.classes.State;

public class Computer {

    Board board;
    State state;
    static char player;
    static char opponent;
    public Computer(Board board, State state, char home, char away){
        this.board = board;
        this.state = state;
        player = away;
        opponent = home;
    }

    
       class Move{
            
            int row, column;        
            
        }
    
    boolean isMovesLeft(){
        
        for(int i = 0; i < board.getBOARD_ROW(); i++){
            
            for(int j = 0; j < board.getBOARD_COLUMN(); j++){
                
                if(board.getBoard()[i][j] == ' ')
                    return true;
                
            }
            
        }
        
        return false;
        
    }

    int evaluate(Board board){
        
        if(isWinner(state, board, player))
            return +10;
        if(isWinner(state, board, opponent))
            return -10;
        
        return 0;
        
    }

    private static boolean isWinner(State state, Board board, char symbol) {

        if (state.checkState(symbol, board)) {
            return true;
        }
        return false;
    }
    
    
    int miniMax(int depth, boolean isMax){
        
        int score = evaluate(board);
        
        if(score == 10)
            return score;
        
        if(score == -10)
            return score;
        
        
        if(!isMovesLeft())
            return 0;
        
        if(isMax){
            
            int best = -1000;
            
            for(int i = 0; i < 3; i++){
                
                for(int j = 0; j < 3; j++){
                    
                    if(board.getBoard()[i][j] == ' '){
                        
                        board.getBoard()[i][j] = player;
                        
                        best = Math.max(best, miniMax(depth + 1, !isMax));

                        board.getBoard()[i][j] = ' ';
                        
                    }
                    
                    
                }
                
                
            }
            
            return best;
            
        }else{


            int best = 1000;

            for(int i = 0; i < 3; i++){

                for(int j = 0; j < 3; j++){

                    if(board.getBoard()[i][j] == ' '){

                        board.getBoard()[i][j] = opponent;

                        best = Math.min(best, miniMax(depth + 1, !isMax));

                        board.getBoard()[i][j] = ' ';

                    }


                }


            }

            return best;
         
        }
       
    }
    
    public int[] findBestMove(){
        
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.column = -1;

        for(int i = 0; i < 3; i++){

            for(int j = 0; j < 3; j++){

                
                if(board.getBoard()[i][j] == ' '){
                    
                    board.getBoard()[i][j] = player;
                    int moveVal = miniMax(0, false);

                    board.getBoard()[i][j] = ' ';
                    
                    if(moveVal > bestVal){
                        
                        bestMove.row = i;
                        bestMove.column = j;
                        bestVal = moveVal;
                        
                    }
            
                }
             

            }


        }
        
        return new int[]{bestMove.row, bestMove.column};
        
    }


}
