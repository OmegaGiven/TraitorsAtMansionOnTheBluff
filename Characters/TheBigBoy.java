/**
 * Real version: Ox Bellows
 */

public class TheBigBoy extends Character {

    public TheBigBoy(){
        this.name = "The Big Boy";
        this.bio = "A big kid who once had to lash out. The Big Boy is now haunted " +
                "by his past and what he did that one time.";
        this.picUrl = "...";

        this.x = 0;
        this.y = 0;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{6, 5, 5, 4, 3, 2, 2, 2, 0};
        this.might = 0;
        this.mightIncr = new int[]{8, 8, 7, 6, 6, 5, 5, 4, 0};
        this.sanity = 0;
        this.sanityIncr = new int[]{7, 6, 5, 5, 4, 3, 2, 2, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{6, 6, 5, 5, 3, 3, 2, 2, 0};

        this.traitor = false;
    }
}
