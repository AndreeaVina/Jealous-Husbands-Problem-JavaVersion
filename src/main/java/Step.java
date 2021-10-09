public class Step {
    private Person person1;
    private Person person2;
    private int numberPerson1;
    private int numberPerson2;
    private String boatPosition;

    public void setNumberPerson1(int numberPerson1) {
        this.numberPerson1 = numberPerson1;
    }

    public void setNumberPerson2(int numberPerson2) {
        this.numberPerson2 = numberPerson2;
    }

    public void setPerson1(Person person1) {

        this.person1= person1;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    public void setBoat(String boat) {
        this.boatPosition = boat;
    }

    public int getNumberPerson1() {
        return numberPerson1;
    }

    public int getNumberPerson2() {
        return numberPerson2;
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public String getBoatPosition() {
        return boatPosition;
    }
}
