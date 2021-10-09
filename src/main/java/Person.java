public class Person {
    private String type;
    private String sideOfRiver;
    Person(String type) {
        this.type = type;
        this.sideOfRiver = "Start";
    }
    Person(String type, String side){
        this.type = type;
        this.sideOfRiver = side;
    }
    public String getSideOfRiver(){
        return this.sideOfRiver;
    }

    public String getType() {
        return type;
    }
    public void changeSideOfRiver(String side){
        this.sideOfRiver = side;
    }
}
