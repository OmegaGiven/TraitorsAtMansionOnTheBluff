import javafx.scene.image.ImageView;

/**
 * Real version: Zoe Ingstrom
 */

public class TheDollKid extends Character{

    public TheDollKid(){

        super.image = new ImageView("https://i.imgur.com/rtwqy76.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "The Doll Kid";
        this.bio = "The Doll Kid has an implied tragic story. Raised in an unhappy home, " +
                "she uses dolls to express her emotions.";
        this.picUrl = "...";

        this.x = 2;
        this.y = 5;

        this.moveCount = 4;

        this.speed = 4; // index speed is at
        this.speedIncr = new int[]{8, 8, 6, 5, 4, 4, 4, 4, 0};
        this.might = 4;
        this.mightIncr = new int[]{7, 6, 4, 4, 3, 3, 2, 2, 0};
        this.sanity = 5;
        this.sanityIncr = new int[]{8, 7, 6, 6, 5, 5, 4, 3, 0};
        this.knowledge = 5;
        this.knowledgeIncr = new int[]{5, 5, 5, 4, 4, 3, 2, 1,0};

        this.traitor = false;
    }
}
