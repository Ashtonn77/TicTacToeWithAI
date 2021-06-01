package tictactoe.helpers;

import tictactoe.interfaces_.UserInput;
import tictactoe.validation.classes.Checker;

import java.util.Scanner;

public class CellGetter implements UserInput {

    Checker checker;
    
    public CellGetter(Checker checker){
        this.checker = checker;
    }
    
    @Override
    public char[] getUserInput() {
        
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter the cells: ");
        String cellInput = in.nextLine();
        
        char[] output = cellInput.toUpperCase().toCharArray();
        
        if(checker.cells.validate(output)){
            System.out.println("\nInvalid input. Try again!");
            return getUserInput();
        }            
        
        return output;
        
    }
}
