import javafx.scene.image.ImageView;

/**
 * Real version: Brandon Jaspers
 */

public class PuppetBoy extends Character {

    public PuppetBoy(){

        super.image = new ImageView("https://i.imgur.com/gKVlLGv.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "Puppet Boy";
        this.bio = "A kid who never liked playing with traditional toys, " +
                "Puppet Boy swore his old clown puppet was moving closer to him when he slept.";
        this.picUrl = "...";

        this.x = 2;
        this.y = 5;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{8, 7, 6, 5, 4, 4, 4, 3, 0};
        this.might = 0;
        this.mightIncr = new int[]{7, 6, 6, 5, 4, 3, 3, 2, 0};
        this.sanity = 0;
        this.sanityIncr = new int[]{8, 7, 6, 5, 4, 3, 3, 2, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{7, 6, 6, 5, 5, 4, 4, 1, 0};

        this.traitor = false;
    }
}
