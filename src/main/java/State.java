import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {
    private int n;
    private List<Person> husbands = new ArrayList<> ();
    private List<Person> wifes = new ArrayList<> ();
    private String boat;
    State(int n){
        this.n = n;
        this.boat = "Start";
        for(int i=0;i<this.n;i++){
            husbands.add(new Person("husband"));
            wifes.add(new Person("wife"));
        }
    }
    public String getBoatState(){
        return this.boat;
    }
    public int getNumberOfCouples(){
        return this.n;
    }

    public List<Person> getHusbands() {
        return husbands;
    }

    public List<Person> getWives() {
        return wifes;
    }

    public void changeBoatLocation(String side){
        this.boat = side;
    }

}
