package Card;
public class ItemCard extends Card {


    public ItemCard() {
        String slimeBall = "An oozing, grey, pocket-sized ball of slime. " +
                "\nDEALS -1 SPEED"; // speed
        String sharpHammer = "A very pointy hammer. " +
                "\nDEALS -1 MIGHT"; // might
        String singingDoll = "A dirty little porcelain doll \nthat " +
                "sings when you squeeze \nits throat. " +
                "\nDEALS -1 SANITY"; // sanity
        String largeStick = "A large, flat stick that's \nthe perfect " +
                "size for banging \nsomeones head. " +
                "\nDEALS -1 KNOWLEDGE"; // knowledge

        int which = (int) (Math.random() * (4 - 1) + 1) + 1;
        if (which == 1) {
            this.setCardName("SLIME BALL");
            this.setCardDescription(slimeBall);
            this.setType("Item Card");
            this.setDamage(1);
            this.setCategory("speed");
        } else if (which == 2) {
            this.setCardName("SHARP HAMMER");
            this.setCardDescription(sharpHammer);
            this.setType("Item Card");
            this.setDamage(1);
            this.setCategory("might");
        } else if (which == 3) {
            this.setCardName("SINGING DOLL");
            this.setCardDescription(singingDoll);
            this.setType("Item Card");
            this.setDamage(1);
            this.setCategory("sanity");
        } else {
            this.setCardName("LARGE STICK");
            this.setCardDescription(largeStick);
            this.setType("Item Card");
            this.setDamage(1);
            this.setCategory("knowledge");
        }
    }
}
