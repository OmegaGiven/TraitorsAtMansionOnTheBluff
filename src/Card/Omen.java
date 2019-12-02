package Card;

public class Omen extends Card {

    public Omen(){
        String ravenClaw = "A gnarled, shriveled raven's claw. " +
                "\nSpook count +1";
        String batWing = "A leathery black wing. " +
                "\nSpook count +1";
        String deerAntler = "A cracked, greying antler with dark brown " +
                "splotches at its base. " +
                "\nSpook count +1";
        String ratSkull = "A tiny, delicate rat skull with bits of rotting " +
                "flesh behind its eye sockets. " +
                "\nSpook count +1";

        int which = (int)(Math.random() * (4 - 1) + 1) + 1;
        if(which == 1){
            this.setCardName("RAVEN CLAW");
            this.setCardDescription(ravenClaw);
            this.setType("Item Card");
        }
        else if(which == 2){
            this.setCardName("BAT WING");
            this.setCardDescription(batWing);
            this.setType("Item Card");
        }
        else if(which == 3){
            this.setCardName("DEER ANTLER");
            this.setCardDescription(deerAntler);
            this.setType("Item Card");
        }
        else{
            this.setCardName("RAT SKULL");
            this.setCardDescription(ratSkull);
            this.setType("Item Card");
        }
    }
//
//    public String toString(){
//        return "Omen";
//    }
}
