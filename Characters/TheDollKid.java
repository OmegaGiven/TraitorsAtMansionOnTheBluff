/**
 * Real version: Zoe Ingstrom
 */

public class TheDollKid extends Character{

    public TheDollKid(){
        this.name = "The Doll Kid";
        this.bio = "The Doll Kid has an implied tragic story. Raised in an unhappy home, " +
                "she uses dolls to express her emotions.";
        this.picUrl = "...";

        this.x = 0;
        this.y = 0;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{8, 8, 6, 5, 4, 4, 4, 4, 0};
        this.might = 0;
        this.mightIncr = new int[]{7, 6, 4, 4, 3, 3, 2, 2, 0};
        this.sanity = 0;
        this.sanityIncr = new int[]{8, 7, 6, 6, 5, 5, 4, 3, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{5, 5, 5, 4, 4, 3, 2, 1,0};

        this.traitor = false;
    }
}
