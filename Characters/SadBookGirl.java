/**
 * Real version: Jenny LeClerc
 */

public class SadBookGirl extends Character{

    public SadBookGirl(){
        this.name = "Sad Book Girl";
        this.bio = "A quiet bookworm whose mother disappeared when she was younger. " +
                "Sad Book Girl always feels alone.";
        this.picUrl = "...";

        this.x = 0;
        this.y = 0;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{8, 6, 5, 4, 4, 4, 3, 2, 0};
        this.might = 0;
        this.mightIncr = new int[]{8, 6, 5, 4, 4, 4, 4, 3, 0};
        this.sanity = 0;
        this.sanityIncr = new int[]{6, 5, 4, 4, 4, 2, 1, 1, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{8, 6, 5, 4, 4, 3, 3, 2, 0};

        this.traitor = false;
    }
}
