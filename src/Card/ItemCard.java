package Card;
public class ItemCard extends Card {


    public ItemCard(){
        String slimeBall = "An oozing, grey, pocket-sized ball of slime. " +
                "Does -1 Speed damage"; // speed
        String sharpHammer = "A very point hammer. " +
                "Does -1 Might damage"; // might
        String singingDoll = "A dirty little porcelain doll that " +
                "sings when you squeeze its throat. " +
                "Does -1 Sanity damage"; // sanity
        String largeStick = "A large, flat stick that's the perfect " +
                "size for banging someones head. " +
                "Does -1 Knowledge damage"; // knowledge

        int which = (int)(Math.random() * (4 - 1) + 1) + 1;
        if(which == 1){
            this.setCardName("SLIME BALL");
            this.setCardDescription(slimeBall);
            this.setType("Item Card");
        }
        else if(which == 2){
            this.setCardName("SHARP HAMMER");
            this.setCardDescription(sharpHammer);
            this.setType("Item Card");
        }
        else if(which == 3){
            this.setCardName("SINGING DOLL");
            this.setCardDescription(singingDoll);
            this.setType("Item Card");
        }
        else{
            this.setCardName("LARGE STICK");
            this.setCardDescription(largeStick);
            this.setType("Item Card");
        }
    }

    public String toString(){
        return "Item Card";
    }
}
