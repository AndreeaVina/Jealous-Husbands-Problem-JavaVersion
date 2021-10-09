import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Backtracking extends Algorithm{
    private List<Step> steps = new ArrayList<>();
    Backtracking(State state) {
        super(state);
    }
    public void calculateSolution(){
        if(checkIfStateIsFinal(this.state))
            displaySolution();
        else{
            var numberOfPersons =  (int)((Math.random() * (3 - 1)) + 1);
            if(numberOfPersons == 1){
                var randomType = Arrays.asList("husband","wife").get(new Random().nextInt(2));
//                var randomCoupleNumber
            }
        }
    }
    public void displaySolution(){
       for (var step : steps) {
           System.out.print(step.getPerson1().getType() + step.getNumberPerson1() + " ");
           if(!step.getPerson2().equals(null))
               System.out.print(step.getPerson2().getType() + step.getNumberPerson2() + " ");
           System.out.print(step.getBoatPosition());
       }
    }
}
