package Characters;
import javafx.scene.image.ImageView;

/**
 * Real version: Missy Dubourde
 */

public class TheFrogSlayer extends Character{

    public TheFrogSlayer(){

        super.image = new ImageView("Characters/character_images/TheFrogSlayer.png");
        traitorImage = new ImageView("Characters/character_images/TheFrogSlayer_TRAITOR.png");
        image.setFitWidth(75);
        image.setFitHeight(75);
        move = moveCount;

        this.name = "The Frog Slayer";
        this.bio = "The Frog Slayer slays frogs. In her nightmares, \nthey slay her.";
        this.age = 9;

        this.x = 2;
        this.y = 5;

        this.speed = 5; // index speed is at
        this.speedIncr = new int[]{7, 7, 6, 6, 6, 5, 4, 3, 0};
        this.might = 4;
        this.mightIncr = new int[]{7, 6, 5, 4,  3, 3, 3, 2, 0};
        this.sanity = 5;
        this.sanityIncr = new int[]{7, 6, 5, 5, 4, 3, 2, 1, 0};
        this.knowledge = 4;
        this.knowledgeIncr = new int[]{6, 6, 6, 5, 4, 4, 3, 2, 0};

        this.moveCount = speedIncr[speed];

        this.traitor = false;
    }
}