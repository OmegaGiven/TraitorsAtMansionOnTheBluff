import javafx.scene.image.ImageView;

/**
 * Real version: Missy Dubourde
 */

public class TheFrogSlayer extends Character{

    public TheFrogSlayer(){

        super.image = new ImageView("https://i.imgur.com/LI8jfhd.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "The Frog Slayer";
        this.bio = "A creepy little girl, who wants to be a doctor. " +
                "She cuts up dead frogs, for fun. The Frog Slayer then has nightmares about them swarming her.";
        this.picUrl = "...";

        this.x = 2;
        this.y = 5;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{7, 7, 6, 6, 6, 5, 4, 3, 0};
        this.might = 0;
        this.mightIncr = new int[]{7, 6, 5, 4,  3, 3, 3, 2, 0};
        this.sanity = 0;
        this.sanityIncr = new int[]{7, 6, 5, 5, 4, 3, 2, 1, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{6, 6, 6, 5, 4, 4, 3, 2, 0};

        this.traitor = false;
    }
}