package Card;

public class Omen extends Card {

    public Omen(){
        String ravenClaw = "A gnarled, shriveled raven's claw. " +
                "\nSpook count +1";
        String batWing = "A leathery black wing. " +
                "\nSpook count +1";
        String deerAntler = "A cracked, greying antler \nwith dark brown " +
                "splotches \nat its base. " +
                "\nSpook count +1";
        String ratSkull = "A tiny, delicate rat skull \nwith bits of rotting " +
                "\nflesh behind its eye sockets. " +
                "\nSpook count +1";

        int which = (int)(Math.random() * (4 - 1) + 1) + 1;
        if(which == 1){
            this.setCardName("RAVEN CLAW");
            this.setCardDescription(ravenClaw);
            this.setType("Omen");
        }
        else if(which == 2){
            this.setCardName("BAT WING");
            this.setCardDescription(batWing);
            this.setType("Omen");
        }
        else if(which == 3){
            this.setCardName("DEER ANTLER");
            this.setCardDescription(deerAntler);
            this.setType("Omen");
        }
        else{
            this.setCardName("RAT SKULL");
            this.setCardDescription(ratSkull);
            this.setType("Omen");
        }
    }
//
//    public String toString(){
//        return "Omen";
//    }
}
