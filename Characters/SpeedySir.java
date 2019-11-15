/**
 * Real version: Darrin Flash Williams
 */

public class SpeedySir extends Character {

    public SpeedySir(){
        this.name = "Speedy Sir";
        this.bio = "Speedy Sir is a paranoid runner who can't help but " +
                "shake the feeling that something is chasing him.";
        this.picUrl = "...";

        this.x = 0;
        this.y = 0;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{8, 7, 7, 6, 5, 4, 4, 4, 0};
        this.might = 0;
        this.mightIncr = new int[]{7, 6, 6, 5, 4, 3, 3, 2, 0};
        this.sanity = 0;
        this.sanityIncr = new int[]{7, 5, 5, 5, 4, 3, 2, 1, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{7, 5, 5, 5, 4, 3, 3, 2, 0};

        this.traitor = false;
    }
}
