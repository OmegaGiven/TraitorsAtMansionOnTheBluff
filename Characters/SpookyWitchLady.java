/**
 * Real version: Signora Zopstrumm
 */

public class SpookyWitchLady extends Character{

    public SpookyWitchLady(){
        this.name = "Spooky Witch Lady";
        this.bio = "Also known as The Bubster, Spooky Witch Lady is a tarot card and " +
                "tea-leaf reader with her own stay-at-home astrology business.";
        this.picUrl = "...";

        this.x = 0;
        this.y = 0;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{7, 6, 6, 5, 5, 3, 3, 2, 0};
        this.might = 0;
        this.mightIncr = new int[]{6, 5, 5, 5, 4, 3, 3, 2, 0};
        this.sanity = 0;
        this.sanityIncr = new int[]{8, 8, 7, 6, 5, 4, 4, 4, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{6, 6, 5, 4, 4, 4, 3, 1, 0};

        this.traitor = false;
    }
}
