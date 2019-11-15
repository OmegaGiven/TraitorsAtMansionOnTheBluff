/**
 * Real version: Heather Granville
 */


public class BougieBrain extends Character {

    public BougieBrain(){
        this.name = "Bougie Brain";
        this.bio = "Seen as perfect in both her eyes and the eyes of others, " +
                "Bougie Brain feels like something's trying to claw its way out of her " +
                "when things aren't perfect. She keeps smiling anyway.";
        this.picUrl = "...";

        this.x = 0;
        this.y = 0;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{8, 7, 6, 6, 5, 4, 3, 3, 0};
        this.might = 0;
        this.mightIncr = new int[]{8, 7, 6, 5, 4, 3, 3, 3, 0};
        this.sanity = 0;
        this.sanityIncr = new int[]{6, 6, 6, 5, 4, 3, 3, 3, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{8, 7, 6, 5, 4, 3, 3, 2, 0};

        this.traitor = false;
    }
}
