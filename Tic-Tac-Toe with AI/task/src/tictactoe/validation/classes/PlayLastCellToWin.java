package tictactoe.validation.classes;

import tictactoe.mainclasses.Board;

public class PlayLastCellToWin {
    
    Board board;
    
    public PlayLastCellToWin(Board board){
        this.board = board;
    }
 
    public boolean checkRow(char first, char second){
        
        for(int i = 0; i < 3; i++){
            
            if(board.getBoard()[i][0] == first && board.getBoard()[i][1] == first){
                if(board.getBoard()[i][2] == ' ') {
                    board.getBoard()[i][2] = second;
                    return true;
                }
            }else if(board.getBoard()[i][0] == first && board.getBoard()[i][2] == first){
                if(board.getBoard()[i][1] == ' ') {
                    board.getBoard()[i][1] = second;
                    return true;
                }
            }else if(board.getBoard()[i][1] == first && board.getBoard()[i][2] == first){
                if(board.getBoard()[i][0] == ' ') {
                    board.getBoard()[i][0] = second;
                    return true;
                }
            }
            
        }
        
        return false;
        
    }

    public boolean checkColumn(char first, char second){

        for(int i = 0; i < 3; i++){

            if(board.getBoard()[0][i] == first && board.getBoard()[1][i] == first){
                if(board.getBoard()[2][i] == ' ') {
                    board.getBoard()[2][i] = second;
                    return true;
                }
            }else if(board.getBoard()[0][i] == first && board.getBoard()[2][i] == first){
                if(board.getBoard()[1][i] == ' ') {
                    board.getBoard()[1][i] = second;
                    return true;
                }
            }else if(board.getBoard()[1][i] == first && board.getBoard()[2][i] == first){
                if(board.getBoard()[0][i] == ' ') {
                    board.getBoard()[0][i] = second;
                    return true;
                }
            }

        }

        return false;
        
    }

    public boolean checkDiagonal(char first, char second){

       if(board.getBoard()[0][0] == first && board.getBoard()[1][1] == first){
           if(board.getBoard()[2][2] == ' ') {
               board.getBoard()[2][2] = second;
               return true;
           }
       }else if(board.getBoard()[0][0] == first && board.getBoard()[2][2] == first){
           if(board.getBoard()[1][1] == ' ') {
               board.getBoard()[1][1] = second;
               return true;
           }
       }else if(board.getBoard()[1][1] == first && board.getBoard()[2][2] == first){
           if(board.getBoard()[0][0] == ' ') {
               board.getBoard()[0][0] = second;
               return true;
           }
       }
       
       else if(board.getBoard()[2][0] == first && board.getBoard()[1][1] == first){
           if(board.getBoard()[0][2] == ' ') {
               board.getBoard()[0][2] = second;
               return true;
           }
       }else if(board.getBoard()[2][0] == first && board.getBoard()[0][2] == first){
           if(board.getBoard()[1][1] == ' ') {
               board.getBoard()[1][1] = second;
               return true;
           }
       }else if(board.getBoard()[1][1] == first && board.getBoard()[0][2] == first){
           if(board.getBoard()[2][0] == ' ') {
               board.getBoard()[2][0] = second;
               return true;
           }
       }

        return false;

    }

    
}
