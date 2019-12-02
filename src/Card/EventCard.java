package Card;

public class EventCard extends Card {

    public EventCard() {
        String frogAttack = "Dozens of tiny frogs descend from the " +
                "ceiling and start nibbling at your toes. " +
                "\nSpeed -1";
        String flameDemon = "Suddenly, a burst of flame erupts from " +
                "the floor panels. Your eyebrows are singed. " +
                "\nMight -1";
        String ghostSwoop = "A silvery specter swoops from above. " +
                "\"Your mother never loved you\", it hisses. " +
                "\nSanity -1";
        String stinkBomb = "A gremlin-like creature hops from behind " +
                "a flower pot and tosses something in your direction. " +
                "\nHe cackles and runs away as a putrid yellow smoke fills " +
                "the room. \nKnowledge - 1";

        int which = (int)(Math.random() * (4 - 1) + 1) + 1;
        if(which == 1){
            this.setCardName("FROG ATTACK");
            this.setCardDescription(frogAttack);
            this.setType("Event Card");
        }
        else if(which == 2){
            this.setCardName("FLAME DEMON");
            this.setCardDescription(flameDemon);
            this.setType("Event Card");
        }
        else if(which == 3){
            this.setCardName("GHOST SWOOP");
            this.setCardDescription(ghostSwoop);
            this.setType("Event Card");
        }
        else{
            this.setCardName("STINK BOMB");
            this.setCardDescription(stinkBomb);
            this.setType("Event Card");
        }
    }
//
//    public String toString(){
//        return "Event Card";
//    }
}