package tictactoe.helpers;

import tictactoe.interfaces_.Difficulty;
import tictactoe.mainclasses.Board;
import tictactoe.validation.classes.PlayLastCellToWin;

import java.util.Random;

public class AI implements Difficulty{
    
    PlayLastCellToWin playLastCellToWin;
    Board board;
    
    public AI(PlayLastCellToWin playLastCellToWin, Board board){
        this.playLastCellToWin = playLastCellToWin;
        this.board = board;
    }

    @Override
    public void execute(Random random, char symbol) {

        System.out.println("Making move level \"easy\"");
        playRandom(random, symbol);

    }

    public void execute(Random random, char homeSymbol, char awaySymbol){

        System.out.println("Making move level \"medium\"");
        
        if(!playLastCell(homeSymbol) && !blockOpponent(homeSymbol, awaySymbol)){
            
            playRandom(random, homeSymbol);
            
        }
        
    }

    private void playRandom(Random random, char symbol){

        int[] coords = computerMove(random, board);
        board.getBoard()[coords[0]][coords[1]] = symbol;
        
    }
    
    private boolean playLastCell(char homeSymbol){
        
        return playLastCellToWin.checkRow(homeSymbol, homeSymbol)
                || playLastCellToWin.checkColumn(homeSymbol, homeSymbol)
                || playLastCellToWin.checkDiagonal(homeSymbol, homeSymbol);
        
    }
    
    private boolean blockOpponent(char homeSymbol, char awaySymbol){

        return playLastCellToWin.checkRow(awaySymbol, homeSymbol)
                || playLastCellToWin.checkColumn(awaySymbol, homeSymbol)
                || playLastCellToWin.checkDiagonal(awaySymbol, homeSymbol);
        
    }
            
    private static int[] computerMove(Random randomGenerator, Board board){

       
        int randomRow = randomGenerator.nextInt(3);
        int randomColumn = randomGenerator.nextInt(3);

        while(board.getBoard()[randomRow][randomColumn] != ' '){

            randomRow = randomGenerator.nextInt(3);
            randomColumn = randomGenerator.nextInt(3);

        }

        return new int[]{randomRow, randomColumn};

    }


   
}
