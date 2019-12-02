package Card;

public class EventCard extends Card {

    public EventCard() {
        String frogAttack = "Dozens of tiny frogs descend \nfrom the " +
                "ceiling and start \nnibbling at your toes. " +
                "\nSPEED -1";
        String flameDemon = "Suddenly, a burst of flame \nerupts from " +
                "the floor panels. \nYour eyebrows are singed. " +
                "\nMIGHT -1";
        String ghostSwoop = "A silvery specter swoops \nfrom above. " +
                "\"Your mother\nnever loved you\", it hisses. " +
                "\nSANITY -1";
        String stinkBomb = "A gremlin thing appears and \n" +
                "tosses something at you. \n" +
                "Putrid smoke fills the room.\nKNOWLEDGE - 1";

        int which = (int)(Math.random() * (4 - 1) + 1) + 1;
        if(which == 1){
            this.setCardName("FROG ATTACK");
            this.setCardDescription(frogAttack);
            this.setType("Event Card");
            this.setDamage(1);
            this.setCategory("speed");
        }
        else if(which == 2){
            this.setCardName("FLAME DEMON");
            this.setCardDescription(flameDemon);
            this.setType("Event Card");
            this.setDamage(1);
            this.setCategory("might");
        }
        else if(which == 3){
            this.setCardName("GHOST SWOOP");
            this.setCardDescription(ghostSwoop);
            this.setType("Event Card");
            this.setDamage(1);
            this.setCategory("sanity");
        }
        else{
            this.setCardName("STINK BOMB");
            this.setCardDescription(stinkBomb);
            this.setType("Event Card");
            this.setCategory("knowledge");
        }
    }
}