package tictactoe.mainclasses;

import tictactoe.helpers.AI;
import tictactoe.helpers.PlayerInput;
import tictactoe.helpers.PositionGetter;
import tictactoe.helpers.PrintUtil;
import tictactoe.interfaces_.UserInput;
import tictactoe.validation.classes.Checker;
import tictactoe.validation.classes.PlayLastCellToWin;
import tictactoe.validation.classes.State;

import java.util.Random;

public class Game {

    Board board = new Board();
    State state = new State(board);  

    UserInput positionGetter = new PositionGetter(new Checker());

    AI ai = new AI(new PlayLastCellToWin(board), board);
    Player player = new Player(positionGetter, board);

    boolean isPlayerTurn = true;
    Random randomGenerator = new Random();    

    void start() {

        int cellLimit = 0;
        char[] choice = new PlayerInput(new Checker()).getUserInput();
        if (choice[0] == '0')
            System.exit(0);

        int first = choice[1];
        int second = choice[2];

        if (first == '2' && second == '2') {

            while (true) {

                new PrintUtil(board).print(board);
                
                if (isPlayerTurn) {

                    player.play('X');
                    isPlayerTurn = false;

                } else {

                    player.play('O');
                    isPlayerTurn = true;

                }
                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }
            

        } else if (first == '2' && second == '3') {


            while (true) {

                new PrintUtil(board).print(board);
                
                if (isPlayerTurn) {

                    player.play('X');
                    isPlayerTurn = false;

                } else {

                    ai.execute(randomGenerator, 'O');
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }
            
            
        } else if (first == '2' && second == '4') {

            while (true) {

                new PrintUtil(board).print(board);
                
                if (isPlayerTurn) {

                    player.play('X');
                    isPlayerTurn = false;

                } else {

                    ai.execute(randomGenerator, 'O', 'X');
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }
            

        }else if(first == '2' && second == '5'){
            
            Computer computer = new Computer(board, state, 'X', 'O');
            
            while (true) {

                new PrintUtil(board).print(board);

                if (isPlayerTurn) {

                    player.play('X');
                    isPlayerTurn = false;

                } else {

                  int[] pos = computer.findBestMove();
                  board.getBoard()[pos[0]][pos[1]] = 'O';                   
                  isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }
            
            
 
            
        } else if (first == '3' && second == '2') {

            while (true) {

                new PrintUtil(board).print(board);
                
                if (isPlayerTurn) {

                    ai.execute(randomGenerator, 'X');
                    isPlayerTurn = false;

                } else {

                    player.play('O');
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }
            
            
        } else if (first == '3' && second == '3') {

            while (true) {

                new PrintUtil(board).print(board);
                
                if (isPlayerTurn) {

                    ai.execute(randomGenerator, 'X');
                    isPlayerTurn = false;

                } else {

                    ai.execute(randomGenerator, 'O');
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }


        }else if (first == '3' && second == '4') {

            while (true) {

                new PrintUtil(board).print(board);
                
                if (isPlayerTurn) {

                    ai.execute(randomGenerator, 'X');
                    isPlayerTurn = false;

                } else {

                    ai.execute(randomGenerator, 'O', 'X');
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }

        } else if(first == '3' && second == '5'){
        
            Computer computer = new Computer(board, state, 'X', 'O');

            while (true) {

                new PrintUtil(board).print(board);

                if (isPlayerTurn) {

                    ai.execute(randomGenerator, 'X');
                    isPlayerTurn = false;

                } else {

                    int[] pos = computer.findBestMove();
                    board.getBoard()[pos[0]][pos[1]] = 'O';
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }



        } else if (first == '4' && second == '2') {

            while (true) {

                new PrintUtil(board).print(board);
                
                if (isPlayerTurn) {

                    ai.execute(randomGenerator, 'X', 'O');
                    isPlayerTurn = false;

                } else {

                    player.play('O');
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }
         

        } else if (first == '4' && second == '3') {

            while (true) {

                new PrintUtil(board).print(board);
                
                if (isPlayerTurn) {

                    ai.execute(randomGenerator, 'X', 'O');
                    isPlayerTurn = false;

                } else {

                    ai.execute(randomGenerator, 'O');
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }


        } else if (first == '4' && second == '4') {

            while (true) {

                new PrintUtil(board).print(board);
                
                if (isPlayerTurn) {

                    ai.execute(randomGenerator, 'X', 'O');
                    isPlayerTurn = false;

                } else {

                    ai.execute(randomGenerator, 'O', 'X');
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }


        }else if(first == '4' && second == '5'){

            Computer computer = new Computer(board, state, 'X', 'O');

            while (true) {

                new PrintUtil(board).print(board);

                if (isPlayerTurn) {

                    ai.execute(randomGenerator, 'X', 'O');
                    isPlayerTurn = false;

                } else {

                    int[] pos = computer.findBestMove();
                    board.getBoard()[pos[0]][pos[1]] = 'O';
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }
            
            

        }
        else if(first == '5' && second == '2'){

            Computer computer = new Computer(board, state, 'O', 'X');

            while (true) {

                new PrintUtil(board).print(board);

                if (isPlayerTurn) {

                    int[] pos = computer.findBestMove();
                    board.getBoard()[pos[0]][pos[1]] = 'X';
                    isPlayerTurn = false;

                } else {

                    player.play('O');
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }
            

        }else if(first == '5' && second == '3'){

            Computer computer = new Computer(board, state, 'O', 'X');

            while (true) {

                new PrintUtil(board).print(board);

                if (isPlayerTurn) {

                    int[] pos = computer.findBestMove();
                    board.getBoard()[pos[0]][pos[1]] = 'X';
                    isPlayerTurn = false;

                } else {

                    ai.execute(randomGenerator, 'O');
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }

        }
        else if(first == '5' && second == '4'){

            Computer computer = new Computer(board, state, 'O', 'X');

            while (true) {

                new PrintUtil(board).print(board);

                if (isPlayerTurn) {

                    int[] pos = computer.findBestMove();
                    board.getBoard()[pos[0]][pos[1]] = 'X';
                    isPlayerTurn = false;

                } else {

                    ai.execute(randomGenerator, 'O', 'X');
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }



        }else if(first == '5' && second == '5'){
          
            while (true) {

                new PrintUtil(board).print(board);

                if (isPlayerTurn) {
                    
                    Computer computer = new Computer(board, state, 'O', 'X');
                    int[] pos = computer.findBestMove();
                    board.getBoard()[pos[0]][pos[1]] = 'X';
                    isPlayerTurn = false;

                } else {
                    
                    Computer computer = new Computer(board, state, 'X', 'O');
                    int[] pos = computer.findBestMove();
                    board.getBoard()[pos[0]][pos[1]] = 'O';
                    isPlayerTurn = true;

                }

                cellLimit++;
                if (isWinner(state, board, 'X'))
                    break;
                if (isWinner(state, board, 'O'))
                    break;

                if (cellLimit == 9) {
                    new PrintUtil(board).print(board);
                    System.out.println("Draw");
                    break;
                }

            }

        }


    }

    private static boolean isWinner(State state, Board board, char symbol) {

        if (state.checkState(symbol, board)) {
            new PrintUtil(board).print(board);
            System.out.println(symbol + " wins");
            return true;
        }
        return false;
    }

}
