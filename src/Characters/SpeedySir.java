package Characters;
import javafx.scene.image.ImageView;

/**
 * Real version: Darrin Flash Williams
 */

public class SpeedySir extends Character {

    public SpeedySir(){

        super.image = new ImageView("Characters/character_images/SpeedySir.png");
        traitorImage = new ImageView("Characters/character_images/SpeedySir_TRAITOR.png");
        image.setFitWidth(75);
        image.setFitHeight(75);
        move = moveCount;

        this.name = "Speedy Sir";
        this.bio = "Speedy Sir can outrun his competitors, but \nhe can't outrun " +
        "himself. Or the Unpleasant \nSomething that's chasing him.";
        this.age = 20;

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
