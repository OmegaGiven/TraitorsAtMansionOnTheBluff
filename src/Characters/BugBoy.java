package Characters;

import javafx.scene.image.ImageView;

/**
 * Real version: Peter Akimoto
 */


public class BugBoy extends Character {

    public BugBoy(){

        super.image = new ImageView("https://i.imgur.com/PPxxrhH.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "Bug Boy";
        this.bio = "Bug Boy was bullied by his family when \nhe was younger." +
        " Now he takes out \nhis anger on the ants.";
        this.age = 13;

        this.x = 2;
        this.y = 5;

        this.speed = 4; // index speed is at
        this.speedIncr = new int[]{7, 7, 6, 6, 4, 3, 3, 3, 0};
        this.might = 5;
        this.mightIncr = new int[]{8, 6, 5, 5, 4, 3, 3, 2, 0};
        this.sanity = 4;
        this.sanityIncr = new int[]{7, 6, 6, 5, 4, 4, 4, 3, 0};
        this.knowledge = 5;
        this.knowledgeIncr = new int[]{8, 7, 7, 6, 5, 4, 4, 3, 0};

        this.moveCount = speedIncr[speed];

        this.traitor = false;
    }
}
