package Card;

import java.util.ArrayList;

public class Decks {
    public ArrayList<Card> itemCards = new ArrayList<>();
    public ArrayList<Card> eventCards = new ArrayList<>();
    public ArrayList<Card> omenCards = new ArrayList<>();

    public Decks() {
        ArrayList<Card> cards = Card.readCards("cards.txt");
        for (Card i : cards) {
            if (i.getType().equals("Item")) {
                itemCards.add(i);
            } else if (i.getType().equals("Omen")) {
                omenCards.add(i);
            } else {
                eventCards.add(i);
            }
        }
    }
    public static Card drawCard(ArrayList<Card> deck){
        int card = (int)(Math.random() * deck.size());
        return deck.get(card);
    }
}
