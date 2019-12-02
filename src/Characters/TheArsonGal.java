package Characters;
import javafx.scene.image.ImageView;

/**
 * Real version: Vivian Lopez
 */

public class TheArsonGal extends Character {

    public TheArsonGal(){

        super.image = new ImageView("Characters/character_images/TheArsonGal.png");
        traitorImage = new ImageView("Characters/character_images/TheArsonGal_TRAITOR.png");
        image.setFitWidth(75);
        image.setFitHeight(75);
        move = moveCount;

        this.name = "The Arson Gal";
        this.bio = "The Arson Gal runs a failing bookstore. \nYou do the math.";
        this.age = 42;

        this.speed = 4; // index speed is at
        this.speedIncr = new int[]{8, 7, 6, 4, 4, 4, 4, 3, 0};
        this.might = 5;
        this.mightIncr = new int[]{6, 6, 5, 4, 4, 2, 2, 2, 0};
        this.sanity = 5;
        this.sanityIncr = new int[]{8, 8, 7, 6, 5, 4, 4, 4, 0};
        this.knowledge = 4;
        this.knowledgeIncr = new int[]{7, 6, 6, 5, 5, 5, 5, 4, 0};

        this.moveCount = speedIncr[speed];

        this.traitor = false;
    }
}
