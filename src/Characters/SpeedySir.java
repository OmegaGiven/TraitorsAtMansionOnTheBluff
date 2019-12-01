package Characters;
import javafx.scene.image.ImageView;

/**
 * Real version: Darrin Flash Williams
 */

public class SpeedySir extends Character {

    public SpeedySir(){

        super.image = new ImageView("https://i.imgur.com/TKLWSmm.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "Speedy Sir";
        this.bio = "Speedy Sir can outrun his competitors, but \nhe can't outrun " +
        "himself. Or the Unpleasant \nSomething that's chasing him.";
        this.age = 20;

        this.x = 2;
        this.y = 5;

        this.speed = 3; // index speed is at
        this.speedIncr = new int[]{8, 7, 7, 6, 5, 4, 4, 4, 0};
        this.might = 5;
        this.mightIncr = new int[]{7, 6, 6, 5, 4, 3, 3, 2, 0};
        this.sanity = 5;
        this.sanityIncr = new int[]{7, 5, 5, 5, 4, 3, 2, 1, 0};
        this.knowledge = 5;
        this.knowledgeIncr = new int[]{7, 5, 5, 5, 4, 3, 3, 2, 0};

        this.moveCount = speedIncr[speed];

        this.traitor = false;
    }
}
