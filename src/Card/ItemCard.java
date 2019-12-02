package Card;

import java.util.HashMap;
import java.util.Map;

public class ItemCard extends Card {

    private Map<String, String> cards;

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

        cards = new HashMap<>();
        cards.put("SLIME BALL", slimeBall);
        cards.put("SHARP HAMMER", sharpHammer);
        cards.put("SINGING DOLL", singingDoll);
        cards.put("LARGE STICK", largeStick);
        
    }

    public String getValue(String key) {
        return cards.getOrDefault(key, "ERROR: KEY INVALID");
    }

    public String toString(){
        return "Item Card";
    }
}
