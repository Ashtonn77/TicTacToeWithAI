package tictactoe.helpers;

import tictactoe.interfaces_.UserInput;
import tictactoe.validation.classes.Checker;

import java.util.Arrays;
import java.util.Scanner;

public class PositionGetter implements UserInput {
    
    Checker checker;
    public PositionGetter(Checker checker){
        this.checker = checker;
    }
    
    @Override
    public char[] getUserInput() {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        
        String coordinatesInput = in.nextLine();
        String[] coordinates = coordinatesInput.split(" ");
        
        char[] output = String.join("", coordinates).toCharArray();


        if(!checker.numbers.validate(output)){

            System.out.println("You should enter numbers!");
            return getUserInput();

        }else if(!checker.boundary.validate(output)){
            
            System.out.println("Coordinates should be from 1 to 3!");
            System.out.println(Arrays.toString(output));
            return getUserInput();
            
        }
      
        return output;
        
    }
}
