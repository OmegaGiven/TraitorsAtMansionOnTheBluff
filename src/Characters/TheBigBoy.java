package Characters;
import javafx.scene.image.ImageView;

/**
 * Real version: Ox Bellows
 */

public class TheBigBoy extends Character {

    public TheBigBoy(){

        super.image = new ImageView("https://i.imgur.com/DnigrM7.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "The Big Boy";
        this.bio = "The Big Boy weighs 288 lbs. 288! That's crazy. \nAlso he might be " +
        "a murderer. But seriously, \n288? Dude must drink a lot of milk.";
        this.age = 23;

        this.x = 2;
        this.y = 5;

        this.speed = 3; // index speed is at
        this.speedIncr = new int[]{6, 5, 5, 4, 3, 2, 2, 2, 0};
        this.might = 5;
        this.mightIncr = new int[]{8, 8, 7, 6, 6, 5, 5, 4, 0};
        this.sanity = 5;
        this.sanityIncr = new int[]{7, 6, 5, 5, 4, 3, 2, 2, 0};
        this.knowledge = 5;
        this.knowledgeIncr = new int[]{6, 6, 5, 5, 3, 3, 2, 2, 0};

        this.moveCount = speedIncr[speed];

        this.traitor = false;
    }
}
