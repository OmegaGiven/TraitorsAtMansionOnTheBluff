package Card;

import javafx.scene.image.ImageView;

public class ItemCard extends Card {


    public ItemCard() {
        String slimeBall = "An oozing, green \npocket-sized ball of slime. " +
                "\nDEALS -1 SPEED"; // speed
        String sharpHammer = "A very pointy hammer. " +
                "\nDEALS -1 MIGHT"; // might
        String singingDoll = "A dirty little porcelain doll \nthat " +
                "sings when you squeeze \nits throat. " +
                "\nDEALS -1 SANITY"; // sanity
        String largeStick = "A large, flat stick that's \nthe perfect " +
                "size for banging \nsomeones head. " +
                "\nDEALS -1 KNOWLEDGE"; // knowledge

        ImageView slime = new ImageView("Card/item_images/SlimeBall.png");
        ImageView hammer = new ImageView("Card/item_images/SharpHammer.png");
        ImageView doll = new ImageView("Card/item_images/SingingDoll.png");
        ImageView stick = new ImageView("Card/item_images/LargeStick.png");

        int which = (int) (Math.random() * ((4 - 1) + 1)) + 1;
        if (which == 1) {
            this.setCardName("SLIME BALL");
            this.setCardDescription(slimeBall);
            this.setType("Item");
            this.setDamage(1);
            this.setCategory("speed");
            this.setImage(slime);
        } else if (which == 2) {
            this.setCardName("SHARP HAMMER");
            this.setCardDescription(sharpHammer);
            this.setType("Item");
            this.setDamage(1);
            this.setCategory("might");
            this.setImage(hammer);
        } else if (which == 3) {
            this.setCardName("SINGING DOLL");
            this.setCardDescription(singingDoll);
            this.setType("Item");
            this.setDamage(1);
            this.setCategory("sanity");
            this.setImage(doll);
        } else {
            this.setCardName("LARGE STICK");
            this.setCardDescription(largeStick);
            this.setType("Item");
            this.setDamage(1);
            this.setCategory("knowledge");
            this.setImage(stick);
        }
    }
}
