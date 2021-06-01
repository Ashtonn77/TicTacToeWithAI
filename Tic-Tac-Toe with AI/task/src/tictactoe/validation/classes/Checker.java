package tictactoe.validation.classes;

import tictactoe.validation.interfaces_.PlayerChecker;
import tictactoe.validation.interfaces_.Validator;

public class Checker {

    public Validator boundary = (values) ->
            (Integer.parseInt(String.valueOf(values[0])) >= 1 && Integer.parseInt(String.valueOf(values[0])) <= 3)
                    &&
                    (Integer.parseInt(String.valueOf(values[1])) >= 1 && Integer.parseInt(String.valueOf(values[1])) <= 3);


    public Validator numbers = (values) ->
            Character.isDigit(values[0]) && Character.isDigit(values[1]);
    
    
    public Validator cells = (values) -> {
        
        if(values.length != 9) return false;
        for(char value : values){
            
            if(value != '_' && value != 'X' && value != 'O')
                return false;
        }
        
        return true;
        
    };
   
    public PlayerChecker players = (input) -> {
        
      String[] inputArray = input.split(" ");
      
      if(inputArray.length == 0 || inputArray.length == 2)
          return false;
      
      if(inputArray.length == 1 && !inputArray[0].equals("exit"))
        return false;
          
      for(String word : inputArray)
          if(!word.equals("easy") && !word.equals("user") 
                  && !word.equals("exit") && !word.equals("start")
                  && !word.equals("medium") && !word.equals("hard"))
              return false;
        
      return true;  
      
    };
    

}
