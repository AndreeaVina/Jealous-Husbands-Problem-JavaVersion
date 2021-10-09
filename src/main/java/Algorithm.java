
public abstract class Algorithm {
    protected State state;
    Algorithm(State state) {
       this.state = state;
    }

    public boolean checkIfStateIsFinal(State state) {
        if (state.getBoatState().equals("Start"))
            return false;
       for(int i = 0; i< state.getNumberOfCouples();i++){
           if(state.getHusbands().get(i).getSideOfRiver().equals("Start") || state.getWives().get(i).getSideOfRiver().equals("Start"))
               return false;
       }

        return true;
    }

    public boolean checkIfTransitionIsValid(State state, Person person1, int coupleNumber1, Person person2, int coupleNumber2, String side) {
        /**
         * we should have at least one person in the boat
         */
        if(person1 == null && person2 == null)
            return false;
        /**
         *  the boat is already on the transition side so transition is not valid
         */
        if (state.getBoatState().equals(side))
            return false;

        var husbands = state.getHusbands();
        var wives = state.getWives();
        /**
         * if the person1 is a wife we should check if her husband is on the side where we make the transition
         * if not we have to check if there is more than one husband from another couple
         */
        if (person1.getType().equals("wife"))
            if(!husbands.get(coupleNumber1).getSideOfRiver().equals(side))
                for(int i=0; i < state.getNumberOfCouples();i++)
                    if(husbands.get(i).getSideOfRiver().equals(side))
                        return false;

        /**
         * same check for person number 2
          */
        if (person2.getType().equals("wife"))
            if(!husbands.get(coupleNumber2).getSideOfRiver().equals(side))
                for(int i=0; i < state.getNumberOfCouples();i++)
                    if(husbands.get(i).getSideOfRiver().equals(side))
                        return false;
        /**
         * if the person in the boat is a husband we should check if his wife is not alone
         * one the other side with at another husband
          */
        if (person1.getType().equals("husband"))
            if(!wives.get(coupleNumber1).getSideOfRiver().equals(husbands.get(coupleNumber1).getSideOfRiver()))
                for(int i=0; i < state.getNumberOfCouples();i++)
                    if(husbands.get(i).getSideOfRiver().equals(wives.get(coupleNumber1).getSideOfRiver()))
                        return false;
        if (person2.getType().equals("husband"))
            if(!wives.get(coupleNumber2).getSideOfRiver().equals(husbands.get(coupleNumber2).getSideOfRiver()))
                for(int i=0; i < state.getNumberOfCouples();i++)
                    if(husbands.get(i).getSideOfRiver().equals(wives.get(coupleNumber2).getSideOfRiver()))
                        return false;
        return true;
    }
    public State getChangedState(State state, Person person1, int coupleNumber1, Person person2, int coupleNumber2, String side){
        if(checkIfTransitionIsValid(state,person1,coupleNumber1,person2,coupleNumber2,side)){
            if(person1.getType().equals("husband"))
                state.getHusbands().get(coupleNumber1).changeSideOfRiver(side);
            else  state.getWives().get(coupleNumber1).changeSideOfRiver(side);
            if(person2.getType().equals("husband"))
                state.getHusbands().get(coupleNumber2).changeSideOfRiver(side);
            else  state.getWives().get(coupleNumber2).changeSideOfRiver(side);
            state.changeBoatLocation(side);
        }
        return state;
    }
}