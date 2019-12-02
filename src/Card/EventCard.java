package Card;
import java.util.Map;
import java.util.HashMap;

public class EventCard extends Card {

    private Map<String, String> cards;

    public EventCard() {
        String frogAttack = "Dozens of tiny frogs descend from the " +
                "ceiling and start nibbling at your toes. " +
                "Speed -1";
        String flameDemon = "Suddenly, a burst of flame erupts from " +
                "the floor panels. Your eyebrows are singed. " +
                "Might -1";
        String ghostSwoop = "A silvery specter swoops from above. " +
                "\"Your mother never loved you\", it hisses. " +
                "Sanity -1";
        String stinkBomb = "A gremlin-like creature hops from behind " +
                "a flower pot and tosses something in your direction. " +
                "He cackles and runs away as a putrid yellow smoke fills " +
                "the room. Knowledge - 1";

        cards = new HashMap<>();
        cards.put("Frog Attack", frogAttack);
        cards.put("Flame Demon", flameDemon);
        cards.put("Ghost Swoop", ghostSwoop);
        cards.put("Stink Bomb", stinkBomb);
    }

    public String getValue(String key) {
        return cards.getOrDefault(key, "ERROR: KEY INVALID");
    }

    public String toString(){
        return "Event Card";
    }
}