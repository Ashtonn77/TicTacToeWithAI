package tictactoe.helpers;

import tictactoe.interfaces_.UserInput;
import tictactoe.validation.classes.Checker;
import tictactoe.validation.interfaces_.PlayerChecker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayerInput implements UserInput {
    
    Checker checker;
    public PlayerInput(Checker checker){
        this.checker = checker;
    }
    
    @Override
    public char[] getUserInput() {

        Scanner in = new Scanner(System.in);

        System.out.print("Input command: ");

        String choice = in.nextLine();
        
        if(!checker.players.check(choice)) {
            System.out.println("Bad parameters!");
            return getUserInput();
        }
        
        return splitChoice(choice);
        
    }
    
    private char[] splitChoice(String choice){

        Map<String, Character> map = new HashMap<>();
        
        map.put("exit", '0');
        map.put("start", '1');
        map.put("user", '2');
        map.put("easy", '3');
        map.put("medium", '4');
        map.put("hard", '5');
        
        String[] array = choice.split(" ");

        return array.length == 1 ? new char[]{'0', '9', '9', '9', '9'} 
        : new char[]{map.get(array[0]), map.get(array[1]), map.get(array[2])};
        
    }
    
}
