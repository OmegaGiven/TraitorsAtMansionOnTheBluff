package Card;

import javafx.scene.image.ImageView;

public class Omen extends Card {

    public Omen(){

        ImageView raven = new ImageView("Card/item_images/RavenClaw.png");
        ImageView wing = new ImageView("Card/item_images/BatWing.png");
        ImageView antler = new ImageView("Card/item_images/DeerAntler.png");
        ImageView skull = new ImageView("Card/item_images/RatSkull.png");

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

        int which = (int)(Math.random() * ((4 - 1) + 1)) + 1;
        if(which == 1){
            this.setCardName("RAVEN CLAW");
            this.setCardDescription(ravenClaw);
            this.setType("Omen");
            this.setImage(raven);
        }
        else if(which == 2){
            this.setCardName("BAT WING");
            this.setCardDescription(batWing);
            this.setType("Omen");
            this.setImage(wing);
        }
        else if(which == 3){
            this.setCardName("DEER ANTLER");
            this.setCardDescription(deerAntler);
            this.setType("Omen");
            this.setImage(antler);
        }
        else{
            this.setCardName("RAT SKULL");
            this.setCardDescription(ratSkull);
            this.setType("Omen");
            this.setImage(skull);
        }
        this.setDamage(1);
        this.setCategory("spook");
    }

}
